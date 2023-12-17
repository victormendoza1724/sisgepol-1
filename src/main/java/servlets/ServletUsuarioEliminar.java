
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.UsuarioController;

@WebServlet(name = "ServletUsuarioEliminar", urlPatterns = {"/ServletUsuarioEliminar"})

public class ServletUsuarioEliminar extends HttpServlet {
    public ServletUsuarioEliminar(){
        super();
    }
    @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            UsuarioController usuario = new UsuarioController();
            int id_tabla = Integer.parseInt(request.getParameter("id_tabla"));


            String result = usuario.eliminar(id_tabla);

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
