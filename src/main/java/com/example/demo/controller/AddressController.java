package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Address;
import com.example.demo.repository.AddressRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api")
public class AddressController {
	@Autowired
	AddressRepository addressRepository;

	@RequestMapping(value = "/Address", method = RequestMethod.GET)
	public List<Address> index(Model model) {
		List<Address> addressList = addressRepository.findAll();
		model.addAttribute("testList", addressList);
		return addressList;
	}
}
