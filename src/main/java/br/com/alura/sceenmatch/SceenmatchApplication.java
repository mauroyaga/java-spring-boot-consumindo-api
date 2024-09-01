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
        * Para consumir a API do OMDB é necessário uma chave de API
        * Você pode obter uma chave de API em: http://www.omdbapi.com/apikey.aspx
        * Também pode ver a documentação da API em: http://www.omdbapi.com/
        * para obter os dados de uma série específica, basta passar o nome da série como parâmetro
        * Exemplo: http://www.omdbapi.com/?t=Friends&apikey=SUA_CHAVE_DE_API_AQUI
        *
        * */
        var json = consumindoAPI.obterDados(  "SUA CHAVE DE API AQUI");
		System.out.println(json);

        ConverteDados conversor = new ConverteDados();

        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);

        System.out.println(dados);
    }
}