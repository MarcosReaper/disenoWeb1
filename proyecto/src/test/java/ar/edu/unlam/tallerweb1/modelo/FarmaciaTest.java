package ar.edu.unlam.tallerweb1.modelo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;

public class FarmaciaTest extends SpringTest{

	@SuppressWarnings("unchecked")
	@Test
	@Transactional
	public void farmaciaDeTurnoLosMartes() {
		Farmacia farmaciaA = new  Farmacia("Belen", "4512-1234", "Martes");
		Farmacia farmaciaB = new  Farmacia("Junin", "4512-1232", "martes");
		Session session = getSession();
		session.saveOrUpdate(farmaciaA);
		session.saveOrUpdate(farmaciaB);
		List<Farmacia> farmacia = session.createCriteria(Farmacia.class).add(Restrictions.eq("diaDeTurno", "martes").ignoreCase()).list();
		Assert.assertTrue(!farmacia.isEmpty());
	}
	
	@SuppressWarnings("unchecked")
	public void todasLasFarmaciasDeUnaCalle() {
		Farmacia farmaciaA = new  Farmacia("Belen", "4512-1234", "Martes");
		farmaciaA.setDireccion(new Direccion("viamonte", "1484",new Barrio("Tribunales")));
		Farmacia farmaciaB = new  Farmacia("Junin", "4512-1232", "martes");
		farmaciaB.setDireccion(new Direccion("viamonte", "666", new Barrio("Tribunales")));
		Farmacia farmaciaC = new  Farmacia("Flores", "4512-1231", "jueves");
		farmaciaC.setDireccion(new Direccion("parana", "3221", new Barrio("Tribunales")));
		Session session = getSession();
		session.saveOrUpdate(farmaciaA);
		session.saveOrUpdate(farmaciaB);
		session.saveOrUpdate(farmaciaC);
		Criteria c = session.createCriteria(Farmacia.class, "a");
		c.createAlias("a.direccion", "u");
		c.add(Restrictions.eq("u.calle", "viamonte"));
		List<Farmacia> farmacia = c.list();
		Assert.assertTrue(farmacia.size() == 2);
		
	}
	
	@Test
	@Transactional
	@SuppressWarnings("unchecked")
	public void todasLasFarmaciasDeUnBarrio() {
		Barrio barrio = new Barrio("villa luro");
		Direccion direccionA = new Direccion("Falsa", "123", barrio);
		Direccion direccionB = new Direccion("Verdadera", "312", barrio);
		Farmacia farmaciaA = new  Farmacia("Belen", "4512-1234", "Martes");
		farmaciaA.setDireccion(direccionA);
		Farmacia farmaciaB = new  Farmacia("Junin", "4512-1232", "martes");
		farmaciaB.setDireccion(direccionB);
		Session session = getSession();
		session.saveOrUpdate(farmaciaA);
		session.saveOrUpdate(farmaciaB);
		List<Farmacia> farmaciaList = session.createCriteria(Farmacia.class, "farmacia")
				.createAlias("farmacia.direccion", "direccion")
				.createAlias("direccion.barrio", "barrio")
		.add(Restrictions.eq("barrio.nombre", "Villa Luro").ignoreCase()).list();
		Assert.assertTrue(!farmaciaList.isEmpty());
	}
}
