package eda.videoclub.test;


import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Sets;


import eda.videoclub.pelicula.Pelicula;
import eda.videoclub.pelicula.PeliculaImpl;
import eda.videoclub.videoteca.Videoteca;
import eda.videoclub.videoteca.VideotecaImpl;

public class TestPredicados {

	Pelicula p1, p2, p3, p4, p5;
	Videoteca videoteca;
	
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
		p5 = new PeliculaImpl("El laberinto del fauno", "Guillermo del Toro", 131, "Tequila Gang", "Espa�a/Mexico", c5, 83.0, "$");
		
		videoteca = new VideotecaImpl();
		videoteca.add(p1);
		videoteca.add(p2);
		videoteca.add(p3);
		videoteca.add(p4);
		videoteca.add(p5);
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
		Set<Pelicula> directorIgual = videoteca.getPeliculasDirectorIgualA("Martin Scorsese");
		System.out.println(directorIgual.size());
		assertTrue("El predicado de director no es correcto", directorIgual.size() == 1);
		assertTrue("El predicado de director no es correcto", videoteca.size() == 5);
		
		directorIgual = videoteca.getPeliculasDirectorIgualA("James Cameron");
		assertTrue("El predicado de director no es correcto", directorIgual.size() == 2);
		assertTrue("El predicado de director no es correcto", videoteca.size() == 5);
	}
	
	@Test
	public void test2(){
		Calendar c = Calendar.getInstance();
		c.set(2005, 12, 12);
		Set<Pelicula> posterioresA = Sets.newHashSet(videoteca.getPeliculasFechaPosteriorA(c));
		System.out.println(posterioresA.size());
		assertTrue("El predicado de fecha no es correcto", posterioresA.size() == 3);
		assertTrue("El predicado de fecha no es correcto", videoteca.size() == 5);
		
		c.set(2007, 12, 12);
		posterioresA = videoteca.getPeliculasFechaPosteriorA(c);
		assertTrue("El predicado de fecha no es correcto", posterioresA.size() == 2);
		assertTrue("El predicado de fecha no es correcto", videoteca.size() == 5);
	}

}
