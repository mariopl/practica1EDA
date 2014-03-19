package eda.videoclub.functions;

import com.google.common.base.Function;

import eda.videoclub.pelicula.Pelicula;

//TODO
public class FunctionDirectores implements Function<Pelicula,String> {
	
	public String apply(Pelicula p) {
		
		return p.getDirector();
	}
}
