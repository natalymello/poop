package petshoup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

public class TelaPetShop extends JFrame {

	private final PetShopRepositorio repositorio = new PetShopRepositorio();
	private Animal animalSelecionado;
	// ── Campos do formulário ───────────────────────────────
	private final JTextField campNome = new JTextField(10);
	private final JTextField campRaca = new JTextField(10);
	private final JTextField campIdade = new JTextField(10);
	private final JTextField campNomeDono = new JTextField(10);
	private final JTextField campTelefone = new JTextField(10);

	// ── Área de resultado ──────────────────────────────────
	private final JTextArea areaResultado = new JTextArea(12, 50);

	// ── Botões ─────────────────────────────────────────────
	private final JButton btnCadastrar = new JButton("Cadastrar");
	private final JButton btnBuscar = new JButton("Buscar");
	private final JButton btnAtualizar = new JButton("Atualizar");
	private final JButton btnRemover = new JButton("Remover");
	private final JButton btnListar = new JButton("Listar Todos");
	private final JButton btnLimpar = new JButton("Limpar");

	// ── Construtor ─────────────────────────────────────────
	public TelaPetShop() {
		super("Pet Shop — Gerenciador de Animais");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// O JFrame usa BorderLayout por padrão
		setLayout(new BorderLayout(8, 8));

		add(criarPainelFormulario(), BorderLayout.NORTH);
		add(criarAreaResultado(), BorderLayout.CENTER);
		add(criarPainelBotoes(), BorderLayout.SOUTH);

		configurarListeners();

		setSize(900, 600);
		pack();
		setLocationRelativeTo(null); // centraliza na tela

		setVisible(true);
	}

	// ── Painel Norte: formulário ───────────────────────────
	private JPanel criarPainelFormulario() {
		JPanel painel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 6));
		painel.setBorder(BorderFactory.createTitledBorder("Dados do Pet e Tutor"));

		painel.add(new JLabel("Nome:"));
		painel.add(campNome);
		painel.add(new JLabel("Raça:"));
		painel.add(campRaca);
		painel.add(new JLabel("Idade:"));
		painel.add(campIdade);
		painel.add(new JLabel("Tutor:"));
		painel.add(campNomeDono);
		painel.add(new JLabel("Telefone(Tutor):"));
		painel.add(campTelefone);

		return painel;
	}

	// ── Centro: área de texto com scroll ──────────────────
	private JScrollPane criarAreaResultado() {
		areaResultado.setEditable(false);
		areaResultado.setFont(new Font("Monospaced", Font.PLAIN, 13));
		areaResultado.setBorder(BorderFactory.createEmptyBorder(6, 8, 6, 8));
		exibirTexto("Bem-vindo ao sistema do Pet Shop!\n"
				+ "Preencha os campos acima e use os botões para gerenciar os pets.\n");
		return new JScrollPane(areaResultado);
	}

	// ── Painel Sul: botões ─────────────────────────────────
	private JPanel criarPainelBotoes() {
		JPanel painel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 8));
		painel.add(btnCadastrar);
		painel.add(btnBuscar);
		painel.add(btnAtualizar);
		painel.add(btnRemover);
		painel.add(btnListar);
		btnLimpar.setBackground(Color.red);
		painel.add(btnLimpar);
		return painel;
	}

	// ── ActionListeners ────────────────────────────────────
	private void configurarListeners() {

		// ---- CADASTRAR ----
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = campNome.getText().trim();
				String raca = campRaca.getText().trim();
				String nomeDono = campNomeDono.getText().trim();
				String telefone = campTelefone.getText().trim();

				try {

					int idade = Integer.parseInt(campIdade.getText().trim());

					if (idade < 0)
						throw new NumberFormatException();

					Cachorro novo = new Cachorro(raca, nome, idade, nomeDono, telefone);

					repositorio.adicionar(novo);
					exibirTexto("Pet cadastrado com sucesso!\n\n" + novo.exibirDados());
					limparCampos();
				} catch (NumberFormatException ex) {
					exibirTexto("ERRO: Idade deve ser inteiro e positivo.");
				}

			}
		});
		// ---- BUSCAR ----
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nome = campNome.getText().trim();
				Animal animal = repositorio.buscarPorNome(nome);

				if (animal == null) {
					exibirTexto("ERRO: O animal não foi encontrado/cadastrado");
					return;
				}
				exibirTexto("Cachorro Encontrado!\n\n" + animal.exibirDados());
				limparCampos();
			}
		});
		// ---- LIMPAR AREA ----
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparArea();
				limparCampos();
			}
		});

		// ---- ATUALIZAR ----
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exibirTexto("Você está na área de atualizações...\nInsira o nome do animal que deseja modificar. ");

//aqui ele faz a busca (aqui é a mesma coisa unica coisa do cadastrar oque mudou é que nao to guardando em variaveis os campos tlg)

				if (animalSelecionado == null) {

					String nome = campNome.getText().trim();

					animalSelecionado = repositorio.buscarPorNome(nome);

					if (animalSelecionado == null) {
						exibirTexto("ERRO: Cachorro não encontrado.");
						return;
					}
//aqui ele manda pro campo as info que ja tem 
					campIdade.setText(String.valueOf(animalSelecionado.getIdade()));
					campNomeDono.setText(animalSelecionado.getDono().getNome());
					campTelefone.setText(animalSelecionado.getDono().getTelefone());

					if (animalSelecionado instanceof Cachorro cachorro) {
						campRaca.setText(cachorro.getRaca());
					}

					exibirTexto("Animal encontrado!\n Edite os dados e clique em Atualizar novamente.");

					return;
				}
// aqui ele começa a salvar as novas info
				try {

					int novaIdade = Integer.parseInt(campIdade.getText().trim());

					if (novaIdade < 0)
						throw new NumberFormatException();

					String novoNomeDono = campNomeDono.getText().trim();
					String novoTelefone = campTelefone.getText().trim();

					animalSelecionado.renovarInfo(novaIdade, novoNomeDono, novoTelefone);

					if (animalSelecionado instanceof Cachorro cachorro) {
						cachorro.setRaca(campRaca.getText().trim());
					}

					exibirTexto("Dados atualizados com sucesso!\n\n" + animalSelecionado.exibirDados());
					animalSelecionado = null;
					limparCampos();

				} catch (NumberFormatException ex) {
					exibirTexto("ERRO: Idade inválida, digite apenas números inteiros para a idade");
				}
			}
		});

		// ---- REMOVER ----
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = campNome.getText().trim();
				if (repositorio.remover(nome) == false) {
					exibirTexto("ERRO: Cachorro não cadastrado/encontrado.");
				} else {
					exibirTexto("O cachorro foi removido com sucessso!");

				}
				limparCampos();
			}
		});

		// ---- LISTAR TODOS ----
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ListaDeTodos = "";
				for (Animal a : repositorio.listarTodos()) {
					ListaDeTodos = ListaDeTodos + "\n\n" + a.exibirDados();
				}
				exibirTexto("Aqui está a lista de todos os animais cadastrados em nosso sistema:\n" + ListaDeTodos);

			}
		});

	}

	// ── Métodos auxiliares ─────────────────────────────────

	/** Exibe texto na área de resultado, substituindo o conteúdo anterior. */
	private void exibirTexto(String texto) {
		areaResultado.setText(texto);
	}

	/** Limpa todos os campos do formulário. */
	private void limparArea() {
		exibirTexto("Bem-vindo ao sistema do Pet Shop!\n"
				+ "Preencha os campos acima e use os botões para gerenciar os pets.\n");
	}

	private void limparCampos() {
		campNome.setText("");
		campRaca.setText("");
		campIdade.setText("");
		campNomeDono.setText("");
		campTelefone.setText("");
		campNome.requestFocus();
	}

}