package petshoup;

public class Cachorro extends Animal implements AtendivelNoEstetica {
	private String raca;

	Cachorro(String nome, int idade, String nomeDono, String telefone,String raca) {
		super(nome, idade, nomeDono, telefone);
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
	
	@Override
	public void darBanho() {
		System.out.println("Dando banho no "+ getNome()+"...");
	}
	@Override
	public void cortarUnhas() {
		System.out.println("Cortando unha do "+ getNome()+"...");
	}
	@Override
	public void comer() {
		super.comer();
	}
	}
