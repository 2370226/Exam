package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import bean.School;
import bean.Student;
import bean.Subject;
import bean.Test;
import bean.TestListSubject;

public class TestListSubjectDao extends Dao {
	/*
	 * baseSql:データ取得用のSQL
	 */
//	private String baseSql = "select * from test where subject_cd = ? and school_cd = ?";
	/*
	 * postFilter:フィルター後のリストへの格納処理
	 */
	private List<TestListSubject> postFilter(ResultSet rSet) throws Exception {
		// list:格納リスト
		List<TestListSubject> list = new ArrayList<>();
		try {
			while (rSet.next()) {
				Test test = new Test();
				/*
				 * ent_year:入学年度
				 * integer(10), value = null
				 */
				/*
				 * student_no:学生番号
				 * varchar(10), primary key, not null
				 */
				/*
				 * student_name:学生名
				 * varchar(10), value = null
				 */
				/*
				 * class_num:クラス番号
				 * varchar(5), value = null
				 */
				/*
				 * point:得点
				 * intger(10), value = null
				 */
				//
				//
				/*
				 * student_no:学生番号
				 * varchar(10), primary key, not null
				 */
				StudentDao studentDao = new StudentDao();
				String studentNo = rSet.getString("student_no");
				Student student = studentDao.get(studentNo);
				test.setStudent(student);
				/*
				 * subject_cd:科目コード
				 * char(3), primary key, not null
				 */
				SubjectDao subjectDao = new SubjectDao();
				String cd = rSet.getString("subject_cd");
				Subject subject = subjectDao.get(cd, school);
				test.setSubject(subject);
				/*
				 * school_cd:学校コード
				 * char(3), primary key, not null
				 */
				test.setSchool(school);
				/*
				 * no:回数
				 * integer(10), primary key, not null
				 */
				int no = rSet.getInt("no");
				test.setNo(no);
				/*
				 * point:得点
				 * intger(10), value = null
				 */
				int point = rSet.getInt("point");
				test.setPoint(point);
				/*
				 * class_num:クラス番号
				 * varchar(5), value = null
				 */
				String classNum = rSet.getString("class_num");
				test.setClassNum(classNum);
				list.add(test);
			}
		} catch (Exception e) {
			 e.printStackTrace();
		}
		return list;
	}
	/*
	 * filter:入学年度、クラス番号、強化、試験回数、学校を指定して学生一覧を取得
	 */
	public List<TestListSubject> filter(
			int entYear,
			String classNum,
			Subject subject,
			School school
	) throws Exception {
		System.out.println("入力入学年度:'"+entYear+"'");
		System.out.println("入力クラス番号:'"+classNum+"'");
		System.out.println("入力科目情報:");
		subject.getSchool();
		subject.getCd();
		subject.getName();
		System.out.println("入力学校情報:");
		school.getCd();
		school.getName();
		// list:検索結果
		List<TestListSubject> list = new ArrayList<>();
		// データベースと接続
		Connection connection = getConnection();
		// SQL文を準備
		PreparedStatement statement = null;
		// rSet:検索結果
		ResultSet rSet;
		try {
			// SQL文を準備
			String sql = "select * ";
			statement = connection.prepareStatement(sql);
			statement.setString(1, schoolCd);
			statement.setInt(2, entYear);
			statement.setString(3, classNum);
			StringBuilder printSql = new StringBuilder();
			printSql.append("検索用SQL文:'");
			printSql.append(sql
					.replaceFirst("\\?", schoolCd)
					.replaceFirst("\\?", String.valueOf(entYear))
					.replaceFirst("\\?", classNum));
			printSql.append("'");
			System.out.println(printSql);
			// 検索結果を格納
			rSet = statement.executeQuery();
			list = postFilter(rSet);
		} catch (Exception e) {
			 throw e;
		} finally {
			if (Objects.nonNull(statement)) {
				try {
					statement.close();
				} catch (SQLException sqlException) {
					 throw sqlException;
				}
			}
			if (Objects.nonNull(connection)) {
				try {
					connection.close();
				} catch (SQLException sqlException) {
					 throw sqlException;
				}
			}
		}
		//
		TestDao testDao = new TestDao();
		List<Test> list = testDao.filter(entYear, classNum, subject, no, school);
		StudentDao studentDao = new StudentDao();
		List<Student> students = studentDao.filter(school, entYear, classNum, true);
		for (Student student : students) {
			TestListSubject test = new TestListSubject();
			/*
			 * ent_year:入学年度
			 * integer(10), value = null
			 */
			/*
			 * student_no:学生番号
			 * varchar(10), primary key, not null
			 */
			/*
			 * student_name:学生名
			 * varchar(10), value = null
			 */
			/*
			 * class_num:クラス番号
			 * varchar(5), value = null
			 */
			/*
			 * point:得点
			 * intger(10), value = null
			 */
			/*
			 * student_no:学生番号
			 * varchar(10), primary key, not null
			 */
			test.setStudent(student);
			/*
			 * subject_cd:科目コード
			 * char(3), primary key, not null
			 */
			test.setSubject(subject);
			/*
			 * school_cd:学校コード
			 * char(3), primary key, not null
			 */
			test.setSchool(school);
			/*
			 * no:回数
			 * integer(10), primary key, not null
			 */
			test.setNo(no);
			/*
			 * point:得点
			 * intger(10), value = null
			 */
			Test old = this.get(student, subject, school, no);
			if (Objects.nonNull(old)) {
				int point = old.getPoint();
				test.setPoint(point);
			}
			/*
			 * class_num:クラス番号
			 * varchar(5), value = null
			 */
			test.setClassNum(classNum);
			list.add(test);
		}
		return list;
	}
}