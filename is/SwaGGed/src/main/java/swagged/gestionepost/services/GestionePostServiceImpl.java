package swagged.gestionepost.services;

import swagged.model.bean.*;
import swagged.model.dao.*;

import javax.servlet.GenericServlet;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class GestionePostServiceImpl implements GestionePostService {
    PostDAO postDAO = new PostDAO();
    private static final String UPLOAD_DIR = "assets/images/post";
    UtenteDAO utenteDAO = new UtenteDAO();
    CommunityDAO communityDAO = new CommunityDAO();
    ApprezzaPostDAO apprezzaPostDAO = new ApprezzaPostDAO();
    CommentoDAO commentoDAO = new CommentoDAO();

    @Override
    public PostBean create(String titolo, String corpo, Part filePart, UtenteBean utente, String comunityNome, GenericServlet servlet) throws SQLException {
        if (titolo == null || titolo.isEmpty() ||
                utente == null || comunityNome == null || comunityNome.isEmpty() || communityDAO.getByNome(comunityNome) == null) {
            return null;
        }

        PostBean newPost = new PostBean();
        newPost.setTitolo(titolo);
        newPost.setCorpo(corpo);

        String relativeFileName = null;
        if (filePart != null && filePart.getSubmittedFileName() != null && !filePart.getSubmittedFileName().isEmpty()) {
            if (!isImageFile(filePart)) {
                return null;
            }
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            String applicationPath = servlet.getServletContext().getRealPath("");
            String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
            File uploadDir = new File(uploadFilePath);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }
            String sanitizedFileName = fileName.replaceAll("\\s+", "_");
            String filePath = uploadFilePath + File.separator + sanitizedFileName;
            File file = new File(filePath);
            while (file.exists()) {
                String uniqueID = UUID.randomUUID().toString();
                sanitizedFileName = uniqueID + "_" + sanitizedFileName;
                filePath = uploadFilePath + File.separator + sanitizedFileName;
                file = new File(filePath);
            }
            try {
                Files.copy(filePart.getInputStream(), Paths.get(filePath));
            } catch (IOException e) {
                return null;
            }
            relativeFileName = sanitizedFileName;
        }

        newPost.setImmagine(relativeFileName); // Imposta l'immagine solo se presente
        newPost.setSegnalazioni(0);
        newPost.setLikes(0);
        newPost.setDataCreazione(new Date(System.currentTimeMillis()));
        newPost.setUtenteEmail(utente.getEmail());
        newPost.setCommunityNome(comunityNome);

        utente.add("postCreati", newPost);

        CommunityBean community = communityDAO.getByNome(comunityNome);
        community.addPost(newPost);

        if (postDAO.save(newPost)) {
            return newPost;
        } else {
            return null;
        }
    }


    @Override
    public boolean remove(int id, UtenteBean utente) throws SQLException {
        if(postDAO.getById(id) == null)
            return false;

        PostBean post = postDAO.getById(id);
        utente.remove("postCreati", post);

        CommunityBean community = communityDAO.getByNome(post.getCommunityNome());
        community.removePost(post);

        return postDAO.delete(id);
    }

    @Override
    public List<PostBean> cerca(String substring) throws SQLException {
        if(substring.isEmpty() || substring.equals(""))
            return null;

        return postDAO.getByTitleSubstring(substring);
    }

    @Override
    public List<PostBean> home() throws SQLException {
        return postDAO.getByDateWithPagination(1, 10);
    }

    @Override
    public PostBean like(UtenteBean utente, int postId) throws SQLException {
        if(utente == null || postDAO.getById(postId) == null)
            return null;

        ApprezzaPostBean apprezzaPostBean = new ApprezzaPostBean();

        if((apprezzaPostDAO.getByKey(utente.getEmail(), postId) == null)){
            apprezzaPostBean.setUtenteEmail(utente.getEmail());
            apprezzaPostBean.setPostId(postId);
            apprezzaPostDAO.save(apprezzaPostBean);

            PostBean postBean = postDAO.getById(postId);
            postBean.aggiungiLike();

            utente.add("postApprezzati", apprezzaPostBean);
            if(postDAO.update(postBean))
                return postBean;
            else
                return null;
        } else {
            apprezzaPostBean = apprezzaPostDAO.getByKey(utente.getEmail(), postId);
            apprezzaPostDAO.delete(utente.getEmail(), postId);

            PostBean postBean = postDAO.getById(postId);
            postBean.rimuoviLike();
            System.out.println("G: " + utente.get("postApprezzati"));
            utente.remove("postApprezzati", apprezzaPostBean);
            if(postDAO.update(postBean))
                return postBean;
            else
                return null;
        }
    }

    private boolean isImageFile(Part filePart) {
        String contentType = filePart.getContentType();
        return contentType != null && (contentType.equals("image/jpeg") || contentType.equals("image/png") || contentType.equals("image/gif") || contentType.equals("image/jpg"));
    }

    public PostBean visualizza(int id) throws SQLException{
        if(postDAO.getById(id) == null)
            return null;
        List<CommentoBean> commenti = commentoDAO.getByPostId(id);

        PostBean postBean = postDAO.getById(id);

        postBean.setCommenti(commenti);
        return postBean;
    }
}
