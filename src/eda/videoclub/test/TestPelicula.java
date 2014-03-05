package eda.videoclub.test;


import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

import eda.videoclub.pelicula.Pelicula;
import eda.videoclub.pelicula.PeliculaImpl;

public class TestPelicula {

	Pelicula p1, p2, p3, p4, p5;
	List<Pelicula> lista;
	@Before
	public void setUp() throws Exception {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		Calendar c3 = Calendar.getInstance();
		Calendar c4 = Calendar.getInstance();
		Calendar c5 = Calendar.getInstance();
		
		c1.set(2009, 4, 14);
		c2.set(2000, 7, 26);
		c3.set(2010, 3, 8);
		c4.set(1997, 10, 9);
		c5.set(2006, 8, 10);
		
		p1 = new PeliculaImpl("Avatar", "James Cameron", 162, "20th Century Fox", "EE.UU.", c1, 2779.551, "$");
		p2 = new PeliculaImpl("Gladiator", "Ridley Scott", 155, "Independiente", "EE.UU.", c2, 2.071, "$");
		p3 = new PeliculaImpl("Shutter Island", "Martin Scorsese", 138, "Paramount Pictures", "EE.UU.", c3, 40.2, "$");
		p4 = new PeliculaImpl("Titanic", "James Cameron", 193, "20th Century Fox", "EE.UU.", c4, 1842.879, "$");
		p5 = new PeliculaImpl("El laberinto del fauno", "Guillermo del Toro", 131, "Tequila Gang", "España/Mexico", c5, 83.0, "$");
		
		lista = Lists.newArrayList();
		lista.add(p1);
		lista.add(p2);
		lista.add(p3);
		lista.add(p4);
		lista.add(p5);
	}

	@After
	public void tearDown() throws Exception {
		p1 = null;
		p2 = null;
		p3 = null;
		p4 = null;
		p5 = null;
	}
	
	@Test
	public void test1(){
		Collections.sort(lista, PeliculaImpl.getOrdenPeliculaDuracion());
		assertTrue("La ordenación por duración no es correcta", lista.get(0).equals(p5) && lista.get(1).equals(p3) && lista.get(2).equals(p2) && lista.get(3).equals(p1) && lista.get(4).equals(p4));		
	}
	
	@Test
	public void test2(){
		Collections.sort(lista, PeliculaImpl.getOrdenPeliculaFechaEstreno());
		assertTrue("La ordenación por duración no es correcta", lista.get(0).equals(p4) && lista.get(1).equals(p2) && lista.get(2).equals(p5) && lista.get(3).equals(p1) && lista.get(4).equals(p3));
	}

}
