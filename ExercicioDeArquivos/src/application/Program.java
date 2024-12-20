package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.entities.Produto;

public class Program {

	public static void main(String[] args) {
		
		List<Produto> listaDeProdutos = new ArrayList<Produto>();
		
		// Ler arquivo e instanciar os produtos com o preço e quantidade
		
		String caminhoDoAquivoTxt = "C:\\Users\\JoãoVitorDuarteSanto\\Documents\\Estudos\\ExercicioDeArquivos\\Produtos.txt";
		File arquivoTxt = new File(caminhoDoAquivoTxt); // arquivo criado a partir do caminho que foi passado
		
		try (BufferedReader lerArquivoTxt = new BufferedReader(new FileReader(arquivoTxt))){ // aqui ele recebe o arquivo e fica pronto para ser lido pelo "BufferedReader"
			
			String lerLinhaDoArquivoTxt = lerArquivoTxt.readLine(); // vai ler linha por linha do arquivo 
			while (lerLinhaDoArquivoTxt != null) {
				
				String[] itensSeparados = lerLinhaDoArquivoTxt.split(","); // separando os itens por virgula
				String nomeDoproduto = itensSeparados[0];
				double valor = Double.parseDouble(itensSeparados[1]);
				int quantidade = Integer.parseInt(itensSeparados[2]);
						
				Produto produto = new Produto(nomeDoproduto, valor, quantidade);
				listaDeProdutos.add(produto);
				
				lerLinhaDoArquivoTxt = lerArquivoTxt.readLine();
			}
		} 
		catch (IOException e) {
			System.out.println("Erro ao ler arquivo e instanciar\n");
			e.printStackTrace();
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Erro ao ler arquivo e instanciar\n");
			e.printStackTrace();
		}
		
		// Criar caminho da pasta onde irá receber o arquivo csv
		
		String caminhoDaPasta = "C:\\Users\\JoãoVitorDuarteSanto\\Documents\\Estudos\\ExercicioDeArquivos\\";
		boolean criacaoDaPasta =  new File(caminhoDaPasta + "\\PastaCSV_CriadoPorMim").mkdir(); // "mkdir" cria uma nova pasta para colocar o arquivo lá dentro
		
		if(criacaoDaPasta == true) {
			System.out.println("Pasta criada com sucesso!");
		}
		else {
			System.out.println("Não foi possível criar a pasta.");
		}
	
		// Criar o novo arquivo(.csv) com o produto e o preço total(quantidade * valor)
		
		String caminhoParaCriacaoDoArquivo = "C:\\Users\\JoãoVitorDuarteSanto\\Documents\\Estudos\\ExercicioDeArquivos\\PastaCSV_CriadoPorMim\\";
		File arquivoCSV = new File(caminhoParaCriacaoDoArquivo + "\\produtoCSV_criadoPorMim.csv"); // criando o arquivo no caminho especificado e com nome que coloquei no argumento
		
		try(BufferedWriter criarArquivoCSV = new BufferedWriter(new FileWriter(arquivoCSV))){
			
			for(Produto produto : listaDeProdutos) { // vai passar por cada produto e escrever no arquivo conforme os comandos abaixo
				criarArquivoCSV.write(produto.getNomeDoProduto() + "," + produto.valorTotal()); // escrevendo apenas o nome e o valor total(método da classe "Produto")
				criarArquivoCSV.newLine();
			}
			System.out.println("Arquivo criada com sucesso");
		}
		catch (IOException e) {
			System.out.println("Erro ao criar arquivo CSV e escrever no documento.");
			e.printStackTrace();
		}
	}

}
