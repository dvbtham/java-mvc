package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Models.ContactModel;
import Views.CreateContactFrame;
import Views.IndexUpdateFrame;

public class ContactController implements ActionListener {
	private ContactModel model;
	private CreateContactFrame contactView;
	private IndexUpdateFrame showDataView;

	public ContactController(CreateContactFrame contactView) throws ClassNotFoundException {
		this.contactView = contactView;
		contactView.ButtonEvent(this);
	}

	public ContactController(IndexUpdateFrame showDataView) throws ClassNotFoundException {
		this.showDataView = showDataView;
		model = new ContactModel();
	}

	private boolean isValid() {
		if (contactView.getFirstName().equals("")) {
			JOptionPane.showMessageDialog(null, "Firstname is reuired");
			return false;
		}
		if (contactView.getLastName().equals("")) {
			JOptionPane.showMessageDialog(null, "Lastname is reuired");
			return false;
		}
		if (contactView.getTitle().equals("")) {
			JOptionPane.showMessageDialog(null, "Title is reuired");
			return false;
		}
		if (contactView.getOrigani().equals("")) {
			JOptionPane.showMessageDialog(null, "Origanization is reuired");
			return false;
		}
		if (contactView.getContent().equals("")) {
			JOptionPane.showMessageDialog(null, "Content is reuired");
			return false;
		}

		return true;
	}

	public void Create() {
		try {
			if (isValid()) {
				model = new ContactModel(contactView.getFirstName(), contactView.getLastName(), contactView.getTitle(),
						contactView.getOrigani(), contactView.getContent());
				model.Insert();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public ResultSet GetContactList() {
		if (model != null)
			return model.contactList();
		ResultSet res = null;
		try {
			res = new ContactModel().contactList();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	public void Delete(int id) {
		if (model == null)
			try {
				model = new ContactModel();
				model.Delete(id);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		case "create-insert":
			Create();
			break;
		case "create-exit":
			this.contactView.dispose();
			break;

		case "create-show":
			IndexUpdateFrame frame = new IndexUpdateFrame();
			this.showDataView = frame;
			frame.ButtonEvent(this);
			// this.contactView.dispose();
			break;

		case "update":
			ContactModel c_model = null;
			try {
				c_model = new ContactModel(this.showDataView.getModel().getId(), this.showDataView.getFirstName(),
						this.showDataView.getLastName(), this.showDataView.getTitle(), this.showDataView.getOrigani(),
						this.showDataView.getContent());
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			c_model.Update(c_model.getId());
			this.showDataView.LoadData(this);
			break;

		case "clear":
			this.showDataView.setEmpty();
			break;

		case "delete":
			int id = this.showDataView.getModel().getId();
			Delete(id);
			this.showDataView.LoadData(this);
			break;

		case "update-exit":
			this.showDataView.dispose();
			break;
		}

	}

}
