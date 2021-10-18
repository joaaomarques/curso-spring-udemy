package com.nelioalves.cursomc.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.service.validation.ClienteUpdate;

@ClienteUpdate
public class ClienteDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotNull(message = "Preenchimento Obrigatório")
	@Size(min=5, max=120, message = "O tamanho deve ser entre 5 e 120 caracteres")
	private String nome;
	
	@NotNull(message = "Preenchimento Obrigatório")
	@Email(message = "Email Inválido")
	private String email;
	
	public ClienteDTO() {
		
	}
	
	public ClienteDTO(Cliente cliente) {
		id = cliente.getId();
		nome = cliente.getNome();
		email = cliente.getEmail();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
