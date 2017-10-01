package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import common.constants;
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

	@SuppressWarnings("static-access")
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
					common.closeWindows.closeAll();
					mainFrame.startFrame();
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
					common.closeWindows.closeAll();
					mainFrame.startFrame();
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
					common.closeWindows.closeAll();
					mainFrame.startFrame();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn bài hát để xóa");
			}
			break;

		}
	}
}
