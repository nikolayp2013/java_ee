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
    _jspx_dependants = new java.util.ArrayList<String>(4);
    _jspx_dependants.add("/WEB-INF/jspf/header.jspf");
    _jspx_dependants.add("/pages/../WEB-INF/jspf/left_menu.jspf");
    _jspx_dependants.add("/pages/../WEB-INF/jspf/letters.jspf");
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Онлайн библиотека</title>\r\n");
      out.write("        <link href=\"../css/style_main.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");


            request.setCharacterEncoding("UTF-8");
            String searchString = "";

            if (request.getParameter("search_string") != null) {
                searchString = request.getParameter("search_string");
                session.setAttribute("search_string", searchString);
            } else if (session.getAttribute("search_string") != null) {
                searchString = session.getAttribute("search_string").toString();
            } else {
                session.setAttribute("search_string", searchString);
            }
            
            if (request.getParameter("username") != null) {
                session.setAttribute("username", request.getParameter("username"));
            }

        
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("            <div class=\"header\">\r\n");
      out.write("                <div class=\"logo\">\r\n");
      out.write("                    <a href=\"main.jsp\"><img src=\"../images/library.png\" alt=\"Логотип\" name=\"logo\" /></a>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"descr\">\r\n");
      out.write("                    <h3>Онлайн библиотека проекта javabegin.ru <br/> Все книги - в электронном виде!</h3>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"welcome\">\r\n");
      out.write("                    <h5>Добро пожаловать, ");
      out.print(session.getAttribute("username"));
      out.write(" !</h5>\r\n");
      out.write("                    <h6><a href=\"../index.jsp\">Выход</a></h6>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"search_form\">\r\n");
      out.write("                                <form name=\"search_form\" method=\"GET\" action=\"books.jsp\">\r\n");
      out.write("                                    <input type=\"text\" name=\"search_string\" value=\"");
      out.print(searchString);
      out.write("\" size=\"110\"/>\r\n");
      out.write("                                    <input class=\"search_button\" type=\"submit\" value=\"Поиск\"/>\r\n");
      out.write("                                    <select name=\"search_option\">\r\n");
      out.write("                                        <option>Название</option>\r\n");
      out.write("                                        <option>Автор</option>\r\n");
      out.write("                                    </select>\r\n");
      out.write("                                </form>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            </div>");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("           \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"sidebar1\">\r\n");
      out.write("    <h4>Жанры:</h4>\r\n");
      out.write("    <ul class=\"nav\">\r\n");
      out.write("        ");
      ru.javabegin.training.web.beans.GenreList genreList = null;
      synchronized (application) {
        genreList = (ru.javabegin.training.web.beans.GenreList) _jspx_page_context.getAttribute("genreList", PageContext.APPLICATION_SCOPE);
        if (genreList == null){
          genreList = new ru.javabegin.training.web.beans.GenreList();
          _jspx_page_context.setAttribute("genreList", genreList, PageContext.APPLICATION_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("\r\n");
      out.write("        ");


            long selectedGenreId = 0;


            if (request.getParameter("genre_id") != null) {
                selectedGenreId = Long.valueOf(request.getParameter("genre_id"));
                
            } else if (session.getAttribute("genre_id") != null) {
                selectedGenreId = Long.valueOf(session.getAttribute("genreId").toString());
            }
            
            session.setAttribute("genreId", selectedGenreId);

        
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <li><a href=\"books.jsp?genre_id=0\">Все книги</a></li>\r\n");
      out.write("        ");

            for (Genre genre : genreList.getGenreList()) {
                if (selectedGenreId != 0 && selectedGenreId == genre.getId()) {
        
      out.write("\r\n");
      out.write(" <li><a style=\"color:red;\" href=\"books.jsp?genre_id=");
      out.print(genre.getId());
      out.write('"');
      out.write('>');
      out.print(genre.getName());
      out.write("</a></li>\r\n");
      out.write("        ");
        } else {
                    
        
      out.write("\r\n");
      out.write(" <li><a href=\"books.jsp?genre_id=");
      out.print(genre.getId());
      out.write('"');
      out.write('>');
      out.print(genre.getName());
      out.write("</a></li>\r\n");
      out.write("        ");
                }
            }

        
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </ul>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("           \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"letters\">\r\n");
      out.write("    ");
      ru.javabegin.training.web.beans.LetterList letterList = null;
      synchronized (application) {
        letterList = (ru.javabegin.training.web.beans.LetterList) _jspx_page_context.getAttribute("letterList", PageContext.APPLICATION_SCOPE);
        if (letterList == null){
          letterList = new ru.javabegin.training.web.beans.LetterList();
          _jspx_page_context.setAttribute("letterList", letterList, PageContext.APPLICATION_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("    ");


        String searchLetter = null;


        if (request.getParameter("letter") != null) {
            searchLetter = request.getParameter("letter");
            session.setAttribute("letter", searchLetter);
        } else if (session.getAttribute("letter") != null) {
            searchLetter = session.getAttribute("letter").toString();
        }


        char[] letters = letterList.getRussianLetters();
        for (int i = 0; i < letters.length; i++) {

            if (searchLetter != null && searchLetter.toString().toUpperCase().charAt(0) == letters[i]) {

    
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <a style=\"color:red;\" href=\"books.jsp?letter=");
      out.print(letters[i]);
      out.write('"');
      out.write('>');
      out.print(letters[i]);
      out.write("</a>\r\n");
      out.write("    ");

    } else {
    
      out.write("\r\n");
      out.write("    <a  href=\"books.jsp?letter=");
      out.print(letters[i]);
      out.write('"');
      out.write('>');
      out.print(letters[i]);
      out.write("</a>\r\n");
      out.write("    ");

            }
        }
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div style=\"float:left; margin-top: 20px;\">\r\n");
      out.write("<h3>Выберите раздел или используйте поиск книги</h3>\r\n");
      out.write("      </div>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div style=\"clear: both; width:1100px;\">&nbsp;</div>\r\n");
      out.write("  </div><!-- end .container -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
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
