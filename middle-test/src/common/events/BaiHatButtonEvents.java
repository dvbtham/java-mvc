package common.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import common.constants;
import models.BaiHatModel;
import views.baihatFrame;
import views.mainFrame;

public class BaiHatButtonEvents implements ActionListener {
	private BaiHatModel model;
	private baihatFrame frame;
	private mainFrame mainFrame;

	public BaiHatButtonEvents(BaiHatModel model, baihatFrame frame, views.mainFrame mainFrame) {
		this.model = model;
		this.frame = frame;
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case constants.SAVE_BAIHAT:
			if (frame.validForm()) {
				try {
					model = new BaiHatModel(frame.getId(), frame.getTenBaiHat(), frame.getTheLoai(),
							frame.getMaAlbum());
					if (!model.isExists(frame.getId()))
						model.Insert();
					else
						model.Update(frame.getId());

					mainFrame.RefreshBaiHatTable(model.getAll());
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			break;

		case constants.CANCEL_BAIHAT:
			frame.dispose();
			break;
		}
	}

}
