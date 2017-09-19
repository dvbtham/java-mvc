package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import common.constants;

public class CaSiController {
	private views.casiFrame casiFrame;

	public CaSiController(views.casiFrame casiFrame) {
		this.casiFrame = casiFrame;
		this.casiFrame.registerButtonEvents(new CaSiButtonEvents());
	}

	class CaSiButtonEvents implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case constants.SAVE_ADD_CASI:
				break;

			case constants.CANCEL_ADD_CASI:
				casiFrame.dispose();
				break;
			}
		}

	}
}
