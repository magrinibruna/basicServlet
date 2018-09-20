package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns="/loginSession")
public class LoginSession extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String usuarioP = "bruna";
		String senhaP = "1";
		
		String usuario = req.getParameter("usuario");
		String senha = req.getParameter("senha");
		
		if(usuarioP.equals(usuario) && senhaP.equals(senha)) {
			//armazenando o usuario dentro da sessão
			HttpSession session = req.getSession();
			session.setAttribute("usuarioLogado", usuario);
			req.setAttribute("usuario", usuario);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/login.jsp");
			requestDispatcher.forward(req, resp);
		} else {
			
		}
	
	}

}
