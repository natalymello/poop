package petshoup;

public class Pessoa {
	private String nome;
	private String sobrenome;
	private String telefone;

	Pessoa(){}
	

	 public String getNome() {
		return nome;
	}


	public String getSobrenome() {
		return sobrenome;
	}


	public String getTelefone() {
		return telefone;
	}


	 Pessoa(String nome, String telefone) {
		 this.nome = nome;
		 this.telefone = telefone;
	 }
 	 public String exibirInformacoes(){
 		 String DadosPessoa =
		 ("\nNome(Tutor): "+this.nome+"\nTelefone: "+ this.telefone);
 		 return DadosPessoa;
	 }
}
