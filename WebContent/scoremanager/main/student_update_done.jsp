<%@page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../common/base.jsp">
	<c:param name="title">得点管理システム</c:param>
	<c:param name="contents">
		<section>
			<!-- 画面タイトル -->
			<h2>学生情報変更</h2>
			<!-- /画面タイトル -->
			<!-- 完了メッセージ -->
			<div>
				<p>変更が完了しました</p>
			</div>
			<!-- /完了メッセージ -->
			<!-- 学生番号一覧リンク -->
			<div>
				<a href="StudentList.action">学生一覧</a>
			</div>
			<!-- /学生番号一覧リンク -->
		</section>
	</c:param>
</c:import>