package eda.videoclub.videoteca;

import eda.videoclub.pelicula.Pelicula;

public interface Videoteca2 {

	public boolean devolver(Pelicula p);

	public int devolverSome(Pelicula p, int n);

	public boolean alquilar(Pelicula p);

	public int getExistencias(Pelicula p);

}