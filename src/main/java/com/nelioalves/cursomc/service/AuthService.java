package com.nelioalves.cursomc.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.repository.ClienteRepository;
import com.nelioalves.cursomc.service.exceptions.ObjectNotFoundException;

@Service
public class AuthService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEconder;
	
	@Autowired
	private EmailService emailService;
	
	
	private Random random = new Random(); 
	
	
	public void sendNewPassword(String email) {
		
		Cliente cliente = clienteRepository.findByEmail(email);
		if(cliente == null) {
			throw new ObjectNotFoundException("Email não encontrado");
		}
		
		String newPass = newPassword();
		cliente.setSenha(passwordEconder.encode(newPass));
		
		clienteRepository.save(cliente);
		emailService.sendNewPasswordEmail(cliente, newPass);
	}


	private String newPassword() {
		char[] vet = new char[10];
		for(int i=0;i<10;i++) {
			vet[i] = randomChar();
		}
		return new String(vet);
	}


	private char randomChar() { // utilizando a unicode table para saber qual numero representa o 0 = 48, A(maiúsculo) = 65 e a(minúsculo) =97
		int opt = random.nextInt(3);
		if(opt == 0) { //Gera um digito entre 0 a 10 
			return (char) (random.nextInt(10) + 48);
		}
		else if (opt == 1) { //gera letra minúscula entre as 26 possíveis
			return (char) (random.nextInt(26) + 65);
		}
		else { //gera letra maiúscula entre as 26 possíveis
			return (char) (random.nextInt(26) + 97);
		}
	}
}
