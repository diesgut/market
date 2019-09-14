package com.diesgut.market.service;

import java.util.List;
import java.util.Optional;

import com.diesgut.market.entity.Customer;

public interface ICustomerService {

	Customer saveOrUpdate(Customer customer);

	List<Customer> getAll();

	Optional<Customer> getById(Long id);

}
