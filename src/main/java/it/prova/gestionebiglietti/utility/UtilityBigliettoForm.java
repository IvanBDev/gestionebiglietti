package it.prova.gestionebiglietti.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionebiglietti.model.Biglietto;


public class UtilityBigliettoForm {
	
	public static Biglietto createBigliettoFromParams(String provenienzaInputParam, String destinazioneInputParam,
			String prezzoInputStringParam, String dataStringParam) {

		Biglietto result = new Biglietto(provenienzaInputParam, destinazioneInputParam);

		if (NumberUtils.isCreatable(prezzoInputStringParam)) {
			result.setPrezzo(Integer.parseInt(prezzoInputStringParam));
		}
		result.setData(parseDateArrivoFromString(dataStringParam));

		return result;
	}

	public static boolean validateBigliettoBean(Biglietto bigliettoToBeValidated) {
		// prima controlliamo che non siano vuoti i parametri
		if (StringUtils.isBlank(bigliettoToBeValidated.getPartenza())
				|| StringUtils.isBlank(bigliettoToBeValidated.getDestinazione())
				|| bigliettoToBeValidated.getPrezzo() == null 
				|| bigliettoToBeValidated.getPrezzo() < 1
				|| bigliettoToBeValidated.getData() == null) {
			return false;
		}
		return true;
	}

	public static Date parseDateArrivoFromString(String dataStringParam) {
		if (StringUtils.isBlank(dataStringParam))
			return null;

		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(dataStringParam);
		} catch (ParseException e) {
			return null;
		}
	}
	
}
