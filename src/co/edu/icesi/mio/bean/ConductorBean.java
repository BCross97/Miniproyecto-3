package co.edu.icesi.mio.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

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
