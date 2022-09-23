package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.Address;
import com.example.demo.repository.AddressRepository;

@Controller
public class AddressController {
	@Autowired
	AddressRepository addressRepository;

	@RequestMapping(value = "/Address", method = RequestMethod.GET)
	public String index(Model model) {
		List<Address> addressList = addressRepository.findAll();
		model.addAttribute("testList", addressList);
		return "index";
	}
}
