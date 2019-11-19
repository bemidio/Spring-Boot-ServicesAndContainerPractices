package com.emidio.checkinstall;

import com.emidio.checkinstall.entididade.CategoriaProdutoEnum;

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
	 public static CommandLineRunner commandLineRunner() {

		return args -> {

			CategoriaProdutoEnum aaa =  CategoriaProdutoEnum.CAMA_MESA_BANHO;

			System.out.println("o valor é " + aaa.name());
		};
	}

}
