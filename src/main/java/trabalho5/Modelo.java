package trabalho5;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "modelo")
public class Modelo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_modelo")	
	private Integer id; 
	private String descricao; 
	private Integer potencia;
	
	@OneToOne
	@JoinColumn(name = "id_marca")
	private Marca marca_id;
	
	public Modelo() {
		
	}
	
	public Modelo(Integer id, String descricao, Integer potencia, Marca marca_id) {
		this.id = id;
		this.descricao = descricao;
		this.potencia = potencia;
		this.marca_id = marca_id;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getPotencia() {
		return potencia;
	}

	public void setPotencia(Integer potencia) {
		this.potencia = potencia;
	}

	public Marca getMarca_id() {
		return marca_id;
	}

	public void setMarca_id(Marca marca_id) {
		this.marca_id = marca_id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}