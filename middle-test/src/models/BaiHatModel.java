package models;

import java.sql.ResultSet;

public class BaiHatModel extends DbModel{
	private DbModel db;
	String mabaihat, tenbaihat, theloai, maalbum;
	
	public String getMabaihat() {
		return mabaihat;
	}

	public String getTenbaihat() {
		return tenbaihat;
	}

	public String getTheloai() {
		return theloai;
	}

	public String getMaalbum() {
		return maalbum;
	}

	public BaiHatModel() throws ClassNotFoundException {
		super();
		db= new DbModel();
	}
	public BaiHatModel(String mabaihat, String tenbaihat, String theloai, String maalbum) throws ClassNotFoundException {
		super();
		db= new DbModel();
		this.maalbum = maalbum;
		this.tenbaihat = tenbaihat;
		this.mabaihat = maalbum;
		this.theloai = theloai;
	}
	
	public ResultSet getAll(){
		ResultSet res = db.SelectQuery("select * from baihat");
		return res;
	}
	
	public boolean isExists(String id) {
		String sql = "SELECT mabaihat FROM baihat WHERE mabaihat = \"" + id + "\";";
		return this.CheckExists(sql);
	}
	
	public void Insert() {
		String sql = "insert into baihat values('" + this.mabaihat + "' , '" + this.tenbaihat + "', '" + this.theloai + "','" + this.maalbum + "')";
		this.CrudQuery(sql, "Insert");
	}

	public void Update(String id) {

		String sql = "update album set tenbaihat = \"" + this.tenbaihat + "\", theloai = \"" + this.theloai
				+ "\", maalbum = \"" + this.maalbum + "\" where id = \"" + id
				+ "\";";
		this.CrudQuery(sql, "Update");
	}

	public void Delete(String id) {
		String sql = "DELETE FROM baihat WHERE id = \"" + id + "\";";
		this.CrudQuery(sql, "Delete");
	}
}
