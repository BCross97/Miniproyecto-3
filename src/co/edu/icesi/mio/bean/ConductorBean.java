package co.edu.icesi.mio.bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("conductor")
@SessionScoped
public class ConductorBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8380058001086340360L;
	private String cedula;
	private String apellidos;

}
