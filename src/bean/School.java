package bean;

import java.io.Serializable;

public class School implements Serializable {
	/*
	 * cd:学校コード
	 * char(3), primary key, not null
	 */
	private String cd;
	public String getCd() {
		System.out.println("取得学校コード:'"+this.cd+"'");
		return this.cd;
	}
	public void setCd(String cd) {
		this.cd = cd;
		System.out.println("設定学校コード:'"+this.cd+"'");
	}
	/*
	 * name:学校名
	 * varchar(20), value = null
	 */
	private String name = null;
	public String getName() {
		System.out.println("取得学校名:'"+this.name+"'");
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
		System.out.println("設定学校名:'"+this.name+"'");
	}
}