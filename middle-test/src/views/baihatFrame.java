package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.github.lgooddatepicker.components.DatePicker;

import common.constants;

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
	private JComboBox cbbAlbum;

	private JButton btnSave;
	private JButton btnCancel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					baihatFrame frame = new baihatFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public baihatFrame() {
		super("Thêm mới bài hát");
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
		String[] casi = { "Sơn Tùng M-TP", "Chi Dân", "Issac", "Will" };
		cbbAlbum = new JComboBox(casi);
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

	public void registerButtonEvents(ActionListener listener) {

		btnSave.setActionCommand(constants.SAVE_ADD_BAIHAT);
		btnCancel.setActionCommand(constants.CANCEL_ADD_BAIHAT);

		btnSave.addActionListener(listener);
		btnCancel.addActionListener(listener);
	}

}
