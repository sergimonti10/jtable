package centroeducativo2JPA;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the centroeducativo database table.
 * 
 */
@Entity
@NamedQuery(name="Centroeducativo.findAll", query="SELECT c FROM Centroeducativo c")
public class Centroeducativo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String descripcion;

	//bi-directional many-to-one association to Nivel
	@OneToMany(mappedBy="centroeducativo")
	private List<Nivel> nivels;

	public Centroeducativo() {
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

	public List<Nivel> getNivels() {
		return this.nivels;
	}

	public void setNivels(List<Nivel> nivels) {
		this.nivels = nivels;
	}

	public Nivel addNivel(Nivel nivel) {
		getNivels().add(nivel);
		nivel.setCentroeducativo(this);

		return nivel;
	}

	public Nivel removeNivel(Nivel nivel) {
		getNivels().remove(nivel);
		nivel.setCentroeducativo(null);

		return nivel;
	}

}