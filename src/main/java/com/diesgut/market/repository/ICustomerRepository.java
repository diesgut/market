package com.diesgut.market.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.diesgut.market.entity.Customer;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {

	Optional<Customer> findByDni(String dni);

	@Query("SELECT c FROM Customer c WHERE c.dni=?1")
	List<Customer> getByDni(String dni);

	@Query(value = "SELECT * FROM Customer c WHERE c.dni=?1", nativeQuery = true)
	List<Customer> fetchByDni(String dni);

}
