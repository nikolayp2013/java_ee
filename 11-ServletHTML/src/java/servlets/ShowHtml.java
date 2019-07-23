/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tim
 */
public class ShowHtml extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>"
                    + "<head>"
                    + "<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">"
                    + "<title>Документ</title>"
                    + "</head>"
                    + "<body>"
                    + "<table width=\"450\" border=\"0\" cellpadding=\"0\" cellspacing=\"15\">"
                    + "<tr>"
                    + " <td colspan=\"2\" align=\"center\"><strong><font color=\"#FF0000\" size=\"5\">Секретный документ</font></strong></td>"
                    + " </tr>"
                    + " <tr>"
                    + "   <td width=\"150\" rowspan=\"2\"><img src=\"images/java.png\" alt=\"\" width=\"119\" height=\"222\"></td>"
                    + "  <td width=\"340\" height=\"99\"><table width=\"300\" border=\"1\" align=\"left\" cellpadding=\"15\" cellspacing=\"0\">"
                    + "    <tr>"
                    + "      <th align=\"left\"><font color=\"#006699\"> <strong>Имя</strong></font></th>"
                    + "    <th align=\"left\"><font color=\"#006699\"><strong>Телефон</strong></font></th>"
                    + "  </tr>"
                    + "  <tr>"
                    + "    <td>Петр</td>"
                    + "   <td>555444</td>"
                    + " </tr>"
                    + " <tr>"
                    + "   <td>Иван</td>"
                    + "   <td>111222</td>"
                    + " </tr>"
                    + "  </table></td>"
                    + " </tr>"
                    + " <tr>"
                    + "  <td>"
                    + "<ul>"
                    + " <li>Текстовый документ 1</li>"
                    + " <li>Текстовый документ 1</li>"
                    + " <li>Текстовый документ 1</li>"
                    + " </ul>    "
                    + " </td>"
                    + "</tr>"
                    + "  <tr>"
                    + "  <td colspan=\"2\"><p align=\"center\"><font color=\"#999999\">Тестовый проект 2013 г</font></p></td>"
                    + "  </tr>"
                    + "</table>"
                    + "</body>"
                    + "</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
