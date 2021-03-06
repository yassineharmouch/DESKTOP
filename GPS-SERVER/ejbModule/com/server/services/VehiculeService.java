package com.server.services;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import com.server.dao.IVehicule;
import com.server.models.Vehicule;

@Singleton(name = "VEH")
public class VehiculeService extends UnicastRemoteObject implements IVehicule {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2731833548079106725L;

	final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("GPS-SER");

	public VehiculeService() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouter(Vehicule obj) {
		// TODO Auto-generated method stub
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(obj);
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}

	@Override
	public void modifier(Vehicule obj) {
		// TODO Auto-generated method stub
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Vehicule v=entityManager.find(Vehicule.class, obj.getId());
		v.setMarque(obj.getMarque());
		v.setMatricule(obj.getMatricule());
		v.setType(obj.getType());
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Override
	public void supprimer(Vehicule obj) {
		// TODO Auto-generated method stub
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		if (entityManager.contains(obj)) {
			entityManager.remove(obj);
		} else {
			entityManager.remove(entityManager.merge(obj));
		}

		entityManager.getTransaction().commit();
		entityManager.close();

	}

	@Override
	public Vehicule findById(int id) {
		// TODO Auto-generated method stub
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		@SuppressWarnings("unchecked")
		Vehicule response = (Vehicule) entityManager.find(Vehicule.class, id);
		entityManager.getTransaction().commit();
		entityManager.close();
		return response;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vehicule> findAll() {
		// TODO Auto-generated method stub
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		Query query = entityManager.createQuery("from Vehicule");
		@SuppressWarnings("unchecked")
		List<Vehicule> liste = (List<Vehicule>) query.getResultList();

		entityManager.getTransaction().commit();
		entityManager.close();
		return liste;
	}
	
	@PostConstruct
	public void init() {
		this.ajouter(new Vehicule("Vehicule1", "FERRARI", "C4"));
		this.ajouter(new Vehicule("Vehicule2", "RENAULT", "F4"));
		this.ajouter(new Vehicule("Vehicule3", "Renault", "Clio"));
		this.ajouter(new Vehicule("Vehicule4", "Dacia", "Logan"));
		this.ajouter(new Vehicule("Vehicule5", "Renault", "R4"));
		this.ajouter(new Vehicule("Vehicule6", "DUSTER", "C"));
	}

}
