package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import common.constants;
import models.AlbumModel;
import models.BaiHatModel;
import models.CaSiModel;
import views.mainFrame;

public class HomeController implements ActionListener {
	private views.albumFrame albumFrame;
	private views.casiFrame casiFrame;
	private views.baihatFrame baihatFrame;
	private views.mainFrame mainFrame;

	public HomeController(mainFrame mainFrame, views.albumFrame albumFrame, views.casiFrame casiFrame,
			views.baihatFrame baihatFrame) {

		this.mainFrame = mainFrame;
		this.mainFrame.RegisterButtonEvents(this);
		this.albumFrame = albumFrame;
		this.casiFrame = casiFrame;
		this.baihatFrame = baihatFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case common.constants.HOME_ADD_ALBUM:
			this.albumFrame.setVisible(true);
			break;

		case constants.HOME_ADD_CASI:
			this.casiFrame.setVisible(true);

			break;

		case constants.HOME_ADD_BAIHAT:
			this.baihatFrame.setVisible(true);

			break;

		case constants.HOME_DELETE_ALBUM:
			if (mainFrame.albumTableClicked) {
				String id = mainFrame.albumModel().getId();
				int option = JOptionPane.showConfirmDialog(mainFrame, "Bạn có chắc chắn muốn xóa album này?",
						"Xác nhận xóa", JOptionPane.YES_NO_OPTION);

				if (option == JOptionPane.OK_OPTION) {
					mainFrame.albumModel().Delete(id);
					AlbumModel model = null;
					try {
						model = new AlbumModel();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					mainFrame.RefreshAlbumTable(model.getAll());
				}
			}
			else
				JOptionPane.showMessageDialog(null, "Bạn chưa chọn album!!!");

			break;

		case constants.HOME_DELETE_CASI:
			if (mainFrame.casiTableClicked) {
				String casi_id = mainFrame.casiModel().getId();
				int option = JOptionPane.showConfirmDialog(mainFrame, "Bạn có chắc chắn muốn xóa ca sĩ này?",
						"Xác nhận xóa", JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.OK_OPTION) {
					mainFrame.casiModel().Delete(casi_id);
					CaSiModel model = null;
					try {
						model = new CaSiModel();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					mainFrame.RefreshCasiTable(model.getAll());
				}
			} else {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn ca sĩ để xóa");
			}

			break;

		case constants.HOME_DELETE_BAIHAT:
			
			if (mainFrame.baihatTableClicked) {
				String baihat_id = mainFrame.baihatModel().getMabaihat();
				int option = JOptionPane.showConfirmDialog(mainFrame, "Bạn có chắc chắn muốn xóa bài hát này?",
						"Xác nhận xóa", JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.OK_OPTION) {
					mainFrame.baihatModel().Delete(baihat_id);
					BaiHatModel model = null;
					try {
						model = new BaiHatModel();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					mainFrame.RefreshBaiHatTable(model.getAll());
				}
			} else {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn bài hát để xóa");
			}
			break;

		}
	}
}
