package centroeducativo2JPA;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the notas database table.
 * 
 */
@Entity
@Table(name="notas")
@NamedQuery(name="Nota.findAll", query="SELECT n FROM Nota n")
public class Nota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private float nota;

	public Nota() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getNota() {
		return this.nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "" + nota;
	}

	
	
	

}