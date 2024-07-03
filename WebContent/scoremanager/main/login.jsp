<%@page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../common/base.jsp">
	<c:param name="title">得点管理システム</c:param>
	<c:param name="contents">
		<section>
			<div>
				<!-- 画面タイトル -->
				<h2>ログイン</h2>
				<!-- /画面タイトル -->
				<!-- 画面エラーメッセージ -->
				<c:if test="${errors.size()>0}">
					<ul>
						<c:forEach items="${errors}" var="error">
							<li>${error}</li>
						</c:forEach>
					</ul>
				</c:if>
				<!-- /画面エラーメッセージ -->
				<form
					action="LoginExecute.action"
					method="post">
					<p>
						<!-- ログインID -->
						<input
							name="id"
							type="text"
							placeholder="半角でご入力ください"
							maxlength="20"
							pattern="^[a-zA-Z0-9]+$"
							required>
						<!-- /ログインID -->
					</p>
					<p>
						<!-- パスワード -->
						<input
							name="password"
							type="password"
							id="password"
							placeholder="20文字以内の半角英数字でご入力ください"
							maxlength="20"
							pattern="^[a-zA-Z0-9]+$"
							required>
						<!-- /パスワード -->
					</p>
					<p>
						<label>
							<!-- パスワード表示/非表示 -->
							<input
								name="chk_d_ps"
								type="checkbox"
								id="checkPass">
							パスワードを表示
							<!-- /パスワード表示/非表示 -->
						</label>
					</p>
					<p>
						<!-- ログインボタン -->
						<input name="login" type="submit" value="ログイン">
						<!-- /ログインボタン -->
					</p>
					<script type="text/javascript">
					// チェックボックスにチェックを入れたら伏字解除
						document.addEventListener("DOMContentLoaded", function(event){
							const targetElement = document.getElementById("password");
							const triggerElement = document.getElementById("checkPass");
							triggerElement.addEventListener("change", function(event){
								if (this.checked) {
									targetElement.setAttribute("type", "text");
								} else {
									targetElement.setAttribute("type", "password");
								}
							}, false);
						}, false);
					</script>
				</form>
			</div>
		</section>
	</c:param>
</c:import>