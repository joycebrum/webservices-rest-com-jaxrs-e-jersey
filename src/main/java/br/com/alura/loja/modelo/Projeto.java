package br.com.alura.loja.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

@XmlRootElement // informa que esse elemento é um elemento válido do XML do jaxB
@XmlAccessorType(XmlAccessType.FIELD) // todos os campos serão serializados por padrão
public class Projeto {
	
	private String nome;
	private long id;
	private int anoDeInicio;
	
	public Projeto(long id, String nome, int anoDeInicio) {
		this.nome = nome;
		this.id = id;
		this.anoDeInicio = anoDeInicio;
	}
	
	public Projeto() {}
	
	public String getNome() {
		return nome;
	}

	public long getId() {
		return id;
	}

	public int getAnoDeInicio() {
		return anoDeInicio;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String toXML() {
		return new XStream().toXML(this);
	}
	
	public String toJson() {
        return new Gson().toJson(this);
	}
}
