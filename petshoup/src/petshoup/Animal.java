package petshoup;

public abstract class Animal {
	protected String nome;
	protected int idade;
	protected boolean faminto = true;
	protected Pessoa dono = new Pessoa();
	protected static int totalAnimais = 0;

	Animal(String nome, int idade, String nomeDono, String telefone) {
		this.nome = nome;
		this.idade = idade;
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

	public void emitirSom() {
		System.out.println("O Animal emitiu um som.");
	}

	public void comer() {
		if (this.faminto == true) {
			System.out.println("O " + this.getNome() + " comeu!");
			this.faminto = false;
		} else {
			System.out.println(this.getNome() + " já está satisfeito.");
		}

	}

	public boolean isFaminto() {
		return faminto;
	}

	public String exibirDados() {
		String Dados = 
		("Nome: " + this.getNome()+ "\nIdade: " + this.getIdade()+"\nFaminto: " + this.isFaminto());
		if (dono != null) {
			dono.exibirInformacoes();
		}
		return Dados;

	}
}
