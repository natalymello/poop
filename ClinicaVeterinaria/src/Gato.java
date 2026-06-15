public class Gato extends Animal {
    private boolean arranhaMoveis=true;
	Gato(String nome, int idade, boolean faminto,boolean arranhaMoveis,String nomeDono,String telefone) {
		super(nome, idade, faminto,nomeDono,telefone);
		this.arranhaMoveis=arranhaMoveis;
	}
	@Override
	public void emitirSom() {
		System.out.println("O Gato faz MIAU!");
	}

}