package Views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controllers.ContactController;
import Models.ContactModel;

public class IndexUpdateFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel topPane;
	private JPanel bottomPane;
	private JPanel innerBottomPane;

	private JLabel lblFirstname;
	private JLabel lblLastname;
	private JLabel lblTitle;
	private JLabel lblOrgani;
	private JLabel lblContent;

	private JTextField txtFirstname;
	private JTextField txtLastname;
	private JTextField txtTitle;
	private JTextField txtOrgani;
	private JTextArea txtContent;

	private JButton btnUpdate;
	private JButton btnExit;
	private JButton btnClear;
	private JButton btnDelete;
	private DefaultTableModel tModel;
	ContactModel model;

	/**
	 * Create the frame.
	 */
	public void LoadData(ContactController contactController){
		String[] columnNames = { "Id", "First Name", "Last Name", "Title", "Organization", "Content" };

		JTable table = new JTable();
		tModel = new DefaultTableModel();
		tModel.setColumnIdentifiers(columnNames);
		table.setModel(tModel);
		tableBinding(tModel, contactController.GetContactList());
		table.setFillsViewportHeight(true);
		table.setBorder(BorderFactory.createEtchedBorder());
		table.setPreferredScrollableViewportSize(new Dimension(500, 130));
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				clickTable(table);
				txtFirstname.setText(model.getFirstName());
				txtLastname.setText(model.getLastName());
				txtTitle.setText(model.getTitle());
				txtOrgani.setText(model.getOrganization());
				txtContent.setText(model.getContent());
			}
		});
		JScrollPane scrollPane = new JScrollPane(table);
		topPane.add(scrollPane);
		topPane.setBorder(BorderFactory.createTitledBorder("Contact data table"));
	}
	public void tableBinding(DefaultTableModel tableModel, ResultSet result) {
		try {
			while (result.next()) {
				String rows[] = new String[6];
				rows[0] = result.getString(1);
				rows[1] = result.getString(2);
				rows[2] = result.getString(3);
				rows[3] = result.getString(4);
				rows[4] = result.getString(5);
				rows[5] = result.getString(6);
				tableModel.addRow(rows);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public IndexUpdateFrame() {

		setLayout(new BorderLayout());
		try {
			ContactController contactController = new ContactController(this);
			topPane = new JPanel();
				
			// table
			LoadData(contactController);
			
			add(topPane, BorderLayout.NORTH);
			bottomPane = new JPanel();
			innerBottomPane = new JPanel(new GridBagLayout());
			bottomPane.add(innerBottomPane);
			bottomPane.setBorder(BorderFactory.createTitledBorder("Update contact data"));

			GridBagConstraints gc = new GridBagConstraints();
			gc.fill = GridBagConstraints.HORIZONTAL;

			///////////// first row ///////////////////

			gc.gridx = 0;
			gc.gridy = 1;
			gc.insets = new Insets(5, 5, 0, 0);
			gc.anchor = GridBagConstraints.LINE_END;
			lblFirstname = new JLabel("First name:");
			innerBottomPane.add(lblFirstname, gc);

			gc.gridx = 1;
			gc.gridy = 1;
			gc.anchor = GridBagConstraints.LINE_START;
			txtFirstname = new JTextField(20);
			txtFirstname.setPreferredSize(new Dimension(20, 30));
			innerBottomPane.add(txtFirstname, gc);

			///////////// second row ///////////////////

			gc.gridx = 0;
			gc.gridy = 2;
			gc.anchor = GridBagConstraints.LINE_END;
			lblLastname = new JLabel("Last name:");
			innerBottomPane.add(lblLastname, gc);

			gc.gridx = 1;
			gc.gridy = 2;
			gc.anchor = GridBagConstraints.LINE_START;
			txtLastname = new JTextField(20);
			txtLastname.setPreferredSize(new Dimension(20, 30));
			innerBottomPane.add(txtLastname, gc);

			///////////// third row ///////////////////

			gc.gridx = 0;
			gc.gridy = 3;
			gc.anchor = GridBagConstraints.LINE_END;
			lblTitle = new JLabel("Contact title:");
			innerBottomPane.add(lblTitle, gc);

			gc.gridx = 1;
			gc.gridy = 3;
			gc.anchor = GridBagConstraints.LINE_START;
			txtTitle = new JTextField(20);
			txtTitle.setPreferredSize(new Dimension(20, 30));
			innerBottomPane.add(txtTitle, gc);

			///////////// fourth row ///////////////////

			gc.gridx = 0;
			gc.gridy = 4;
			gc.anchor = GridBagConstraints.LINE_END;
			lblOrgani = new JLabel("Your organization:");
			innerBottomPane.add(lblOrgani, gc);

			gc.gridx = 1;
			gc.gridy = 4;
			gc.anchor = GridBagConstraints.LINE_START;
			txtOrgani = new JTextField(20);
			txtOrgani.setPreferredSize(new Dimension(20, 30));
			innerBottomPane.add(txtOrgani, gc);

			///////////// fifth row ///////////////////

			gc.gridx = 0;
			gc.gridy = 5;
			gc.anchor = GridBagConstraints.LINE_END;
			lblContent = new JLabel("Your content:");
			innerBottomPane.add(lblContent, gc);

			gc.gridx = 1;
			gc.gridy = 5;
			gc.anchor = GridBagConstraints.LINE_START;
			txtContent = new JTextArea(210, 18);
			txtContent.setRows(4);

			JScrollPane scroll = new JScrollPane(txtContent, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			innerBottomPane.add(scroll, gc);

			///////////// six row ///////////////////
			JPanel buttonsPanel = new JPanel();
			add(bottomPane, BorderLayout.CENTER);

			btnUpdate = new JButton("Update");
			buttonsPanel.add(btnUpdate);

			btnClear = new JButton("Clear");

			buttonsPanel.add(btnClear);

			btnDelete = new JButton("Delete");
			buttonsPanel.add(btnDelete);

			btnExit = new JButton("Exit");
			buttonsPanel.add(btnExit);

			gc.gridx = 0;
			gc.gridy = 6;
			add(buttonsPanel, BorderLayout.SOUTH);

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			setSize(600, 500);
			setVisible(true);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public ContactModel getModel(){
		return model;
	}
	public String getFirstName(){
		return this.txtFirstname.getText();
	}
	public String getLastName(){
		return this.txtLastname.getText();
	}
	public String getTitle(){
		return this.txtTitle.getText();
	}
	public String getOrigani(){
		return this.txtOrgani.getText();
	}
	public String getContent(){
		return this.txtContent.getText();
	}
	private void clickTable(JTable table) {

		int row = table.getSelectedRow();
		String id = (String.valueOf(table.getValueAt(row, 0)));
		String fn = (String.valueOf(table.getValueAt(row, 1)));
		String ln = (String.valueOf(table.getValueAt(row, 2)));
		String title = (String.valueOf(table.getValueAt(row, 3)));
		String ori = (String.valueOf(table.getValueAt(row, 4)));
		String content = (String.valueOf(table.getValueAt(row, 5)));
		try {
			model = new ContactModel(Integer.parseInt(id), fn, ln, title, ori, content);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setEmpty() {
		txtFirstname.setText("");
		txtLastname.setText("");
		txtTitle.setText("");
		txtOrgani.setText("");
		txtContent.setText("");
	}

	public void ButtonEvent(ActionListener listener) {
		btnClear.setActionCommand("clear");
		btnDelete.setActionCommand("delete");
		btnUpdate.setActionCommand("update");
		btnExit.setActionCommand("update-exit");

		btnClear.addActionListener(listener);
		btnExit.addActionListener(listener);
		btnUpdate.addActionListener(listener);
		btnDelete.addActionListener(listener);
	}
}
