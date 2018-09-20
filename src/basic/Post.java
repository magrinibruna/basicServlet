
package basic;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/apresentacao")
public class Post extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("nome", req.getParameter("nome"));
		req.setAttribute("sobrenome", req.getParameter("sobrenome"));
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/nome.jsp");
		requestDispatcher.forward(req, resp);
	}

}
