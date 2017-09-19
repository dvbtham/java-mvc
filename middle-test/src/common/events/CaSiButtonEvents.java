package common.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import common.constants;
import models.CaSiModel;
import views.casiFrame;
import views.mainFrame;

public class CaSiButtonEvents implements ActionListener {
	private CaSiModel model;
	private casiFrame frame;

	public CaSiButtonEvents(CaSiModel model, casiFrame frame) {
		this.model = model;
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case constants.SAVE_CASI:
			try {
				if (frame.validForm()) {
					model = new CaSiModel(frame.getId(), frame.getTenCaSi(), Integer.parseInt(frame.getGioiTinh()),
							frame.getDate(), frame.getGioiThieu());
					if (!model.isExists(frame.getId()))
						model.Insert();
					else
						model.Update(model.getId());
					common.closeWindows.closeAll();
					mainFrame.run();
				}

			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;

		case constants.CANCEL_CASI:
			frame.dispose();
			break;
			
		default:
			frame.dispose();
			JOptionPane.showMessageDialog(null, "Có lỗi xảy ra.");
			break;
		}
	}

}
