package com.sushydevalexandre_re.apirestcoursespringboot;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.sushydevalexandre_re.apirestcoursespringboot.configsecurity.Role;
import com.sushydevalexandre_re.apirestcoursespringboot.models.Utilisateur;
import com.sushydevalexandre_re.apirestcoursespringboot.repository.RoleRepository;
import com.sushydevalexandre_re.apirestcoursespringboot.repository.UtilisateurRepository;

@SpringBootApplication
public class ApiRestCourseSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestCourseSpringBootApplication.class, args);
	}
	
	@Bean
	CommandLineRunner run(RoleRepository roleRepository,UtilisateurRepository utilisateurReposotory,PasswordEncoder passwordEncoder) {
		passwordEncoder = new BCryptPasswordEncoder();
		String pass = passwordEncoder.encode("password");
		
		return args ->{
			if(roleRepository.findByAuthority("ADMIN").isPresent())return;
			
			Role adminRole = roleRepository.save(new Role("ADMIN"));
			roleRepository.save(new Role("USER"));
			
			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);
			
			Utilisateur admin = new Utilisateur("CHATEAU","Nathan","{bcrypt}"+pass,"admin",roles);
			utilisateurReposotory.save(admin);
		};
	}

}
