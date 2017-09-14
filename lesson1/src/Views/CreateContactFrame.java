package Views;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Controllers.ContactController;

public class CreateContactFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	private JPanel buttonsPanel;
	private JLabel lblHeadTitle;
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

	private JButton btnInsert;
	private JButton btnExit;
	private JButton btnShowData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateContactFrame frame = new CreateContactFrame();
					frame.setVisible(true);
					ContactController contact = new ContactController(frame);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public CreateContactFrame() {
		super("Create contact");
		contentPanel = new JPanel(new GridBagLayout());
		add(contentPanel);

		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 1;
		gc.gridy = 0;
		gc.weightx = 0.1;
		gc.weighty = 1;
		lblHeadTitle = new JLabel("INSERT CONTACT INFORMATION");
		contentPanel.add(lblHeadTitle, gc);

		///////////// first row ///////////////////

		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.gridy = 1;
		gc.insets = new Insets(5, 5, 0, 0);
		gc.anchor = GridBagConstraints.LINE_END;
		lblFirstname = new JLabel("First name:");
		contentPanel.add(lblFirstname, gc);

		gc.gridx = 1;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		txtFirstname = new JTextField(20);
		txtFirstname.setPreferredSize(new Dimension(20, 30));
		contentPanel.add(txtFirstname, gc);

		///////////// second row ///////////////////

		gc.gridx = 0;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_END;
		lblLastname = new JLabel("Last name:");
		contentPanel.add(lblLastname, gc);

		gc.gridx = 1;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_START;
		txtLastname = new JTextField(20);
		txtLastname.setPreferredSize(new Dimension(20, 30));
		contentPanel.add(txtLastname, gc);

		///////////// third row ///////////////////

		gc.gridx = 0;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.LINE_END;
		lblTitle = new JLabel("Contact title:");
		contentPanel.add(lblTitle, gc);

		gc.gridx = 1;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.LINE_START;
		txtTitle = new JTextField(20);
		txtTitle.setPreferredSize(new Dimension(20, 30));
		contentPanel.add(txtTitle, gc);

		///////////// fourth row ///////////////////

		gc.gridx = 0;
		gc.gridy = 4;
		gc.anchor = GridBagConstraints.LINE_END;
		lblOrgani = new JLabel("Your organization:");
		contentPanel.add(lblOrgani, gc);

		gc.gridx = 1;
		gc.gridy = 4;
		gc.anchor = GridBagConstraints.LINE_START;
		txtOrgani = new JTextField(20);
		txtOrgani.setPreferredSize(new Dimension(20, 30));
		contentPanel.add(txtOrgani, gc);

		///////////// fifth row ///////////////////

		gc.gridx = 0;
		gc.gridy = 5;
		gc.anchor = GridBagConstraints.LINE_END;
		lblContent = new JLabel("Your content:");
		contentPanel.add(lblContent, gc);

		gc.gridx = 1;
		gc.gridy = 5;
		gc.anchor = GridBagConstraints.LINE_START;
		txtContent = new JTextArea(215, 19);
		txtContent.setRows(4);

		JScrollPane scroll = new JScrollPane(txtContent, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		contentPanel.add(scroll, gc);

		///////////// six row ///////////////////
		buttonsPanel = new JPanel();
		add(buttonsPanel);

		btnInsert = new JButton("Insert");
		buttonsPanel.add(btnInsert);

		btnExit = new JButton("Exit");
		buttonsPanel.add(btnExit);

		btnShowData = new JButton("Show data");
		buttonsPanel.add(btnShowData);

		setBounds(100, 100, 450, 300);
		setContentPane(getContentPane());
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);

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
	
	public void ButtonEvent(ActionListener listener){
		btnInsert.setActionCommand("create-insert");
		btnExit.setActionCommand("create-exit");
		btnShowData.setActionCommand("create-show");
		
		btnInsert.addActionListener(listener);
		btnExit.addActionListener(listener);
		btnShowData.addActionListener(listener);
	}
}
