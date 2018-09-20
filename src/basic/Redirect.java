package basic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Redirect implements Tarefa {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		return "WEB-INF/view/redirect.jsp";
	}

}
