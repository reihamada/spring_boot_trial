package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Address;
import com.example.demo.repository.AddressRepository;

@Service
public class AddressService {
	@Autowired
	AddressRepository addressRepository;

	// CREATE 
	public Address createAddress(Address address) {
		return addressRepository.save(address);
	}

	// READ
	public List<Address> getAddresss() {
		return addressRepository.findAll();
	}

	// DELETE
	public void deleteAddress(Long empId) {
		addressRepository.deleteById(empId);
	}

	// UPDATE
	public Address updateAddress(Long empId, Address addressDetails) {
		Address address = addressRepository.findById(empId).get();
		address.setAddress(addressDetails.getAddress());
		address.setAddress2(addressDetails.getAddress2());
		address.setDistrict(addressDetails.getDistrict());
		address.setCity_id(addressDetails.getCity_id());
		address.setPostal_code(addressDetails.getPostal_code());
		address.setPhone(addressDetails.getPhone());
//		address.setLocation(addressDetails.getLocation());
		address.setLast_update(addressDetails.getLast_update());
		return addressRepository.save(address);
	}
}
