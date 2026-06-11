package petshoup;

public class Cachorro extends Animal implements AtendivelNoEstetica {
	private String raca;

	Cachorro(String raca,String nome, int idade, String nomeDono, String telefone) {
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
	public String  exibirDados() {
		super.exibirDados();
		String DadosCachorro = ("/nRaça"+this.raca);
		return DadosCachorro;
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
