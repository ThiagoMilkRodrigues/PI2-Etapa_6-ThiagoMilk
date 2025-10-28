package controller;

import dao.UsuarioDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// COMENTE ou REMOVA esta linha:
// @WebServlet(name = "LoginServlet", urlPatterns = {"/login"})

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome = request.getParameter("nome");
        String senha = request.getParameter("senha");
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        boolean autenticado = usuarioDAO.autenticar(nome, senha);
        
        if (autenticado) {
            // Cria sessão e redireciona para menu
            HttpSession session = request.getSession();
            session.setAttribute("usuario", nome);
            response.sendRedirect("pages/menu.html");
        } else {
            // Login falhou
            response.sendRedirect("index.html?erro=1");
        }
    }
}