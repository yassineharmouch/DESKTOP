package com.server.dao;

import java.util.List;

import javax.ejb.Remote;

import com.server.models.Position;

@Remote
public interface IPosition {
    
	public void ajouter(Position obj);
	public void modifier(Position obj);
	public void supprimer(Position obj);
	public Position findById(int id);
	public List<Position> findAll();
	
	
}
