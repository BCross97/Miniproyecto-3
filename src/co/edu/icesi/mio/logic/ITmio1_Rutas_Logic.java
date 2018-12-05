package co.edu.icesi.mio.logic;

import java.math.BigDecimal;
import java.util.List;

import co.edu.icesi.mio.model.Tmio1Ruta;

public interface ITmio1_Rutas_Logic {

	public List<Tmio1Ruta> searchByDayRange(BigDecimal firstDay, BigDecimal lastDay);

	public boolean create(Tmio1Ruta ruta);

	public boolean update(Tmio1Ruta ruta);

	public boolean delete(Tmio1Ruta ruta);
}
