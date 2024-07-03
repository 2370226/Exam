package scoremanager.main;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.Action;

public class LogoutAction extends Action {
	@Override
	public void execute(
		HttpServletRequest req,
		HttpServletResponse res
	) throws Exception {
		System.out.println("ログアウト機能を起動。");
		// セッションの呼び出し
		HttpSession session = req.getSession();
		if (Objects.nonNull(session.getAttribute("user"))) {
			// エラー文を表示
			session.removeAttribute("user");
		}
		System.out.println("★ file name -> /scoremanager/main/logout.jsp");
		req.getRequestDispatcher("logout.jsp").forward(req, res);
	}
}