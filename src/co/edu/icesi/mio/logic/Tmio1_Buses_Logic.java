package co.edu.icesi.mio.logic;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.icesi.mio.dao.Tmio1_Buses_DAO;
import co.edu.icesi.mio.model.Tmio1Bus;

public class Tmio1_Buses_Logic implements ITmio1_Buses_Logic {

	@PersistenceContext
	private EntityManager entityManager;

	private Tmio1_Buses_DAO busDAO;

	@Override
	public List<Tmio1Bus> searchByModel(BigDecimal model) {
		// TODO Auto-generated method stub
		try {
			return busDAO.findByModel(entityManager, model);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Tmio1Bus> searchByType(String type) {
		// TODO Auto-generated method stub
		try {
			return busDAO.findByType(entityManager, type);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Tmio1Bus> searchByCapacity(BigDecimal capacity) {
		try {
			return busDAO.findByCapacity(entityManager, capacity);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean create(Tmio1Bus bus) {
		if (busDAO.findById(entityManager, bus.getId()) != null)
			return false;
		try {
			busDAO.save(entityManager, bus);
			if (busDAO.findById(entityManager, bus.getId()) != null)
				return true;
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Tmio1Bus bus) {
		if (busDAO.findById(entityManager, bus.getId()) == null)
			return false;
		try {
			busDAO.update(entityManager, bus);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(Tmio1Bus bus) {
		if (busDAO.findById(entityManager, bus.getId()) == null)
			return false;
		try {
			busDAO.delete(entityManager, bus);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
