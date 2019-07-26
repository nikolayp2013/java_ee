package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("        <title>Онлайн библиотека::Вход</title>\r\n");
      out.write("        <link href=\"css/style_index.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"main\">\r\n");
      out.write("\r\n");
      out.write("            <div class=\"content\">\r\n");
      out.write("                <p class=\"title\"><span class=\"text\"><img src=\"images/lib.png\" width=\"76\" height=\"77\" hspace=\"10\" vspace=\"10\" align=\"middle\"></span></p>\r\n");
      out.write("                <p class=\"title\">Онлайн библиотека</p>\r\n");
      out.write("                <p class=\"text\">Добро пожаловать в онлайн библиотеку, где вы сможете найти любую книгу на ваш вкус. Доступны функции поиска, просмотра, сортировки и многие другие.</p>\r\n");
      out.write("                <p class=\"text\">Проект находится в разработке, поэтому дизайн и функционал будет постоянно дорабатываться.</p>\r\n");
      out.write("                <p class=\"text\">По всем вопросам обращайтесь по адресу <a href=\"mailto:support@testlibrary.com\">support@testlibrary.com</a></p>\r\n");
      out.write("                <p>&nbsp;</p>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"login_div\">\r\n");
      out.write("                <p class=\"title\">Для входа введит свои данные:</p>\r\n");
      out.write("                <form class=\"login_form\" name=\"username\" action=\"pages/main.jsp\" method=\"POST\">\r\n");
      out.write("                    Имя: <input type=\"text\" name=\"username\" value=\"\" size=\"20\" />\r\n");
      out.write("                    <input type=\"submit\" value=\"Войти\" />\r\n");
      out.write("                </form>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"footer\">\r\n");
      out.write("                Разработчик: Тимур Батыршинов, 2013 г\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
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
