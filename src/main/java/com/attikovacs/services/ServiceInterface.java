package com.attikovacs.services;

import java.util.List;

public interface ServiceInterface<T> {

	List<?> listAll();
    
    T getById(Integer id);
    
    T saveOrUpdate(T domainObject);
    
    void delete(Integer id);

}
