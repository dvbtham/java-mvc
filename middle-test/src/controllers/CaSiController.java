package controllers;
import java.sql.ResultSet;
import common.events.CaSiButtonEvents;
import models.CaSiModel;

public class CaSiController {
	private views.casiFrame casiFrame;
	private CaSiModel model;

	public CaSiController(views.casiFrame casiFrame) throws ClassNotFoundException {
		this.casiFrame = casiFrame;
		model = new CaSiModel();
		this.casiFrame.registerButtonEvents(new CaSiButtonEvents(this.casiFrame.getModel(), casiFrame));
	}

	public ResultSet getAll() {
		return model.getAll();
	}
}
