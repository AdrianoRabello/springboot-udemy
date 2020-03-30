package com.nelioalves.cursomc;


import com.nelioalves.cursomc.domain.*;
import com.nelioalves.cursomc.domain.enums.EstadoPagamento;
import com.nelioalves.cursomc.domain.enums.Perfil;
import com.nelioalves.cursomc.domain.enums.TipoCiente;
import com.nelioalves.cursomc.repository.ClienteRepository;
import com.nelioalves.cursomc.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;


@SpringBootApplication

public class CursomcApplication  implements CommandLineRunner {

	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	private ClienteService clienteService;

	@Autowired
	private EstadoService estadoService;

	@Autowired
	private CidadeService cidadeService;

	@Autowired
	private EnderecoService enderecoService;

	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private BCryptPasswordEncoder bc;

	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {

		Estado estado = new Estado();
		estado.setNome("Espirito santo");
		estadoService.save(estado);

		Cidade cidade = new Cidade();
		cidade.setNome("Serra");
		cidade.setEstado(estado);

		cidadeService.save(cidade);

		Cliente cliente = new Cliente();

		cliente.setNome("Adriano");
		cliente.setEmail("rabellocbmes@gmail.com");
		cliente.setTipo(TipoCiente.PESSOAFISICA);
		cliente.setCpfOuCnpj("12055673726");
		cliente.setSenha("Milk1903");
		cliente.addPerfil(Perfil.ADMIN);
		cliente.getTelefones().addAll(Arrays.asList("27992757824","996566191"));

		Cliente cliente2 = new Cliente();

		cliente2.setNome("Adriano");
		cliente2.setEmail("adrianor.rabello@hotmail.com");
		cliente2.setTipo(TipoCiente.PESSOAFISICA);
		cliente2.setCpfOuCnpj("12055673726");
		cliente2.setSenha("Milk1903");
		cliente2.getTelefones().addAll(Arrays.asList("27992757824","996566191"));

		//System.out.println("-------------------- " +clienteRepository.findByEmail("rabellocbmes@gmail.com"));

		clienteService.save(cliente);
		clienteService.save(cliente2);


		Endereco endereco = new Endereco(null,"rua das flores", "300","apto 303", "jarfim","29163566",cliente, cidade );

		enderecoService.save(endereco);


		Categoria cat1 = new Categoria(null,"Informática",true,new ArrayList<>());
		Categoria cat2 = new Categoria(null,"Cama",true,new ArrayList<>());
		Categoria cat3 = new Categoria(null,"Mesa",true,new ArrayList<>());
		Categoria cat4 = new Categoria(null,"Banho",true,new ArrayList<>());
		Categoria cat5 = new Categoria(null,"Coonsctução",true,new ArrayList<>());
		Categoria cat6 = new Categoria(null,"Comida",true,new ArrayList<>());

		categoriaService.save(cat1);
		categoriaService.save(cat2);
		categoriaService.save(cat3);
		categoriaService.save(cat4);
		categoriaService.save(cat5);
		categoriaService.save(cat6);





	}

}
