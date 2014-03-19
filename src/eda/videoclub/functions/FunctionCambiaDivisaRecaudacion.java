package eda.videoclub.functions;

import java.util.Calendar;

import com.google.common.base.Function;

import eda.videoclub.pelicula.Pelicula;
import eda.videoclub.pelicula.PeliculaImpl;

//TODO
public class FunctionCambiaDivisaRecaudacion implements Function<Pelicula,Pelicula> {
	
	public Pelicula apply(Pelicula p) {
		String titulo = p.getTitulo();
		String director = p.getDirector();
		Integer duracion = p.getDuracion();
		String distribuidora = p.getDistribuidora(); 
		String nacionalidad = p.getNacionalidad(); 
		Calendar fechaEstreno = p.getFechaEstreno(); 
		Double recaudacion = p.getRecaudacion(); 
		String divisa = p.getDivisa();
		
		Pelicula ret; 
		if(divisa.equals("$")) {
			Double nuevaRecaudacion = recaudacion * 0.741;
			ret = new PeliculaImpl(titulo,director,duracion,distribuidora,nacionalidad,fechaEstreno,nuevaRecaudacion,"Ä");
		} else {
			Double nuevaRecaudacion = recaudacion / 0.741; 
			ret = new PeliculaImpl(titulo,director,duracion,distribuidora,nacionalidad,fechaEstreno,nuevaRecaudacion,"$");
		}
		
		return ret; 
		}
}