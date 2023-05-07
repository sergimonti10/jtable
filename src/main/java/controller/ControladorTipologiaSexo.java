package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import centroeducativo2JPA.Profesor;
import centroeducativo2JPA.Tipologiasexo;

public class ControladorTipologiaSexo {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("centroeducativo2");

    public static List<Tipologiasexo> findAll() {

        EntityManager em = entityManagerFactory.createEntityManager();
        Query q = em.createNativeQuery("SELECT * FROM tipologiasexo;", Tipologiasexo.class);
        List<Tipologiasexo> l = (List<Tipologiasexo>) q.getResultList();

        em.close();
        return l;
    }

}
