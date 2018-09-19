package session;

import java.io.IOException;
import java.io.PrintWriter;

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
		PrintWriter p = resp.getWriter();
		
		String usuarioP = "bruna";
		String senhaP = "1";
		
		String usuario = req.getParameter("usuario");
		String senha = req.getParameter("senha");
		
		if(usuarioP.equals(usuario) && senhaP.equals(senha)) {
			//armazenando o usuario dentro da sessã
			HttpSession session = req.getSession();
			session.setAttribute("usuario.logado", usuario);
			p.println("Logado com sucesso");
		} else {
			p.println("Usuario inválido");
		}
	
	}

}
