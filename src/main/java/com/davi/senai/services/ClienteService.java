package com.davi.senai.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davi.senai.domain.Cliente;
import com.davi.senai.exeptions.ObjectNotFoundExeption;
import com.davi.senai.repositories.ClienteRepository;


@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer idCliente) {
		Optional<Cliente> obj = repo.findById(idCliente);
		return obj.orElseThrow(() -> new ObjectNotFoundExeption(
				"Número de id não encontrado. Id: " + idCliente + ", tipo: " 
				+ Cliente.class.getName()));
	}

}
