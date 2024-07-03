package bean;

import java.io.Serializable;

public class Teacher implements Serializable {
	/*
	 * id:教員ID
	 * varcher(10), primary key, not null
	 */
	private String id;
	public String getId(){
		System.out.println("取得教員ID:'"+this.id+"'");
		return this.id;
	}
	public void setId(String id){
		this.id = id;
		System.out.println("設定教員ID:'"+this.id+"'");
	}
	/*
	 * password:パスワード
	 * varcher(30), value = null
	 */
	private String password;
	public String getPassword(){
		return this.password;
	}
	public void setPassword(String password){
		this.password = password;
	}
	/*
	 * name:氏名
	 * varcher(10), value = null
	 */
	private String name;
	public String getName(){
		System.out.println("取得氏名:'"+this.name+"'");
		return this.name;
	}
	public void setName(String name){
		this.name = name;
		System.out.println("設定氏名:'"+this.name+"'");
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
}