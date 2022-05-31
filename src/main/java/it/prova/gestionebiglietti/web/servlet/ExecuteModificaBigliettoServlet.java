package it.prova.gestionebiglietti.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionebiglietti.model.Biglietto;
import it.prova.gestionebiglietti.service.MyServiceFactory;
import it.prova.gestionebiglietti.utility.UtilityBigliettoForm;

@WebServlet("/ExecuteModificaBigliettoServlet")
public class ExecuteModificaBigliettoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idBigliettoParam = request.getParameter("idBiglietto");

		if (!NumberUtils.isCreatable(idBigliettoParam)) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		String partenzaInputParam = request.getParameter("partenza");
		String destinazioneInputParam = request.getParameter("destinazione");
		String prezzoInputParam = request.getParameter("prezzo");
		String dataInputParam = request.getParameter("data");

		Biglietto bigliettoAggiornato = UtilityBigliettoForm.createBigliettoFromParams(partenzaInputParam,
				destinazioneInputParam, prezzoInputParam, dataInputParam);
		bigliettoAggiornato.setId(Long.parseLong(idBigliettoParam));

		try {
			MyServiceFactory.getBigliettoServiceInstance().aggiorna(bigliettoAggiornato);
			request.setAttribute("listaBigliettiAttribute", MyServiceFactory.getBigliettoServiceInstance().listAll());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/biglietto/results.jsp").forward(request, response);
	}

}
