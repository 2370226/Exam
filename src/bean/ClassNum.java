package bean;

import java.io.Serializable;

public class ClassNum implements Serializable {
	/*
	 * school_cd:学校コード
	 * char(3), primary key, not null
	 */
	private String schoolCd;
	public String getSchoolCd() {return this.schoolCd;}
	public void setSchoolCd(String schoolCd) {this.schoolCd = schoolCd;}
	/*
	 * class_num:クラス番号
	 * varchar(5), primary key, not null
	 */
	private String classNum;
	public String getClassNum() {return this.classNum;}
	public void setClassNum(String classNum) {this.classNum = classNum;}
}