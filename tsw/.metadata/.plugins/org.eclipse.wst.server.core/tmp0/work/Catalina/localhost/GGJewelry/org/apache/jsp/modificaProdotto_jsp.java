/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.86
 * Generated at: 2024-07-01 15:22:20 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.ProdottoBean;

public final class modificaProdotto_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(1);
    _jspx_imports_classes.add("model.ProdottoBean");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html class=\"no-js\" lang=\"zxx\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <meta name=\"description\" content=\"meta description\">\r\n");
      out.write("    <title>Modifica Prodotto</title>\r\n");
      out.write("    <link rel=\"shortcut icon\" href=\"assets/img/logo.png\" type=\"image/x-icon\"/>\r\n");
      out.write("\r\n");
      out.write("    <!--== Google Fonts ==-->\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("          href=\"https://fonts.googleapis.com/css?family=Droid+Serif:400,400i,700,700i\"/>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"https://fonts.googleapis.com/css?family=Montserrat:400,700\"/>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("          href=\"https://fonts.googleapis.com/css?family=Playfair+Display:400,400i,700,700i\"/>\r\n");
      out.write("\r\n");
      out.write("    <!--=== Bootstrap CSS ===-->\r\n");
      out.write("    <link href=\"assets/css/vendor/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <!--=== Font-Awesome CSS ===-->\r\n");
      out.write("    <link href=\"assets/css/vendor/font-awesome.css\" rel=\"stylesheet\">\r\n");
      out.write("    <!--=== Plugins CSS ===-->\r\n");
      out.write("    <link href=\"assets/css/plugins.css\" rel=\"stylesheet\">\r\n");
      out.write("    <!--=== Main Style CSS ===-->\r\n");
      out.write("    <link href=\"assets/css/style.css\" rel=\"stylesheet\">\r\n");
      out.write("    <!-- Modernizer JS -->\r\n");
      out.write("    <script src=\"assets/js/vendor/modernizr-2.8.3.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "fragments/header.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!--== Page Title Area Start ==-->\r\n");
      out.write("<div id=\"page-title-area\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"col-12 text-center\">\r\n");
      out.write("                <div class=\"page-title-content\">\r\n");
      out.write("                    <h1>Modifica Prodotto</h1>\r\n");
      out.write("                    <ul class=\"breadcrumb\">\r\n");
      out.write("                        <li><a href=\"homePage.jsp\">Home</a></li>\r\n");
      out.write("                        <li><a href=\"adminArea.jsp\">Indietro</a></li>\r\n");
      out.write("                        <li><a class=\"active\">Modifica Prodotto</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<!--== Page Title Area End ==-->\r\n");
      out.write("\r\n");
      out.write("<!--== Page Content Wrapper Start ==-->\r\n");
      out.write("<div id=\"page-content-wrapper\" class=\"p-9\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"col-lg-7 m-auto\">\r\n");
      out.write("                <div class=\"login-register-wrapper\">\r\n");
      out.write("                    <div class=\"tab-content\" id=\"login-reg-tabcontent\">\r\n");
      out.write("                        <div class=\"tab-pane fade show active\" id=\"register\" role=\"tabpanel\">\r\n");
      out.write("                            <div class=\"login-reg-form-wrap\">\r\n");
      out.write("                                ");
 
                                    ProdottoBean prodotto = (ProdottoBean) request.getAttribute("prodotto");
                                    if (prodotto == null) {
                                        out.println("Errore: prodotto non trovato");
                                        return;
                                    }
                                
      out.write("\r\n");
      out.write("                                <form action=\"modificaProdotto\" method=\"post\">\r\n");
      out.write("    <div class=\"single-input-item\">\r\n");
      out.write("        <input type=\"hidden\" id=\"id\" name=\"id\" value=\"");
      out.print( prodotto.getId() );
      out.write("\">\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"single-input-item\">\r\n");
      out.write("        <label for=\"nome\">Nome:</label>\r\n");
      out.write("        <input type=\"text\" placeholder=\"Nome\" id=\"nome\" name=\"nome\" value=\"");
      out.print( prodotto.getNome() );
      out.write("\" required>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"single-input-item\">\r\n");
      out.write("        <label for=\"descrizione\">Descrizione:</label>\r\n");
      out.write("        <textarea placeholder=\"Descrizione\" id=\"descrizione\" name=\"descrizione\" required>");
      out.print( prodotto.getDescrizione() );
      out.write("</textarea>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"single-input-item\">\r\n");
      out.write("        <label for=\"quantita\">Quantità:</label>\r\n");
      out.write("        <input type=\"number\" placeholder=\"Quantità\" id=\"quantita\" name=\"quantita\" value=\"");
      out.print( prodotto.getQuantita() );
      out.write("\" required>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"single-input-item\">\r\n");
      out.write("        <label for=\"costo\">Costo:</label>\r\n");
      out.write("        <input type=\"number\" placeholder=\"Costo\" id=\"costo\" name=\"costo\" value=\"");
      out.print( prodotto.getCosto() );
      out.write("\" required>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"single-input-item\">\r\n");
      out.write("        <label for=\"sesso\">Sesso:</label>\r\n");
      out.write("        <select class=\"form-control\" id=\"sesso\" name=\"sesso\" required>\r\n");
      out.write("            <option value=\"M\" ");
      out.print( prodotto.getSesso().equals("M") ? "selected" : "" );
      out.write(">Maschile</option>\r\n");
      out.write("            <option value=\"F\" ");
      out.print( prodotto.getSesso().equals("F") ? "selected" : "" );
      out.write(">Femminile</option>\r\n");
      out.write("        </select>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"single-input-item\">\r\n");
      out.write("        <label for=\"immagine\">Immagine URL:</label>\r\n");
      out.write("        <input type=\"text\" placeholder=\"Immagine URL\" id=\"immagine\" name=\"immagine\" value=\"");
      out.print( prodotto.getImmagine() );
      out.write("\" required>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"single-input-item\">\r\n");
      out.write("        <label for=\"categoriaNome\">Categoria:</label>\r\n");
      out.write("        <input type=\"text\" placeholder=\"Categoria\" id=\"categoriaNome\" name=\"categoriaNome\" value=\"");
      out.print( prodotto.getCategoriaNome() );
      out.write("\" required>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"single-input-item\">\r\n");
      out.write("        <button class=\"btn-login\" type=\"submit\">Salva Modifiche</button>\r\n");
      out.write("    </div>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<!--== Page Content Wrapper End ==-->\r\n");
      out.write("\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "fragments/footer.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- Scroll to Top Start -->\r\n");
      out.write("<a href=\"#\" class=\"scrolltotop\"><i class=\"fa fa-angle-up\"></i></a>\r\n");
      out.write("<!-- Scroll to Top End -->\r\n");
      out.write("\r\n");
      out.write("<!--=== Javascript ===-->\r\n");
      out.write("<script src=\"assets/js/vendor/jquery-3.3.1.min.js\"></script>\r\n");
      out.write("<script src=\"assets/js/vendor/bootstrap.min.js\"></script>\r\n");
      out.write("<script src=\"assets/js/plugins.js\"></script>\r\n");
      out.write("<script src=\"assets/js/active.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
