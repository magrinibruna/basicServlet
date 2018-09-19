package cookie;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.Cookies;

//o urlpatterns define quem vai passar por esse filtro (/* significa todos)
@WebFilter(urlPatterns = "/*")
public class FiltroCookie implements Filter {

	@Override
	public void destroy() {
		// executado quando o filtro é destruido
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// como o filtro é usado pra qualquer protocolo, não recebe HTTPServlet
		HttpServletRequest req = (HttpServletRequest) request;

		String usuario = getUser(req, (HttpServletResponse) response);

		String uri = req.getRequestURI();
		System.out.println("Usuario " + usuario + " acessando URI: " + uri);

		// depois de executar o comando acima, ele vai continuar com a requisição
		// normalmente
		chain.doFilter(request, response);

	}

	private String getUser(HttpServletRequest req, HttpServletResponse resp) {
		String usuario = "<deslogado>";
		
		// pegando os cookies
		Cookie cookie = new Cookie("usuario.logado", new Cokie(req.getCookies()).getUsuario());
		resp.addCookie(cookie);
		usuario = cookie.getValue();
		return usuario;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// utilizado quando o filtro inicializada
	}

}
