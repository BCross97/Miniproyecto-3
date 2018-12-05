package co.edu.icesi.mio.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;

import co.edu.icesi.mio.model.Tmio1Ruta;

public class Tmio1_Rutas_DAO implements ITmio1_Rutas_DAO {

	// adicionales
	@Override
	public List<Tmio1Ruta> findByRangeOfDays(EntityManager em, BigDecimal diaInicio, BigDecimal diaFin) {
		String jpql = "Select r from Tmio1Ruta r Where r.diaInicio >=" + diaInicio + "and r.diaFin <=" + diaFin;
		return em.createQuery(jpql).getResultList();
	}

	// normales
	@Override
	public void save(EntityManager em, Tmio1Ruta ruta) {
		em.persist(ruta);
	}

	@Override
	public void update(EntityManager em, Tmio1Ruta ruta) {
		em.merge(ruta);
	}

	@Override
	public void delete(EntityManager em, Tmio1Ruta ruta) {
		em.remove(ruta);
	}

	@Override
	public List<Tmio1Ruta> findAll(EntityManager em) {
		String jpql = "Select r from Tmio1Ruta r";
		return em.createQuery(jpql).getResultList();
	}

	@Override
	public Tmio1Ruta findById(EntityManager em, Integer id) {
		return em.find(Tmio1Ruta.class, id);
	}

}
