package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/logoutSession")
public class LogoutSecao extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//tira o atributo
		req.getSession().removeAttribute("usuario.logado");
	
		//invalida a sess�o
		req.getSession().invalidate();
		
		//a diferen�a � que um tira s� o atributo, o outro acaba com a sess�o (incluindo tudo que tinha nela)

		
		PrintWriter p = resp.getWriter();
		p.println("deslogado com sucesso");
		
	}
	
}
