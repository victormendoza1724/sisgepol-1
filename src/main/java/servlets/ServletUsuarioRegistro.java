/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import controller.UsuarioController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author remis
 */
@WebServlet(name = "ServletUsuarioRegistro", urlPatterns = {"/ServletUsuarioRegistro"})
public class ServletUsuarioRegistro extends HttpServlet {

     public ServletUsuarioRegistro(){
        super();
    }
    @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            UsuarioController usuario = new UsuarioController();
            int id_Tabla = 0;
            String contrasena = request.getParameter("contrasena");
            String nombres = request.getParameter("nombres");
            String apellidos = request.getParameter("apellidos");
            String correo = request.getParameter("correo");
            String rol = request.getParameter("rol");
            String placa = request.getParameter("placa");
            String estado = request.getParameter("estado");
            String estacion = request.getParameter("estacion");
            String grado = request.getParameter("grado");

            String result = usuario.register(id_Tabla, nombres,apellidos,correo,contrasena,placa,rol,estado,estacion,grado);

            response.setContentType("text/html;charset-UTF-8");
            PrintWriter out = response.getWriter();
            out.println(result);
            out.flush();
            out.close();
        
        }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
