package com.nelioalves.cursomc;


import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.domain.enums.Perfil;
import com.nelioalves.cursomc.domain.enums.TipoCiente;
import com.nelioalves.cursomc.repository.ClienteRepository;
import com.nelioalves.cursomc.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication

public class CursomcApplication  implements CommandLineRunner {

	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	private ClienteService clienteService;

	@Autowired
	private BCryptPasswordEncoder bc;

	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {

		Cliente cliente = new Cliente();

		cliente.setNome("Adriano");
		cliente.setEmail("rabellocbmes@gmail.com");
		cliente.setTipo(TipoCiente.PESSOAFISICA);
		cliente.setCpfOuCnpj("12055673726");
		cliente.setSenha(bc.encode("Milk1903"));
		cliente.addPerfil(Perfil.ADMIN);

		//System.out.println("-------------------- " +clienteRepository.findByEmail("rabellocbmes@gmail.com"));

		//clienteService.save(cliente);
		
	}

}
