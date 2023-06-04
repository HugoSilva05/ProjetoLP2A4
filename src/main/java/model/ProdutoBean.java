package model;

public class ProdutoBean {
	private String idprod;
	private String nome;
	private String preco;
	private String quantidade;
	private String categoria;
	
	public ProdutoBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProdutoBean(String idprod, String nome, String preco, String quantidade, String categoria) {
		super();
		this.idprod = idprod;
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
		this.categoria = categoria;
	}
	public String getIdprod() {
		return idprod;
	}
	public void setIdprod(String idprod) {
		this.idprod = idprod;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	@Override
	public String toString() {
		return "ProdutoBean [idprod=" + idprod + ", nome=" + nome + ", preco=" + preco + ", quantidade=" + quantidade
				+ ", categoria=" + categoria + "]";
	}
	
	
}
