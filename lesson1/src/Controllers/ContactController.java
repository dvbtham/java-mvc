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
	private CreateContactFrame insertView;
	private IndexUpdateFrame showDataView;

	public ContactController(CreateContactFrame insertView) throws ClassNotFoundException {
		this.insertView = insertView;
		insertView.ButtonEvent(this);
	}

	public ContactController(IndexUpdateFrame showDataView) throws ClassNotFoundException {
		this.showDataView = showDataView;
		model = new ContactModel();
	}

	private boolean isInsertValid() {
		if (insertView.getFirstName().equals("")) {
			JOptionPane.showMessageDialog(null, "Firstname is reuired");
			return false;
		}
		if (insertView.getLastName().equals("")) {
			JOptionPane.showMessageDialog(null, "Lastname is reuired");
			return false;
		}
		if (insertView.getTitle().equals("")) {
			JOptionPane.showMessageDialog(null, "Title is reuired");
			return false;
		}
		if (insertView.getOrigani().equals("")) {
			JOptionPane.showMessageDialog(null, "Origanization is reuired");
			return false;
		}
		if (insertView.getContent().equals("")) {
			JOptionPane.showMessageDialog(null, "Content is reuired");
			return false;
		}

		return true;
	}

	private boolean isUpdateValid() {
		if (showDataView.getFirstName().equals("")) {
			JOptionPane.showMessageDialog(null, "Firstname is reuired");
			return false;
		}
		if (showDataView.getLastName().equals("")) {
			JOptionPane.showMessageDialog(null, "Lastname is reuired");
			return false;
		}
		if (showDataView.getTitle().equals("")) {
			JOptionPane.showMessageDialog(null, "Title is reuired");
			return false;
		}
		if (showDataView.getOrigani().equals("")) {
			JOptionPane.showMessageDialog(null, "Origanization is reuired");
			return false;
		}
		if (showDataView.getContent().equals("")) {
			JOptionPane.showMessageDialog(null, "Content is reuired");
			return false;
		}

		return true;
	}

	public void Create() {
		try {
			if (isInsertValid()) {
				model = new ContactModel(insertView.getFirstName(), insertView.getLastName(), insertView.getTitle(),
						insertView.getOrigani(), insertView.getContent());
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
			this.insertView.dispose();
			break;

		case "create-show":
			IndexUpdateFrame frame = new IndexUpdateFrame();
			this.showDataView = frame;
			frame.ButtonEvent(this);
			// this.insertView.dispose();
			break;

		case "update":
			if (isUpdateValid()) {
				ContactModel c_model = null;
				try {
					c_model = new ContactModel(this.showDataView.getModel().getId(), this.showDataView.getFirstName(),
							this.showDataView.getLastName(), this.showDataView.getTitle(),
							this.showDataView.getOrigani(), this.showDataView.getContent());
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				c_model.Update(c_model.getId());
				this.showDataView.LoadData(this);
			} else {
				JOptionPane.showMessageDialog(null, "Something went wrongs!!!");
			}
			break;

		case "clear":
			this.showDataView.setEmpty();
			break;

		case "delete":
			int option = JOptionPane.showConfirmDialog(null, "Are you sure that you want to delete this contact?",
					"Delete contact", JOptionPane.YES_NO_OPTION);

			if (option == JOptionPane.YES_OPTION) {
				int id = this.showDataView.getModel().getId();
				if (id > 0)
					Delete(id);
				else
					JOptionPane.showMessageDialog(null, "Contact not found!!!");
			}
			break;

		case "update-exit":
			this.showDataView.dispose();
			break;
		}

	}

}
