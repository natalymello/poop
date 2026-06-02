package petshoup;

public class Pessoa {
	String nome;
	String sobrenome;
	String telefone;

	Pessoa(){}

	 Pessoa(String nome, String telefone) {
		 this.nome = nome;
		 this.telefone = telefone;
	 }
 	 public void exibirInformacoes(){
		 System.out.println("Nome:"+this.nome);
		 System.out.println("Telefone: ");
	 }
}
