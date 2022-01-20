package com.davi.senai;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.davi.senai.domain.Cidade;
import com.davi.senai.domain.Cliente;
import com.davi.senai.domain.Endereco;
import com.davi.senai.domain.Estado;
import com.davi.senai.enuns.TipoCliente;
import com.davi.senai.repositories.CidadeRepository;
import com.davi.senai.repositories.ClienteRepository;
import com.davi.senai.repositories.EnderecoRepository;
import com.davi.senai.repositories.EstadoRepository;

@SpringBootApplication
public class Senai21Application implements CommandLineRunner {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;


    public static void main(String[] args) {
        SpringApplication.run(Senai21Application.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        Estado est1 = new Estado(null, "Minas Gerais");
        Estado est2 = new Estado(null, "Mato Grosso");
        estadoRepository.saveAll(Arrays.asList(est1,est2));

        Cidade c1 = new Cidade(null, "Uberlândia", est1);
        Cidade c2 = new Cidade(null, "Teresinha", est2);
        cidadeRepository.saveAll(Arrays.asList(c1,c2));

        Cliente cli1 = new  Cliente(null, "Davi", "22345157808", "davisigon@gmail.com", 
                TipoCliente.PESSOAFISICA);
        Cliente cli2 = new  Cliente(null, "Anderson", "33352127790", "dersobert0@gmail.com",
                TipoCliente.PESSOAFISICA);
        cli1.getTelefones().addAll(Arrays.asList("2400012345", "1212144987"));
        cli2.getTelefones().addAll(Arrays.asList("4444167789", "1000085656"));
        clienteRepository.saveAll(Arrays.asList(cli1,cli2));

        Endereco e1 = new Endereco(null, "Rua Omegalul", "91","", "Roosevelto", "38125314",cli1, c1);
        Endereco e2 = new Endereco(null, "Rua Pixingu", "691","", "Jardin Americ", "1698574",cli2, c2);
        cli1.getEnderecos().addAll(Arrays.asList(e1));
        cli2.getEnderecos().addAll(Arrays.asList(e2));
        enderecoRepository.saveAll(Arrays.asList(e1,e2));
    }
    
}
