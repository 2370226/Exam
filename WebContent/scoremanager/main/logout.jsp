<%@page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../common/base.jsp">
	<c:param name="title">得点管理システム</c:param>
	<c:param name="contents">
		<section>
			 <!-- 画面タイトル -->
			 <h2>ログアウト</h2>
			 <!-- /画面タイトル -->
			 <!-- ログアウト -->
			 <p>ログアウトしました。</p>
			 <!-- /ログアウト -->
			 <!-- ログイン画面リンク -->
			 <a href="LoginAction">ログイン</a>
			 <!-- /ログイン画面リンク -->
		</section>
	</c:param>
</c:import>