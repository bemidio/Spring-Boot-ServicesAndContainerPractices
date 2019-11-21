package com.emidio.pedidoservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PedidoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PedidoServiceApplication.class, args);
	}

	@Value("${ambiente.execucao}")
	private String ambienteExecucao;

	@Bean
	public CommandLineRunner commandLineRunner(){
		return args ->{

			System.out.println("AMBIENTE DE EXECUÇÃO: " + this.ambienteExecucao);
		};
	}

}
