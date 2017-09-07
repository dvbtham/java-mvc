package Views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					IndexUpdateFrame frame = new IndexUpdateFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public IndexUpdateFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(600, 500);
		setLayout(new BorderLayout());

		topPane = new JPanel();

		// table
		String[] columnNames = { "Id", "First Name", "Last Name", "Title", "Organization", "Content" };
		Object[][] data = { { 1, "Kathy", "Smith", "Smith's title", "Abc", "Smith's content" },
				{ 2, "Kathy", "Smith", "Smith's title", "Abc", "Smith's content" },
				{ 3, "Kathy", "Smith", "Smith's title", "Abc", "Smith's content" },

		};
		JTable table = new JTable(data, columnNames);
		table.setFillsViewportHeight(true);
		table.setBorder(BorderFactory.createEtchedBorder());
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		JScrollPane scrollPane = new JScrollPane(table);
		topPane.add(scrollPane);
		topPane.setBorder(BorderFactory.createTitledBorder("Contact data table"));

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

	}

}
