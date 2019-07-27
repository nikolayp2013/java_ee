package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ru.javabegin.training.web.beans.Genre;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/WEB-INF/jspf/header.jspf");
    _jspx_dependants.add("/pages/../WEB-INF/jspf/left_menu.jspf");
    _jspx_dependants.add("/WEB-INF/jspf/footer.jspf");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Онлайн библиотека</title>\n");
      out.write("        <link href=\"../css/style_main.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("\n");
      out.write("            <div class=\"header\">\n");
      out.write("                <div class=\"logo\">\n");
      out.write("                    <img src=\"../images/library.png\" alt=\"Логотип\" name=\"logo\" />\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"descr\">\n");
      out.write("                    <h3>Онлайн библиотека проекта javabegin.ru</h3>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"search_form\">\n");
      out.write("                    <form name=\"search_form\" method=\"POST\">\n");
      out.write("                        <input type=\"text\" name=\"search_String\" value=\"\" size=\"110\" />\n");
      out.write("                        <input class=\"search_button\" type=\"submit\" value=\"Поиск\" name=\"search_button\" />\n");
      out.write("                        <select name=\"search_option\">\n");
      out.write("                            <option>Название</option>\n");
      out.write("                            <option>Автор</option>\n");
      out.write("                        </select>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("           \n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"sidebar1\">\n");
      out.write("    <h4>Жанры:</h4>\n");
      out.write("    <ul class=\"nav\">\n");
      out.write("        ");
      ru.javabegin.training.web.beans.GenreList genreList = null;
      synchronized (application) {
        genreList = (ru.javabegin.training.web.beans.GenreList) _jspx_page_context.getAttribute("genreList", PageContext.APPLICATION_SCOPE);
        if (genreList == null){
          genreList = new ru.javabegin.training.web.beans.GenreList();
          _jspx_page_context.setAttribute("genreList", genreList, PageContext.APPLICATION_SCOPE);
        }
      }
      out.write("\n");
      out.write("        ");

            for (Genre genre : genreList.getGenreList()) {
        
      out.write("\n");
      out.write("        <li><a href=\"books.jsp?genre_id=");
      out.print(genre.getId());
      out.write("&name=");
      out.print(genre.getName());
      out.write('"');
      out.write('>');
      out.print(genre.getName());
      out.write("</a></li>\n");
      out.write("\n");
      out.write("        ");
}
      out.write("\n");
      out.write("    </ul>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("           \n");
      out.write("\n");
      out.write("\n");
      out.write("      ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<div style=\"clear:both;\"></div>\n");
      out.write("  </div><!-- end .container -->\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
