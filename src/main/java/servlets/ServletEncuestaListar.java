
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.EncuestaController;

@WebServlet(name = "ServletEncuestaListar", urlPatterns = {"/ServletEncuestaListar"})

public class ServletEncuestaListar extends HttpServlet {
    public ServletEncuestaListar(){
        super();
    }
    @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            EncuestaController encuesta = new EncuestaController();
            int FK_Usuario = Integer.parseInt(request.getParameter("FK_Usuario"));;
            String fecha_inicio = request.getParameter("fecha_inicio");
            String fecha_fin = request.getParameter("fecha_fin");
            String result = encuesta.listar(FK_Usuario, fecha_inicio,fecha_fin);
            
            
            response.setContentType("text/html;charset-UTF-8");
            PrintWriter out = response.getWriter();
            out.println(result);
            out.flush();
            out.close();
        
        }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}
