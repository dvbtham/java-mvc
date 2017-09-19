package models;

import java.sql.ResultSet;

public class AlbumModel extends DbModel {

	private int soBaiHat;
	private String id, tenAlbum, ngayTao, maCaSi;
	private DbModel db;

	public AlbumModel() throws ClassNotFoundException {
		super();
		db = new DbModel();
	}

	public AlbumModel(String id, String tenAlbum, int soBaiHat, String ngayTao, String maCaSi)
			throws ClassNotFoundException {
		super();
		this.id = id;
		this.tenAlbum = tenAlbum;
		this.soBaiHat = soBaiHat;
		this.ngayTao = ngayTao;
		this.maCaSi = maCaSi;
		db = new DbModel();
	}

	public String getId() {
		return this.id;
	}

	public int getSoBaiHat() {
		return soBaiHat;
	}

	public String getTenAlbum() {
		return tenAlbum;
	}

	public String getNgayTao() {
		return ngayTao;
	}

	public String getMaCaSi() {
		return maCaSi;
	}
	
	public boolean isExists(String id){
		String sql = "SELECT id FROM album WHERE id = \"" + id + "\";";
		return this.CheckExists(sql);
	}
	
	public ResultSet getAll() {
		ResultSet res = db.SelectQuery("select id, tenalbum , sobaihat, DATE_FORMAT(ngaytao, '%d/%m/%Y'), macasi from album");
		return res;
	}

	public void Insert() {
		String sql = "insert into album " + "values('" + this.id + "' , '" + this.tenAlbum + "', '" + this.soBaiHat
				+ "', STR_TO_DATE('" + this.ngayTao + "', '%d/%m/%Y'), '" + this.maCaSi + "')";
		this.CrudQuery(sql, "Insert");
	}

	public void Update(String id) {

		String sql = "update album set tenalbum = \"" + this.tenAlbum + "\", sobaihat = \"" + this.soBaiHat
				+ "\", ngaytao = STR_TO_DATE('" + this.ngayTao + "', '%d/%m/%Y'), macasi = \"ssf\" where id = \""+ id + "\";";
		this.CrudQuery(sql, "Update");
	}

	public void Delete(String id) {
		String sql = "DELETE FROM album WHERE id = \"" + id + "\";";
		this.CrudQuery(sql, "Delete");
	}
}