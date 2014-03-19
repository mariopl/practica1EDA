package eda.videoclub.predicates;

import java.util.Calendar;

import com.google.common.base.Predicate;

import eda.videoclub.pelicula.Pelicula;

//TODO
public class PredicateFechaPosteriorA implements Predicate<Pelicula> {
	
	private Calendar fechaEstreno;
	
	public PredicateFechaPosteriorA(Calendar fechaEstreno) {
		
		super();
		this.fechaEstreno = fechaEstreno;
	}
	
	public boolean apply(Pelicula p) {
		
		return p.getFechaEstreno().compareTo(fechaEstreno) > 0;
	}

}
