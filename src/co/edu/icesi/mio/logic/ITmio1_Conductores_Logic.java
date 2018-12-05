package co.edu.icesi.mio.logic;

import java.util.List;

import co.edu.icesi.mio.model.Tmio1Conductore;

public interface ITmio1_Conductores_Logic {

	public List<Tmio1Conductore> searchByName(String name);

	public List<Tmio1Conductore> searchByLastname(String lastname);

	public Tmio1Conductore searchByID(String id);

	public boolean create(Tmio1Conductore conductor);

	public boolean update(Tmio1Conductore conductor);

	public boolean delete(Tmio1Conductore conductor);

}
