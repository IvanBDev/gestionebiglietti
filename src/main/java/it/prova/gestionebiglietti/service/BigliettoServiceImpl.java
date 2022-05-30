package it.prova.gestionebiglietti.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestionebiglietti.dao.BigliettoDAO;
import it.prova.gestionebiglietti.model.Biglietto;
import it.prova.gestionebiglietti.web.listener.LocalEntityMAnagerFactoryListener;

public class BigliettoServiceImpl implements BigliettoService {

	private BigliettoDAO bigliettoDAO;

	@Override
	public void setBigliettoDao(BigliettoDAO bigliettoDAO) {
		// TODO Auto-generated method stub
		this.bigliettoDAO = bigliettoDAO;
	}

	@Override
	public List<Biglietto> listAll() throws Exception {
		// TODO Auto-generated method stub
		// questo è come una connection
		EntityManager entityManager = LocalEntityMAnagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			bigliettoDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return bigliettoDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityMAnagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public Biglietto caricaSingoloElemento(Long idInput) throws Exception {
		// TODO Auto-generated method stub
		// questo è come una connection
		EntityManager entityManager = LocalEntityMAnagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			bigliettoDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return bigliettoDAO.findOne(idInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityMAnagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public void aggiorna(Biglietto input) throws Exception {
		// TODO Auto-generated method stub
		// questo è come una connection
		EntityManager entityManager = LocalEntityMAnagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			bigliettoDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			bigliettoDAO.update(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityMAnagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public void inserisciNuovo(Biglietto input) throws Exception {
		// TODO Auto-generated method stub
		// questo è come una connection
		EntityManager entityManager = LocalEntityMAnagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			bigliettoDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			bigliettoDAO.insert(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityMAnagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public void rimuovi(Biglietto input) throws Exception {
		// TODO Auto-generated method stub
		// questo è come una connection
		EntityManager entityManager = LocalEntityMAnagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			bigliettoDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			bigliettoDAO.delete(input);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityMAnagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public List<Biglietto> findByExample(Biglietto input) throws Exception {
		// TODO Auto-generated method stub
		// questo è come una connection
		EntityManager entityManager = LocalEntityMAnagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			bigliettoDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return bigliettoDAO.findByExample(input);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityMAnagerFactoryListener.closeEntityManager(entityManager);
		}
	}

}
