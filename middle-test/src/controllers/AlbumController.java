package controllers;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import common.events.AlbumButtonEvents;
import models.AlbumModel;
public class AlbumController {

	private AlbumModel albumModel;
	private views.albumFrame albumFrame;

	public AlbumController(views.albumFrame albumFrame) {
		try {
			albumModel = new AlbumModel();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.albumFrame = albumFrame;
	}
	public ResultSet getAll(){
		return albumModel.getAll();
	}
	
	public AlbumController() {
		try {
			albumModel = new AlbumModel();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
