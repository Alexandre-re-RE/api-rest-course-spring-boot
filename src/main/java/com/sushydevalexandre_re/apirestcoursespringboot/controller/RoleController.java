package com.sushydevalexandre_re.apirestcoursespringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sushydevalexandre_re.apirestcoursespringboot.configsecurity.Role;
import com.sushydevalexandre_re.apirestcoursespringboot.repository.RoleRepository;

@RestController
@RequestMapping("/role")
@CrossOrigin("*")
public class RoleController {
	
	public RoleController(RoleRepository roleRepository) {
		super();
		this.roleRepository = roleRepository;
	}
	@Autowired
	private RoleRepository roleRepository;
	
	@GetMapping("/getall")
	public List<Role> getAllUser() {
		return roleRepository.findAll();
	}
	 @DeleteMapping("/drop")
	    public void dropAllByIds(@RequestBody List<Integer> ids) {
	        roleRepository.deleteAllById(ids);
	    }

}
