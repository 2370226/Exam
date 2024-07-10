<%@page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="../common/base.jsp">
	<c:param name="title">得点管理システム</c:param>
	<c:param name="contents">
		<section>
			<!-- 画面タイトル -->
			<h2>成績参照</h2>
			<!-- /画面タイトル -->
			<div>
				<!-- 科目情報 -->
				<div>
					<form action="TestListSubjectExecute.action" method="post">
						科目情報
						<table>
							<!-- ヘッダー -->
							<tr>
								<th>入学年度</th>
								<th>クラス</th>
								<th>科目</th>
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
							</tr>
						</table>
						<!-- 検索ボタン -->
						<button>検索</button>
						<!-- /検索ボタン -->
					</form>
				</div>
				<!-- /科目情報 -->
				<!-- 学生情報 -->
				<div>
					<form action="TestListStudentExecute.action" method="post">
						学生情報
						<table>
							<!-- ヘッダー -->
							<tr>
								<th>学生番号</th>
							</tr>
							<!-- /ヘッダー -->
							<tr>
								<td>
									<!-- 学生番号テキストボックス -->
									<input
										name="f4"
										type="text"
										value="${f4}"
										placeholder="学生番号を入力してください"
										maxlength="10"
										pattern="^[0-9]+$"
										required>
									<!-- /学生番号テキストボックス -->
								</td>
							</tr>
						</table>
						<!-- 検索ボタン -->
						<button>検索</button>
						<!-- /検索ボタン -->
					</form>
				</div>
				<!-- /学生情報 -->
			</div>
			<div>
				科目：${subject.name}
			</div>
			<div>
				<table>
					<tr>
						<th>入学年度</th>
						<th>クラス</th>
						<th>学生番号</th>
						<th>氏名</th>
						<c:forEach var="no" begin="1" end="${noMax}">
							<th>${no}回</th>
						</c:forEach>
					</tr>
					<c:forEach items="${tests}" var="test">
						<tr>
							<td>
								${f1}
							</td>
							<td>
								${f2}
							</td>
							<td>
								${test.student.no}
							</td>
							<td>
								${test.student.name}
							</td>
							<c:forEach var="no" begin="1" end="${noMax}">
								<td>
									${test.point.get(no)}
								</td>
							</c:forEach>
						</tr>
					</c:forEach>
				</table>
			</div>
		</section>
	</c:param>
</c:import>