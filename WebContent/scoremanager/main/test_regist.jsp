<%@page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../common/base.jsp">
	<c:param name="title">得点管理システム</c:param>
	<c:param name="contents">
		<section>
			<!-- 画面タイトル -->
			<h2>成績管理</h2>
			<!-- /画面タイトル -->
			<!-- 新規登録リンク -->
			<div>
				<a href="StudentCreate.action">新規登録</a>
			</div>
			<!-- /新規登録リンク -->
			<form method="post">
				<table>
					<!-- ヘッダー -->
					<tr>
						<th>入学年度</th>
						<th>クラス</th>
						<th>科目</th>
						<th>回数</th>
					</tr>
					<!-- /ヘッダー -->
					<tr>
						<td>
							<!-- 入学年度セレクトボックス -->
							<select name="f1">
								<option value="0">--------</option>
								<c:forEach items="${entYearSet}" var="entYear">
									<option
										value="${entYear}"
										<c:if test="${f1 == entYear}">selected</c:if>
									>
										${entYear}
									</option>
								</c:forEach>
							</select>
							<!-- /入学年度セレクトボックス -->
						</td>
						<td>
							<!-- クラスセレクトボックス -->
							<select name="f2">
								<option value="0">--------</option>
								<c:forEach items="${classNumSet}" var="classNum">
									<option
										value="${classNum}"
										<c:if test="${f2.equals(classNum)}">selected</c:if>
									>
										${classNum}
									</option>
								</c:forEach>
							</select>
							<!-- /クラスセレクトボックス -->
						</td>
						<td>
							<!-- 科目セレクトボックス -->
							<select name="f3">
								<option value="0">--------</option>
								<c:forEach items="${subjectSet}" var="subject">
									<option
										value="${subject.cd}"
										<c:if test="${f3.equals(subject.cd)}">selected</c:if>
									>
										${subject.name}
									</option>
								</c:forEach>
							</select>
							<!-- /科目セレクトボックス -->
						</td>
						<td>
							<!-- 回数セレクトボックス -->
							<select name="f4">
								<option value="0">--------</option>
								<c:forEach items="${noSet}" var="no">
									<option
										value="${no}"
										<c:if test="${f4 == no}">selected</c:if>
									>
										${no}
									</option>
								</c:forEach>
							</select>
							<!-- /回数セレクトボックス -->
						</td>
					</tr>
				</table>
				<!-- 検索ボタン -->
				<button>検索</button>
				<!-- /検索ボタン -->
				<div>
					${errors.get("f1")}
				</div>
			</form>
			<c:choose>
				<c:if test="${tests.size() > 0}">
					<!-- 科目 -->
					<div>科目：${subject.cd}（${no}回）</div>
					<!-- /科目 -->
					<!-- 成績一覧テーブル -->
					<table>
						<tr>
							<!-- 入学年度（ヘッダー） -->
							<th>入学年度</th>
							<!-- /入学年度（ヘッダー） -->
							<!-- クラス（ヘッダー） -->
							<th>クラス</th>
							<!-- /クラス（ヘッダー） -->
							<!-- 学生番号（ヘッダー） -->
							<th>学生番号</th>
							<!-- /学生番号（ヘッダー） -->
							<!-- 氏名（ヘッダー） -->
							<th>氏名</th>
							<!-- /氏名（ヘッダー） -->
							<!-- 点数 -->
							<th>点数</th>
							<!-- /点数 -->
						</tr>
						<c:forEach items="${tests}" var="test">
							<tr>
								<!-- 入学年度（学生情報） -->
								<td>${student.entYear}</td>
								<!-- /入学年度（学生情報） -->
								<!-- 学生番号（学生情報） -->
								<td>${student.no}</td>
								<!-- /学生番号（学生情報） -->
								<!-- 氏名（学生情報） -->
								<td>${student.name}</td>
								<!-- /氏名（学生情報） -->
								<!-- クラス（学生情報） -->
								<td>${student.classNum}</td>
								<!-- /クラス（学生情報） -->
								<!-- 在学中（学生情報） -->
								<td>
									<c:choose>
										<c:when test="${student.isAttend()}">
											○
										</c:when>
										<c:otherwise>
											×
										</c:otherwise>
									</c:choose>
								</td>
								<!-- /在学中（学生情報） -->
								<!-- 学生情報変更リンク -->
								<td>
									<!--
									仕様書ではaタグの指定であったが、
									想定通りの動作にならないため、formタグを用いている
									-->
									<form action="StudentUpdate.action">
										<input type="hidden" name="student_no" value="${student.no}">
										<button>変更</button>
									</form>
								</td>
								<!-- /学生情報変更リンク -->
							</tr>
						</c:forEach>
					</table>
					<!-- /成績一覧テーブル -->
				</c:if>
			</c:choose>
		</section>
	</c:param>
</c:import>