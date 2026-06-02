package petshoup;

public class Animal {
	protected String nome;
	protected int idade;
	protected boolean faminto = true;
	protected Pessoa dono = new Pessoa();
	protected static int totalAnimais = 0;

	Animal(String nome, int idade, boolean faminto) {
		this.nome = nome;
		this.idade = idade;
		this.faminto = faminto;
		totalAnimais++;

	}

	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	public Pessoa getDono() {
		return dono;
	}

	public static int getTotalAnimais() {
		return totalAnimais;
	}

	public void emitirSom() {
		System.out.println("O Animal emitiu um som.");
	}

	public void comer() {
		if (this.faminto) {
			System.out.println("O " + this.getNome() + " comeu!");
			this.faminto = false;
		} else {
			System.out.println(this.getNome() + " já está satisfeito.");
		}

	}

	public boolean isFaminto() {
		return faminto;
	}

	public void exibirDados() {
		System.out.println("Nome: " + this.getNome());
		System.out.println("Idade: " + this.getIdade());
		System.out.println("Faminto " + this.isFaminto());
		if (dono != null) {
			dono.exibirInformacoes();
		}

	}
}
