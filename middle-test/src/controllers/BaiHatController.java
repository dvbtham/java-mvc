package controllers;

import java.sql.ResultSet;

import common.events.BaiHatButtonEvents;
import models.BaiHatModel;

public class BaiHatController {
	private views.baihatFrame baihatFrame;
	private BaiHatModel model;

	public BaiHatController(views.baihatFrame baihatFrame, views.mainFrame mainFrame) {
		try {
			model = new BaiHatModel();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.baihatFrame = baihatFrame;
		this.baihatFrame.registerButtonEvents(new BaiHatButtonEvents(baihatFrame.getModel(), this.baihatFrame, mainFrame));
	}
	
	public ResultSet getAll(){
		return model.getAll();
	}
		
}
