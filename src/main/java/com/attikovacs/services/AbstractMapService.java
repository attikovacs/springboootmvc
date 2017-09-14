package com.attikovacs.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.attikovacs.domain.DomainObject;

public abstract class AbstractMapService {

	protected HashMap<Integer,DomainObject> map;
	
	public AbstractMapService() {
		map = new HashMap<>();
		loadMap();
	}
	
    public List<DomainObject> listAll() {
        return new ArrayList<>(map.values());
    }
    
	public DomainObject getById(Integer id) {
		return map.get(id);
	}

	public DomainObject saveOrUpdate(DomainObject domainObject) {
		if (domainObject == null) throw new RuntimeException("Cannot be null");
		
		if (domainObject.getId() == null) {
			domainObject.setId(getNextKey());
		}
		
		map.put(domainObject.getId(), domainObject);
		return domainObject;
	}
	
	public void delete(Integer id) {
		map.remove(id);
	}
	
	protected abstract void loadMap();
	
	private Integer getNextKey() {
		return map.keySet().isEmpty() ? 1 : Collections.max(map.keySet()) + 1;
	}
	
}
