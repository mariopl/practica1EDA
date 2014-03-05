package eda.videoclub.test;


import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eda.videoclub.pelicula.Pelicula;
import eda.videoclub.pelicula.PeliculaImpl;
import eda.videoclub.videoteca.Videoteca2;
import eda.videoclub.videoteca.Videoteca2Impl;

public class TestVideoteca2 {

	Pelicula p1, p2, p3, p4, p5;
	Videoteca2 videoteca;
	
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
		videoteca = new Videoteca2Impl();
		videoteca.devolver(p1);
		assertTrue("El método add no es correcto", videoteca.getExistencias(p1) == 1);
		
		videoteca.devolver(p1);
		assertTrue("El método add no es correcto", videoteca.getExistencias(p1) == 2);
		
		videoteca.devolver(p2);
		assertTrue("El método add no es correcto", videoteca.getExistencias(p1) == 2);
		assertTrue("El método add no es correcto", videoteca.getExistencias(p2) == 1);
	}
	
	@Test
	public void test2(){
		videoteca = new Videoteca2Impl();
		videoteca.devolver(p1);
		videoteca.devolver(p1);
		videoteca.devolver(p2);
		videoteca.devolver(p3);
		videoteca.devolver(p4);
		assertTrue("El método add no es correcto", videoteca.getExistencias(p1) == 2);
		assertTrue("El método add no es correcto", videoteca.getExistencias(p2) == 1);
		assertTrue("El método add no es correcto", videoteca.getExistencias(p3) == 1);
		assertTrue("El método add no es correcto", videoteca.getExistencias(p4) == 1);
		
		videoteca.alquilar(p1);
		assertTrue("El método add no es correcto", videoteca.getExistencias(p1) == 1);
		assertTrue("El método add no es correcto", videoteca.getExistencias(p2) == 1);
		assertTrue("El método add no es correcto", videoteca.getExistencias(p3) == 1);
		assertTrue("El método add no es correcto", videoteca.getExistencias(p4) == 1);
		
	}
	
	@Test
	public void test3(){
		videoteca = new Videoteca2Impl();
		videoteca.devolverSome(p1, 3);
		assertTrue("El método add no es correcto", videoteca.getExistencias(p1) == 3);
		
		videoteca.devolverSome(p1, 2);
		assertTrue("El método add no es correcto", videoteca.getExistencias(p1) == 5);
		
		videoteca.devolverSome(p2, 4);
		assertTrue("El método add no es correcto", videoteca.getExistencias(p1) == 5);
		assertTrue("El método add no es correcto", videoteca.getExistencias(p2) == 4);
	}

}
