package com.nelioalves.cursomc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication

public class CursomcApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}


			/*@Override
	public void run(String... args) throws Exception {

		Categoria categoria1 = new Categoria(null,"imformatica");
		Categoria categoria2 = new Categoria(null,"bicicleta");

		Produto p1 = new Produto(null,"computador",2000.00);
		Produto p2 = new Produto(null,"mouse",200.00);daed

		Produto p3 = new Produto(null,"sense 2018",200.00);


		categoria1.getProdutos().addAll(Arrays.asList(p1,p2));

		categoria2.getProdutos().addAll(Arrays.asList(p3));


		p1.getCategorias().addAll(Arrays.asList(categoria1));
		p2.getCategorias().addAll(Arrays.asList(categoria1));

		p3.getCategorias().addAll(Arrays.asList(categoria2));



		categoriaRepository.saveAll(Arrays.asList(categoria1));

		produtoRepository.saveAll(Arrays.asList(categoria2));
		
		
		
	}*/

}
