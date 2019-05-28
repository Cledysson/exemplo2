

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class add
 */
@WebServlet("/add")
public class add extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String atividade = request.getParameter("atividade");

		if(atividade!= null && !atividade.trim().isEmpty()) {
			List<String> itens = getLista(request);
			itens.add(atividade);
		} 
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}
private List<String> getLista(HttpServletRequest request){
	Object o = request.getSession().getAttribute("lista");
	List<String> itens = null;
	if (o instanceof List<?>) {
		itens = (List<String>) o;
	}else {
		itens = new ArrayList<String>();
		request.getSession().setAttribute("lista", itens);
		}
		return itens;
	}
}
