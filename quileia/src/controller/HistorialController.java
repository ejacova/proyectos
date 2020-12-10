package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import quileia.Agente;
import quileia.Via;

public class HistorialController {

	public Integer ID;
	public Integer numero;
	private EntityManagerFactory emf;
	private EntityManager em;
	private List<Agente> Historiales;
	public Boolean BuscarId = false;
	public Boolean BuscarVia = false;

	public HistorialController() {
		this.emf = Persistence.createEntityManagerFactory("quileia");
		this.em = this.emf.createEntityManager();
		this.Historiales = ConsultarHistoriales();

	}

	public List<Agente> ConsultarHistoriales() {

		String jpql = "SELECT cit FROM Agente cit ";
		Query query = (Query) this.em.createQuery(jpql);
		List<Agente> historiales = query.getResultList();

		return historiales;

	}

	public List<Agente> obtenerHistorial() {

		if (BuscarId == true && BuscarVia == false) {
			BuscarId = false;

			if (this.ID >= 1) {

				String jpql = "SELECT e FROM Agente e WHERE e.codigoAgente = " + this.ID;
				Query query = (Query) this.em.createQuery(jpql);
				Historiales = query.getResultList();

				return Historiales;
			} else {
				return ConsultarHistoriales();
			}

		} else if (BuscarId == false && BuscarVia == false) {

			return ConsultarHistoriales();

		} else if (BuscarVia == true && BuscarId == false) {
			BuscarVia = false;
			if (this.numero >= 1) {

				String jpql = "Select e FROM Agente e JOIN e.via p WHERE p.identificador = " + this.numero;
				Query query = (Query) this.em.createQuery(jpql);
				Historiales = query.getResultList();

				return Historiales;
			} else {
				return ConsultarHistoriales();
			}

		}else {
			return null;
		}

	}

	public Boolean getBuscarId() {
		return BuscarId;
	}

	public void setBuscarId(Boolean buscarId) {
		System.out.println(this.ID);
		BuscarId = buscarId;
		System.out.println(BuscarId);
	}

	public Boolean getBuscarVia() {
		return BuscarVia;
	}

	public void setBuscarVia(Boolean buscarVia) {
		System.out.println(this.numero);
		BuscarVia = buscarVia;
		System.out.println(BuscarVia);
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public List<Agente> getHistoriales() {
		return Historiales;
	}

	public void setHistoriales(List<Agente> historiales) {
		Historiales = historiales;
	}

}
