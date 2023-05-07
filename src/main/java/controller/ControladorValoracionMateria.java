package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import centroeducativo2JPA.Estudiante;
import centroeducativo2JPA.Materia;
import centroeducativo2JPA.Profesor;
import centroeducativo2JPA.Valoracionmateria;

public class ControladorValoracionMateria {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("centroeducativo2");
	
//	/**
//	 * 
//	 * @param l
//	 */
//	public static void guardar (Valoracionmateria l) {
//		if (l.getId() == 0) {
//			insertar(l);
//		}
//		else {
//			modificar(l);
//		}
//	}
	
	/**
	 * 
	 * @param l
	 */
	public static void guardar (Valoracionmateria l) {
	    Valoracionmateria registroExistente = notaEstudianteMateriaProfesor(l.getEstudiante(), l.getProfesor(), l.getMateria());
	    if (registroExistente == null) {
	        insertar(l);
	    } else {
	        l.setId(registroExistente.getId());
	        modificar(l);
	    }
	}
	
	/**
	 * 
	 * @param l
	 */
	public static void guardar1 (Valoracionmateria l) {
	if (l.getId() == 0) {
		insertar(l);
	}
	else {
		modificar(l);
	}
}

	
	/**
	 * 
	 * @param l
	 */
	public static void insertar (Valoracionmateria v) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(v);
		System.out.println("insertar");
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * 
	 * @param l
	 */
	public static void modificar (Valoracionmateria v) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(v);
		System.out.println("update");
		em.getTransaction().commit();
		em.close();
		
	}
	
//	/**
//	 * 
//	 * @param e
//	 * @param p
//	 * @param m
//	 * @return
//	 */
//	public static Valoracionmateria notaEstudianteMateriaProfesor(Estudiante e, Profesor p, Materia m) {
//	    Valoracionmateria v = null;
//	    EntityManager em = entityManagerFactory.createEntityManager();
//	    try {
//	        Query q = em.createNativeQuery("select * from valoracionmateria where idEstudiante = "+e.getId()+" and idProfesor = "+p.getId()+" and idMateria = "+m.getId()+";", Valoracionmateria.class);
//	        v = (Valoracionmateria) q.getSingleResult();
//	    
//	    } catch (Exception e2) {
//	    }
//	    em.close();
//	    return v;
//	}
	
	/**
	 * 
	 * @param e
	 * @param p
	 * @param m
	 * @return
	 */
	public static Valoracionmateria notaEstudianteMateriaProfesor(Estudiante e, Profesor p, Materia m) {
	    Valoracionmateria v = null;
	    EntityManager em = entityManagerFactory.createEntityManager();
	    try {
	        Query q = em.createNativeQuery("select * from valoracionmateria where idEstudiante = "+e.getId()+" and idProfesor = "+p.getId()+" and idMateria = "+m.getId()+";", Valoracionmateria.class);
	        v = (Valoracionmateria) q.getSingleResult();
	    } catch (Exception e2) {
	    }
	    em.close();
	    return v;
	}

}
