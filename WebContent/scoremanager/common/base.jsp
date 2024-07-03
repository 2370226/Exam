<%@page import="java.util.Objects"%>
<%@page import="bean.Teacher"%>
<%@page contentType="text/html; charset=utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
Teacher user = (Teacher)session.getAttribute("user");
boolean userIsNotNull = Objects.nonNull(user);
if (userIsNotNull){
	String userId = user.getId();
	String userName = user.getName();
	request.setAttribute("userName", userName);
	request.setAttribute("userIsNotNull", userIsNotNull);
}
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" >
		<title>
			${param.title}
		</title>
	</head>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" ></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" ></script>
	<body>
		<!-- ヘッダー -->
		<header>
			<!-- 見出し -->
			<h1>
				得点管理システム
			</h1>
			<!-- /見出し -->
			<c:if test="${userIsNotNull}">
				<!-- ログインユーザー名 -->
				<span>
					${userName}様
				</span>
				<!-- /ログインユーザー名 -->
				<!-- ログアウト -->
				<a href="Logout.action">
					ログアウト
				</a>
				<!-- /ログアウト -->
			</c:if>
		</header>
		<!-- /ヘッダー -->
		<!-- サイドバー -->
		<div>
			<c:if test="${userIsNotNull}">
				<!-- ナビゲーション -->
				<nav>
					<ul>
						<li>
							<!-- メニュー -->
							<a href="Menu.action">メニュー</a>
							<!-- /メニュー -->
						</li>
						<li>
							<!-- 学生管理 -->
							<a href="StudentList.action">学生管理</a>
							<!-- /学生管理 -->
						</li>
						<li>
							<!-- 成績管理 -->
							<label>成績管理</label>
							<ul>
								<li>
									<!-- 成績登録 -->
									<a href="#">成績登録</a>
									<!-- /成績登録 -->
								</li>
								<li>
									<!-- 成績参照 -->
									<a href="#">成績参照</a>
									<!-- /成績参照 -->
								</li>
							</ul>
							<!-- /成績管理 -->
						</li>
						<li>
							<!-- 科目管理 -->
							<a href="#">科目管理</a>
							<!-- /科目管理 -->
						</li>
					</ul>
				</nav>
				<!-- /ナビゲーション -->
			</c:if>
		</div>
		<!-- /サイドバー -->
		<!-- 本文 -->
		${param.contents}
		<!-- /本文 -->
		<!-- フッター -->
		<footer>
			<!-- コピーライト上段 -->
			<p><small>&copy; 2023 TIC</small></p>
			<!-- /コピーライト上段 -->
			<!-- コピーライト下段 -->
			<p><small>大原学園</small></p>
			<!-- /コピーライト下段 -->
		</footer>
		<!-- /フッター -->
	</body>
</html>
