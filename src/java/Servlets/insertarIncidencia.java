/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.IncidenciaEJB;
import Model.Empleado;
import Model.Incidencia;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author uriishii
 */
@WebServlet(name = "insertarIncidencia", urlPatterns = {"/insertarIncidencia"})
public class insertarIncidencia extends HttpServlet {

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
            out.println("<title>Servlet insertarIncidencia</title>");
            out.println("<style type=\"text/css\">"
                    + "body {"
                    + "text-align: center; }"
                    + "</style>");
            out.println("</head>");
            out.println("<body>");
            String userNameOrigen = request.getParameter("userNameOrigen");
            Empleado origen = new Empleado(userNameOrigen);
            String userNameDestino = request.getParameter("userNameDestino");
            Empleado destino = new Empleado(userNameDestino);
            String detalles = request.getParameter("detalles");
            java.util.Date d = new java.util.Date();
            SimpleDateFormat plantilla = new SimpleDateFormat("dd/MM/yyyy H:mm");
            String tiempo = plantilla.format(d);
            String tipo = request.getParameter("tipoInci");
            Incidencia incidencia = new Incidencia();
            incidencia.setDetalle(detalles);
            incidencia.setTipo(tipo);
            incidencia.setFechahora(tiempo);
            incidencia.setOrigen(origen);
            incidencia.setDestino(destino);
            List<Incidencia> incidencias = incidenciaEJB.findAllIncidencias();
            int idInci = incidencias.size() + 1;
            incidencia.setIdincidencia(idInci);
            incidenciaEJB.createIncidencia(incidencia);
            out.println("Incidencia Creada Correctamente.");
            out.println("<form action=\"index.jsp\" method=\"POST\">"
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
