package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Address;
import com.example.demo.service.AddressService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api")
public class AddressController {
	@Autowired
	AddressService addressService;

	@GetMapping("/Address")
	public List<Address> index(Model model) {
		return  addressService.getAddresss();
	}
	
	@PostMapping("/Address")
	public Address createAddress(@RequestBody Address address) {
		return addressService.createAddress(address);
	}
}
