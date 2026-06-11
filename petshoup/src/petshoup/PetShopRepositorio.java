package petshoup;
import java.util.ArrayList;
import java.util.List;
public class PetShopRepositorio {
	private final ArrayList<Animal> animais = new ArrayList<>();

	/** Adiciona um animal à lista. */
	public void adicionar(Animal a) {
		animais.add(a);
	}

	/**
	 * Busca um animal pelo nome (case-insensitive).
	 * 
	 * @return o Animal encontrado, ou null se não existir.
	 */
	public Animal buscarPorNome(String nome) {

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
