package Models;

import java.sql.ResultSet;

public class ContactModel extends DbModel {
	private int Id;
	private String FirstName, LastName, Title, Organization, Content;
	private DbModel db;

	public ContactModel(int id, String fn, String ln, String title, String ori, String content)
			throws ClassNotFoundException {
		super();
		this.Id = id;
		this.FirstName = fn;
		this.LastName = ln;
		this.Title = title;
		this.Organization = ori;
		this.Content = content;
		db = new DbModel();
	}

	public ContactModel(String fn, String ln, String title, String ori, String content) throws ClassNotFoundException {
		super();
		this.FirstName = fn;
		this.LastName = ln;
		this.Title = title;
		this.Organization = ori;
		this.Content = content;
		db = new DbModel();
	}

	public ContactModel() throws ClassNotFoundException {
		super();
		db = new DbModel();
	}

	public ResultSet contactList() {
		ResultSet res = db.SelectQuery("select * from contact");
		return res;
	}

	public void Insert() {
		String sql = "insert into contact(firstname,lastname,title,organi,content) " + "values('" + this.FirstName
				+ "', '" + this.LastName + "','" + this.Title + "', '" + this.Organization + "', '" + this.Content
				+ "')";
		this.CrudQuery(sql, "Insert");
	}

	public void Update(int id) {
		
		String sql = "update contact set firstname = \"" + this.FirstName + "\", lastname = \"" + this.LastName  + 
				"\", title = \"" + this.Title + "\", organi = \"" + this.Organization + "\", content = \"" + 
				this.Content + "\" where id = " + id + ";";
		this.CrudQuery(sql, "Update");
	}

	public void Delete(int id) {
		String sql = "delete from contact where id = " + id;
		this.CrudQuery(sql, "Delete");
	}

	public int getId() {
		return Id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public String getLastName() {
		return LastName;
	}

	public String getTitle() {
		return Title;
	}

	public String getOrganization() {
		return Organization;
	}

	public String getContent() {
		return Content;
	}

}
