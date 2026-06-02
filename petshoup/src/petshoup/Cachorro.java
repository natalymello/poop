package petshoup;

public class Cachorro extends Animal {
	private String raca;

	Cachorro(String nome, int idade, boolean faminto, String raca) {
		super(nome, idade, faminto);
		this.raca = raca;
	}
	@Override
	public void emitirSom() {
		System.out.println("O Cachorro faz AU AU!");
	}

	public String getRaca() {
		return raca;
	}
	@Override
	public void exibirDados() {
		super.exibirDados();
		System.out.println("Raça: "+ this.getRaca());
	}

	}
