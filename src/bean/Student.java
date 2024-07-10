package bean;

import java.io.Serializable;

public class Student implements Serializable{
	/*
	 * no:学生番号
	 * varchar(10), primary key, not null
	 */
	private String no;
	public String getNo() {
		System.out.println("取得学生番号:'"+this.no+"'");
		return this.no;
	}
	public void setNo(String no) {
		this.no = no;
		System.out.println("設定学生番号:'"+this.no+"'");
	}
	/*
	 * name:学生名
	 * varchar(10), value = null
	 */
	private String name;
	public String getName() {
		System.out.println("取得学生名:'"+this.name+"'");
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
		System.out.println("設定学生名:'"+this.name+"'");
	}
	/*
	 * ent_year:入学年度
	 * integer(10), value = null
	 */
	private int entYear;
	public int getEntYear() {
		System.out.println("取得入学年度:'"+this.entYear+"'");
		return this.entYear;
	}
	public void setEntYear(int entYear) {
		this.entYear = entYear;
		System.out.println("設定入学年度:'"+this.entYear+"'");
	}
	/*
	 * class_num:クラス番号
	 * char(3), value = null
	 */
	private String classNum;
	public String getClassNum() {
		System.out.println("取得クラス番号:'"+this.classNum+"'");
		return this.classNum;
	}
	public void setClassNum(String classNum) {
		this.classNum = classNum;
		System.out.println("設定クラス番号:'"+this.classNum+"'");
	}
	/*
	 * is_attend:在学中フラグ
	 * boolean, value = null
	 */
	private boolean isAttend;
	public boolean isAttend() {
		System.out.println("取得在学中フラグ:'"+this.isAttend+"'");
		return this.isAttend;
	}
	public void setAttend(boolean isAttend) {
		this.isAttend = isAttend;
		System.out.println("設定在学中フラグ:'"+this.isAttend+"'");
	}
	/*
	 * school_cd:学校コード
	 * char(3), value = null
	 */
	private School school;
	public School getSchool(){
		System.out.println("取得学校情報:");
		this.school.getCd();
		this.school.getName();
		return this.school;
	}
	public void setSchool(School school){
		this.school = school;
		System.out.println("設定学校情報:");
		this.school.getCd();
		this.school.getName();
	}
//	public int getSchoolYear() {}
}