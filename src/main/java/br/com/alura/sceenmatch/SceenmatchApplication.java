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

        /*
         * O conimingAPI.obterDados é um método que recebe uma url que contém a chave de acesso
         * para consumir a API do OMDB. Extistem alguns parametro que podem ser passados na url
         * da requisição, como por exemplo o nome do filme que deseja buscar:
         * Ex: https://omdbapi.com/?t=gilmore+girls&apikey=SUA-CHAVE-DE-ACESSO
         *
         * Link para a home da api: https://www.omdbapi.com/
         * Lá voce pode fazer um cadastro rápido e obter a chave de acesso,
         * além de ver a documentação da API par entender os tipos de
         * requisições que podem ser feitas.
         * */

        var json = consumindoAPI.obterDados("Sua url da requisição com a chave de acesso");
        System.out.println(json);

        ConverteDados conversor = new ConverteDados();

        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);

        System.out.println(dados);
    }
}