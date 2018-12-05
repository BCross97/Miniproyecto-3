package co.edu.icesi.mio.logic;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import co.edu.icesi.mio.model.Tmio1Servicio;

public interface ITmio1_Servicios_Logic {
	public boolean save(Tmio1Servicio servicio);

	public boolean update(Tmio1Servicio servicio);

	public boolean delete(Tmio1Servicio servicio);

	public List<Tmio1Servicio> findByRangeOfDates(Calendar start, Calendar end);

}
