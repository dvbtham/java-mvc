package controllers;

import java.sql.ResultSet;
import common.events.AlbumButtonEvents;
import models.AlbumModel;

public class AlbumController {

	private AlbumModel albumModel;
	private views.albumFrame albumFrame;

	public AlbumController(views.albumFrame albumFrame, views.mainFrame mainFrame) throws ClassNotFoundException {
		albumModel = new AlbumModel();
		this.albumFrame = albumFrame;
		this.albumFrame.registerButtonEvents(new AlbumButtonEvents(this.albumFrame.AlbumModel(), albumFrame, mainFrame));
	}

	public ResultSet getAll() {
		return albumModel.getAll();
	}
}
