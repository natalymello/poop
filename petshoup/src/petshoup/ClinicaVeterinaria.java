package petshoup;

public class ClinicaVeterinaria {

	public static void main(String[] args) {
		AtendivelNoEstetica[] filaEstetica = new AtendivelNoEstetica[3];
		Cachorro cachorro1 = new Cachorro("totó", 3, "Julinha", "987772323", "poodle");
		Cachorro cachorro2 = new Cachorro("toby", 2, "maria", "984772323", "chiuaua");
		Cachorro cachorro3 = new Cachorro("bidu", 5, "maria", "984772673", "vira-lata");

		filaEstetica[0] = cachorro1;
		filaEstetica[1] = cachorro2;
		filaEstetica[2] = cachorro3;

		for (int i = 0; i < filaEstetica.length; i++) {
			filaEstetica[i].cortarUnhas();
			filaEstetica[i].darBanho();
		}

		Animal[] filaAnimais = new Animal[5];
		Gato gato1 = new Gato("oreo", 4, "raysa", "67237647823");
		Gato gato2 = new Gato("dorama", 2, "raysa", "8723445435");

		filaAnimais[0] = cachorro1;
		filaAnimais[1] = cachorro2;
		filaAnimais[2] = cachorro3;
		filaAnimais[3] = gato1;
		filaAnimais[4] = gato2;

		for (int i = 0; i < filaAnimais.length; i++) {
          filaAnimais[i].exibirDados();
		}
	}
}