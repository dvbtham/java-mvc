package common.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import common.constants;
import models.AlbumModel;
import views.albumFrame;
import views.mainFrame;

public class AlbumButtonEvents implements ActionListener {
	private AlbumModel albumModel;
	private albumFrame frame;
	private mainFrame mainFrame;
	public AlbumButtonEvents(AlbumModel albumModel, albumFrame frame,  mainFrame mainFrame) {
		this.albumModel = albumModel;
		this.frame = frame;
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {

		case constants.SAVE_ALBUM:
			try {
				if (this.frame.validForm()) {
					albumModel = new AlbumModel(frame.Id(), frame.TenAlbum(), frame.SoBaiHat(), frame.NgayTao(),
							frame.MaCaSi());
					if (!albumModel.isExists(frame.Id()))
						albumModel.Insert();
					else
						albumModel.Update(frame.Id());				
					
					mainFrame.RefreshAlbumTable(albumModel.getAll());
				}

			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;

		case constants.CANCEL_ALBUM:
			frame.dispose();
			break;
		}
	}

}
