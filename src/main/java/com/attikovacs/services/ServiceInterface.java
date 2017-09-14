package com.attikovacs.services;

import java.util.List;

public interface ServiceInterface<T> {

	List<?> listAll();
    
    T getById(Integer id);
    
    T saveOrUpdate(T t);
    
    void delete(Integer id);

}
