/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.EmpleadoEJB;
import Model.Empleado;
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
 * @author uriishii
 */
@WebServlet(name = "getDataIncidencia", urlPatterns = {"/getDataIncidencia"})
public class getDataIncidencia extends HttpServlet {

    @EJB
    EmpleadoEJB empleadoEJB;

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
            List<Empleado> empleados = empleadoEJB.findAllEmpleados();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet getDataIncidencia</title>");
            out.println("<style type=\"text/css\">"
                    + "body {"
                    + "text-align: center; }"
                    + "</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form action=\"insertarIncidencia\" method=\"POST\">");
            out.println("<p>Tipo de Incidencia: Normal O Urgente\n"
                    + "                <select name=\"tipoInci\"> \n"
                    + "                    <option>Normal</option>\n"
                    + "                    <option>Urgente</option>\n"
                    + "                </select>\n"
                    + "            </p>");
            out.println("<p>Nombre Usuario Origen:");
            out.println("<select name=\"userNameOrigen\">");
            for (Empleado empleado : empleados) {
                out.println("<option>" + empleado.getNombreusuario() + "</option>");
            }
            out.println("</select>");
            out.println("</p>");
            out.println("<p>Nombre Usuario Destino:");
            out.println("<select name=\"userNameDestino\">");
            for (Empleado empleado : empleados) {
                out.println("<option>" + empleado.getNombreusuario() + "</option>");
            }
            out.println("</select>");
            out.println("</p>");
            out.println("<p>Detalles de la incidencia: ");
            out.println("<input type=\"text\" name=\"detalles\">");
            out.println("</p>");
            out.println("<input type=\"submit\" value=\"insertar\">");
            out.println("</form>");
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
