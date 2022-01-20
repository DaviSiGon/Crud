package com.davi.senai;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.davi.senai.domain.Cliente;
import com.davi.senai.repositories.ClienteRepository;

@SpringBootTest

public class clienteTest {

	@Autowired
	ClienteRepository clienteRepository;

	@Test
	void Cliente() {
		Cliente cli = new Cliente();
		cli.setIdCliente(null);
		cli.setNome("Júlia Alves");
		cli.setCpfOuCnpj("23109212390");
		cli.setEmail("julia3@gmail.com");
		clienteRepository.save(cli);
	}

	@Test
	public void listaCliente() {
		List<Cliente> List = clienteRepository.findAll();
		assertThat(List).size().isGreaterThan(0);
	}

	@Test
	public void idCliente() {
		Cliente cliente = clienteRepository.findById(1).get();
		assertEquals("Júlia Alves", cliente.getNome());
	}

	@Test
	public void updateCliente() {
		Cliente cliente = clienteRepository.findById(1).get();
		cliente.setNome("Júlia Alves");
		clienteRepository.save(cliente);
		assertNotEquals("Júlia", cliente.getNome());
	}

	@Test
	public void deleteCliente() {
		clienteRepository.deleteById(1);
		assertThat(clienteRepository.existsById(1));
	}
}