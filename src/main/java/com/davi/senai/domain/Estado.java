package com.davi.senai.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Estado implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "id_estado")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nome_estado")
	private String nome;
	
	@JsonIgnore
	@OneToMany(mappedBy = "estado")
	private List <Cidade> cidades= new ArrayList<>();
	
	public Estado() {
		
	}

	public Estado(Integer id, String nome) {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setId(Object object) {
		// TODO Auto-generated method stub
		
	}

	public void setCidades(Object object) {
		// TODO Auto-generated method stub
		
	}
	
}
