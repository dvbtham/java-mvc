package common;

import com.github.lgooddatepicker.components.DatePickerSettings;

public class DatePickerSettingsHelper {
	public DatePickerSettings getDatePickerSettings(){
		DatePickerSettings dateSettings = new DatePickerSettings();
	    dateSettings.setFormatForDatesCommonEra("dd/MM/yyyy");
	    dateSettings.setFormatForDatesBeforeCommonEra("dd/MM/yyyy");
		return dateSettings;
	}
}
