package bean;

import java.io.Serializable;

public class ClassNum implements Serializable {
	/*
	 * school_cd:学校コード
	 * char(3), primary key, not null
	 */
	private String schoolCd;
	public String getSchoolCd() {
		System.out.println("取得学校コード:'"+this.schoolCd+"'");
		return this.schoolCd;
	}
	public void setSchoolCd(String schoolCd) {
		this.schoolCd = schoolCd;
		System.out.println("設定学校コード:'"+this.schoolCd+"'");
	}
	/*
	 * class_num:クラス番号
	 * varchar(5), primary key, not null
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
}