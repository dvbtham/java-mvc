package views;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.github.lgooddatepicker.components.DatePicker;

import common.DatePickerSettingsHelper;
import common.GroupButtonHelper;
import common.constants;
import models.CaSiModel;

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
	private ButtonGroup group;

	private JButton btnSave;
	private JButton btnCancel;
	private CaSiModel model;

	public void initGUI(CaSiModel model){
		initGUI();
		txtId.setText(model.getId());
		txtId.setEnabled(false);
		
		txtTenCaSi.setText(model.getTencasi());
		txtBio.setText(model.getGioithieu());
		datePicker.setText(model.getNgaysinh());
		
		if(model.getGioitinh() == 1)
			rbNam.setSelected(true);
		else
			rbNu.setSelected(true);
		
		
	}
	public void initGUI(){
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
		
		group = new ButtonGroup();
		
		gc.gridx = 1;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.LINE_START;
		JPanel rbPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
		contentPanel.add(rbPane, gc);
		
		rbNam = new JRadioButton("Nam");
		rbNam.setName("1");
		rbPane.add(rbNam);
		
		rbNu = new JRadioButton("Nữ");
		rbNu.setName("0");
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
		datePicker = new DatePicker(new DatePickerSettingsHelper().getDatePickerSettings());
		datePicker.setPreferredSize(new Dimension(223, 30));
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
	
	
	public casiFrame() {
		super("Thêm mới ca sĩ");
		
		initGUI();
	}
	public casiFrame(CaSiModel model) {
		super("Cập nhật ca sĩ " + model.getTencasi());
		
		this.model = model;
		initGUI(model);
	}
	public CaSiModel getModel(){
		return this.model;
	}
	public String getId(){
		return txtId.getText();
	}
	public String getDate(){
		return datePicker.getText();
	}
	public String getTenCaSi(){
		return txtTenCaSi.getText();
	}
	public String getGioiThieu(){
		return txtBio.getText();
	}
	public String getGioiTinh(){
		return new GroupButtonHelper().getSelectedButtonText(group);
	}
	public void registerButtonEvents(ActionListener listener) {
				
		btnSave.setActionCommand(constants.SAVE_CASI);
		btnCancel.setActionCommand(constants.CANCEL_CASI);

		btnSave.addActionListener(listener);
		btnCancel.addActionListener(listener);
	}
	public boolean validForm(){
		if (txtId.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Bạn phải nhập Id");
			return false;
		}
		if (txtTenCaSi.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Bạn phải nhập tên ca sĩ");
			return false;
		}
		if (new GroupButtonHelper().getSelectedButtonText(group).equals("")) {
			JOptionPane.showMessageDialog(null, "Bạn phải chọn giới tính");
			return false;
		}
		if (datePicker.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Bạn phải chọn ngày sinh");
			return false;
		}
		if (txtBio.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Bạn phải giới thiệu về bản thân");
			return false;
		}
		return true;
	}
}
