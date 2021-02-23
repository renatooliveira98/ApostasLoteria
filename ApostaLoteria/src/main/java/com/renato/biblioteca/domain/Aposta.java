package com.renato.biblioteca.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Aposta implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date data;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="apostador_id")
	private Apostador apostador;
	@ElementCollection
	private Set<Integer> numerosAleatorios = new HashSet<>();
	
	public Aposta() {
		
	}

	public Aposta(Integer id, Date data, Apostador apostador) {
		super();
		this.id = id;
		this.data = data;
		this.apostador = apostador;
		Random rd = new Random();
		while(numerosAleatorios.size()<6) {
			numerosAleatorios.add(rd.nextInt(60)+1);
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Apostador getApostador() {
		return apostador;
	}

	public void setApostador(Apostador apostador) {
		this.apostador = apostador;
	}
	
	public Set<Integer> getNumerosAleatorios() {
		return numerosAleatorios;
	}

	public void setNumerosAleatorios(Set<Integer> numerosAleatorios) {
		this.numerosAleatorios = numerosAleatorios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aposta other = (Aposta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
