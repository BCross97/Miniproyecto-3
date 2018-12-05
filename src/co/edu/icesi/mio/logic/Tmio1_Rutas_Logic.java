package co.edu.icesi.mio.logic;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.icesi.mio.dao.Tmio1_Rutas_DAO;
import co.edu.icesi.mio.model.Tmio1Ruta;

public class Tmio1_Rutas_Logic implements ITmio1_Rutas_Logic {

	@PersistenceContext
	private EntityManager entityManager;

	private Tmio1_Rutas_DAO rutasDAO;

	@Override
	public List<Tmio1Ruta> searchByDayRange(BigDecimal firstDay, BigDecimal lastDay) {
		// TODO Auto-generated method stub
		try {
			List<Tmio1Ruta> listt = rutasDAO.findByRangeOfDays(entityManager, firstDay, lastDay);
			return listt;
		} catch (Exception e) {
			return null;
			// TODO: handle exception
		}
	}

	@Override
	public boolean create(Tmio1Ruta ruta) {
		// TODO Auto-generated method stub
		if (rutasDAO.findById(entityManager, ruta.getId()) != null)
			return false;
		try {
			rutasDAO.save(entityManager, ruta);
		} catch (Exception e) {
			return false;
		}
		if (rutasDAO.findById(entityManager, ruta.getId()) != null)
			return true;
		return false;
	}

	@Override
	public boolean update(Tmio1Ruta ruta) {
		// TODO Auto-generated method stub
		if (rutasDAO.findById(entityManager, ruta.getId()) == null)
			return false;
		try {
			rutasDAO.update(entityManager, ruta);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(Tmio1Ruta ruta) {
		// TODO Auto-generated method stub
		if (rutasDAO.findById(entityManager, ruta.getId()) == null)
			return false;
		try {
			rutasDAO.delete(entityManager, ruta);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
