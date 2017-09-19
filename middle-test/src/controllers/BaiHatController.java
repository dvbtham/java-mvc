package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import common.constants;

public class BaiHatController {
	private views.baihatFrame baihatFrame;

	public BaiHatController(views.baihatFrame baihatFrame) {
		this.baihatFrame = baihatFrame;
		this.baihatFrame.registerButtonEvents(new BaiHatButtonEvents());
	}

	class BaiHatButtonEvents implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case constants.SAVE_BAIHAT:
				break;
				
			case constants.CANCEL_BAIHAT:
				baihatFrame.dispose();
				break;
			}
		}

	}
}
