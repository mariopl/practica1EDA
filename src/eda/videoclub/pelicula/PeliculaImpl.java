package eda.videoclub.pelicula;

import java.util.Calendar;

//TODO
public class PeliculaImpl implements Pelicula, Comparable<Pelicula> {
	
	private String titulo;
	private String director;
	private Integer duracion;
	private String distribuidora;
	private String nacionalidad;
	private Calendar fechaEstreno;
	private Double recaudacion;
	private String divisa;
	private static Comparator<Pelicula> ordenPeliculaFechaEstreno = 
			new OrdenPeliculaFechaEstreno();
	private static Comparator<Pelicula> ordenPeliculaDuracion =
			new OrdenPeliculaDuracion();
	
	public PeliculaImpl(String titulo, String director, Integer duracion,
			String distribuidora, String nacionalidad, Calendar fechaEstreno,
			Double recaudacion, String divisa) {
		super();
		this.titulo = titulo;
		this.director = director;
		this.duracion = duracion;
		this.distribuidora = distribuidora;
		this.nacionalidad = nacionalidad;
		this.fechaEstreno = fechaEstreno;
		this.recaudacion = recaudacion;
		this.divisa = divisa;
	}
	
	public static Comparator<Pelicula> getOrdenPeliculaFechaEstreno() {
		
		return ordenPeliculaFechaEstreno;
	}
	
	public static Comparator<Pelicula> getOrdenPeliculaDuracion() {
		
		return ordenPeliculaDuracion;
	}
	
	@Override
	public String getTitulo() {
		// TODO Auto-generated method stub
		return titulo;
	}

	@Override
	public String getDirector() {
		// TODO Auto-generated method stub
		return director;
	}

	@Override
	public Integer getDuracion() {
		// TODO Auto-generated method stub
		return duracion;
	}

	@Override
	public String getDistribuidora() {
		// TODO Auto-generated method stub
		return distribuidora;
	}

	@Override
	public String getNacionalidad() {
		// TODO Auto-generated method stub
		return nacionalidad;
	}

	@Override
	public Calendar getFechaEstreno() {
		// TODO Auto-generated method stub
		return fechaEstreno;
	}

	@Override
	public Double getRecaudacion() {
		// TODO Auto-generated method stub
		return recaudacion;
	}

	@Override
	public String getDivisa() {
		// TODO Auto-generated method stub
		return divisa;
	}
	
	@Override
	public int compareTo(Pelicula other) {
	
		int result;
		if (this == null || other == null) {
			if (this == null && other == null)
				result = 0;
			else if (this == null)
				result = +1;
			else
				result = -1;
		} else {
			result = getTitulo().compareTo(other.getTitulo());
		}
		return result;
	}
}
