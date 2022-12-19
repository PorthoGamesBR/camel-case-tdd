package camel_case;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TesteCamelCase {
	
	private CamelCase camel;
	
	@BeforeEach
	public void inicializaCamel()
	{
		camel = new CamelCase();
	}
	
	@Test
	public void iniciaClasse() {
		/*
		 * Teste "iniciaClasse" para ver se a classe para tratar camelcase existe e está iniciando normalmente
		 * Antes:
		 * Depois:
		 * public class CamelCase {

}
		 * Foi criada a classe CamelCase
		 */
		
		assertFalse(camel == null);
	}
	
	@Test
	public void retornaLista() {
		/*
		 * Teste "retornaLista" para ver se a função retorna uma lista
		 * Antes:
		 * public class CamelCase {

}
		 * Depois:
		 * public class CamelCase {

	public List converterCamelCase(String string) {
		List l = new ArrayList();
		return l;
	}

}
		 * Foi criada a função converterCamelCase, que recebe uma string como argumento e deve retornar uma lista.
		 */
		assertTrue(camel.converterCamelCase("abc") instanceof List);
	}
	
	@Test
	public void conteudoLista() {
		/*
		 * Teste "conteudoLista" para ver se a lista retornada não está vazia
		 * Antes:
		 *
	public List converterCamelCase(String string) {
		List l = new ArrayList();
		return l;
	}
		 * Depois:
		 * 	public List converterCamelCase(String string) {
		List l = new ArrayList();
		l.add(1);
		return l;
	}
		 * Agora a função converterCamelCase retorna uma Lista com conteúdo
		 */
		List<String> l = camel.converterCamelCase("abc");
		assertFalse(l.isEmpty());
	}
	
	@Test
	public void listaDeStrings()
	{
		/*
		 * Teste "listaDeStrings" para ver se a lista retornada é uma lista de strings
		 * Antes:
		 * public List converterCamelCase(String string) {
		List l = new ArrayList();
		l.add(1);
		return l;
	}
		 * Depois:
		 * public List converterCamelCase(String string) {
		List l = new ArrayList();
		l.add(string);
		return l;
	}
		 * Agora a lista retornada da função contém apenas strings
		 */
		
		List<String> l = camel.converterCamelCase("abc");
		for (int i = 0; i < l.size(); i++)
		{
			assertTrue(l.get(i) instanceof String);
		}
		
	}
	
	@Test
	public void separaPalavras()
	{
		/*
		 * Teste "separaPalavras" para testar se a função "separaMaiuscula" retorna as palavras separadas pelas suas letras maiúsculas
		 * Antes:
		 * public class CamelCase {

		 public List converterCamelCase(String string) {
		List l = new ArrayList();
		l.add(string);
		return l;
	}
}
		 * Depois:
		 * public class CamelCase {

	public List converterCamelCase(String string) {
		List l = new ArrayList();
		l.add(string);
		return l;
	}

	public String[] separaMaiscula(String string) {
		String[] palavras = string.split("(?=\\p{Lu})");
		return palavras;
	}

}
		 * Criamos a função que retorna uma array de palavras separadas por letras maiúsculas e testamos com dois casos diferentes
		 */
		String[] separadas = camel.separaMaiscula("helloWorld");
		assertFalse(separadas.length == 0);
		assertEquals("hello", separadas[0]);
		assertEquals("World", separadas[1]);
		separadas = camel.separaMaiscula("helloMyBabyHelloMyMama");
		assertEquals("hello", separadas[0]);
		assertEquals("Mama", separadas[separadas.length-1]);
		assertEquals("Baby", separadas[2]);
	}
	
	@Test
	public void retornaPrimeiraMinuscula()
	{
		/*
		 * Teste "retornaPrimeiraMinuscula" para a função "formatarPalavra" retornar palavras que comecem com letra minuscula ou maiuscula como totalmente minusculas
		 * Antes: 
		 * public String[] separaMaiscula(String string) {
		String[] palavras = string.split("(?=\\p{Lu})");
		return palavras;
	}

}
		 * Depois:
		 * public String[] separaMaiscula(String string) {
		String[] palavras = string.split("(?=\\p{Lu})");
		return palavras;
	}

	public String formatarPalavra(String string) {
		return string.substring(0,1).toLowerCase() + string.substring(1);
	}

}
		 * Criamos a função formatarPalavra, que retorna uma string diminuindo a primeira letra de uma palavra
		 */
		assertEquals("hello",camel.formatarPalavra("hello"));
		assertEquals("hello",camel.formatarPalavra("Hello"));
	}
	
	@Test
	public void retornaPalavraMaiscula()
	{
		/*
		 * Teste "retornaPalavraMaiscula" para a função "formatarPalavra" retornar palavras que sejam completamente maisculas iguais
		 * Antes: 
		 * public String formatarPalavra(String string) {
		return string.substring(0,1).toLowerCase() + string.substring(1);
	}

		 * Depois:
		 * public String formatarPalavra(String string) {
		for(int i=0; i < string.length(); i++){
            
         if( !Character.isUpperCase( string.charAt(i)))
        	 return string.substring(0,1).toLowerCase() + string.substring(1);
        }
		return string;
	}
		 * Agora a função vai checar se algum caractere daquela palavra é em letras minúsculas, e se nenhum for, só retorna a string.
		 */
		
		assertEquals("CPF",camel.formatarPalavra("CPF"));
		assertEquals("cpf",camel.formatarPalavra("Cpf"));
		
	}
	
	@Test
	public void separaPalavraMaiuscula()
	{
		/*
		 * Teste "separaPalavraMaiscula" para a função "separaMaiuscula" retornar como palavras 3 ou mais caracteres que estejam todos em maiúsculo
		 * Antes: 
		 * public String[] separaMaiscula(String string) {
		String[] palavras = string.split("(?=\\p{Lu})");
		return palavras;
	}
		 * Depois:
		 * public String[] separaMaiscula(String string) {
		String[] palavras = string.split("(?=\\p{Lu})");
		List<String> subarray = new ArrayList<>();
		for (int i = 0; i < palavras.length; i++)
		{
			if (palavras[i].length() < 2)
			{
				while((i < palavras.length-1) && (palavras[i+1].length() < 2))
				{
					palavras[i+1] = palavras[i] + palavras[i+1];
					i++;
				}
			}
			subarray.add(palavras[i]);
			
		}
		return subarray.toArray(new String[0]);
	}
		 * Agora a função vai checar por letras maiusculas separadas e uni-las para fazer palavras inteiras
		 */
		String[] separadas = camel.separaMaiscula("CPF");
		assertEquals("CPF",separadas[0]);
		separadas = camel.separaMaiscula("seuCPFPorFavor");
		assertEquals("seu",separadas[0]);
		assertEquals("CPF",separadas[1]);
		assertEquals("Por",separadas[2]);
		assertEquals("Favor",separadas[3]);
		separadas = camel.separaMaiscula("PorFavorCPF");
		assertEquals("CPF",separadas[2]);
	}
	
	@Test
	public void umCharEMesmoTipo()
	{
		/*
		 * Teste "umCharEMesmoTipo" para a função "charETipo" retornar verdadeiro caso a string seja apenas um caractere e do mesmo tipo que o indicado (Numerico ou não)
		 * Antes: 
		 * 	return l;
	}
	

	public String[] separaMaiscula(String string) {
		String[] palavras = string.split("(?=\\p{Lu})");
		 * Depois:
		 * 	return l;
	}
	
	public boolean charETipo(String string, boolean isNumeric) {
		return (string.length() < 2) && (isNumeric == Character.isDigit(string.charAt(0)));
	}

	public String[] separaMaiscula(String string) {
		String[] palavras = string.split("(?=\\p{Lu})");
		 * Criamos a função que retorna true caso a string seja de um caracter e do tipo especificado
		 */
		
		assertTrue(camel.charETipo("A",false));
		assertTrue(camel.charETipo("1",true));
		assertFalse(camel.charETipo("AB",false));
		assertFalse(camel.charETipo("12",true));
		assertFalse(camel.charETipo("A",true));
		assertFalse(camel.charETipo("1",false));
	}
	
	@Test
	public void separaNumeros()
	{
		/*
		 * Teste "separaNumeros" para a função "separaMaiscula" retornar os numeros separados como palavras
		 * Antes: 
		 * public String[] separaMaiscula(String string) {
		String[] palavras = string.split("(?=\\p{Lu})");
		List<String> subarray = new ArrayList<>();
		for (int i = 0; i < palavras.length; i++)
		{
			if (palavras[i].length() < 2)
			{
				while((i < palavras.length-1) && (palavras[i+1].length() < 2))
				{
					palavras[i+1] = palavras[i] + palavras[i+1];
					i++;
				}
			}
			subarray.add(palavras[i]);
			
		}
		return subarray.toArray(new String[0]);
	}
		 * Depois:
		 * String[] palavras = string.split("(?=[\\p{Lu}\\d])");
		List<String> subarray = new ArrayList<>();
		for (int i = 0; i < palavras.length; i++)
		{
			if (palavras[i].length() < 2)
			{
				boolean isNumeric = Character.isDigit(palavras[i].charAt(0));
				while((i < palavras.length-1) && charETipo(palavras[i+1],isNumeric))
				{
					palavras[i+1] = palavras[i] + palavras[i+1];
					i++;
				}
			}
			subarray.add(palavras[i]);
			
		}
		return subarray.toArray(new String[0]);
		 * Agora a função também separa caracteres numéricos como se fossem letras maiúsculas, que depois são unidas em uma palavra só
		 */
		
		String[] separadas = camel.separaMaiscula("pedidoNumero4058ChegouE40Com8Chegaram");
		assertEquals("4058",separadas[2]);
		assertEquals("40",separadas[5]);
		assertEquals("8",separadas[7]);
	}
	
	@Test
	public void erroSeComecarNumero()
	{
		/*
		 * Teste "erroSeComecarNumero" para a função converterCamelCase dar erro caso a string comece com um caracter numerico
		 * Antes: 
		 * public List converterCamelCase(String string) {
			List l = new ArrayList();
			l.add(string);
			return l;
		}
		 * Depois:
		 * CamelCase.java:
		 * public List converterCamelCase(String string) {
		List l = new ArrayList();
		if (Character.isDigit(string.charAt(0)))
			throw new FormatacaoErrada("String começa com caracter numérico");
		l.add(string);
		return l;
	}
		 * FormatacaoErrada.java (NOVO)
		 * public class FormatacaoErrada extends RuntimeException {
	
	public FormatacaoErrada(String message)
	{
		super(message);
	}

	private static final long serialVersionUID = 1L;

}
		 * A classe de erro foi criada e foi adicionada uma checagem na função converterCamelCase para lançar esse erro
		 */
		
		assertThrows(FormatacaoErrada.class, () -> camel.converterCamelCase("10HelloWorld"));
	}
	
	@Test
	public void erroSeTiverEspecial()
	{
		/*
		 * Teste "erroSeTiverEspecial" para a função converterCamelCase dar erro caso a string tenha caracter especial
		 * Antes: 
		 * public List converterCamelCase(String string) {
		List l = new ArrayList();
		if (Character.isDigit(string.charAt(0)))
			throw new FormatacaoErrada("String começa com caracter numérico");
		l.add(string);
		return l;
	}
		 * Depois:
		 * public List converterCamelCase(String string) {
		List l = new ArrayList();
		if (Character.isDigit(string.charAt(0)))
			throw new FormatacaoErrada("String começa com caracter numérico");
		if(string.matches(".*[^A-Za-z0-9].*"))
			throw new FormatacaoErrada("String tem caracteres não alfanuméricos");
		l.add(string);
		return l;
	}
		 * Foi adicionada uma checagem na função converterCamelCase para lançar o erro caso a string contenha algum caracter que não seja alfanumerico
		 */
		assertThrows(FormatacaoErrada.class, () -> camel.converterCamelCase("#HelloWorld"));
		assertThrows(FormatacaoErrada.class, () -> camel.converterCamelCase("Hello@World"));
		assertThrows(FormatacaoErrada.class, () -> camel.converterCamelCase("HelloWor~ld"));
	}
	
	@Test
	public void converteCamelCase()
	{
		/*
		 * Teste "converteCamelCase" para a função converterCamelCase retornar lista de palavras separadas de uma string em camelcase
		 * Antes: 
		 * public List converterCamelCase(String string) {
		List l = new ArrayList();
		if (Character.isDigit(string.charAt(0)))
			throw new FormatacaoErrada("String começa com caracter numérico");
		if(string.matches(".*[^A-Za-z0-9].*"))
			throw new FormatacaoErrada("String tem caracteres não alfanuméricos");
		l.add(string);
		return l;
	}
		 * Depois:
		 * public List converterCamelCase(String string) {
		List l = new ArrayList();
		if (Character.isDigit(string.charAt(0)))
			throw new FormatacaoErrada("String começa com caracter numérico");
		if(string.matches(".*[^A-Za-z0-9].*"))
			throw new FormatacaoErrada("String tem caracteres não alfanuméricos");
		String[] palavras = separaMaiscula(string);
		for (String p : palavras)
		{
			l.add(formatarPalavra(p));
		}
		return l;
	}
		 * Finalmente introduzimos os outros métodos a função principal
		 */
		
		List<String> separadas = camel.converterCamelCase("nome");
		assertEquals(separadas.get(0),"nome");
		separadas = camel.converterCamelCase("Nome");
		assertEquals("nome",separadas.get(0));
		separadas = camel.converterCamelCase("CPF");
		assertEquals("CPF",separadas.get(0));
		separadas = camel.converterCamelCase("nomeComposto");
		List<String> resposta = Arrays.asList("nome","composto");
		assertLinesMatch(resposta,separadas);
		separadas = camel.converterCamelCase("NomeComposto");
		assertLinesMatch(resposta,separadas);
		separadas = camel.converterCamelCase("numeroCPF");
		resposta = Arrays.asList("numero","CPF");
		assertLinesMatch(resposta,separadas);
		separadas = camel.converterCamelCase("numeroCPFContribuinte");
		resposta = Arrays.asList("numero","CPF","contribuinte");
		assertLinesMatch(resposta,separadas);
		separadas = camel.converterCamelCase("recupera10Primeiros");
		resposta = Arrays.asList("recupera","10","primeiros");
		assertLinesMatch(resposta,separadas);
		
	}
	

}
