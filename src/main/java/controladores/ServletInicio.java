/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 51950
 */
@WebServlet(name = "ServletInicio", urlPatterns = {"/ServletInicio"})
public class ServletInicio extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession misession = (HttpSession) request.getSession();
        String usuario = (String) misession.getAttribute("usuario");
    

        if (misession == null || misession.getAttribute("usuario") == null) {
            out.print("<link rel=\"stylesheet\" \n"
                    + "              href=\"webjars/bootstrap/5.1.0/css/bootstrap.min.css\" type=\"text/css\" />");
            out.println("<div class=\'container mt-5\'>");
            out.println("<center>");
            out.println("<h3>No tiene permisos para acceder a esta seccion</h3>");
            out.println("<a class='btn btn-primary' href='/WebSistema/index.jsp'>Ir a página de acceso</a>");
            out.println("</center>");
            out.println("</div>");
            return;
        }
            try {
                /* TODO output your page here. You may use following sample code. */

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>" + usuario +  "</title>");
                out.println("<meta charset=\'UTF-8\'>");
                out.println("<meta name=\'viewport\' content=\'width=device-width, initial-scale=1.0\'>");
                out.println("<link rel=\'stylesheet\' href=\'webjars/bootstrap/5.1.0/css/bootstrap.min.css\' type=\'text/javascript\' />");
                out.println("<frameset rows=\'80,*\' border=\'0\' frameborder=\'0\' y framespacing=\'40\'>");
                out.println("<frame src=titulo.html name=titulo>");
                out.println("<frameset cols=\'250,*\'>");
                out.println("<frame src=opciones.html name=izquierda>");
                out.println("<frame src=contenido.html name=derecha>");
                out.println("</frameset>");
                out.println("</frameset> ");
                out.println("</head>");
                out.println("<a href=\'/WebSistema/ServletLogout\' class=\'list-group-item list-group-item-action list-group-item-secondary\' \n" +
"                   target=\'derecha\'>Cerrar Sesion</a>");
                out.println("</html>");
                
            } finally {
                out.close();
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
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }
