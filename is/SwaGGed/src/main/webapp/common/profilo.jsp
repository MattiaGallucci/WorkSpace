<%@ page import="swagged.model.bean.PostBean" %>
<%@ page import="swagged.model.bean.UtenteBean" %>
<%@ page import="java.util.List" %>
<%@ page import="swagged.model.bean.CommentoBean" %>
<%@ page import="swagged.model.bean.ApprezzaPostBean" %>
<%@ page import="swagged.model.dao.PostDAO" %>
<%@ page import="java.util.ArrayList" %>
<%
    UtenteBean utente = (UtenteBean) session.getAttribute("utente");
    List<PostBean> postCreati = (List<PostBean>) utente.get("postCreati");
    List<ApprezzaPostBean> apprezzaPostBeans = (List<ApprezzaPostBean>) utente.get("postApprezzati");
    List<CommentoBean> commentiCreati = (List<CommentoBean>) utente.get("commentiCreati");
    PostDAO postDAO = new PostDAO();
    List<PostBean> postApprezzati = new ArrayList<>();
    for (ApprezzaPostBean post : apprezzaPostBeans) {
        postApprezzati.add(postDAO.getById(post.getPostId()));
    }
%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>SwaGGed | <%=utente.getUsername()%>
    </title>

    <link rel="shortcut icon" href="<%=request.getContextPath()%>/assets/images/favicon.ico"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/libs.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/socialv.css?v=4.0.0">
    <link rel="stylesheet"
          href="<%=request.getContextPath()%>/assets/vendor/@fortawesome/fontawesome-free/css/all.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/vendor/remixicon/fonts/remixicon.css">
    <link rel="stylesheet"
          href="<%=request.getContextPath()%>/assets/vendor/vanillajs-datepicker/dist/css/datepicker.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/vendor/font-awesome-line-awesome/css/all.min.css">
    <link rel="stylesheet"
          href="<%=request.getContextPath()%>/assets/vendor/line-awesome/dist/line-awesome/css/line-awesome.min.css">

</head>
<body class="  ">
<!-- Wrapper Start -->
<div class="wrapper">
    <jsp:include page="../fragments/sidebar.jsp"/>
    <jsp:include page="../fragments/navbar.jsp"/>
    <div id="content-page" class="content-page">
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <div class="card">
                        <div class="card-body profile-page p-0">
                            <div class="profile-header">
                                <div class="position-relative">
                                    <img src="<%=request.getContextPath()%>/assets/images/trasparente.png"
                                         alt="profile-bg"
                                         class="rounded img-fluid">
                                </div>
                                <div class="user-detail text-center mb-3">
                                    <div class="profile-img">
                                        <img src="<%=request.getContextPath() + "/assets/images/pfp/" + utente.getImmagine()%>"
                                             alt="profile-img"
                                             class="avatar-130 img-fluid"/>
                                    </div>
                                    <div class="profile-detail">
                                        <h3 class=""><%=utente.getUsername()%>
                                        </h3>
                                    </div>
                                </div>
                                <div class="profile-info p-3 d-flex align-items-center justify-content-between position-relative">
                                    <div class="social-info">
                                        <ul class="social-data-block d-flex align-items-center justify-content-between list-inline p-0 m-0">
                                            <li class="text-center ps-3">
                                                <h6>Post</h6>
                                                <p class="mb-0"><%=utente.get("postCreati").size()%>
                                                </p>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>

                            <div class="modal fade" id="post-modal-community" tabindex="-1"
                                 aria-labelledby="post-modalLabel"
                                 aria-hidden="true">
                                <div class="modal-dialog   modal-fullscreen-sm-down">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="post-modalLabel-community">Crea Community</h5>
                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal"><i
                                                    class="ri-close-fill"></i></button>
                                        </div>
                                        <div class="modal-body">
                                            <form action="community" method="post">
                                                <input type="hidden" name="mode" value="create">
                                                <div class="form-group">
                                                    <label class="form-label" for="communityNomeCreazione">Nome
                                                        community</label>
                                                    <input type="text" class="form-control mb-0"
                                                           id="communityNomeCreazione"
                                                           name="communityNomeCreazione"
                                                           placeholder="Inserisci il nome della community"
                                                           required>
                                                </div>
                                                <div class="form-group">
                                                    <label class="form-label" for="descrizione">Descrizione</label>
                                                    <input type="text" class="form-control mb-0" id="descrizione"
                                                           name="descrizione"
                                                           placeholder="Inserisci descrizione">
                                                </div>
                                                <hr>
                                                <button type="submit" class="btn btn-primary d-block w-100 mt-3">Crea
                                                </button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>

                    <div class="card">
                        <div class="card-body p-0">
                            <div class="user-tabing">
                                <ul class="nav nav-pills d-flex align-items-center justify-content-center profile-feed-items p-0 m-0">
                                    <li class="nav-item col-12 col-sm-3 p-0">
                                        <a class="nav-link active" href="#pills-timeline-tab" data-bs-toggle="pill"
                                           data-bs-target="#timeline" role="button">Post Creati</a>
                                    </li>
                                    <li class="nav-item col-12 col-sm-3 p-0">
                                        <a class="nav-link" href="#pills-about-tab" data-bs-toggle="pill"
                                           data-bs-target="#about" role="button">Post Apprezzati</a>
                                    </li>
                                    <li class="nav-item col-12 col-sm-3 p-0">
                                        <a class="nav-link" href="#pills-friends-tab" data-bs-toggle="pill"
                                           data-bs-target="#friends" role="button">Commenti Creati</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-12">
                    <div class="tab-content">
                        <div class="tab-pane fade show active" id="timeline" role="tabpanel">
                            <div class="card-body p-0">
                                <div class="row">
                                    <%
                                        for (PostBean post : postCreati) {

                                    %>
                                    <div class="col-sm-12">
                                        <div class="card">
                                            <div class="card-body">
                                                <div class="user-post-data py-3">
                                                    <div class="d-flex justify-content-between">
                                                        <div class="me-3">
                                                            <img class="avatar-60 rounded-circle"
                                                                 src="<%=request.getContextPath() + "/assets/images/pfp/" + utente.getImmagine()%>"
                                                                 alt="">
                                                        </div>
                                                        <div class="w-100">
                                                            <div class="d-flex justify-content-between">
                                                                <div class="">
                                                                    <h5 class="mb-0 d-inline-block">
                                                                        <a href="<%=request.getContextPath()%>/utente?mode=visualizza&username=<%=utente.getUsername()%>"
                                                                           class=""><%=utente.getUsername()%>
                                                                        </a>
                                                                    </h5>
                                                                    <a href="<%=request.getContextPath()%>/community?mode=visualizza&nome=<%=post.getCommunityNome()%>">
                                                                        <p class="mb-0"><%=post.getCommunityNome()%>
                                                                        </p>
                                                                    </a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <%
                                                            if (utente != null && (post.getUtenteEmail().equals(utente.getEmail()) || utente.isAdmin())) {
                                                        %>
                                                        <div class="card-post-toolbar">
                                                            <a href="<%=request.getContextPath()%>/post?mode=remove&id=<%=post.getId()%>">
                                                                <i class="ri-delete-bin-7-line h4"></i>
                                                            </a>
                                                        </div>
                                                        <%
                                                            }
                                                        %>
                                                    </div>
                                                </div>
                                                <div class="user-post">
                                                    <h4 class="card-title"><%=post.getTitolo()%>
                                                    </h4>
                                                </div>
                                                <%
                                                    if (post.getCorpo().length() > 0) {
                                                %>
                                                <div class="user-post">
                                                    <p><%=post.getCorpo()%>
                                                    </p>
                                                </div>
                                                <%
                                                    }
                                                    if (post.getImmagine() != null) {
                                                %>
                                                <div class="user-post">
                                                    <img src="<%=request.getContextPath() + "/assets/images/post/" + post.getImmagine()%>"
                                                         alt="post-image" class="img-fluid w-100"/>
                                                </div>
                                                <%
                                                    }
                                                %>
                                                <div class="comment-area mt-3">
                                                    <div class="d-flex justify-content-between align-items-center flex-wrap">
                                                        <div class="like-block position-relative d-flex align-items-center">
                                                            <div class="d-flex align-items-center">
                                                                <div class="like-data">
                                                                    <%
                                                                        if (utente != null && utente.get("postApprezzati").contains(post)) {
                                                                    %>
                                                                    <a href="<%=request.getContextPath()%>/post?mode=like&id=<%=post.getId()%>">
                                                                        <i class="fa fa-thumbs-up"
                                                                           style="color: #50b5ff"></i>
                                                                    </a>
                                                                    <%
                                                                    } else if (utente != null && !utente.get("postApprezzati").contains(post)) {
                                                                    %>
                                                                    <a href="<%=request.getContextPath()%>/post?mode=like&id=<%=post.getId()%>">
                                                                        <i class="fa fa-thumbs-up"
                                                                           style="color: #777d74"></i>
                                                                    </a>
                                                                    <%
                                                                    } else {
                                                                    %>
                                                                    <i class="fa fa-thumbs-up"
                                                                       style="color: #777d74"></i>
                                                                    <%
                                                                        }
                                                                    %>
                                                                </div>
                                                                <div class="total-like-block ms-2 me-3">
                                                                    <label><%=post.getLikes()%>
                                                                    </label>
                                                                </div>
                                                            </div>
                                                            <div class="like-data">
                                                                <a href="<%=request.getContextPath()%>/post?mode=visualizza&id=<%=post.getId()%>">
                                                                    <i class="far fa-comments"></i>
                                                                </a>
                                                            </div>
                                                            <div class="total-like-block ms-2 me-3">
                                                                <a href="<%=request.getContextPath()%>/post?mode=visualizza&id=<%=post.getId()%>">
                                                                    <label><%=post.getNumeroCommenti()%>
                                                                    </label>
                                                                </a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <%
                                        }
                                    %>


                                </div>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="about" role="tabpanel">
                            <div class="card">
                                <div class="card-body">
                                    <div class="row">
                                        <%
                                            for (PostBean post : postApprezzati) {
                                        %>
                                        <div class="col-sm-12">
                                            <div class="card">
                                                <div class="card-body">
                                                    <div class="user-post-data py-3">
                                                        <div class="d-flex justify-content-between">
                                                            <div class="me-3">
                                                                <img class="avatar-60 rounded-circle"
                                                                     src="<%=request.getContextPath() + "/assets/images/pfp/" + utente.getImmagine()%>"
                                                                     alt="">
                                                            </div>
                                                            <div class="w-100">
                                                                <div class="d-flex justify-content-between">
                                                                    <div class="">
                                                                        <h5 class="mb-0 d-inline-block">
                                                                            <a href="<%=request.getContextPath()%>/utente?mode=visualizza&username=<%=utente.getUsername()%>"
                                                                               class=""><%=utente.getUsername()%>
                                                                            </a>
                                                                        </h5>
                                                                        <a href="<%=request.getContextPath()%>/community?mode=visualizza&nome=<%=post.getCommunityNome()%>">
                                                                            <p class="mb-0"><%=post.getCommunityNome()%>
                                                                            </p>
                                                                        </a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <%
                                                                if (utente != null && (post.getUtenteEmail().equals(utente.getEmail()) || utente.isAdmin())) {
                                                            %>
                                                            <div class="card-post-toolbar">
                                                                <a href="<%=request.getContextPath()%>/post?mode=remove&id=<%=post.getId()%>">
                                                                    <i class="ri-delete-bin-7-line h4"></i>
                                                                </a>
                                                            </div>
                                                            <%
                                                                }
                                                            %>
                                                        </div>
                                                    </div>
                                                    <div class="user-post">
                                                        <h4 class="card-title"><%=post.getTitolo()%>
                                                        </h4>
                                                    </div>
                                                    <%
                                                        if (post.getCorpo().length() > 0) {
                                                    %>
                                                    <div class="user-post">
                                                        <p><%=post.getCorpo()%>
                                                        </p>
                                                    </div>
                                                    <%
                                                        }
                                                        if (post.getImmagine() == null) {
                                                    %>
                                                    <div class="user-post">
                                                        <img src="<%=request.getContextPath() + "/assets/images/post/" + post.getImmagine()%>"
                                                             alt="post-image" class="img-fluid w-100"/>
                                                    </div>
                                                    <%
                                                        }
                                                    %>
                                                    <div class="comment-area mt-3">
                                                        <div class="d-flex justify-content-between align-items-center flex-wrap">
                                                            <div class="like-block position-relative d-flex align-items-center">
                                                                <div class="d-flex align-items-center">
                                                                    <div class="like-data">
                                                                        <%
                                                                            if (utente != null && utente.get("postApprezzati").contains(post)) {
                                                                        %>
                                                                        <a href="<%=request.getContextPath()%>/post?mode=like&id=<%=post.getId()%>">
                                                                            <i class="fa fa-thumbs-up"
                                                                               style="color: #50b5ff"></i>
                                                                        </a>
                                                                        <%
                                                                        } else if (utente != null && !utente.get("postApprezzati").contains(post)) {
                                                                        %>
                                                                        <a href="<%=request.getContextPath()%>/post?mode=like&id=<%=post.getId()%>">
                                                                            <i class="fa fa-thumbs-up"
                                                                               style="color: #777d74"></i>
                                                                        </a>
                                                                        <%
                                                                        } else {
                                                                        %>
                                                                        <i class="fa fa-thumbs-up"
                                                                           style="color: #777d74"></i>
                                                                        <%
                                                                            }
                                                                        %>
                                                                    </div>
                                                                    <div class="total-like-block ms-2 me-3">
                                                                        <label><%=post.getLikes()%>
                                                                        </label>
                                                                    </div>
                                                                </div>
                                                                <div class="like-data">
                                                                    <a href="<%=request.getContextPath()%>/post?mode=visualizza&id=<%=post.getId()%>">
                                                                        <i class="far fa-comments"></i>
                                                                    </a>
                                                                </div>
                                                                <div class="total-like-block ms-2 me-3">
                                                                    <a href="<%=request.getContextPath()%>/post?mode=visualizza&id=<%=post.getId()%>">
                                                                        <label><%=post.getNumeroCommenti()%>
                                                                        </label>
                                                                    </a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <%
                                            }

                                        %>


                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="friends" role="tabpanel">
                            <div class="card">
                                <div class="card-body">
                                    <div class="row">
                                        <%
                                            for (CommentoBean commento : commentiCreati) {
                                        %>
                                        <div class="col-sm-12">
                                            <div class="card">
                                                <div class="card-body">
                                                    <div class="d-flex">
                                                        <div class="user-img">
                                                            <img src="<%=request.getContextPath() + "/assets/images/pfp/" + utente.getImmagine()%>"
                                                                 alt="userimg" class="avatar-35 rounded-circle img-fluid">
                                                        </div>
                                                        <div class="w-100">
                                                            <div class="d-flex justify-content-between">
                                                                <div class="comment-data-block ms-3">
                                                                    <h6>
                                                                        <a href="<%=request.getContextPath()%>/common/profilo.jsp?username=<%=utente.getUsername()%>"
                                                                           class=""><%=utente.getUsername()%>
                                                                        </a>
                                                                    </h6>
                                                                    <p class="mb-0"><%=commento.getCorpo()%>
                                                                    </p>
                                                                </div>
                                                                <%
                                                                    if (utente != null && (commento.getUtenteEmail().equals(utente.getEmail()) || utente.isAdmin())) {
                                                                %>
                                                                <div class="card-post-toolbar">
                                                                    <a href="<%=request.getContextPath()%>/commento?mode=remove&id=<%=commento.getId()%>&postId=<%=commento.getPostId()%>">
                                                                        <i class="ri-delete-bin-7-line h4"></i>
                                                                    </a>
                                                                </div>
                                                                <%
                                                                    }
                                                                %>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <%
                                            }
                                        %>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="photos" role="tabpanel">
                            <div class="card">
                                <div class="card-body">
                                    <h2>Photos</h2>
                                    <div class="friend-list-tab mt-2">
                                        <ul class="nav nav-pills d-flex align-items-center justify-content-left friend-list-items p-0 mb-2">
                                            <li>
                                                <a class="nav-link active" data-bs-toggle="pill"
                                                   href="#pill-photosofyou" data-bs-target="#photosofyou">Photos of
                                                    You</a>
                                            </li>
                                            <li>
                                                <a class="nav-link" data-bs-toggle="pill" href="#pill-your-photos"
                                                   data-bs-target="#your-photos">Your Photos</a>
                                            </li>
                                        </ul>
                                        <div class="tab-content">
                                            <div class="tab-pane fade active show" id="photosofyou" role="tabpanel">
                                                <div class="card-body p-0">
                                                    <div class="d-grid gap-2 d-grid-template-1fr-13">
                                                        <div class="">
                                                            <div class="user-images position-relative overflow-hidden">
                                                                <a href="#">
                                                                    <img src="../assets/../assets/images/page-img/51.jpg"
                                                                         class="img-fluid rounded"
                                                                         alt="Responsive image">
                                                                </a>
                                                                <div class="image-hover-data">
                                                                    <div class="product-elements-icon">
                                                                        <ul class="d-flex align-items-center m-0 p-0 list-inline">
                                                                            <li><a href="#" class="pe-3 text-white"> 60
                                                                                <i class="ri-thumb-up-line"></i> </a>
                                                                            </li>
                                                                            <li><a href="#" class="pe-3 text-white"> 30
                                                                                <i class="ri-chat-3-line"></i> </a></li>
                                                                            <li><a href="#" class="pe-3 text-white"> 10
                                                                                <i class="ri-share-forward-line"></i>
                                                                            </a></li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                                <a href="#" class="image-edit-btn"
                                                                   data-bs-toggle="tooltip" data-bs-placement="top"
                                                                   title="" data-bs-original-title="Edit or Remove"><i
                                                                        class="ri-edit-2-fill"></i></a>
                                                            </div>
                                                        </div>
                                                        <div class="">
                                                            <div class="user-images position-relative overflow-hidden">
                                                                <a href="#">
                                                                    <img src="../assets/images/page-img/52.jpg"
                                                                         class="img-fluid rounded"
                                                                         alt="Responsive image">
                                                                </a>
                                                                <div class="image-hover-data">
                                                                    <div class="product-elements-icon">
                                                                        <ul class="d-flex align-items-center m-0 p-0 list-inline">
                                                                            <li><a href="#" class="pe-3 text-white"> 60
                                                                                <i class="ri-thumb-up-line"></i> </a>
                                                                            </li>
                                                                            <li><a href="#" class="pe-3 text-white"> 30
                                                                                <i class="ri-chat-3-line"></i> </a></li>
                                                                            <li><a href="#" class="pe-3 text-white"> 10
                                                                                <i class="ri-share-forward-line"></i>
                                                                            </a></li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                                <a href="#" class="image-edit-btn"
                                                                   data-bs-toggle="tooltip" data-bs-placement="top"
                                                                   title="" data-bs-original-title="Edit or Remove"><i
                                                                        class="ri-edit-2-fill"></i></a>
                                                            </div>
                                                        </div>
                                                        <div class="">
                                                            <div class="user-images position-relative overflow-hidden">
                                                                <a href="#">
                                                                    <img src="../assets/images/page-img/53.jpg"
                                                                         class="img-fluid rounded"
                                                                         alt="Responsive image">
                                                                </a>
                                                                <div class="image-hover-data">
                                                                    <div class="product-elements-icon">
                                                                        <ul class="d-flex align-items-center m-0 p-0 list-inline">
                                                                            <li><a href="#" class="pe-3 text-white"> 60
                                                                                <i class="ri-thumb-up-line"></i> </a>
                                                                            </li>
                                                                            <li><a href="#" class="pe-3 text-white"> 30
                                                                                <i class="ri-chat-3-line"></i> </a></li>
                                                                            <li><a href="#" class="pe-3 text-white"> 10
                                                                                <i class="ri-share-forward-line"></i>
                                                                            </a></li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                                <a href="#" class="image-edit-btn"
                                                                   data-bs-toggle="tooltip" data-bs-placement="top"
                                                                   title="" data-bs-original-title="Edit or Remove"><i
                                                                        class="ri-edit-2-fill"></i></a>
                                                            </div>
                                                        </div>
                                                        <div class="">
                                                            <div class="user-images position-relative overflow-hidden">
                                                                <a href="#">
                                                                    <img src="../assets/images/page-img/54.jpg"
                                                                         class="img-fluid rounded"
                                                                         alt="Responsive image">
                                                                </a>
                                                                <div class="image-hover-data">
                                                                    <div class="product-elements-icon">
                                                                        <ul class="d-flex align-items-center m-0 p-0 list-inline">
                                                                            <li><a href="#" class="pe-3 text-white"> 60
                                                                                <i class="ri-thumb-up-line"></i> </a>
                                                                            </li>
                                                                            <li><a href="#" class="pe-3 text-white"> 30
                                                                                <i class="ri-chat-3-line"></i> </a></li>
                                                                            <li><a href="#" class="pe-3 text-white"> 10
                                                                                <i class="ri-share-forward-line"></i>
                                                                            </a></li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                                <a href="#" class="image-edit-btn"
                                                                   data-bs-toggle="tooltip" data-bs-placement="top"
                                                                   title="" data-bs-original-title="Edit or Remove"><i
                                                                        class="ri-edit-2-fill"></i></a>
                                                            </div>
                                                        </div>
                                                        <div class="">
                                                            <div class="user-images position-relative overflow-hidden">
                                                                <a href="#">
                                                                    <img src="../assets/images/page-img/55.jpg"
                                                                         class="img-fluid rounded"
                                                                         alt="Responsive image">
                                                                </a>
                                                                <div class="image-hover-data">
                                                                    <div class="product-elements-icon">
                                                                        <ul class="d-flex align-items-center m-0 p-0 list-inline">
                                                                            <li><a href="#" class="pe-3 text-white"> 60
                                                                                <i class="ri-thumb-up-line"></i> </a>
                                                                            </li>
                                                                            <li><a href="#" class="pe-3 text-white"> 30
                                                                                <i class="ri-chat-3-line"></i> </a></li>
                                                                            <li><a href="#" class="pe-3 text-white"> 10
                                                                                <i class="ri-share-forward-line"></i>
                                                                            </a></li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                                <a href="#" class="image-edit-btn"
                                                                   data-bs-toggle="tooltip" data-bs-placement="top"
                                                                   title="" data-bs-original-title="Edit or Remove"><i
                                                                        class="ri-edit-2-fill"></i></a>
                                                            </div>
                                                        </div>
                                                        <div class="">
                                                            <div class="user-images position-relative overflow-hidden">
                                                                <a href="#">
                                                                    <img src="../assets/images/page-img/56.jpg"
                                                                         class="img-fluid rounded"
                                                                         alt="Responsive image">
                                                                </a>
                                                                <div class="image-hover-data">
                                                                    <div class="product-elements-icon">
                                                                        <ul class="d-flex align-items-center m-0 p-0 list-inline">
                                                                            <li><a href="#" class="pe-3 text-white"> 60
                                                                                <i class="ri-thumb-up-line"></i> </a>
                                                                            </li>
                                                                            <li><a href="#" class="pe-3 text-white"> 30
                                                                                <i class="ri-chat-3-line"></i> </a></li>
                                                                            <li><a href="#" class="pe-3 text-white"> 10
                                                                                <i class="ri-share-forward-line"></i>
                                                                            </a></li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                                <a href="#" class="image-edit-btn"
                                                                   data-bs-toggle="tooltip" data-bs-placement="top"
                                                                   title="" data-bs-original-title="Edit or Remove"><i
                                                                        class="ri-edit-2-fill"></i></a>
                                                            </div>
                                                        </div>
                                                        <div class="">
                                                            <div class="user-images position-relative overflow-hidden">
                                                                <a href="#">
                                                                    <img src="../assets/images/page-img/57.jpg"
                                                                         class="img-fluid rounded"
                                                                         alt="Responsive image">
                                                                </a>
                                                                <div class="image-hover-data">
                                                                    <div class="product-elements-icon">
                                                                        <ul class="d-flex align-items-center m-0 p-0 list-inline">
                                                                            <li><a href="#" class="pe-3 text-white"> 60
                                                                                <i class="ri-thumb-up-line"></i> </a>
                                                                            </li>
                                                                            <li><a href="#" class="pe-3 text-white"> 30
                                                                                <i class="ri-chat-3-line"></i> </a></li>
                                                                            <li><a href="#" class="pe-3 text-white"> 10
                                                                                <i class="ri-share-forward-line"></i>
                                                                            </a></li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                                <a href="#" class="image-edit-btn"
                                                                   data-bs-toggle="tooltip" data-bs-placement="top"
                                                                   title="" data-bs-original-title="Edit or Remove"><i
                                                                        class="ri-edit-2-fill"></i></a>
                                                            </div>
                                                        </div>
                                                        <div class="">
                                                            <div class="user-images position-relative overflow-hidden">
                                                                <a href="#">
                                                                    <img src="../assets/images/page-img/58.jpg"
                                                                         class="img-fluid rounded"
                                                                         alt="Responsive image">
                                                                </a>
                                                                <div class="image-hover-data">
                                                                    <div class="product-elements-icon">
                                                                        <ul class="d-flex align-items-center m-0 p-0 list-inline">
                                                                            <li><a href="#" class="pe-3 text-white"> 60
                                                                                <i class="ri-thumb-up-line"></i> </a>
                                                                            </li>
                                                                            <li><a href="#" class="pe-3 text-white"> 30
                                                                                <i class="ri-chat-3-line"></i> </a></li>
                                                                            <li><a href="#" class="pe-3 text-white"> 10
                                                                                <i class="ri-share-forward-line"></i>
                                                                            </a></li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                                <a href="#" class="image-edit-btn"
                                                                   data-bs-toggle="tooltip" data-bs-placement="top"
                                                                   title="" data-bs-original-title="Edit or Remove"><i
                                                                        class="ri-edit-2-fill"></i></a>
                                                            </div>
                                                        </div>
                                                        <div class="">
                                                            <div class="user-images position-relative overflow-hidden">
                                                                <a href="#">
                                                                    <img src="../assets/images/page-img/59.jpg"
                                                                         class="img-fluid rounded" alt="image">
                                                                </a>
                                                                <div class="image-hover-data">
                                                                    <div class="product-elements-icon">
                                                                        <ul class="d-flex align-items-center m-0 p-0 list-inline">
                                                                            <li><a href="#" class="pe-3 text-white"> 60
                                                                                <i class="ri-thumb-up-line"></i> </a>
                                                                            </li>
                                                                            <li><a href="#" class="pe-3 text-white"> 30
                                                                                <i class="ri-chat-3-line"></i> </a></li>
                                                                            <li><a href="#" class="pe-3 text-white"> 10
                                                                                <i class="ri-share-forward-line"></i>
                                                                            </a></li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                                <a href="#" class="image-edit-btn"
                                                                   data-bs-toggle="tooltip" data-bs-placement="top"
                                                                   title="" data-bs-original-title="Edit or Remove"><i
                                                                        class="ri-edit-2-fill"></i></a>
                                                            </div>
                                                        </div>
                                                        <div class="">
                                                            <div class="user-images position-relative overflow-hidden">
                                                                <a href="#">
                                                                    <img src="../assets/images/page-img/60.jpg"
                                                                         class="img-fluid rounded"
                                                                         alt="Responsive image">
                                                                </a>
                                                                <div class="image-hover-data">
                                                                    <div class="product-elements-icon">
                                                                        <ul class="d-flex align-items-center m-0 p-0 list-inline">
                                                                            <li><a href="#" class="pe-3 text-white"> 60
                                                                                <i class="ri-thumb-up-line"></i> </a>
                                                                            </li>
                                                                            <li><a href="#" class="pe-3 text-white"> 30
                                                                                <i class="ri-chat-3-line"></i> </a></li>
                                                                            <li><a href="#" class="pe-3 text-white"> 10
                                                                                <i class="ri-share-forward-line"></i>
                                                                            </a></li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                                <a href="#" class="image-edit-btn"
                                                                   data-bs-toggle="tooltip" data-bs-placement="top"
                                                                   title="" data-bs-original-title="Edit or Remove"><i
                                                                        class="ri-edit-2-fill"></i></a>
                                                            </div>
                                                        </div>
                                                        <div class="">
                                                            <div class="user-images position-relative overflow-hidden">
                                                                <a href="#">
                                                                    <img src="../assets/images/page-img/61.jpg"
                                                                         class="img-fluid rounded"
                                                                         alt="Responsive image">
                                                                </a>
                                                                <div class="image-hover-data">
                                                                    <div class="product-elements-icon">
                                                                        <ul class="d-flex align-items-center m-0 p-0 list-inline">
                                                                            <li><a href="#" class="pe-3 text-white"> 60
                                                                                <i class="ri-thumb-up-line"></i> </a>
                                                                            </li>
                                                                            <li><a href="#" class="pe-3 text-white"> 30
                                                                                <i class="ri-chat-3-line"></i> </a></li>
                                                                            <li><a href="#" class="pe-3 text-white"> 10
                                                                                <i class="ri-share-forward-line"></i>
                                                                            </a></li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                                <a href="#" class="image-edit-btn"
                                                                   data-bs-toggle="tooltip" data-bs-placement="top"
                                                                   title="" data-bs-original-title="Edit or Remove"><i
                                                                        class="ri-edit-2-fill"></i></a>
                                                            </div>
                                                        </div>
                                                        <div class="">
                                                            <div class="user-images position-relative overflow-hidden">
                                                                <a href="#">
                                                                    <img src="../assets/images/page-img/62.jpg"
                                                                         class="img-fluid rounded"
                                                                         alt="Responsive image">
                                                                </a>
                                                                <div class="image-hover-data">
                                                                    <div class="product-elements-icon">
                                                                        <ul class="d-flex align-items-center m-0 p-0 list-inline">
                                                                            <li><a href="#" class="pe-3 text-white"> 60
                                                                                <i class="ri-thumb-up-line"></i> </a>
                                                                            </li>
                                                                            <li><a href="#" class="pe-3 text-white"> 30
                                                                                <i class="ri-chat-3-line"></i> </a></li>
                                                                            <li><a href="#" class="pe-3 text-white"> 10
                                                                                <i class="ri-share-forward-line"></i>
                                                                            </a></li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                                <a href="#" class="image-edit-btn"
                                                                   data-bs-toggle="tooltip" data-bs-placement="top"
                                                                   title="" data-bs-original-title="Edit or Remove"><i
                                                                        class="ri-edit-2-fill"></i></a>
                                                            </div>
                                                        </div>
                                                        <div class="">
                                                            <div class="user-images position-relative overflow-hidden">
                                                                <a href="#">
                                                                    <img src="../assets/images/page-img/63.jpg"
                                                                         class="img-fluid rounded"
                                                                         alt="Responsive image">
                                                                </a>
                                                                <div class="image-hover-data">
                                                                    <div class="product-elements-icon">
                                                                        <ul class="d-flex align-items-center m-0 p-0 list-inline">
                                                                            <li><a href="#" class="pe-3 text-white"> 60
                                                                                <i class="ri-thumb-up-line"></i> </a>
                                                                            </li>
                                                                            <li><a href="#" class="pe-3 text-white"> 30
                                                                                <i class="ri-chat-3-line"></i> </a></li>
                                                                            <li><a href="#" class="pe-3 text-white"> 10
                                                                                <i class="ri-share-forward-line"></i>
                                                                            </a></li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                                <a href="#" class="image-edit-btn"
                                                                   data-bs-toggle="tooltip" data-bs-placement="top"
                                                                   title="" data-bs-original-title="Edit or Remove"><i
                                                                        class="ri-edit-2-fill"></i></a>
                                                            </div>
                                                        </div>
                                                        <div class="">
                                                            <div class="user-images position-relative overflow-hidden">
                                                                <a href="#">
                                                                    <img src="../assets/images/page-img/64.jpg"
                                                                         class="img-fluid rounded"
                                                                         alt="Responsive image">
                                                                </a>
                                                                <div class="image-hover-data">
                                                                    <div class="product-elements-icon">
                                                                        <ul class="d-flex align-items-center m-0 p-0 list-inline">
                                                                            <li><a href="#" class="pe-3 text-white"> 60
                                                                                <i class="ri-thumb-up-line"></i> </a>
                                                                            </li>
                                                                            <li><a href="#" class="pe-3 text-white"> 30
                                                                                <i class="ri-chat-3-line"></i> </a></li>
                                                                            <li><a href="#" class="pe-3 text-white"> 10
                                                                                <i class="ri-share-forward-line"></i>
                                                                            </a></li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                                <a href="#" class="image-edit-btn"
                                                                   data-bs-toggle="tooltip" data-bs-placement="top"
                                                                   title="" data-bs-original-title="Edit or Remove"><i
                                                                        class="ri-edit-2-fill"></i></a>
                                                            </div>
                                                        </div>
                                                        <div class="">
                                                            <div class="user-images position-relative overflow-hidden">
                                                                <a href="#">
                                                                    <img src="../assets/images/page-img/65.jpg"
                                                                         class="img-fluid rounded"
                                                                         alt="Responsive image">
                                                                </a>
                                                                <div class="image-hover-data">
                                                                    <div class="product-elements-icon">
                                                                        <ul class="d-flex align-items-center m-0 p-0 list-inline">
                                                                            <li><a href="#" class="pe-3 text-white"> 60
                                                                                <i class="ri-thumb-up-line"></i> </a>
                                                                            </li>
                                                                            <li><a href="#" class="pe-3 text-white"> 30
                                                                                <i class="ri-chat-3-line"></i> </a></li>
                                                                            <li><a href="#" class="pe-3 text-white"> 10
                                                                                <i class="ri-share-forward-line"></i>
                                                                            </a></li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                                <a href="#" class="image-edit-btn"
                                                                   data-bs-toggle="tooltip" data-bs-placement="top"
                                                                   title="" data-bs-original-title="Edit or Remove"><i
                                                                        class="ri-edit-2-fill"></i></a>
                                                            </div>
                                                        </div>
                                                        <div class="">
                                                            <div class="user-images position-relative overflow-hidden">
                                                                <a href="#">
                                                                    <img src="../assets/images/page-img/51.jpg"
                                                                         class="img-fluid rounded"
                                                                         alt="Responsive image">
                                                                </a>
                                                                <div class="image-hover-data">
                                                                    <div class="product-elements-icon">
                                                                        <ul class="d-flex align-items-center m-0 p-0 list-inline">
                                                                            <li><a href="#" class="pe-3 text-white"> 60
                                                                                <i class="ri-thumb-up-line"></i> </a>
                                                                            </li>
                                                                            <li><a href="#" class="pe-3 text-white"> 30
                                                                                <i class="ri-chat-3-line"></i> </a></li>
                                                                            <li><a href="#" class="pe-3 text-white"> 10
                                                                                <i class="ri-share-forward-line"></i>
                                                                            </a></li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                                <a href="#" class="image-edit-btn"
                                                                   data-bs-toggle="tooltip" data-bs-placement="top"
                                                                   title="" data-bs-original-title="Edit or Remove"><i
                                                                        class="ri-edit-2-fill"></i></a>
                                                            </div>
                                                        </div>
                                                        <div class="">
                                                            <div class="user-images position-relative overflow-hidden">
                                                                <a href="#">
                                                                    <img src="../assets/images/page-img/52.jpg"
                                                                         class="img-fluid rounded"
                                                                         alt="Responsive image">
                                                                </a>
                                                                <div class="image-hover-data">
                                                                    <div class="product-elements-icon">
                                                                        <ul class="d-flex align-items-center m-0 p-0 list-inline">
                                                                            <li><a href="#" class="pe-3 text-white"> 60
                                                                                <i class="ri-thumb-up-line"></i> </a>
                                                                            </li>
                                                                            <li><a href="#" class="pe-3 text-white"> 30
                                                                                <i class="ri-chat-3-line"></i> </a></li>
                                                                            <li><a href="#" class="pe-3 text-white"> 10
                                                                                <i class="ri-share-forward-line"></i>
                                                                            </a></li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                                <a href="#" class="image-edit-btn"
                                                                   data-bs-toggle="tooltip" data-bs-placement="top"
                                                                   title="" data-bs-original-title="Edit or Remove"><i
                                                                        class="ri-edit-2-fill"></i></a>
                                                            </div>
                                                        </div>
                                                        <div class="">
                                                            <div class="user-images position-relative overflow-hidden">
                                                                <a href="#">
                                                                    <img src="../assets/images/page-img/53.jpg"
                                                                         class="img-fluid rounded"
                                                                         alt="Responsive image">
                                                                </a>
                                                                <div class="image-hover-data">
                                                                    <div class="product-elements-icon">
                                                                        <ul class="d-flex align-items-center m-0 p-0 list-inline">
                                                                            <li><a href="#" class="pe-3 text-white"> 60
                                                                                <i class="ri-thumb-up-line"></i> </a>
                                                                            </li>
                                                                            <li><a href="#" class="pe-3 text-white"> 30
                                                                                <i class="ri-chat-3-line"></i> </a></li>
                                                                            <li><a href="#" class="pe-3 text-white"> 10
                                                                                <i class="ri-share-forward-line"></i>
                                                                            </a></li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                                <a href="#" class="image-edit-btn"
                                                                   data-bs-toggle="tooltip" data-bs-placement="top"
                                                                   title="" data-bs-original-title="Edit or Remove"><i
                                                                        class="ri-edit-2-fill"></i></a>
                                                            </div>
                                                        </div>
                                                        <div class="">
                                                            <div class="user-images position-relative overflow-hidden">
                                                                <a href="#">
                                                                    <img src="../assets/images/page-img/54.jpg"
                                                                         class="img-fluid rounded"
                                                                         alt="Responsive image">
                                                                </a>
                                                                <div class="image-hover-data">
                                                                    <div class="product-elements-icon">
                                                                        <ul class="d-flex align-items-center m-0 p-0 list-inline">
                                                                            <li><a href="#" class="pe-3 text-white"> 60
                                                                                <i class="ri-thumb-up-line"></i> </a>
                                                                            </li>
                                                                            <li><a href="#" class="pe-3 text-white"> 30
                                                                                <i class="ri-chat-3-line"></i> </a></li>
                                                                            <li><a href="#" class="pe-3 text-white"> 10
                                                                                <i class="ri-share-forward-line"></i>
                                                                            </a></li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                                <a href="#" class="image-edit-btn"
                                                                   data-bs-toggle="tooltip" data-bs-placement="top"
                                                                   title="" data-bs-original-title="Edit or Remove"><i
                                                                        class="ri-edit-2-fill"></i></a>
                                                            </div>
                                                        </div>
                                                        <div class="">
                                                            <div class="user-images position-relative overflow-hidden">
                                                                <a href="#">
                                                                    <img src="../assets/images/page-img/55.jpg"
                                                                         class="img-fluid rounded"
                                                                         alt="Responsive image">
                                                                </a>
                                                                <div class="image-hover-data">
                                                                    <div class="product-elements-icon">
                                                                        <ul class="d-flex align-items-center m-0 p-0 list-inline">
                                                                            <li><a href="#" class="pe-3 text-white"> 60
                                                                                <i class="ri-thumb-up-line"></i> </a>
                                                                            </li>
                                                                            <li><a href="#" class="pe-3 text-white"> 30
                                                                                <i class="ri-chat-3-line"></i> </a></li>
                                                                            <li><a href="#" class="pe-3 text-white"> 10
                                                                                <i class="ri-share-forward-line"></i>
                                                                            </a></li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                                <a href="#" class="image-edit-btn"
                                                                   data-bs-toggle="tooltip" data-bs-placement="top"
                                                                   title="" data-bs-original-title="Edit or Remove"><i
                                                                        class="ri-edit-2-fill"></i></a>
                                                            </div>
                                                        </div>
                                                        <div class="">
                                                            <div class="user-images position-relative overflow-hidden">
                                                                <a href="#">
                                                                    <img src="../assets/images/page-img/56.jpg"
                                                                         class="img-fluid rounded"
                                                                         alt="Responsive image">
                                                                </a>
                                                                <div class="image-hover-data">
                                                                    <div class="product-elements-icon">
                                                                        <ul class="d-flex align-items-center m-0 p-0 list-inline">
                                                                            <li><a href="#" class="pe-3 text-white"> 60
                                                                                <i class="ri-thumb-up-line"></i> </a>
                                                                            </li>
                                                                            <li><a href="#" class="pe-3 text-white"> 30
                                                                                <i class="ri-chat-3-line"></i> </a></li>
                                                                            <li><a href="#" class="pe-3 text-white"> 10
                                                                                <i class="ri-share-forward-line"></i>
                                                                            </a></li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                                <a href="#" class="image-edit-btn"
                                                                   data-bs-toggle="tooltip" data-bs-placement="top"
                                                                   title="" data-bs-original-title="Edit or Remove"><i
                                                                        class="ri-edit-2-fill"></i></a>
                                                            </div>
                                                        </div>
                                                        <div class="">
                                                            <div class="user-images position-relative overflow-hidden">
                                                                <a href="#">
                                                                    <img src="../assets/images/page-img/57.jpg"
                                                                         class="img-fluid rounded"
                                                                         alt="Responsive image">
                                                                </a>
                                                                <div class="image-hover-data">
                                                                    <div class="product-elements-icon">
                                                                        <ul class="d-flex align-items-center m-0 p-0 list-inline">
                                                                            <li><a href="#" class="pe-3 text-white"> 60
                                                                                <i class="ri-thumb-up-line"></i> </a>
                                                                            </li>
                                                                            <li><a href="#" class="pe-3 text-white"> 30
                                                                                <i class="ri-chat-3-line"></i> </a></li>
                                                                            <li><a href="#" class="pe-3 text-white"> 10
                                                                                <i class="ri-share-forward-line"></i>
                                                                            </a></li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                                <a href="#" class="image-edit-btn"
                                                                   data-bs-toggle="tooltip" data-bs-placement="top"
                                                                   title="" data-bs-original-title="Edit or Remove"><i
                                                                        class="ri-edit-2-fill"></i></a>
                                                            </div>
                                                        </div>
                                                        <div class="">
                                                            <div class="user-images position-relative overflow-hidden">
                                                                <a href="#">
                                                                    <img src="../assets/images/page-img/58.jpg"
                                                                         class="img-fluid rounded"
                                                                         alt="Responsive image">
                                                                </a>
                                                                <div class="image-hover-data">
                                                                    <div class="product-elements-icon">
                                                                        <ul class="d-flex align-items-center m-0 p-0 list-inline">
                                                                            <li><a href="#" class="pe-3 text-white"> 60
                                                                                <i class="ri-thumb-up-line"></i> </a>
                                                                            </li>
                                                                            <li><a href="#" class="pe-3 text-white"> 30
                                                                                <i class="ri-chat-3-line"></i> </a></li>
                                                                            <li><a href="#" class="pe-3 text-white"> 10
                                                                                <i class="ri-share-forward-line"></i>
                                                                            </a></li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                                <a href="#" class="image-edit-btn"
                                                                   data-bs-toggle="tooltip" data-bs-placement="top"
                                                                   title="" data-bs-original-title="Edit or Remove"><i
                                                                        class="ri-edit-2-fill"></i></a>
                                                            </div>
                                                        </div>
                                                        <div class="">
                                                            <div class="user-images position-relative overflow-hidden">
                                                                <a href="#">
                                                                    <img src="../assets/images/page-img/59.jpg"
                                                                         class="img-fluid rounded"
                                                                         alt="Responsive image">
                                                                </a>
                                                                <div class="image-hover-data">
                                                                    <div class="product-elements-icon">
                                                                        <ul class="d-flex align-items-center m-0 p-0 list-inline">
                                                                            <li><a href="#" class="pe-3 text-white"> 60
                                                                                <i class="ri-thumb-up-line"></i> </a>
                                                                            </li>
                                                                            <li><a href="#" class="pe-3 text-white"> 30
                                                                                <i class="ri-chat-3-line"></i> </a></li>
                                                                            <li><a href="#" class="pe-3 text-white"> 10
                                                                                <i class="ri-share-forward-line"></i>
                                                                            </a></li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                                <a href="#" class="image-edit-btn"
                                                                   data-bs-toggle="tooltip" data-bs-placement="top"
                                                                   title="" data-bs-original-title="Edit or Remove"><i
                                                                        class="ri-edit-2-fill"></i></a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="tab-pane fade" id="your-photos" role="tabpanel">
                                                <div class="card-body p-0">
                                                    <div class="d-grid gap-2 d-grid-template-1fr-13 ">
                                                        <div class="">
                                                            <div class="user-images position-relative overflow-hidden">
                                                                <a href="#">
                                                                    <img src="../assets/images/page-img/51.jpg"
                                                                         class="img-fluid rounded"
                                                                         alt="Responsive image">
                                                                </a>
                                                                <div class="image-hover-data">
                                                                    <div class="product-elements-icon">
                                                                        <ul class="d-flex align-items-center m-0 p-0 list-inline">
                                                                            <li><a href="#" class="pe-3 text-white"> 60
                                                                                <i class="ri-thumb-up-line"></i> </a>
                                                                            </li>
                                                                            <li><a href="#" class="pe-3 text-white"> 30
                                                                                <i class="ri-chat-3-line"></i> </a></li>
                                                                            <li><a href="#" class="pe-3 text-white"> 10
                                                                                <i class="ri-share-forward-line"></i>
                                                                            </a></li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                                <a href="#" class="image-edit-btn"
                                                                   data-bs-toggle="tooltip" data-bs-placement="top"
                                                                   title="" data-bs-original-title="Edit or Remove"><i
                                                                        class="ri-edit-2-fill"></i></a>
                                                            </div>
                                                        </div>
                                                        <div class="">
                                                            <div class="user-images position-relative overflow-hidden">
                                                                <a href="#">
                                                                    <img src="../assets/images/page-img/52.jpg"
                                                                         class="img-fluid rounded"
                                                                         alt="Responsive image">
                                                                </a>
                                                                <div class="image-hover-data">
                                                                    <div class="product-elements-icon">
                                                                        <ul class="d-flex align-items-center m-0 p-0 list-inline">
                                                                            <li><a href="#" class="pe-3 text-white"> 60
                                                                                <i class="ri-thumb-up-line"></i> </a>
                                                                            </li>
                                                                            <li><a href="#" class="pe-3 text-white"> 30
                                                                                <i class="ri-chat-3-line"></i> </a></li>
                                                                            <li><a href="#" class="pe-3 text-white"> 10
                                                                                <i class="ri-share-forward-line"></i>
                                                                            </a></li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                                <a href="#" class="image-edit-btn"
                                                                   data-bs-toggle="tooltip" data-bs-placement="top"
                                                                   title="" data-bs-original-title="Edit or Remove"><i
                                                                        class="ri-edit-2-fill"></i></a>
                                                            </div>
                                                        </div>
                                                        <div class="">
                                                            <div class="user-images position-relative overflow-hidden">
                                                                <a href="#">
                                                                    <img src="../assets/images/page-img/53.jpg"
                                                                         class="img-fluid rounded"
                                                                         alt="Responsive image">
                                                                </a>
                                                                <div class="image-hover-data">
                                                                    <div class="product-elements-icon">
                                                                        <ul class="d-flex align-items-center m-0 p-0 list-inline">
                                                                            <li><a href="#" class="pe-3 text-white"> 60
                                                                                <i class="ri-thumb-up-line"></i> </a>
                                                                            </li>
                                                                            <li><a href="#" class="pe-3 text-white"> 30
                                                                                <i class="ri-chat-3-line"></i> </a></li>
                                                                            <li><a href="#" class="pe-3 text-white"> 10
                                                                                <i class="ri-share-forward-line"></i>
                                                                            </a></li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                                <a href="#" class="image-edit-btn"
                                                                   data-bs-toggle="tooltip" data-bs-placement="top"
                                                                   title="" data-bs-original-title="Edit or Remove"><i
                                                                        class="ri-edit-2-fill"></i></a>
                                                            </div>
                                                        </div>
                                                        <div class="">
                                                            <div class="user-images position-relative overflow-hidden">
                                                                <a href="#">
                                                                    <img src="../assets/images/page-img/54.jpg"
                                                                         class="img-fluid rounded"
                                                                         alt="Responsive image">
                                                                </a>
                                                                <div class="image-hover-data">
                                                                    <div class="product-elements-icon">
                                                                        <ul class="d-flex align-items-center m-0 p-0 list-inline">
                                                                            <li><a href="#" class="pe-3 text-white"> 60
                                                                                <i class="ri-thumb-up-line"></i> </a>
                                                                            </li>
                                                                            <li><a href="#" class="pe-3 text-white"> 30
                                                                                <i class="ri-chat-3-line"></i> </a></li>
                                                                            <li><a href="#" class="pe-3 text-white"> 10
                                                                                <i class="ri-share-forward-line"></i>
                                                                            </a></li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                                <a href="#" class="image-edit-btn"
                                                                   data-bs-toggle="tooltip" data-bs-placement="top"
                                                                   title="" data-bs-original-title="Edit or Remove"><i
                                                                        class="ri-edit-2-fill"></i></a>
                                                            </div>
                                                        </div>
                                                        <div class="">
                                                            <div class="user-images position-relative overflow-hidden">
                                                                <a href="#">
                                                                    <img src="../assets/images/page-img/55.jpg"
                                                                         class="img-fluid rounded"
                                                                         alt="Responsive image">
                                                                </a>
                                                                <div class="image-hover-data">
                                                                    <div class="product-elements-icon">
                                                                        <ul class="d-flex align-items-center m-0 p-0 list-inline">
                                                                            <li><a href="#" class="pe-3 text-white"> 60
                                                                                <i class="ri-thumb-up-line"></i> </a>
                                                                            </li>
                                                                            <li><a href="#" class="pe-3 text-white"> 30
                                                                                <i class="ri-chat-3-line"></i> </a></li>
                                                                            <li><a href="#" class="pe-3 text-white"> 10
                                                                                <i class="ri-share-forward-line"></i>
                                                                            </a></li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                                <a href="#" class="image-edit-btn"
                                                                   data-bs-toggle="tooltip" data-bs-placement="top"
                                                                   title="" data-bs-original-title="Edit or Remove"><i
                                                                        class="ri-edit-2-fill"></i></a>
                                                            </div>
                                                        </div>
                                                        <div class="">
                                                            <div class="user-images position-relative overflow-hidden">
                                                                <a href="#">
                                                                    <img src="../assets/images/page-img/56.jpg"
                                                                         class="img-fluid rounded"
                                                                         alt="Responsive image">
                                                                </a>
                                                                <div class="image-hover-data">
                                                                    <div class="product-elements-icon">
                                                                        <ul class="d-flex align-items-center m-0 p-0 list-inline">
                                                                            <li><a href="#" class="pe-3 text-white"> 60
                                                                                <i class="ri-thumb-up-line"></i> </a>
                                                                            </li>
                                                                            <li><a href="#" class="pe-3 text-white"> 30
                                                                                <i class="ri-chat-3-line"></i> </a></li>
                                                                            <li><a href="#" class="pe-3 text-white"> 10
                                                                                <i class="ri-share-forward-line"></i>
                                                                            </a></li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                                <a href="#" class="image-edit-btn"
                                                                   data-bs-toggle="tooltip" data-bs-placement="top"
                                                                   title="" data-bs-original-title="Edit or Remove"><i
                                                                        class="ri-edit-2-fill"></i></a>
                                                            </div>
                                                        </div>
                                                        <div class="">
                                                            <div class="user-images position-relative overflow-hidden">
                                                                <a href="#">
                                                                    <img src="../assets/images/page-img/57.jpg"
                                                                         class="img-fluid rounded"
                                                                         alt="Responsive image">
                                                                </a>
                                                                <div class="image-hover-data">
                                                                    <div class="product-elements-icon">
                                                                        <ul class="d-flex align-items-center m-0 p-0 list-inline">
                                                                            <li><a href="#" class="pe-3 text-white"> 60
                                                                                <i class="ri-thumb-up-line"></i> </a>
                                                                            </li>
                                                                            <li><a href="#" class="pe-3 text-white"> 30
                                                                                <i class="ri-chat-3-line"></i> </a></li>
                                                                            <li><a href="#" class="pe-3 text-white"> 10
                                                                                <i class="ri-share-forward-line"></i>
                                                                            </a></li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                                <a href="#" class="image-edit-btn"
                                                                   data-bs-toggle="tooltip" data-bs-placement="top"
                                                                   title="" data-bs-original-title="Edit or Remove"><i
                                                                        class="ri-edit-2-fill"></i></a>
                                                            </div>
                                                        </div>
                                                        <div class="">
                                                            <div class="user-images position-relative overflow-hidden">
                                                                <a href="#">
                                                                    <img src="../assets/images/page-img/58.jpg"
                                                                         class="img-fluid rounded"
                                                                         alt="Responsive image">
                                                                </a>
                                                                <div class="image-hover-data">
                                                                    <div class="product-elements-icon">
                                                                        <ul class="d-flex align-items-center m-0 p-0 list-inline">
                                                                            <li><a href="#" class="pe-3 text-white"> 60
                                                                                <i class="ri-thumb-up-line"></i> </a>
                                                                            </li>
                                                                            <li><a href="#" class="pe-3 text-white"> 30
                                                                                <i class="ri-chat-3-line"></i> </a></li>
                                                                            <li><a href="#" class="pe-3 text-white"> 10
                                                                                <i class="ri-share-forward-line"></i>
                                                                            </a></li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                                <a href="#" class="image-edit-btn"
                                                                   data-bs-toggle="tooltip" data-bs-placement="top"
                                                                   title="" data-bs-original-title="Edit or Remove"><i
                                                                        class="ri-edit-2-fill"></i></a>
                                                            </div>
                                                        </div>
                                                        <div class="">
                                                            <div class="user-images position-relative overflow-hidden">
                                                                <a href="#">
                                                                    <img src="../assets/images/page-img/59.jpg"
                                                                         class="img-fluid rounded"
                                                                         alt="Responsive image">
                                                                </a>
                                                                <div class="image-hover-data">
                                                                    <div class="product-elements-icon">
                                                                        <ul class="d-flex align-items-center m-0 p-0 list-inline">
                                                                            <li><a href="#" class="pe-3 text-white"> 60
                                                                                <i class="ri-thumb-up-line"></i> </a>
                                                                            </li>
                                                                            <li><a href="#" class="pe-3 text-white"> 30
                                                                                <i class="ri-chat-3-line"></i> </a></li>
                                                                            <li><a href="#" class="pe-3 text-white"> 10
                                                                                <i class="ri-share-forward-line"></i>
                                                                            </a></li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                                <a href="#" class="image-edit-btn"
                                                                   data-bs-toggle="tooltip" data-bs-placement="top"
                                                                   title="" data-bs-original-title="Edit or Remove"><i
                                                                        class="ri-edit-2-fill"></i></a>
                                                            </div>
                                                        </div>
                                                        <div class="">
                                                            <div class="user-images position-relative overflow-hidden">
                                                                <a href="#">
                                                                    <img src="../assets/images/page-img/60.jpg"
                                                                         class="img-fluid rounded"
                                                                         alt="Responsive image">
                                                                </a>
                                                                <div class="image-hover-data">
                                                                    <div class="product-elements-icon">
                                                                        <ul class="d-flex align-items-center m-0 p-0 list-inline">
                                                                            <li><a href="#" class="pe-3 text-white"> 60
                                                                                <i class="ri-thumb-up-line"></i> </a>
                                                                            </li>
                                                                            <li><a href="#" class="pe-3 text-white"> 30
                                                                                <i class="ri-chat-3-line"></i> </a></li>
                                                                            <li><a href="#" class="pe-3 text-white"> 10
                                                                                <i class="ri-share-forward-line"></i>
                                                                            </a></li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                                <a href="#" class="image-edit-btn"
                                                                   data-bs-toggle="tooltip" data-bs-placement="top"
                                                                   title="" data-bs-original-title="Edit or Remove"><i
                                                                        class="ri-edit-2-fill"></i></a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="<%=request.getContextPath()%>/assets/js/libs.min.js"></script>
<!-- slider JavaScript -->
<script src="<%=request.getContextPath()%>/assets/js/slider.js"></script>
<!-- masonry JavaScript -->
<script src="<%=request.getContextPath()%>/assets/js/masonry.pkgd.min.js"></script>
<!-- SweetAlert JavaScript -->
<script src="<%=request.getContextPath()%>/assets/js/enchanter.js"></script>
<!-- SweetAlert JavaScript -->
<script src="<%=request.getContextPath()%>/assets/js/sweetalert.js"></script>
<!-- app JavaScript -->
<script src="<%=request.getContextPath()%>/assets/js/charts/weather-chart.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/app.js"></script>
<script src="<%=request.getContextPath()%>/vendor/vanillajs-datepicker/dist/js/datepicker.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/lottie.js"></script>
</body>
</html>