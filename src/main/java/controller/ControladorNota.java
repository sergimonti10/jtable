package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import centroeducativo2JPA.Nota;


public class ControladorNota {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("centroeducativo2");

    public static List<Nota> findAll() {

        EntityManager em = entityManagerFactory.createEntityManager();
        Query q = em.createNativeQuery("SELECT * FROM notas", Nota.class);
        List<Nota> l = (List<Nota>) q.getResultList();

        em.close();
        return l;
    }

}
