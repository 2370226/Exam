package scoremanager.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/scoremanager/main/LoginAction"})
public class LoginAction extends HttpServlet {
	@Override
	public void doGet(
		HttpServletRequest req,
		HttpServletResponse res
	) throws ServletException, IOException {
		System.out.println("ログイン機能を起動。");
		System.out.println("★ servlet path -> /scoremanager/main/LoginAction");
		System.out.println("★ file name -> /scoremanager/main/login.jsp");
		req.getRequestDispatcher("login.jsp").forward(req, res);
	}
}