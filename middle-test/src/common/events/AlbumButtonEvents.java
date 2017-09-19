package common.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import common.constants;
import models.AlbumModel;
import views.albumFrame;

public class AlbumButtonEvents implements ActionListener {
	private AlbumModel albumModel;
	private albumFrame frame;

	public AlbumButtonEvents(AlbumModel albumModel, albumFrame frame) {
		this.albumModel = albumModel;
		this.albumModel = albumModel;
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {

		case constants.SAVE_ADD_ALBUM:
			try {
				if (this.frame.ValidForm()) {
					albumModel = new AlbumModel(frame.Id(), frame.TenAlbum(), frame.SoBaiHat(), frame.NgayTao(), frame.MaCaSi());
					if(!albumModel.isExists(frame.Id()))
						albumModel.Insert();
					else
						albumModel.Update(frame.Id());
					frame.dispose();
				}

			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;

		case constants.CANCEL_ADD_ALBUM:
			frame.dispose();
			break;
		}
	}

}
