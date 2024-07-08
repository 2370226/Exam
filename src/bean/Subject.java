package bean;

import java.io.Serializable;

public class Subject implements Serializable {
	/*
	 * school_cd:学校コード
	 * char(3), primary key, not null
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
	/*
	 * cd:科目コード
	 * char(3), primary key, not null
	 */
	private String cd;
	public String getCd() {
		System.out.println("取得科目コード:'"+this.cd+"'");
		return this.cd;
	}
	public void setCd(String cd) {
		this.cd = cd;
		System.out.println("設定科目コード:'"+this.cd+"'");
	}
	/*
	 * name:科目名
	 * varchar(20), value = null
	 */
	private String name;
	public String getName() {
		System.out.println("取得科目名:'"+this.name+"'");
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
		System.out.println("設定科目名:'"+this.name+"'");
	}
}