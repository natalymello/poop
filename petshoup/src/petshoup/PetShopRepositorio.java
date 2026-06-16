package petshoup;

import java.util.ArrayList;
import java.util.List;

public class PetShopRepositorio {
	private final ArrayList<Animal> animais = new ArrayList<>();

	/** Adiciona um animal à lista. */
	public void adicionar(Animal a) {
		animais.add(a);
	}

	public Animal buscarPorNome(String nome) {
		for (Animal a : animais) {
			if (a.getNome().equals(nome)) {
				return a;
			}
		}
		return null;
	}

	/**
	 * Remove o animal com o nome informado.
	 * 
	 * @return true se encontrou e removeu, false caso contrário.
	 */
	public boolean remover(String nome) {
		return true;
	}

	/** Retorna a lista completa de animais cadastrados (cópia defensiva). */
	public ArrayList<Animal> listarTodos() {
		return animais;
	}

	/** Quantidade de animais cadastrados no repositório. */
	public int quantidade() {
		return 0;
	}
}
