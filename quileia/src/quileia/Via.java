package quileia;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the via database table.
 * 
 */
@Entity
@NamedQuery(name="Via.findAll", query="SELECT v FROM Via v")
public class Via implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int identificador;

	private String calleCarrera;

	private BigDecimal congestion;

	private int numero;

	private String tipo;

	//bi-directional many-to-one association to Agente
	@OneToMany(mappedBy="via")
	private List<Agente> agentes;

	public Via() {
	}

	public int getIdentificador() {
		return this.identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public String getCalleCarrera() {
		return this.calleCarrera;
	}

	public void setCalleCarrera(String calleCarrera) {
		this.calleCarrera = calleCarrera;
	}

	public BigDecimal getCongestion() {
		return this.congestion;
	}

	public void setCongestion(BigDecimal congestion) {
		this.congestion = congestion;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Agente> getAgentes() {
		return this.agentes;
	}

	public void setAgentes(List<Agente> agentes) {
		this.agentes = agentes;
	}

	public Agente addAgente(Agente agente) {
		getAgentes().add(agente);
		agente.setVia(this);

		return agente;
	}

	public Agente removeAgente(Agente agente) {
		getAgentes().remove(agente);
		agente.setVia(null);

		return agente;
	}

}