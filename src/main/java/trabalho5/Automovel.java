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
@Table(name = "automovel")
public class Automovel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_automovel")
	private Integer id; 
	private Integer anoFabricacao; 
	private Integer anoModelo; 
	private String observacoes; 
	private Double preco; 
	private Integer kilometragem;
	@OneToOne
	@JoinColumn(name = "id_modelo")
	private Modelo modelo_id;

	
	public Automovel(){ 
		
	}
	public Automovel(Integer id, Integer anoFabricacao, Integer anoModelo, String observacoes, Double preco,
			                                                          Integer kilometragem, Modelo modelo_id) {
		this.id = id; 
		this.anoFabricacao = anoFabricacao;
		this.anoModelo = anoModelo;
		this.observacoes = observacoes;
		this.preco = preco;
		this.kilometragem = kilometragem;
		this.modelo_id = modelo_id;
		
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
	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	public Integer getAnoModelo() {
		return anoModelo;
	}
	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Integer getKilometragem() {
		return kilometragem;
	}
	public void setKilometragem(Integer kilometragem) {
		this.kilometragem = kilometragem;
	}
	public Modelo getModelo_id() {
		return modelo_id;
	}
	public void setModelo_id(Modelo modelo_id) {
		this.modelo_id = modelo_id;
	}
	

}
