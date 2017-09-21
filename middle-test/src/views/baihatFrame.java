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
import common.constants;
import models.AlbumModel;
import models.BaiHatModel;
import models.CaSiModel;

public class baihatFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	private JPanel buttonsPanel;
	private JLabel lblHeadTitle;
	private JLabel lblId;
	private JLabel lblTenBaiHat;
	private JLabel lblTheLoai;
	private JLabel lblAlbum;

	private JTextField txtId;
	private JTextField txtTenBaiHat;
	private JTextField txtTheLoai;
	private JComboBox<String> cbbAlbum;

	private JButton btnSave;
	private JButton btnCancel;
	private BaiHatModel model;
	private String maalbum;
	DefaultComboBoxModel<String> defaultModel;
	
	public void setSelectedIndexCbb(int index){
		cbbAlbum.setSelectedIndex(index);
	}
	
	public BaiHatModel getModel(){
		return model;
	}
	
	public void initGUI(BaiHatModel model){
		initGUI();
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
		lblHeadTitle = new JLabel("THÔNG TIN BÀI HÁT");
		contentPanel.add(lblHeadTitle, gc);

		///////////// first row ///////////////////

		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.gridy = 1;
		gc.insets = new Insets(5, 5, 0, 0);
		gc.anchor = GridBagConstraints.LINE_END;
		lblId = new JLabel("Mã bài hát:");
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
		lblTenBaiHat = new JLabel("Tên bài hát:");
		contentPanel.add(lblTenBaiHat, gc);

		gc.gridx = 1;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_START;
		txtTenBaiHat = new JTextField(20);
		txtTenBaiHat.setPreferredSize(new Dimension(20, 30));
		contentPanel.add(txtTenBaiHat, gc);

		///////////// third row ///////////////////

		gc.gridx = 0;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.LINE_END;
		lblTheLoai = new JLabel("Thể loại:");
		contentPanel.add(lblTheLoai, gc);

		gc.gridx = 1;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.LINE_START;
		txtTheLoai = new JTextField(20);
		txtTheLoai.setPreferredSize(new Dimension(20, 30));
		contentPanel.add(txtTheLoai, gc);

		///////////// fourth row ///////////////////

		gc.gridx = 0;
		gc.gridy = 4;
		gc.anchor = GridBagConstraints.LINE_END;
		lblAlbum = new JLabel("Album:");		
		contentPanel.add(lblAlbum, gc);

		gc.gridx = 1;
		gc.gridy = 4;
		gc.anchor = GridBagConstraints.LINE_START;
		ResultSet res = null;
		defaultModel = new DefaultComboBoxModel<String>();
		try {
			res = new AlbumModel().getAll();
			while (res.next()) {
				defaultModel.addElement(res.getString("tenalbum"));					
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cbbAlbum = new JComboBox<String>(defaultModel);
		cbbAlbum.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				String tenAlbum = (String)cbbAlbum.getSelectedItem();
		        try {
					maalbum = new CaSiModel().getIdByValue(tenAlbum);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPanel.add(cbbAlbum, gc);

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
	
	public boolean validForm() {
		if (txtId.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Bạn phải nhập mã bài hát");
			return false;
		}
		if (txtTenBaiHat.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Bạn phải nhập tên bài hát");
			return false;
		}

		if (txtTheLoai.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Bạn phải nhập thể loại");
			return false;
		}

		if (maalbum == "") {
			JOptionPane.showMessageDialog(null, "Bạn phải chọn ca sĩ");
			return false;
		}

		return true;
	}
	
	public baihatFrame() {
		super("Thêm mới bài hát");
		initGUI();
	}
	public baihatFrame(BaiHatModel model) {
		super("Cập nhật bài hát " + model);
		this.model = model;
		initGUI(model);
	}
	
	public String getId(){
		return txtId.getText();
	}
	
	public String getTenBaiHat(){
		return txtTenBaiHat.getText();
	}
	
	public String getTheLoai(){
		return txtTheLoai.getText();
	}
	
	public String getMaAlbum(){
		return maalbum;
	}

	public void registerButtonEvents(ActionListener listener) {

		btnSave.setActionCommand(constants.SAVE_BAIHAT);
		btnCancel.setActionCommand(constants.CANCEL_BAIHAT);

		btnSave.addActionListener(listener);
		btnCancel.addActionListener(listener);
	}

}
