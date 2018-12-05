package co.edu.icesi.mio.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;

import co.edu.icesi.mio.model.Tmio1Bus;
import co.edu.icesi.mio.model.Tmio1Conductore;

public class Tmio1_Buses_DAO implements ITmio1_Buses_DAO {

	// adicionales
	@Override
	public List<Tmio1Bus> findByModel(EntityManager em, BigDecimal model) {
		String jpql = "Select b from Tmio1Bus b where b.modelo=" + model;
		return em.createQuery(jpql).getResultList();
	}

	@Override
	public List<Tmio1Bus> findByType(EntityManager em, String type) {
		String jpql = "Select b from Tmio1Bus b where b.tipo= '" + type + "'";
		return em.createQuery(jpql).getResultList();
	}

	@Override
	public List<Tmio1Bus> findByCapacity(EntityManager em, BigDecimal capacity) {
		String jpql = "Select b from Tmio1Bus b where b.capacidad=" + capacity;
		return em.createQuery(jpql).getResultList();
	}

	// normales
	@Override
	public void save(EntityManager em, Tmio1Bus bus) {
		em.persist(bus);
	}

	@Override
	public void update(EntityManager em, Tmio1Bus bus) {
		em.merge(bus);
	}

	@Override
	public void delete(EntityManager em, Tmio1Bus bus) {
		em.remove(bus);
	}

	@Override
	public List<Tmio1Bus> findAll(EntityManager em) {
		String jpql = "Select b from Tmio1Bus b";
		return em.createQuery(jpql).getResultList();
	}

	@Override
	public Tmio1Bus findById(EntityManager em, Integer id) {
		return em.find(Tmio1Bus.class, id);
	}

}
