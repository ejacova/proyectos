package controller;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import quileia.Agente;
import quileia.Via;



public class CrearAgenteController {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	private List<Agente> agentes;
	private Agente agente;
	private List<Via> vias;



	
	public CrearAgenteController() {
		this.emf = Persistence.createEntityManagerFactory("quileia");
		this.em = this.emf.createEntityManager();
		this.agentes = consultarAgentes();
		this.agente = new Agente();
		
	}
	
	private List<Agente> consultarAgentes() {
		String jpql = "SELECT cit FROM Agente cit ";
		Query query = (Query) this.em.createQuery(jpql);
		List<Agente> agentes = query.getResultList();
		
		return agentes;
	}
	
	public void nuevoAgente() {
		
		try {
			this.em.getTransaction().begin();
			this.em.persist(this.agente);
			this.em.getTransaction().commit();
			this.em = this.emf.createEntityManager();
			this.agente = new Agente();
			this.agentes = consultarAgentes();
		
			MensajeConfirmar();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	

	public void MensajeConfirmar() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "¡Atencion!" ,"Un Agente ha sido añadida con éxito"));
		
	}
	
	public void eliminar(Agente agente) {
		
		try {
			this.em.getTransaction().begin();
			this.em.remove(agente);
			this.em.getTransaction().commit();
			this.em = this.emf.createEntityManager();
			this.agente = new Agente();
			this.agentes = consultarAgentes();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	

	
	public List<Via> ViasAceptadas(){
		String jpql = "SELECT e FROM Via e WHERE e.congestion >= 30";
		Query query = (Query) this.em.createQuery(jpql);
		vias = query.getResultList();
		
		
		return vias;
		
	}
	
	 public void modificarCategoria(Agente categoria) {
		 try {

				this.em.getTransaction().begin();
				this.em.merge(categoria);
				this.em.getTransaction().commit();
				this.em = this.emf.createEntityManager();
				this.agente = new Agente();
				this.agentes = consultarAgentes();
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		}

	public List<Agente> getAgentes() {
		return agentes;
	}

	public void setAgentes(List<Agente> agentes) {
		this.agentes = agentes;
	}

	public Agente getAgente() {
		return agente;
	}

	public void setAgente(Agente agente) {
		this.agente = agente;
	}

	public void seleccionar(Via via) {
		
		this.agente.setVia(via);
		
	}

	
	


}
