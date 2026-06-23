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
	
	public void atualizarPessoa(String novoNome,String novoTelefone) {
		if(novoNome==nome) {
			
		}else {
			this.nome=novoNome;
		}
		if(novoTelefone==null) {
			
		}else {
			this.telefone=novoTelefone;
		}
		return;
		
	}
	
	 public void setNome(String nome) {
			this.nome = nome;
		}

		public void setTelefone(String telefone) {
			this.telefone = telefone;
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
