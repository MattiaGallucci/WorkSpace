/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package it.pd2024.web;

import it.pd2024.musiclibrary.MusicLibrary;
import it.pd2024.musiclibrary.Playlist;
import it.pd2024.musiclibrary.Song;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author matti
 */
public class MusicPlayer extends HttpServlet {

    @EJB
    private MusicLibrary musicLibrary;  // EJB per interagire con la libreria musicale
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Music Player</title>");
            out.println("</head>");
            out.println("<body>");

            // Ottieni la lista di tutte le canzoni
            List<Song> songs = musicLibrary.findSongs();
            out.println("<h2>Tutte le Canzoni:</h2>");
            out.println("<ul>");
            for (Song song : songs) {
                out.println("<li>");
                out.println("<strong>" + song.getName() + "</strong> by " + song.getAuthors());
                out.println("<iframe width=\"420\" height=\"315\" src=\"" + song.getUrl() + "\" frameborder=\"0\"></iframe>");
                out.println("</li>");
            }
            out.println("</ul>");

            // Ottieni la lista di tutte le playlist
            List<Playlist> playlists = musicLibrary.trovaPlaylist();
            out.println("<h2>Tutte le Playlist:</h2>");
            out.println("<ul>");
            for (Playlist playlist : playlists) {
                out.println("<li>");
                out.println("<strong>" + playlist.getNome() + "</strong> by " + playlist.getAutore());
                out.println("<p>" + playlist.getDescrizione() + "</p>");
                out.println("</li>");
            }
            out.println("</ul>");

            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
