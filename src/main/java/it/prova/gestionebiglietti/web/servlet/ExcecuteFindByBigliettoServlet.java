package it.prova.gestionebiglietti.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionebiglietti.model.Biglietto;
import it.prova.gestionebiglietti.service.MyServiceFactory;
import it.prova.gestionebiglietti.utility.UtilityBigliettoForm;

@WebServlet("/ExcecuteFindByBigliettoServlet")
public class ExcecuteFindByBigliettoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String partenzaInputParam = request.getParameter("partenza");
		String destinazioneInputParam = request.getParameter("destinazione");
		String prezzoInputParam = request.getParameter("prezzo");
		String dataInputParam = request.getParameter("datao");

		Biglietto bigliettoRicerca = UtilityBigliettoForm.createBigliettoFromParams(partenzaInputParam,
				destinazioneInputParam, prezzoInputParam, dataInputParam);

		try {

			request.setAttribute("listaBigliettiAttribute",
					MyServiceFactory.getBigliettoServiceInstance().findByExample(bigliettoRicerca));
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		// andiamo ai risultati
		request.getRequestDispatcher("/biglietto/results.jsp").forward(request, response);

	}
}
