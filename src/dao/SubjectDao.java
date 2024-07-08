package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import bean.School;
import bean.Subject;

public class SubjectDao extends Dao{
	/*
	 * get:primary key(cd, school)を用いたstudentテーブルの検索
	 */
	public Subject get(String cd, School school) throws Exception {
		System.out.println("入力学生番号:'"+cd+"'");
		System.out.println("入力学校情報:");
		String schoolCd = school.getCd();
		school.getName();
		// subject:検索結果
		Subject subject = new Subject();
		// データベースと接続
		Connection connection = getConnection();
		// SQL文を準備
		PreparedStatement statement = null;
		try {
			// データベースを検索
			String sql = "select * from subject where cd = ? and school_cd = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, cd);
			statement.setString(2, schoolCd);
			StringBuilder printSql = new StringBuilder();
			printSql.append("検索用SQL文:'");
			printSql.append(sql.replaceFirst("\\?", cd).replaceFirst("\\?", schoolCd));
			printSql.append("'");
			System.out.println(printSql);
			// 検索結果を格納
			ResultSet rSet = statement.executeQuery();
			if (rSet.next()) {
				// 学校情報
				subject.setSchool(school);
				// 科目コード
				subject.setCd(cd);
				// 科目名
				String name = rSet.getString("name");
				subject.setName(name);
			} else {
				subject = null;
			}
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
		return subject;
	}
	/*
	 * filter:学校を指定して科目一覧を取得
	 */
	public List<Subject> filter(School school) throws Exception {
		System.out.println("入力学校情報:");
		String schoolCd = school.getCd();
		school.getName();
		// list:検索結果
		List<Subject> list = new ArrayList<>();
		// データベースと接続
		Connection connection = getConnection();
		// SQL文を準備
		PreparedStatement statement = null;
		// rSet:検索結果
		ResultSet rSet;
		try {
			// SQL文を準備
			String sql = "select * from subject where school_cd = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, schoolCd);
			StringBuilder printSql = new StringBuilder();
			printSql.append("検索用SQL文:'");
			printSql.append(sql.replaceFirst("\\?", schoolCd));
			printSql.append("'");
			System.out.println(printSql);
			// 検索結果を格納
			rSet = statement.executeQuery();
			try {
				while (rSet.next()) {
					Subject subject = new Subject();
					// 学校情報
					subject.setSchool(school);
					// 科目コード
					String cd = rSet.getString("cd");
					subject.setCd(cd);
					// 科目名
					String name = rSet.getString("name");
					subject.setName(name);
					list.add(subject);
				}
			} catch (Exception e) {
				 e.printStackTrace();
			}
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
		return list;
	}
	public boolean save(Subject subject) throws Exception {}
	public boolean delete(Subject subject) throws Exception {}
}