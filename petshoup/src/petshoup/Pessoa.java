package petshoup;

public class Pessoa {
	private String nome;

	private String telefone;

	Pessoa(){}
	

	 public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}
	
	 public String setNome() {
			return nome;
		}

		public String setTelefone() {
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
