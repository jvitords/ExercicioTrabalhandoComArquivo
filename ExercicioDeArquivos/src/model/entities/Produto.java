package model.entities;

public class Produto {

	String nomeDoProduto;
	Double valorDoProduto;
	Integer quantidadeDoProduto;
	
	public Produto() {
	}

	public Produto(String nomeDoProduto, Double valorDoProduto, Integer quantidadeDoProduto) {
		this.nomeDoProduto = nomeDoProduto;
		this.valorDoProduto = valorDoProduto;
		this.quantidadeDoProduto = quantidadeDoProduto;
	}

	public String getNomeDoProduto() {
		return nomeDoProduto;
	}

	public void setNomeDoProduto(String nomeDoProduto) {
		this.nomeDoProduto = nomeDoProduto;
	}

	public Double getValorDoProduto() {
		return valorDoProduto;
	}

	public void setValorDoProduto(Double valorDoProduto) {
		this.valorDoProduto = valorDoProduto;
	}

	public Integer getQuantidadeDoProduto() {
		return quantidadeDoProduto;
	}

	public void setQuantidadeDoProduto(Integer quantidadeDoProduto) {
		this.quantidadeDoProduto = quantidadeDoProduto;
	}
	
	public Double valorTotal() {
		return valorDoProduto * quantidadeDoProduto;
	}
}
