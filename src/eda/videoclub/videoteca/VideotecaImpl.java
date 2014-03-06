package eda.videoclub.videoteca;

import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import eda.videoclub.pelicula.Pelicula;

public class VideotecaImpl implements Set<Pelicula>, Videoteca {
	
	private Map<Pelicula, Integer> disponibilidad;
	
	public VideotecaImpl() {
		
		disponibilidad = Maps.newHashMap();
	}
	
	public Integer getDisponibilidad(Pelicula p) {
		
		return disponibilidad.get(p);
	}
	
	public Set<Pelicula> getPeliculasDirectorIgualA(String director) {
		
		return Sets.newHasSet(Iterables.filter(disponibilidad.keySet(), 
				new PredicateDirectorIgualA(director)));
	}
	
	public Set<Pelicula> getPeliculasFechaPosteriorA(Calendar fecha) {
		
		Sets.newHashSet(Iterables.filter(disponibilidad.keySet(), 
				PredicateFechaPosteriorA(fecha)));
	}

	@Override
	public Set<Pelicula> getPeliculasCambioDivisa() {

		return Sets.newHashSet(Iterables.transform(disponibilidad.keySet(),
				new FunctionCambiaDivisaRecaudacion()));
	}

	@Override
	public Set<String> getDirectores() {

		return Sets.newHashSet(Iterables.transform(disponibilidad.keySet,
				new FunctionDirectores()));
	}

	@Override
	public Pelicula getPeliculaMasLarga() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<Pelicula> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Pelicula e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends Pelicula> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
