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
			
			//cookie são criados para armazenar informações que durem várias requisições
			//para login, o usuario ficará salvo e será devolvido para a aplicação a cada nova requisição
			//por padrão, o cookie dura até o navegador ser fechado, mas isso pode ser alterado 
			//com setMaxAge (está em segundo)
			
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
