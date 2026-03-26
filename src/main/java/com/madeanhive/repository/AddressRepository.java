package com.madeanhive.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.madeanhive.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
