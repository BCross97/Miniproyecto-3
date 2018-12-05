package co.edu.icesi.mio.logic;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.icesi.mio.dao.Tmio1_Servicios_DAO;
import co.edu.icesi.mio.model.Tmio1Servicio;

public class Tmio1_Servicios_Logic implements ITmio1_Servicios_Logic {

	@PersistenceContext
	private EntityManager entityManager;

	private Tmio1_Servicios_DAO servicioDAO;

	@Override
	public boolean save(Tmio1Servicio servicio) {
		if (servicioDAO.findById(entityManager, servicio.getId()) != null)
			return false;
		try {
			servicioDAO.save(entityManager, servicio);
			if (servicioDAO.findById(entityManager, servicio.getId()) != null)
				return true;
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Tmio1Servicio servicio) {
		if (servicioDAO.findById(entityManager, servicio.getId()) == null)
			return false;
		try {
			servicioDAO.update(entityManager, servicio);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(Tmio1Servicio servicio) {
		if (servicioDAO.findById(entityManager, servicio.getId()) == null)
			return false;
		try {
			servicioDAO.delete(entityManager, servicio);
			if (servicioDAO.findById(entityManager, servicio.getId()) != null)
				return false;
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Tmio1Servicio> findByRangeOfDates(Calendar start, Calendar end) {
		try {
			return servicioDAO.findByRangeOfDates(entityManager, start, end);
		} catch (Exception e) {
			return null;
		}
	}

}
