package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.github.lgooddatepicker.components.DatePicker;

import common.constants;

public class casiFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	private JPanel buttonsPanel;
	private JLabel lblHeadTitle;
	private JLabel lblId;
	private JLabel lblTenCaSi;
	private JLabel lblGioiTinh;
	private JLabel lblNgaySinh;
	private JLabel lblBio;

	private JTextField txtId;
	private JTextField txtTenCaSi;
	private DatePicker datePicker;
	private JTextArea txtBio;
	private JRadioButton rbNam;
	private JRadioButton rbNu;

	private JButton btnSave;
	private JButton btnCancel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					casiFrame frame = new casiFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public casiFrame() {
		super("Thêm mới ca sĩ");
		contentPanel = new JPanel(new GridBagLayout());
		add(contentPanel);

		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 1;
		gc.gridy = 0;
		gc.weightx = 0.1;
		gc.weighty = 1;
		lblHeadTitle = new JLabel("THÔNG TIN CÁ NHÂN");
		contentPanel.add(lblHeadTitle, gc);

		///////////// first row ///////////////////

		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.gridy = 1;
		gc.insets = new Insets(5, 5, 0, 0);
		gc.anchor = GridBagConstraints.LINE_END;
		lblId = new JLabel("Mã ca sĩ:");
		contentPanel.add(lblId, gc);

		gc.gridx = 1;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		txtId = new JTextField(20);
		txtId.setPreferredSize(new Dimension(20, 30));
		contentPanel.add(txtId, gc);

		///////////// second row ///////////////////

		gc.gridx = 0;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_END;
		lblTenCaSi = new JLabel("Tên ca sĩ: ");
		contentPanel.add(lblTenCaSi, gc);

		gc.gridx = 1;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_START;
		txtTenCaSi = new JTextField(20);
		txtTenCaSi.setPreferredSize(new Dimension(20, 30));
		contentPanel.add(txtTenCaSi, gc);

		///////////// third  row ///////////////////

		gc.gridx = 0;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.LINE_END;
		lblGioiTinh = new JLabel("Giới tính: ");
		contentPanel.add(lblGioiTinh, gc);
		
		ButtonGroup group = new ButtonGroup();
		
		gc.gridx = 1;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.LINE_START;
		JPanel rbPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
		contentPanel.add(rbPane, gc);
		
		rbNam = new JRadioButton("Nam");
		rbPane.add(rbNam);
		
		rbNu = new JRadioButton("Nữ");
		rbPane.add(rbNu);
		
		group.add(rbNam);
		group.add(rbNu);

		///////////// fourth row ///////////////////

		gc.gridx = 0;
		gc.gridy = 4;
		gc.anchor = GridBagConstraints.LINE_END;
		lblNgaySinh = new JLabel("Ngày sinh:");
		contentPanel.add(lblNgaySinh, gc);

		gc.gridx = 1;
		gc.gridy = 4;
		gc.anchor = GridBagConstraints.LINE_START;
		datePicker = new DatePicker();
		contentPanel.add(datePicker, gc);

		///////////// fifth row ///////////////////

		gc.gridx = 0;
		gc.gridy = 5;
		gc.anchor = GridBagConstraints.LINE_END;
		lblBio = new JLabel("Giới thiệu:");
		contentPanel.add(lblBio, gc);

		gc.gridx = 1;
		gc.gridy = 5;
		gc.gridwidth = 2;
		gc.anchor = GridBagConstraints.LINE_START;
		txtBio = new JTextArea(4, 19);
		JScrollPane scroll = new JScrollPane(txtBio, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		contentPanel.add(scroll, gc);

		///////////// six row ///////////////////
		buttonsPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gc1 = new GridBagConstraints();
		gc1.fill = GridBagConstraints.HORIZONTAL;
		add(buttonsPanel);

		gc1.gridx = 0;
		gc1.gridy = 0;
		btnSave = new JButton("Save");
		gc1.insets = new Insets(15, 2, 0, 10);
		buttonsPanel.add(btnSave, gc1);

		gc1.gridx = 1;
		gc1.gridy = 0;
		btnCancel = new JButton("Cancel");
		buttonsPanel.add(btnCancel, gc1);

		setBounds(100, 100, 450, 400);
		setContentPane(getContentPane());
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 400);
	}

	public void registerButtonEvents(ActionListener listener) {

		btnSave.setActionCommand(constants.SAVE_ADD_CASI);
		btnCancel.setActionCommand(constants.CANCEL_ADD_CASI);

		btnSave.addActionListener(listener);
		btnCancel.addActionListener(listener);
	}
}
