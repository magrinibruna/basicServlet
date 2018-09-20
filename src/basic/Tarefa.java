package basic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Tarefa {
	

	public String execute(HttpServletRequest req, HttpServletResponse resp);

}
