package eda.videoclub.constraints;

import com.google.common.collect.Constraint;

import eda.videoclub.pelicula.Pelicula;

//TODO
public class ConstraintDuracionMayor140 implements Constraint<Pelicula> {
	
	public Pelicula checkElement(Pelicula p) {
		
		if(p.getDuracion() <= 140)
			throw new RuntimeException();
			return p;
	}

}
