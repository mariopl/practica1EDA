package eda.videoclub.videoteca;

import com.google.common.collect.Constraints;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import eda.videoclub.constraints.ConstraintDuracionMayor140;
import eda.videoclub.pelicula.Pelicula;

//TODO
public class Videoteca2Impl implements Videoteca2 {
	
	private Multiset<Pelicula> disponibilidad;
	
	public Videoteca2Impl() {
		
		disponibilidad = HashMultiset.create();
    	disponibilidad = Constraints.constrainedMultiset(disponibilidad,new ConstraintDuracionMayor140());
		
	}

	@Override
	public boolean devolver(Pelicula p) {
		
		return disponibilidad.add(p);
	}

	@Override
	public int devolverSome(Pelicula p, int n) {

		return disponibilidad.add(p,n);
	}

	@Override
	public boolean alquilar(Pelicula p) {

		return disponibilidad.remove(p);
	}

	@Override
	public int getExistencias(Pelicula p) {

		return disponibilidad.count(p);
	}

}
