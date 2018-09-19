package cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/login")
public class LoginCookie extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String usuarioP = "bruna";
		String senhaP = "1";
		
		String usuario = req.getParameter("usuario");
		String senha = req.getParameter("senha");
		
		PrintWriter p = resp.getWriter();
		Cookie cookie;
		if(usuarioP.equals(usuario) && senhaP.equals(senha)) {
			p.println("logado");
			
			//cookie s�o criados para armazenar informa��es que durem v�rias requisi��es
			//para login, o usuario ficar� salvo e ser� devolvido para a aplica��o a cada nova requisi��o
			//por padr�o, o cookie dura at� o navegador ser fechado, mas isso pode ser alterado 
			//com setMaxAge (est� em segundo)
			
			cookie = new Cookie("usuario.logado", usuario);
			cookie.setMaxAge(60);
			
			//colocando o cookie na resposta
			resp.addCookie(cookie);
			
		} else {
			cookie = new Cookie("usuario.logado", "<deslogado>");
			resp.addCookie(cookie);
			p.println("erro");
		}
	
	}

}
