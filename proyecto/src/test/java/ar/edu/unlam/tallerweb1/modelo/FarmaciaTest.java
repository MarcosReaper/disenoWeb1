package ar.edu.unlam.tallerweb1.modelo;

import java.util.List;

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
	
	@Test
	@Transactional
	public void todasLasFarmaciasDeUnBarrio() {
//		Session session = getSession();
//		session.createCriteria(Farmacia.class).add(Restrictions.)
		//FIXME Hacer con junit un test que busque todas las farmacias de un barrio
	}
}
