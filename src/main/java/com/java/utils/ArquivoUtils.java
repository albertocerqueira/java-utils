package com.java.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ArquivoUtils {
	
	private static ArquivoUtils instance = new ArquivoUtils();
	
	private ArquivoUtils() {}
	public static ArquivoUtils getInstance() {
		return instance;
	}
	
	public void download(String link, String pasta, String nome) throws IOException {
		URL url = new URL(link);
		
		// URLConnection conn = url.openConnection();
		// String contentType = conn.getContentType();
		// System.out.println(contentType);
		
		BufferedInputStream in = new BufferedInputStream(url.openStream());
		OutputStream out = new BufferedOutputStream(new FileOutputStream(pasta + nome));
		
		for ( int i; (i = in.read()) != -1; ) {
		    out.write(i);
		}
		
		in.close();
		out.close();
	}
	
	public String carregarTexto(String pasta, String arquivo) throws IOException {
		File file  = new File(pasta + arquivo);
		FileReader fileReader = new FileReader(file);
		BufferedReader reader = new BufferedReader(fileReader);
		
		String linha = null;
		StringBuilder linhas = new StringBuilder();
		while ((linha = reader.readLine()) != null) {
			linhas.append(linha);
		}
		
		fileReader.close();
		reader.close();
		return linhas.toString();
	}
	
	public List<String> carregarLinhasDoArquivoTexto(String pasta, String arquivo) throws IOException {
		File file  = new File(pasta + arquivo);
		FileReader fileReader = new FileReader(file);
		BufferedReader reader = new BufferedReader(fileReader);
		
		String linha = null;
		List<String> linhas = new ArrayList<String>();
		while ((linha = reader.readLine()) != null) {
			linhas.add(linha);
		}
		
		fileReader.close();
		reader.close();
		return linhas;
	}
	
	public void gravarLinhaNoArquivoTexto(String pasta, String arquivo, String linha) throws IOException {
		List<String> linhas = carregarLinhasDoArquivoTexto(pasta, arquivo);

		File file = new File(pasta + arquivo);
		FileWriter fileWriter = new FileWriter(file);
		PrintWriter printWriter = new PrintWriter(fileWriter);

		for (String l : linhas) {
			printWriter.printf(l + "\n");
		}

		printWriter.printf(linha);

		fileWriter.close();
		printWriter.close();
	}
	
	public List<String> pegarArquivosNaPasta(String caminhoDaPasta, String regex) {
		final File pasta = new File(caminhoDaPasta);
		
		List<String> arquivos = new ArrayList<String>();
		for (final File arquivo : pasta.listFiles()) {
            if (arquivo.isDirectory()) {
            	pegarArquivosNaPasta(arquivo.getPath(), regex);
            }
            
            if (arquivo.isFile()) {
                if (arquivo.getName().matches(regex)) {
                    arquivos.add(arquivo.getAbsolutePath());
                }
            }
        }
		return arquivos;
	}
}