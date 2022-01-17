package com.server.dao;

import java.util.List;

import javax.ejb.Remote;

import com.server.models.GPSTracker;

@Remote
public interface IGPSTracker  {
	public void ajouter(GPSTracker obj);
	public void modifier(GPSTracker obj);
	public void supprimer(GPSTracker obj);
	public GPSTracker findById(int id);
	public List<GPSTracker> findAll();
}
