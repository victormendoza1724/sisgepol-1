
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.UsuarioController;

@WebServlet(name = "ServletUsuarioListar", urlPatterns = {"/ServletUsuarioListar"})

public class ServletUsuarioListar extends HttpServlet {
    public ServletUsuarioListar(){
        super();
    }
    @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            UsuarioController usuario = new UsuarioController();
            boolean filtrar = Boolean.parseBoolean(request.getParameter("filtrar"));
            int filtro = Integer.parseInt(request.getParameter("filtro"));
            String result = usuario.listar(filtrar, filtro);
            
            
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
