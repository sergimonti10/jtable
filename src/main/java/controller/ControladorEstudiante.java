package controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import centroeducativo2JPA.Estudiante;
import centroeducativo2JPA.Materia;
import centroeducativo2JPA.Profesor;
import views.JTableEstudiante;
import views.MiTableModel;

public class ControladorEstudiante {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("centroeducativo2");

    /**
     * 
     * @return
     */
    public static List<Estudiante> findAll() {

        EntityManager em = entityManagerFactory.createEntityManager();
        Query q = em.createNativeQuery("SELECT * FROM estudiante;", Estudiante.class);
        List<Estudiante> l = (List<Estudiante>) q.getResultList();

        em.close();
        return l;
    }
    
    /**
     * 
     * @return
     */
    public static Estudiante findFirst() {
        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("SELECT e FROM Estudiante e ORDER BY e.id ASC");
        query.setMaxResults(1);
        Estudiante result = (Estudiante) query.getSingleResult();
        em.close();
        return result;
    }

    /**
     * 
     * @return
     */
    public static Estudiante findPrevious(Estudiante e) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("SELECT e FROM Estudiante e WHERE e.id < :id ORDER BY e.id DESC");
        query.setParameter("id", e.getId());
        query.setMaxResults(1);
        Estudiante result = null;
        try {
            result = (Estudiante) query.getSingleResult();
        } catch (NoResultException ex) {
        	return result;
        }
        em.close();
        return result;
    }

    /**
     * 
     * @return
     */
    public static Estudiante findNext(Estudiante e) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("SELECT e FROM Estudiante e WHERE e.id > :id ORDER BY e.id ASC");
        query.setParameter("id", e.getId());
        query.setMaxResults(1);
        Estudiante result = null;
        try {
            result = (Estudiante) query.getSingleResult();
        } catch (NoResultException ex) {
        	return result;
        }
        em.close();
        return result;
    }

    /**
     * 
     * @return
     */
    public static Estudiante findLast() {
        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("SELECT e FROM Estudiante e ORDER BY e.id DESC");
        query.setMaxResults(1);
        Estudiante result = (Estudiante) query.getSingleResult();
        em.close();
        return result;
    }
    
    /**
	 * 
	 * @param l
	 */
	public static void guardar (Estudiante l) {
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
	public static void insertar (Estudiante l) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(l);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * 
	 * @param l
	 */
	public static void modificar (Estudiante l) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(l);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * 
	 * @param l
	 */
	public static void eliminar (Estudiante l) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		l = em.merge(l);
		em.remove(l);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public static Estudiante getEstudianteById(int id) {
	    EntityManager em = entityManagerFactory.createEntityManager();
	    Estudiante estudiante = em.find(Estudiante.class, id);
	    em.close();
	    return estudiante;
	}
	
	/**
	 * 
	 */
	public static void actualizarTabla(MiTableModel modelo) {
	    List<Estudiante> estudiantes = findAll();
	    List<Object[]> datos = new ArrayList<Object[]>();
	    for (Estudiante e : estudiantes) {
	        Object[] fila = new Object[]{e.getId(), e.getNombre(), e.getApellido1(), e.getApellido2(), e.getTelefono(), e.getDireccion(), e.getDni(), e.getEmail(), e.getTipologiasexo().toString()};
	        datos.add(fila);
	    }
	    modelo.setDatos(datos.toArray(new Object[][] {}));
	}

}

