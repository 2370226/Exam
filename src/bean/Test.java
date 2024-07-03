package bean;

import java.io.Serializable;

public class Test implements Serializable {
	/*
	 * student_no:学生番号
	 * varchar(10), primary key, not null
	 */
	private Student student;
	public Student getStudent() {return this.student;}
	public void setStudent(Student student) {this.student = student;}
	/*
	 * subject_no:科目コード
	 * char(3), primary key, not null
	 */
	private Subject subject;
	public Subject getSubject() {return this.subject;}
	public void setSubject(Subject subject) {this.subject = subject;}
	/*
	 * school_cd:学校コード
	 * char(3), primary key, not null
	 */
	private School school;
	public School getSchool() {return this.school;}
	public void setSchool(School school) {this.school = school;}
	/*
	 * no:回数
	 * integer(10), primary key, not null
	 */
	private int no;
	public int getNo() {return this.no;}
	public void setNo(int no) {this.no = no;}
	/*
	 * point:得点
	 * intger(10), value = null
	 */
	private int point;
	public int getPoint() {return this.point;}
	public void setPoint(int point) {this.point = point;}
	/*
	 * class_num:クラス番号
	 * varchar(5), value = null
	 */
	private String classNum;
	public String getClassNum() {return this.classNum;}
	public void setClassNum(String classNum) {this.classNum = classNum;}
}