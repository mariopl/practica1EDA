package eda.videoclub.videoteca;

import java.util.Calendar;
import java.util.Set;

import eda.videoclub.pelicula.Pelicula;

public interface Videoteca extends Set<Pelicula>{

	public Integer getDisponibilidad(Pelicula p);
	
	public Set<Pelicula> getPeliculasDirectorIgualA(String director);
	
	public Set<Pelicula> getPeliculasFechaPosteriorA(Calendar fecha);

	public Set<Pelicula> getPeliculasCambioDivisa();
	
	public Set<String> getDirectores();
	
	public Pelicula getPeliculaMasLarga();
}