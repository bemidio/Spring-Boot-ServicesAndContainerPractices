package com.emidio.estoque;

import java.util.Date;
import java.util.List;

import com.emidio.estoque.entidades.Categoria;
import com.emidio.estoque.entidades.Fornecedor;
import com.emidio.estoque.entidades.Produto;
import com.emidio.estoque.services.CategoriaService;
import com.emidio.estoque.services.FornecedorService;
import com.emidio.estoque.services.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {

		return args -> {

			this.setupFornecedor();
			this.setupCategoria();
			this.setupProduto();
		};
	}

	@Autowired
	private FornecedorService fornecedorService;

	private void setupFornecedor() {

		String[][] dados = { { "Distribuiora de Bijuteria Vanessa", "Rua Editi Cardoso", "22", "São Paulo", "SP" },
				{ "Brinquedoteca da Maria", "Av Vila Ema", "2776", "São Paulo", "SP" },
				{ "Vitor Game Mania", "Rua Constantino Fusco", "295", "São Paulo", "SP" }, };

		for (int i = 0; i < dados.length; i++) {

			String[] registro = dados[i];

			Fornecedor fornecedor = new Fornecedor();
			fornecedor.setRazaoSocial(registro[0]);
			fornecedor.setEndereco(registro[1]);
			fornecedor.setNumero(registro[2]);
			fornecedor.setCidade(registro[3]);
			fornecedor.setEstado(registro[4]);
			fornecedor.setAtivo(true);
			fornecedor.setDataCriacao(new Date());
			fornecedor.setUpdateTimeStamp(new Date());

			this.fornecedorService.criarNovoFornecedor(fornecedor);
		}

		System.out.println("Fornecedores criados.");
	}

	@Autowired
	private CategoriaService categoriaService;

	private void setupCategoria() {

		Categoria categoria = new Categoria();
		categoria.setCodigo("game");
		categoria.setNome("Jogos de Video Game");

		Categoria categoria2 = new Categoria();
		categoria2.setCodigo("joias");
		categoria2.setNome("Joias e bijuterias");

		Categoria categoria3 = new Categoria();
		categoria3.setCodigo("brinc");
		categoria3.setNome("Brinquedos");

		this.categoriaService.criarNovaCategoria(categoria);
		this.categoriaService.criarNovaCategoria(categoria2);
		this.categoriaService.criarNovaCategoria(categoria3);

		System.out.println("Categorias criadas.");
	}

	private Categoria getCategoria(String codigo) {
		return this.categoriaService.obterCategoriaPorCodigo(codigo);
	}

	private Fornecedor getFornecedorPorNome(String nome) {

		List<Fornecedor> lista = this.fornecedorService.getFornecedorPorNome(nome);

		if (lista != null && lista.size() > 0) {
			return lista.get(0);
		}

		return null;

	}

	@Autowired
	private ProdutoService produtoService;

	private void setupProduto() {

		Produto produto = new Produto();
		produto.setCodigo("SM3nes");
		produto.setNome("Super Mario 3 - Super Nintendo");
		produto.setCategoria(this.getCategoria("game"));
		produto.setFornecedor(this.getFornecedorPorNome("Vitor"));

		this.produtoService.criarNovoProduto(produto);

		produto = new Produto();
		produto.setCodigo("BR-AR-G");
		produto.setNome("Brinco de argola grande felheado ouro");
		produto.setCategoria(this.getCategoria("joias"));
		produto.setFornecedor(this.getFornecedorPorNome("Vanessa"));

		this.produtoService.criarNovoProduto(produto);



		produto = new Produto();
		produto.setCodigo("BON-NEG");
		produto.setNome("Boneca Negra Mariazinha");
		produto.setCategoria(this.getCategoria("brinc"));
		produto.setFornecedor(this.getFornecedorPorNome("Maria"));

		this.produtoService.criarNovoProduto(produto);

		System.out.println("Produtos criados");
	}

}
