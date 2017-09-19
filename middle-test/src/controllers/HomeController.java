package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import common.closeWindows;
import common.constants;
import common.events.AlbumButtonEvents;
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
		this.albumFrame.registerButtonEvents(new AlbumButtonEvents(this.albumFrame.AlbumModel(), albumFrame));

		this.casiFrame = casiFrame;
		this.casiFrame.registerButtonEvents(this);

		this.baihatFrame = baihatFrame;
		this.baihatFrame.registerButtonEvents(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case common.constants.HOME_ADD_ALBUM:
			this.albumFrame.setVisible(true);
			break;

		case constants.HOME_ADD_CASI:
			this.casiFrame.setVisible(true);
			CaSiController cs_control = new CaSiController(this.casiFrame);
			break;

		case constants.HOME_ADD_BAIHAT:
			this.baihatFrame.setVisible(true);
			BaiHatController bh_control = new BaiHatController(this.baihatFrame);
			break;

		case constants.HOME_DELETE_ALBUM:
			String id = mainFrame.albumModel().getId();
			System.out.println(id);
			if (!id.equals("0")) {
				mainFrame.albumModel().Delete(id);
			} else {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn album để xóa");
			}

			break;

		case constants.HOME_DELETE_CASI:
			break;

		case constants.HOME_DELETE_BAIHAT:
			break;

		}
	}
}
