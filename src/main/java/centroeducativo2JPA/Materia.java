package centroeducativo2JPA;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the materia database table.
 * 
 */
@Entity
@NamedQuery(name="Materia.findAll", query="SELECT m FROM Materia m")
public class Materia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private byte admiteMatricula;

	private String codigo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaInicio;

	private String nombre;

	private String urlClassroom;

	//bi-directional many-to-one association to Nivel
	@ManyToOne
	@JoinColumn(name="idNivel")
	private Nivel nivel;

	//bi-directional many-to-one association to Valoracionmateria
	@OneToMany(mappedBy="materia")
	private List<Valoracionmateria> valoracionmaterias;

	public Materia() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getAdmiteMatricula() {
		return this.admiteMatricula;
	}

	public void setAdmiteMatricula(byte admiteMatricula) {
		this.admiteMatricula = admiteMatricula;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrlClassroom() {
		return this.urlClassroom;
	}

	public void setUrlClassroom(String urlClassroom) {
		this.urlClassroom = urlClassroom;
	}

	public Nivel getNivel() {
		return this.nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public List<Valoracionmateria> getValoracionmaterias() {
		return this.valoracionmaterias;
	}

	public void setValoracionmaterias(List<Valoracionmateria> valoracionmaterias) {
		this.valoracionmaterias = valoracionmaterias;
	}

	public Valoracionmateria addValoracionmateria(Valoracionmateria valoracionmateria) {
		getValoracionmaterias().add(valoracionmateria);
		valoracionmateria.setMateria(this);

		return valoracionmateria;
	}

	public Valoracionmateria removeValoracionmateria(Valoracionmateria valoracionmateria) {
		getValoracionmaterias().remove(valoracionmateria);
		valoracionmateria.setMateria(null);

		return valoracionmateria;
	}

	@Override
	public String toString() {
		return nombre;
	}
	
	

}