package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import centroeducativo2JPA.Estudiante;

public class ControladorEstudiante {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("centroeducativo2");

    
    public static List<Estudiante> findAll() {

        EntityManager em = entityManagerFactory.createEntityManager();
        Query q = em.createNativeQuery("SELECT * FROM estudiante;", Estudiante.class);
        List<Estudiante> l = (List<Estudiante>) q.getResultList();

        em.close();
        return l;
    }

}







//public class ControladorLocalidad {
//
//	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("alquileres");
//
//	/**
//	 * 
//	 * @param id
//	 * @return
//	 */
//	public static Localidad findById (int id) {
//		EntityManager em = entityManagerFactory.createEntityManager();
//		Localidad l = (Localidad) em.find(Localidad.class, id);	
//		em.close();
//		return l;
//	}
//	
//	/**
//	 * 
//	 * @return
//	 */
//	public static List<Localidad> findAll() {
//		
//		EntityManager em = entityManagerFactory.createEntityManager();
//		Query q = em.createNativeQuery("SELECT * FROM localidad;", Localidad.class);
//		List<Localidad> l = (List<Localidad>) q.getResultList();
//		
//		em.close();
//		return l;
//	}
//	
//	/**
//	 * 
//	 * @param descripcion
//	 * @return
//	 */
//	public static List<Localidad> findByLikeDescripcion (String descripcion) {
//		EntityManager em = entityManagerFactory.createEntityManager();
//		Query q = em.createNativeQuery("SELECT * FROM localidad where descripcion like ?;", Localidad.class);
//		q.setParameter(1, "%" + descripcion + "%");
//		List<Localidad> l = (List<Localidad>) q.getResultList();
//		
//		em.close();
//		return l;
//	}
//	
//	/**
//	 * 
//	 * @param l
//	 */
//	public static void guardar (Localidad l) {
//		if (l.getId() == 0) {
//			insertar(l);
//		}
//		else {
//			modificar(l);
//		}
//	}
//	
//	/**
//	 * 
//	 * @param l
//	 */
//	public static void insertar (Localidad l) {
//		EntityManager em = entityManagerFactory.createEntityManager();
//		em.getTransaction().begin();
//		em.persist(l);
//		em.getTransaction().commit();
//		em.close();
//	}
//	
//	/**
//	 * 
//	 * @param l
//	 */
//	public static void modificar (Localidad l) {
//		EntityManager em = entityManagerFactory.createEntityManager();
//		em.getTransaction().begin();
//		em.merge(l);
//		em.getTransaction().commit();
//		em.close();
//	}
//	
//	
//	/**
//	 * 
//	 * @param l
//	 */
//	public static void eliminar (Localidad l) {
//		EntityManager em = entityManagerFactory.createEntityManager();
//		em.getTransaction().begin();
//		l = em.merge(l);
//		em.remove(l);
//		em.getTransaction().commit();
//		em.close();
//	}
//	
//}





//private void guardar() {
//    estudiantesParaGuardar.removeAll(estudiantesParaGuardar);
//    for (int i = 0; i < listModelEstudiantes2.size(); i++) {
//        estudiantesParaGuardar.add(listModelEstudiantes2.getElementAt(i));
//    }
//    for (Estudiante estudiante : estudiantesParaGuardar) {
//        Valoracionmateria v = ValoracionMateriaController.notaEstudianteMateriaProfesor(estudiante,
//                (Profesor) jcbProfesor.getSelectedItem(), (Materia) jcbMateria.getSelectedItem());
//        if (v != null) {
//            v.setValoracion((float) jcbNota.getSelectedItem());
//            ValoracionMateriaController.update(v);
//        } else {
//            v = new Valoracionmateria();
//            v.setEstudiante(estudiante);
//            v.setMateria((Materia) jcbMateria.getSelectedItem());
//            v.setProfesor((Profesor) jcbProfesor.getSelectedItem());
//            v.setValoracion((float) jcbNota.getSelectedItem());
//            ValoracionMateriaController.insert(v);
//        }
//    }
//}





//public static Valoracionmateria notaEstudianteMateriaProfesor(Estudiante e, Profesor p, Materia m) {
//    Valoracionmateria v = null;
//    EntityManager em = entityManagerFactory.createEntityManager();
//    try {
//        Query q = em.createNativeQuery("select * from valoracionmateria where idEstudiante = "+e.getId()+" and idProfesor = "+p.getId()+" and idMateria = "+m.getId()+";", Valoracionmateria.class);
//        v = (Valoracionmateria) q.getSingleResult();
//    
//    } catch (Exception e2) {
//    }
//    em.close();
//    return v;
//}
