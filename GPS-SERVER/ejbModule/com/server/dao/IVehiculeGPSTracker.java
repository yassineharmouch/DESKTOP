package com.server.dao;

import java.util.List;

import javax.ejb.Remote;

import com.server.models.GPSTracker;

@Remote
public interface IVehiculeGPSTracker {
	public void ajouter(IVehiculeGPSTracker obj);
	public void modifier(IVehiculeGPSTracker obj);
	public void supprimer(IVehiculeGPSTracker obj);
	public GPSTracker findById(int id);
	public List<GPSTracker> findAll();
}
