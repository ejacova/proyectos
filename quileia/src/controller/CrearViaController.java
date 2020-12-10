package controller;

import java.util.List;
import javax.persistence.Query;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import quileia.Agente;
import quileia.Via;

public class CrearViaController {

	
	private EntityManagerFactory emf;
	private EntityManager em;
	private Via via;
	private List<Via> vias;
	
	public CrearViaController() {
		this.emf = Persistence.createEntityManagerFactory("quileia");
		this.em = this.emf.createEntityManager();
		this.vias = consultarCitas();
		this.via = new Via();
	}

	private List<Via> consultarCitas() {
		String jpql = "SELECT cit FROM Via cit ";
		Query query = (Query) this.em.createQuery(jpql);
		List<Via> objetos = query.getResultList();
		return objetos;
	}
	
	public void nuevaVia() {
		
		try {
			this.em.getTransaction().begin();
			System.out.println(this.via.getIdentificador() + " IDENTIFICADOR");
			this.em.persist(this.via);
			this.em.getTransaction().commit();
			this.em = this.emf.createEntityManager();
			this.via = new Via();
			this.vias = consultarCitas();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void eliminar(Via via) {
		
		try {
			this.em.getTransaction().begin();
			this.em.remove(via);
			this.em.getTransaction().commit();
			this.em = this.emf.createEntityManager();
			this.via = new Via();
			this.vias = consultarCitas();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void modificarCategoria(Via categoria) {
		 try {
				this.em.getTransaction().begin();
				this.em.merge(categoria);
				this.em.getTransaction().commit();
				this.em = this.emf.createEntityManager();
				this.via = new Via();
				this.vias = consultarCitas();
			} catch (Exception e) {
				System.out.println(e);
			}
		 
	}

	public Via getVia() {
		return via;
	}

	public void setVia(Via via) {
		this.via = via;
	}

	public List<Via> getVias() {
		return vias;
	}

	public void setVias(List<Via> vias) {
		this.vias = vias;
	}
	
	
}
