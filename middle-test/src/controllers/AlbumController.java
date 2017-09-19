package controllers;

import java.sql.ResultSet;
import common.events.AlbumButtonEvents;
import models.AlbumModel;

public class AlbumController {

	private AlbumModel albumModel;
	private views.albumFrame albumFrame;

	public AlbumController(views.albumFrame albumFrame) throws ClassNotFoundException {
		albumModel = new AlbumModel();
		this.albumFrame = albumFrame;
		this.albumFrame.registerButtonEvents(new AlbumButtonEvents(this.albumFrame.AlbumModel(), albumFrame));
	}

	public ResultSet getAll() {
		return albumModel.getAll();
	}
}
