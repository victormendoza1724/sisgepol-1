/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import controller.EncuestaController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 
import java.util.Date;

/**
 *
 * @author remis
 */
@WebServlet(name = "ServletEncuestaRegistro", urlPatterns = {"/ServletEncuestaRegistro"})
public class ServletEncuestaRegistro extends HttpServlet {

     public ServletEncuestaRegistro(){
        super();
    }
    @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            EncuestaController encuesta = new EncuestaController();
            int id_Tabla = 0;
            int FK_Usuario = Integer.parseInt(request.getParameter("FK_Usuario"));
            int pregunta_1 = Integer.parseInt(request.getParameter("pregunta_1"));
            int pregunta_2 = Integer.parseInt(request.getParameter("pregunta_2"));
            int pregunta_3 = Integer.parseInt(request.getParameter("pregunta_3"));
            int pregunta_4 = Integer.parseInt(request.getParameter("pregunta_4"));
            int pregunta_5 = Integer.parseInt(request.getParameter("pregunta_5"));
            Date fecha = new Date();
       
            String result = encuesta.register(id_Tabla, pregunta_1,pregunta_2,pregunta_3,pregunta_4,pregunta_5,fecha,FK_Usuario);

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
