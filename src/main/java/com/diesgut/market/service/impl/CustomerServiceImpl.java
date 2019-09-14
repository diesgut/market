package com.diesgut.market.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diesgut.market.entity.Customer;
import com.diesgut.market.repository.ICustomerRepository;
import com.diesgut.market.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerRepository customerRepository;

	@Override
	public Customer saveOrUpdate(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getAll() {
		return customerRepository.findAll();
	}

	@Override
	public Optional<Customer> getById(Long id) {
		return customerRepository.findById(id);
	};

}
