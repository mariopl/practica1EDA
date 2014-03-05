package eda.videoclub.pelicula;

import java.util.Calendar;

public interface Pelicula {
	
	String getTitulo();
	String getDirector();
	Integer getDuracion();
	String getDistribuidora();
	String getNacionalidad();
	Calendar getFechaEstreno();
	Double getRecaudacion();
	String getDivisa();

}
