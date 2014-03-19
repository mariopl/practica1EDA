package eda.videoclub.videoteca;

import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.collect.Sets;

import eda.videoclub.functions.FunctionCambiaDivisaRecaudacion;
import eda.videoclub.functions.FunctionDirectores;
import eda.videoclub.pelicula.Pelicula;
import eda.videoclub.pelicula.PeliculaImpl;
import eda.videoclub.predicates.PredicateDirectorIgualA;
import eda.videoclub.predicates.PredicateFechaPosteriorA;

public class VideotecaImpl implements Set<Pelicula>, Videoteca {
	
	private Map<Pelicula, Integer> disponibilidad;
	
	public VideotecaImpl() {
		
		disponibilidad = Maps.newHashMap();
	}
	
	public Integer getDisponibilidad(Pelicula p) {
		
		return disponibilidad.get(p);
	}
	
	public Set<Pelicula> getPeliculasDirectorIgualA(String director) {
		
		return Sets.newHashSet(Iterables.filter(disponibilidad.keySet(), 
				new PredicateDirectorIgualA(director)));
	}
	
	public Set<Pelicula> getPeliculasFechaPosteriorA(Calendar fecha) {
		
		return Sets.newHashSet(Iterables.filter(disponibilidad.keySet(), 
				new PredicateFechaPosteriorA(fecha)));
	}

	@Override
	public Set<Pelicula> getPeliculasCambioDivisa() {

		return Sets.newHashSet(Iterables.transform(disponibilidad.keySet(),
				new FunctionCambiaDivisaRecaudacion()));
	}

	@Override
	public Set<String> getDirectores() {

		return Sets.newHashSet(Iterables.transform(disponibilidad.keySet(),
				new FunctionDirectores()));
	}

	@Override
	public Pelicula getPeliculaMasLarga() {
		
		Ordering<Pelicula> ord = Ordering.from(PeliculaImpl.getOrdenPeliculaDuracion());
		return ord.max(disponibilidad.keySet());
	}

	@Override
	public int size() {

		return disponibilidad.size();
	}

	@Override
	public boolean isEmpty() {

		return disponibilidad.isEmpty();
	}

	@Override
	public boolean contains(Object o) {

		return disponibilidad.keySet().contains(o);
	}

	@Override
	public Iterator<Pelicula> iterator() {

		return disponibilidad.keySet().iterator();
	}

	@Override
	public Object[] toArray() {

		return disponibilidad.keySet().toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {

		return disponibilidad.keySet().toArray(a);
	}

	@Override
	public boolean add(Pelicula p) {
		
		boolean ret;
		
		Integer numPeliculas = disponibilidad.get(p);
		if(numPeliculas == null) {
			ret = true;
			disponibilidad.put(p,1);
		} else {
			disponibilidad.put(p, numPeliculas + 1);
			ret = false;
		}
		return ret;
	}

	@Override
	public boolean remove(Object o) {

		boolean modificado = false;
		
		Integer numPeliculas = disponibilidad.get(o);
		if(numPeliculas != null) {
			if(numPeliculas == 1) {
				modificado = true;
				disponibilidad.remove(o); 
			} else {
				disponibilidad.put((Pelicula) o,numPeliculas - 1);
			}
		}
		return modificado;
	}

	@Override
	public boolean containsAll(Collection<?> c) {

		return disponibilidad.keySet().containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends Pelicula> c) {
		
		boolean modificado = false;
		
		for(Pelicula p:c) {
			
			modificado = this.add(p) || modificado;
		}
		
		return modificado;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		
		return disponibilidad.keySet().retainAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {

		return disponibilidad.keySet().removeAll(c);
	}

	@Override
	public void clear() {
		
		disponibilidad.clear();
		
	}

}
