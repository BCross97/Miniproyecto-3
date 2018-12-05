package co.edu.icesi.mio.logic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.icesi.mio.dao.ITmio1_Conductores_DAO;
import co.edu.icesi.mio.model.Tmio1Conductore;

public class TMio1_Conductores_Logic implements ITmio1_Conductores_Logic {

	@PersistenceContext
	private EntityManager entityManager;

	private ITmio1_Conductores_DAO conductorDAO;

	@Override
	public List<Tmio1Conductore> searchByName(String name) {
		// TODO Auto-generated method stub
		if (name == null || name.equals(""))
			return null;
		List<Tmio1Conductore> searched = conductorDAO.findByName(entityManager, name);
		return searched;
	}

	@Override
	public List<Tmio1Conductore> searchByLastname(String lastname) {
		// TODO Auto-generated method stub
		if (lastname == null || lastname.equals(""))
			return null;
		List<Tmio1Conductore> searched = conductorDAO.findByLastName(entityManager, lastname);
		return searched;
	}

	@Override
	public Tmio1Conductore searchByID(String id) {
		// TODO Auto-generated method stub
		if (id == null || id.equals(""))
			return null;
		Tmio1Conductore searched = conductorDAO.findByCedula(entityManager, id);
		return searched;
	}

	@Override
	public boolean create(Tmio1Conductore conductor) {
		// TODO Auto-generated method stub

		if (searchByID(conductor.getCedula()) != null) {
			try {
				conductorDAO.save(entityManager, conductor);
				if (searchByID(conductor.getCedula()) != null)
					return true;
				return false;
			} catch (Exception e) {
				// TODO: handle exception
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean update(Tmio1Conductore conductor) {
		// TODO Auto-generated method stub
		try {
			conductorDAO.update(entityManager, conductor);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(Tmio1Conductore conductor) {
		// TODO Auto-generated method stub
		try {
			if (searchByID(conductor.getCedula()) == null)
				return false;
			conductorDAO.delete(entityManager, conductor);
			if (searchByID(conductor.getCedula()) == null)
				return true;

			return false;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

}
