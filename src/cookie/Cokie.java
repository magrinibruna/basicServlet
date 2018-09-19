package cookie;

import javax.servlet.http.Cookie;

public class Cokie {

	private final Cookie[] cookies;

	public Cokie(Cookie[] cookies) {
		this.cookies = cookies;

	}

	public String getUsuario() {
		if (cookies == null) return "";
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("usuario.logado")) {
				cookie.setMaxAge(60);
				return cookie.getValue();
			}
		}
		return null;
	}

}
