public abstract class Animal {
	protected String nome;
	protected int idade;
	protected boolean faminto = true;
	protected static int totalAnimais = 0;
	Pessoa dono = new Pessoa();

	Animal(String nome, int idade, boolean faminto, String nomeDono, String telefone) {
		this.nome = nome;
		this.idade = idade;
		this.faminto = faminto;
		dono = new Pessoa(nomeDono,telefone);
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

	public abstract void emitirSom();

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
