package br.com.alura.sceenmatch;

import br.com.alura.sceenmatch.model.DadosSerie;
import br.com.alura.sceenmatch.service.ConsumindoAPI;
import br.com.alura.sceenmatch.service.ConverteDados;
import br.com.alura.sceenmatch.service.IConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URLEncoder;

/*
* Éssa é uma classe que consome API´s em geral
* Neste exemplo eu estou consumindo a API do OMDB
* e retornando o resultado da busca
* */

@SpringBootApplication

//SceeMatchApplication implements CommandLineRunner faz com que a aplicação rode no terminal
public class SceenmatchApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SceenmatchApplication.class, args);
    }

    @Override
    //Método run é chamado quando a aplicação é iniciada
    public void run(String... args) throws Exception {
        var consumindoAPI = new ConsumindoAPI();

        var json = consumindoAPI.obterDados(  "https://omdbapi.com/?t=gilmore+girls&apikey=848b347e");
		System.out.println(json);

        ConverteDados conversor = new ConverteDados();

        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);

        System.out.println(dados);
    }
}