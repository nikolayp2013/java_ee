package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ru.javabegin.training.web.beans.Author;
import ru.javabegin.training.web.beans.AuthorList;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Онлайн библиотека</title>\r\n");
      out.write("        <link href=\"../css/style_main.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <div class=\"header\">\r\n");
      out.write("                <img alt=\"Место для логотипа\" name=\"logo\" width=\"100%\" height=\"90\"/>\r\n");
      out.write("\r\n");
      out.write("                <form class=\"search_form\" name=\"search_form\" method=\"POST\">\r\n");
      out.write("                    <img src=\"../images/search.jpg\"/> \r\n");
      out.write("                    <input type=\"text\" name=\"search_String\" value=\"\" size=\"100\" />\r\n");
      out.write("                    <input type=\"submit\" value=\"Поиск\" name=\"search_button\" />\r\n");
      out.write("                    <select name=\"search_option\">\r\n");
      out.write("                        <option>Название</option>\r\n");
      out.write("                        <option>Автор</option>\r\n");
      out.write("                    </select>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <div class=\"sidebar1\">\r\n");
      out.write("                <h4>Список авторов:</h4>\r\n");
      out.write("                <ul class=\"nav\">\r\n");
      out.write("                    ");
 AuthorList authorList = new AuthorList();
                        for (Author author : authorList.getAuthorList()) {
                    
      out.write("\r\n");
      out.write("                    <li><a href=\"#\">");
      out.print(author.getName());
      out.write("</a></li>\r\n");
      out.write("\r\n");
      out.write("                    ");
}
      out.write("\r\n");
      out.write("                </ul>\r\n");
      out.write("                <p>&nbsp;</p>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <div class=\"content\">\r\n");
      out.write("                <h1>&nbsp;</h1>\r\n");
      out.write("                <p>&nbsp;</p>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    \r\n");
      out.write("        </div><!-- end .container -->\r\n");
      out.write("                \r\n");
      out.write("    </body>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
