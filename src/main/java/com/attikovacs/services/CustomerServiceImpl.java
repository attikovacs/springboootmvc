package com.attikovacs.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.attikovacs.domain.Customer;

@Service
@Profile("map")
public class CustomerServiceImpl extends AbstractMapService implements CustomerService {

	@Override
	public Customer getById(Integer id) {
		return (Customer) super.getById(id);
	}

	@Override
	public Customer saveOrUpdate(Customer customer) {
		return (Customer) super.saveOrUpdate(customer);
	}

    @Override
	protected void loadMap() {
    	Customer c1 = new Customer();
    	c1.setId(1);
    	c1.setAddress1("first customer address line 1");
    	c1.setAddress2("first customer address line 2");
    	c1.setCity("Budapest");
    	c1.setEmail("first@gmail.com");
    	c1.setFirstName("First");
    	c1.setLastName("Customer");
    	c1.setPhone("012345671");
    	c1.setState("Hungary");
    	c1.setZipCode("1138");
    	map.put(1, c1);
    	
       	Customer c2 = new Customer();
    	c2.setId(2);
    	c2.setAddress1("second customer address line 1");
    	c2.setAddress2("second customer address line 2");
    	c2.setCity("Budapest");
    	c2.setEmail("second@gmail.com");
    	c2.setFirstName("Second");
    	c2.setLastName("Customer");
    	c2.setPhone("012345672");
    	c2.setState("");
    	c2.setZipCode("1138");
    	map.put(2, c2);
    	
       	Customer c3 = new Customer();
    	c3.setId(3);
    	c3.setAddress1("third customer address line 1");
    	c3.setAddress2("third customer address line 2");
    	c3.setCity("Budapest");
    	c3.setEmail("third@gmail.com");
    	c3.setFirstName("Third");
    	c3.setLastName("Customer3");
    	c3.setPhone("012345673");
    	c3.setState("Hungary");
    	c3.setZipCode("1133");
    	map.put(3, c3);
    	
       	Customer c4 = new Customer();
    	c4.setId(4);
    	c4.setAddress1("fourth customer address line 1");
    	c4.setAddress2("fourth customer address line 2");
    	c4.setCity("Budapest");
    	c4.setEmail("fourth@gmail.com");
    	c4.setFirstName("Fourth");
    	c4.setLastName("Customer");
    	c4.setPhone("012345674");
    	c4.setState("Hungary");
    	c4.setZipCode("1138");
    	map.put(4, c4);
    }

}
