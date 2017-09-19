package models;

import java.sql.ResultSet;

import javax.swing.text.StyleContext.SmallAttributeSet;

public class CaSiModel extends DbModel {

	private String id, tencasi, ngaysinh, gioithieu;
	private DbModel db;
	int gioitinh;

	public CaSiModel() throws ClassNotFoundException {
		super();
		db = new DbModel();
	}

	public CaSiModel(String id, String tencasi, int gioitinh, String ngaysinh, String gioithieu)
			throws ClassNotFoundException {
		super();
		this.id = id;
		this.tencasi = tencasi;
		this.gioitinh = gioitinh;
		this.ngaysinh = ngaysinh;
		this.gioithieu = gioithieu;
		db = new DbModel();
	}

	public String getTencasi() {
		return tencasi;
	}

	public int getGioitinh() {
		return gioitinh;
	}

	public String getNgaysinh() {
		return ngaysinh;
	}

	public String getGioithieu() {
		return gioithieu;
	}

	public String getId() {
		return this.id;
	}
	
	public String getNameById(String id) {
		String sql = "SELECT tencasi FROM casi WHERE id = \"" + id + "\";";
		return db.getNameById(sql, "tencasi");
	}
	
	public boolean isExists(String id){
		String sql = "SELECT id FROM casi WHERE id = \"" + id + "\";";
		return this.CheckExists(sql);
	}
	
	public ResultSet getAll() {
		ResultSet res = db.SelectQuery("select id, tencasi , gioitinh, DATE_FORMAT(ngaysinh, '%d/%m/%Y'), gioithieu from casi");
		return res;
	}

	public void Insert() {
		String sql =  "insert into casi values('"+ getId() +"', '"+ getTencasi() +"', " + getGioitinh() + ", STR_TO_DATE('"+ getNgaysinh() +"', '%d/%m/%Y'), '"+ getGioithieu() +"');";
		this.CrudQuery(sql, "Insert");
	}

	public void Update(String id) {

		String sql = "update casi set tencasi = \"" + this.tencasi + "\", " + 
				"ngaysinh = STR_TO_DATE('" + this.ngaysinh + "', '%d/%m/%Y'), " + 
				"gioitinh = "+ getGioitinh() + ", gioithieu = \"" + this.gioithieu + "\" "+ 
				"where id = \""+ id + "\";";
		this.CrudQuery(sql, "Update");
	}

	public void Delete(String id) {
		String sql = "DELETE FROM casi WHERE id = \"" + id + "\";";
		this.CrudQuery(sql, "Delete");
	}
}
