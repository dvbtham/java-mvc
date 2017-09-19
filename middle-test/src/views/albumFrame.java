package views;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.optionalusertools.DateChangeListener;
import com.github.lgooddatepicker.zinternaltools.DateChangeEvent;

import common.constants;
import controllers.AlbumController;
import models.AlbumModel;

public class albumFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	private JPanel buttonsPanel;
	private JLabel lblHeadTitle;
	private JLabel lblId;
	private JLabel lblTenAlbum;
	private JLabel lblSoBaiHat;
	private JLabel lblTitle;
	private JLabel lblCaSi;

	private JTextField txtId;
	private JTextField txtTenAlbum;
	private JTextField txtSoBaiHat;
	private DatePicker datePicker;
	private JComboBox cbbCaSi;

	private JButton btnSave;
	private JButton btnCancel;
	private JTextField createDate;
	private AlbumModel albumModel;

	public String Id() {
		return txtId.getText();
	}

	public String TenAlbum() {
		return txtTenAlbum.getText();
	}

	public int SoBaiHat() {
		int number = txtSoBaiHat.getText().equals("") ? 0 : Integer.parseInt(txtSoBaiHat.getText());
		return number;
	}

	public String MaCaSi() {
		return "ssf";
	}

	public String NgayTao() {
		return createDate.getText();
	}

	private void initGUI(AlbumModel model) {
		contentPanel = new JPanel(new GridBagLayout());
		add(contentPanel);

		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 1;
		gc.gridy = 0;
		gc.weightx = 0.1;
		gc.weighty = 1;
		lblHeadTitle = new JLabel("THÔNG TIN VỀ ALBUM");
		contentPanel.add(lblHeadTitle, gc);

		///////////// first row ///////////////////

		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.gridy = 1;
		gc.insets = new Insets(5, 5, 0, 0);
		gc.anchor = GridBagConstraints.LINE_END;
		lblId = new JLabel("Mã album:");
		contentPanel.add(lblId, gc);

		gc.gridx = 1;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		txtId = new JTextField(20);
		txtId.setText(model.getId());
		txtId.setEnabled(false);
		txtId.setPreferredSize(new Dimension(20, 30));
		contentPanel.add(txtId, gc);

		///////////// second row ///////////////////

		gc.gridx = 0;
		gc.gridy = 2;
		gc.insets = new Insets(5, 5, 0, 0);
		gc.anchor = GridBagConstraints.LINE_END;
		lblTenAlbum = new JLabel("Tên album:");
		contentPanel.add(lblTenAlbum, gc);

		gc.gridx = 1;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_START;
		txtTenAlbum = new JTextField(20);
		txtTenAlbum.setText(model.getTenAlbum());
		txtTenAlbum.setPreferredSize(new Dimension(20, 30));
		contentPanel.add(txtTenAlbum, gc);

		///////////// third row ///////////////////

		gc.gridx = 0;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.LINE_END;
		lblSoBaiHat = new JLabel("Số bài hát:");
		contentPanel.add(lblSoBaiHat, gc);

		gc.gridx = 1;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.LINE_START;
		txtSoBaiHat = new JTextField(20);
		int soBH = model.getSoBaiHat();
		txtSoBaiHat.setText(Integer.toString(soBH));
		txtSoBaiHat.setPreferredSize(new Dimension(20, 30));
		contentPanel.add(txtSoBaiHat, gc);

		///////////// fourth row ///////////////////

		gc.gridx = 0;
		gc.gridy = 4;
		gc.anchor = GridBagConstraints.LINE_END;
		lblTitle = new JLabel("Ngày tạo:");
		contentPanel.add(lblTitle, gc);

		gc.gridx = 1;
		gc.gridy = 4;
		gc.anchor = GridBagConstraints.LINE_START;
		createDate = new JTextField(20);
		createDate.setText(model.getNgayTao());
		createDate.setPreferredSize(new Dimension(20, 30));
		contentPanel.add(createDate, gc);

		///////////// fifth row ///////////////////

		gc.gridx = 0;
		gc.gridy = 5;
		gc.anchor = GridBagConstraints.LINE_END;
		lblCaSi = new JLabel("Ca sĩ:");
		contentPanel.add(lblCaSi, gc);

		gc.gridx = 1;
		gc.gridy = 5;
		gc.gridwidth = 2;
		gc.anchor = GridBagConstraints.LINE_START;
		String[] casi = { "Sơn Tùng M-TP", "Chi Dân", "Issac", "Will" };
		cbbCaSi = new JComboBox(casi);
		contentPanel.add(cbbCaSi, gc);

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
		
		setBounds(100, 100, 450, 300);
		setContentPane(getContentPane());
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 300);
	}

	private void initGUI() {
		contentPanel = new JPanel(new GridBagLayout());
		add(contentPanel);

		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 1;
		gc.gridy = 0;
		gc.weightx = 0.1;
		gc.weighty = 1;
		lblHeadTitle = new JLabel("THÔNG TIN VỀ ALBUM");
		contentPanel.add(lblHeadTitle, gc);

		///////////// first row ///////////////////

		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.gridy = 1;
		gc.insets = new Insets(5, 5, 0, 0);
		gc.anchor = GridBagConstraints.LINE_END;
		lblId = new JLabel("Mã album:");
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
		gc.insets = new Insets(5, 5, 0, 0);
		gc.anchor = GridBagConstraints.LINE_END;
		lblTenAlbum = new JLabel("Tên album:");
		contentPanel.add(lblTenAlbum, gc);

		gc.gridx = 1;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_START;
		txtTenAlbum = new JTextField(20);
		txtTenAlbum.setPreferredSize(new Dimension(20, 30));
		contentPanel.add(txtTenAlbum, gc);

		///////////// third row ///////////////////

		gc.gridx = 0;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.LINE_END;
		lblSoBaiHat = new JLabel("Số bài hát:");
		contentPanel.add(lblSoBaiHat, gc);

		gc.gridx = 1;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.LINE_START;
		txtSoBaiHat = new JTextField(20);
		txtSoBaiHat.setPreferredSize(new Dimension(20, 30));
		contentPanel.add(txtSoBaiHat, gc);

		///////////// fourth row ///////////////////

		gc.gridx = 0;
		gc.gridy = 4;
		gc.anchor = GridBagConstraints.LINE_END;
		lblTitle = new JLabel("Ngày tạo:");
		contentPanel.add(lblTitle, gc);

		gc.gridx = 1;
		gc.gridy = 4;
		gc.anchor = GridBagConstraints.LINE_START;
		createDate = new JTextField(20);
		createDate.setPreferredSize(new Dimension(20, 30));
		contentPanel.add(createDate, gc);

		///////////// fifth row ///////////////////

		gc.gridx = 0;
		gc.gridy = 5;
		gc.anchor = GridBagConstraints.LINE_END;
		lblCaSi = new JLabel("Ca sĩ:");
		contentPanel.add(lblCaSi, gc);

		gc.gridx = 1;
		gc.gridy = 5;
		gc.gridwidth = 2;
		gc.anchor = GridBagConstraints.LINE_START;
		String[] casi = { "Sơn Tùng M-TP", "Chi Dân", "Issac", "Will" };
		cbbCaSi = new JComboBox(casi);
		contentPanel.add(cbbCaSi, gc);

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
		
		setBounds(100, 100, 450, 300);
		setContentPane(getContentPane());
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 300);
	}

	public albumFrame() {
		super("Thêm mới album");
		initGUI();
	}

	public albumFrame(AlbumModel model) {
		super("Cập nhật album " + model.getTenAlbum());
		
		this.albumModel = model;
		initGUI(model);
	}

	public boolean ValidForm() {
		if (txtId.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Bạn phải nhập Id");
			return false;
		}
		if (txtTenAlbum.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Bạn phải nhập tên album");
			return false;
		}

		if (txtSoBaiHat.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Bạn phải nhập tên album");
			return false;
		}

		if (createDate.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Bạn phải nhập ngày tạo");
			return false;
		}

		return true;
	}

	public AlbumModel AlbumModel() {
		return this.albumModel;
	}

	public void registerButtonEvents(ActionListener listener) {

		btnSave.setActionCommand(constants.SAVE_ADD_ALBUM);
		btnCancel.setActionCommand(constants.CANCEL_ADD_ALBUM);

		btnSave.addActionListener(listener);
		btnCancel.addActionListener(listener);
	}

}
