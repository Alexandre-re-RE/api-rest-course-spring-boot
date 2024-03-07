package com.sushydevalexandre_re.apirestcoursespringboot.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sushydevalexandre_re.apirestcoursespringboot.configsecurity.Role;
import com.sushydevalexandre_re.apirestcoursespringboot.models.LoginResponseDTO;
import com.sushydevalexandre_re.apirestcoursespringboot.models.Utilisateur;
import com.sushydevalexandre_re.apirestcoursespringboot.repository.RoleRepository;
import com.sushydevalexandre_re.apirestcoursespringboot.repository.UtilisateurRepository;

@Service
@Transactional
public class AuthentificationService {
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private AuthenticationManager authentificationManager;
	@Autowired
	private TokenService tokenService;
	
	public Utilisateur registerUser(String username,String password,String nom,String prenom) {
		
		passwordEncoder = new BCryptPasswordEncoder();
		String pass = passwordEncoder.encode(password);
		
		String encodedPassword = passwordEncoder.encode(password);
		Role userRole = roleRepository.findByAuthority("USER").get();
		
		Set<Role> authorities = new HashSet<>();
		authorities.add(userRole);
		
		
		return utilisateurRepository.save(new Utilisateur(prenom,nom,"{bcrypt}"+pass,username,authorities) );
	}
	
	public LoginResponseDTO loginUser(String username,String password) {
		
		try {
			
			System.out.println("username : "+ username + " password : "+ password);
			
			Authentication auth = authentificationManager.authenticate(
					new UsernamePasswordAuthenticationToken(username, password)
				);
			
			System.out.println("username : "+ username + " password : "+ password);
			
			String token = tokenService.generateJwt(auth);
			
			System.out.println("token : "+ token);
			
			return new LoginResponseDTO(utilisateurRepository.findByUsername(username).get(),token);
		} catch (Exception e) {
			System.out.println("error : "+ e);
			return new LoginResponseDTO(null,"");
		}
	
	}

}
