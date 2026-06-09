package petshoup;

public class Gato extends Animal {
    private boolean arranhaMoveis=true;
	Gato(String nome, int idade, String nomeDono,String telefone) {
		super(nome, idade,nomeDono,telefone);

	}
	@Override
	public void emitirSom() {
		System.out.println("O Gato faz MIAU!");
	}

}
