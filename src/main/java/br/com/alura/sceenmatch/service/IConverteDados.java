package br.com.alura.sceenmatch.service;

public interface IConverteDados {
    <T> T obterDados(String jason, Class<T> classe);
}
