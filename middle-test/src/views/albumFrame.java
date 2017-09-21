package views;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.github.lgooddatepicker.components.DatePicker;
import common.DatePickerSettingsHelper;
import common.constants;
import models.AlbumModel;
import models.CaSiModel;

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
	private JComboBox<String> cbbCaSi;

	private JButton btnSave;
	private JButton btnCancel;
	private AlbumModel albumModel;
	private String macasi;
	DefaultComboBoxModel<String> defaultModel;
	
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
		return macasi;
	}

	public String NgayTao() {
		return datePicker.getText();
	}

	public void setSelectedIndexCbb(int index){
		cbbCaSi.setSelectedIndex(index);
	}
	
	private void initGUI(AlbumModel model) {
		initGUI();
		txtId.setText(model.getId());
		txtId.setEnabled(false);

		txtTenAlbum.setText(model.getTenAlbum());

		int soBH = model.getSoBaiHat();
		txtSoBaiHat.setText(Integer.toString(soBH));

		datePicker.setText(model.getNgayTao());

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
		datePicker = new DatePicker(new DatePickerSettingsHelper().getDatePickerSettings());
		datePicker.setPreferredSize(new Dimension(223, 30));
		contentPanel.add(datePicker, gc);

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
		ResultSet res = null;
		
		defaultModel = new DefaultComboBoxModel<String>();
		
		try {
			res = new CaSiModel().getAll();
			while (res.next()) {
				defaultModel.addElement(res.getString("tencasi"));					
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cbbCaSi = new JComboBox<String>(defaultModel);
		cbbCaSi.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				String tencasi = (String)cbbCaSi.getSelectedItem();
		        try {
					macasi = new AlbumModel().getIdByValue(tencasi);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
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
	public DefaultComboBoxModel<String> getDefaultModel() {
		return defaultModel;
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

	public boolean validForm() {
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

		if (datePicker.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Bạn phải nhập ngày tạo");
			return false;
		}
		if (macasi == "") {
			JOptionPane.showMessageDialog(null, "Bạn phải chọn ca sĩ");
			return false;
		}

		return true;
	}

	public AlbumModel AlbumModel() {
		return this.albumModel;
	}

	public void registerButtonEvents(ActionListener listener) {

		btnSave.setActionCommand(constants.SAVE_ALBUM);
		btnCancel.setActionCommand(constants.CANCEL_ALBUM);

		btnSave.addActionListener(listener);
		btnCancel.addActionListener(listener);
	}

}
