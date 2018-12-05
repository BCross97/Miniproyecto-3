package co.edu.icesi.mio.logic;

import java.math.BigDecimal;
import java.util.List;

import co.edu.icesi.mio.model.Tmio1Bus;

public interface ITmio1_Buses_Logic {

	public List<Tmio1Bus> searchByModel(BigDecimal model);

	public List<Tmio1Bus> searchByType(String type);

	public List<Tmio1Bus> searchByCapacity(BigDecimal capacity);

	public boolean create(Tmio1Bus bus);

	public boolean update(Tmio1Bus bus);

	public boolean delete(Tmio1Bus bus);
}
