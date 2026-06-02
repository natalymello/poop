package petshoup;

public class Gato extends Animal {
    private boolean arranhaMoveis=true;
	Gato(String nome, int idade, boolean faminto,boolean arranhaMoveis) {
		super(nome, idade, faminto);
		this.arranhaMoveis=arranhaMoveis;
	}
	@Override
	public void emitirSom() {
		System.out.println("O Gato faz MIAU!");
	}

}
