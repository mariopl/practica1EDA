package eda.videoclub.predicates;

import com.google.common.base.Predicate;

import eda.videoclub.pelicula.Pelicula;

//TODO
public class PredicateDirectorIgualA implements Predicate<Pelicula> {
	
	private String director;
	
	public PredicateDirectorIgualA(String director) {
		
		super();
		this.director = director;
	}
	
	public boolean apply(Pelicula p) {
		
		return p.getDirector().equals(director);
	}
}
