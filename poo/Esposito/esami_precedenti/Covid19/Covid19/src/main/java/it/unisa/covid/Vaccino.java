package it.unisa.covid;

public enum Vaccino {
	AstraZeneca("AstraZeneca", Categoria.VettoreVirale, 2, 18),
	JohnsonJohnson("Johnson&Johnson", Categoria.VettoreVirale, 1, 18),
	Pfizer("Pfizer", Categoria.mRNA, 2, 16),
	Moderna("Moderna", Categoria.mRNA, 2, 18);
	
	
	private String nome;
	private Categoria categoria;
	private int numeroDosi;
	private int limiteAnno;
	private Vaccino(String nome, Categoria categoria, int numeroDosi, int limiteAnno) {
		this.nome = nome;
		this.categoria = categoria;
		this.numeroDosi = numeroDosi;
		this.limiteAnno = limiteAnno;
	}
	public String getNome() {
		return nome;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public int getNumeroDosi() {
		return numeroDosi;
	}
	public int getLimiteAnno() {
		return limiteAnno;
	}
	
	
}
