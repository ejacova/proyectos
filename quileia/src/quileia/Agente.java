package quileia;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the agente database table.
 * 
 */
@Entity
@NamedQuery(name="Agente.findAll", query="SELECT a FROM Agente a")
public class Agente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String codigoAgente;

	private BigDecimal a�osExperiencia;

	private String codigoSecretaria;

	private String nombre;

	//bi-directional many-to-one association to Via
	@ManyToOne
	@JoinColumn(name="ViaActual")
	private Via via;

	public Agente() {
	}

	public String getCodigoAgente() {
		return this.codigoAgente;
	}

	public void setCodigoAgente(String codigoAgente) {
		this.codigoAgente = codigoAgente;
	}

	public BigDecimal getA�osExperiencia() {
		return this.a�osExperiencia;
	}

	public void setA�osExperiencia(BigDecimal a�osExperiencia) {
		this.a�osExperiencia = a�osExperiencia;
	}

	public String getCodigoSecretaria() {
		return this.codigoSecretaria;
	}

	public void setCodigoSecretaria(String codigoSecretaria) {
		this.codigoSecretaria = codigoSecretaria;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Via getVia() {
		return this.via;
	}

	public void setVia(Via via) {
		this.via = via;
	}

}