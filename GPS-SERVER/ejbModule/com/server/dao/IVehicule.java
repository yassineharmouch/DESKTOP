package com.server.dao;

import java.util.List;

import javax.ejb.Remote;
import com.server.models.Vehicule;


@Remote
public interface IVehicule  {
	public void ajouter(Vehicule obj);
	public void modifier(Vehicule obj);
	public void supprimer(Vehicule obj);
	public Vehicule findById(int id);
	public List<Vehicule> findAll();
}
