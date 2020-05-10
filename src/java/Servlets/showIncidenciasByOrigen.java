/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.IncidenciaEJB;
import Model.Incidencia;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author uryy9
 */
@WebServlet(name = "showIncidenciasByOrigen", urlPatterns = {"/showIncidenciasByOrigen"})
public class showIncidenciasByOrigen extends HttpServlet {

    @EJB
    IncidenciaEJB incidenciaEJB;

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<style type=\"text/css\">"
                    + "body {"
                    + "text-align: center; }"
                    + "</style>");
            out.println("</head>");
            out.println("<body>");
            String userNameOrigen = request.getParameter("userNameOrigen");
            List<Incidencia> incidencias = incidenciaEJB.findIncidenciaByOrigen(userNameOrigen);
            if (incidencias.size() > 0) {
                for (Incidencia incidencia : incidencias) {
                    out.print(
                            "<b>id: </b>"
                            + incidencia.getIdincidencia()
                            + ", <b>Tipo: </b>"
                            + incidencia.getTipo()
                            + ", <b>Detalles: </b>"
                            + incidencia.getDetalle()
                            + ", <b>Fecha Hora: </b>"
                            + incidencia.getFechahora()
                            + ", <b> Empresario Destino: </b>"
                            + incidencia.getDestino().getNombreusuario()
                            + "<br>");
                }
            } else {
                out.println("No existe incidencia con ese UserName Origen.");
            }
            out.println("- - - - - -  --  - -- - - - - - - - - - - - ");
            out.println("<form action=\"incidenciasEJB.html\" method=\"POST\">"
                    + "Volver a la pagina inicial"
                    + "<input type=\"submit\" name=\"volver\" value=\"Volver\" />"
                    + "</form>");
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
