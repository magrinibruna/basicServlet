package full;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basic.Tarefa;

@WebServlet(urlPatterns="/redirect")
public class Executa extends HttpServlet {

	@Override //aceita todos os métodos (get, post)
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
		String tarefa = req.getParameter("tarefa");
		if(tarefa==null) {
			throw new IllegalArgumentException("Falta a tarefa");
		}
		
		tarefa = "basic." + tarefa;
		
			Class<?> clazz = Class.forName(tarefa);
			Tarefa instancia = (Tarefa) clazz.newInstance();
			String pagina = instancia.execute(req, resp);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher(pagina);
			requestDispatcher.forward(req, resp);
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
