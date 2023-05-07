package centroeducativo2JPA;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the nivel database table.
 * 
 */
@Entity
@NamedQuery(name="Nivel.findAll", query="SELECT n FROM Nivel n")
public class Nivel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String descripcion;

	//bi-directional many-to-one association to Materia
	@OneToMany(mappedBy="nivel")
	private List<Materia> materias;

	//bi-directional many-to-one association to Centroeducativo
	@ManyToOne
	@JoinColumn(name="idCentro")
	private Centroeducativo centroeducativo;

	public Nivel() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Materia> getMaterias() {
		return this.materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	public Materia addMateria(Materia materia) {
		getMaterias().add(materia);
		materia.setNivel(this);

		return materia;
	}

	public Materia removeMateria(Materia materia) {
		getMaterias().remove(materia);
		materia.setNivel(null);

		return materia;
	}

	public Centroeducativo getCentroeducativo() {
		return this.centroeducativo;
	}

	public void setCentroeducativo(Centroeducativo centroeducativo) {
		this.centroeducativo = centroeducativo;
	}

}