<%@page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../common/base.jsp">
	<c:param name="title">得点管理システム</c:param>
	<c:param name="contents">
		<section>
			<!-- 画面タイトル -->
			<h2>メニュー</h2>
			<!-- /画面タイトル -->
			<!-- 学生管理リンク -->
			<div>
				<a href="StudentList.action">学生管理</a>
			</div>
			<!-- /学生管理リンク -->
			<!-- 成績管理 -->
			<div>
				<div>
					成績管理
				</div>
				<!-- 成績登録リンク -->
				<div>
					<a href="TestRegist.action">成績登録</a>
				</div>
				<!-- /成績登録リンク -->
				<!-- 成績参照リンク -->
				<div>
					<a href="TestList.action">成績参照</a>
				</div>
				<!-- /成績参照リンク -->
			</div>
			<!-- /成績管理 -->
			<!-- 科目管理リンク -->
			<div>
				<a href="#">科目管理</a>
			</div>
			<!-- /科目管理リンク -->
		</section>
	</c:param>
</c:import>