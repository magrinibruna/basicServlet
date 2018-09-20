package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/")
public class Get extends  HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter p = resp.getWriter();
		p.println("Bem-vinda, " + req.getParameter("nome"));
		
		//redirecionamento feito pelo cliente (não consegue acessar dentro do web-inf
		//resp.sendRedirect("home.jsp");
		
		//redirecionamento feito pelo servidor
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/home.jsp");
		requestDispatcher.forward(req, resp);
	
	}

}
