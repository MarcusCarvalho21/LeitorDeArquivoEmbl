import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.JOptionPane;

import java.io.*;

public class Embl {

	private String caminho;
	private double cds = 0;
	private double produto;
	private double produtoComGene;
	private double rrna;
	private double trna;
	
	public Embl(String caminho) {
		this.caminho = caminho;
	}
	
	public void quantidadeCDS() {
		
		BufferedReader leitura = null;
		try {
			FileReader arquivo = new FileReader(this.caminho);
			leitura = new BufferedReader(arquivo);
			String linha = "";
			
			try {
				
				linha = leitura.readLine();
				while(linha!=null) {
					if(linha.contains("  CDS  ")) {
						this.cds = this.cds + 1d;
					}

					linha = leitura.readLine();
				}
				arquivo.close();
			}catch(IOException ex) {
				ex.printStackTrace();
				System.exit(-1);
			
			}
			
		}catch(FileNotFoundException ex) {
			ex.printStackTrace();
			System.exit(-1);
		}
		
		JOptionPane.showMessageDialog(null, "Quantidade de CDS: " + this.cds);
		
	}
	
	public void quantidadeProduto() {
		
		BufferedReader leitura = null;
		try {
			FileReader arquivo = new FileReader(this.caminho);
			leitura = new BufferedReader(arquivo);
			String linha = "";
			String segundaLinha = "";
			
			try {
				
				linha = leitura.readLine();
	
				while(linha!=null) {
					if(linha.contains("/product")) {
						segundaLinha = leitura.readLine();
						if(!segundaLinha.contains("/gene")) {
							this.produto = this.produto + 1d;
						}
					}

					linha = leitura.readLine();
				}
				arquivo.close();
			}catch(IOException ex) {
				ex.printStackTrace();
				System.exit(-1);
			
			}
			
		}catch(FileNotFoundException ex) {
			ex.printStackTrace();
			System.exit(-1);
		}
		
		JOptionPane.showMessageDialog(null, "Quantidade de Produtos: " + this.produto);
		
	}
	
	public void quantidadeProdutoComGene() {
		
		BufferedReader leitura = null;
		try {
			FileReader arquivo = new FileReader(this.caminho);
			leitura = new BufferedReader(arquivo);
			String linha = "";
			String segundaLinha = "";
			
			try {
				
				linha = leitura.readLine();
	
				while(linha!=null) {
					if(linha.contains("/product")) {
						segundaLinha = leitura.readLine();
						if(segundaLinha.contains("/gene")) {
							this.produtoComGene = this.produtoComGene + 1d;
						}
					}

					linha = leitura.readLine();
				}
				arquivo.close();
			}catch(IOException ex) {
				ex.printStackTrace();
				System.exit(-1);
			
			}
			
		}catch(FileNotFoundException ex) {
			ex.printStackTrace();
			System.exit(-1);
		}
		
		JOptionPane.showMessageDialog(null, "Quantidade de Produtos com a sigla gene: " + this.produtoComGene);
		
	}
	
	public void quantidadeTRNA() {
		
		BufferedReader leitura = null;
		try {
			FileReader arquivo = new FileReader(this.caminho);
			leitura = new BufferedReader(arquivo);
			String linha = "";
			
			try {
				
				linha = leitura.readLine();
				while(linha!=null) {
					if(linha.contains("  tRNA  ")) {
						this.trna = this.trna + 1d;
					}

					linha = leitura.readLine();
				}
				arquivo.close();
			}catch(IOException ex) {
				ex.printStackTrace();
				System.exit(-1);
			
			}
			
		}catch(FileNotFoundException ex) {
			ex.printStackTrace();
			System.exit(-1);
		}
		
		JOptionPane.showMessageDialog(null, "Quantidade de tRNA: " + this.trna);
		
	}
	
	public void quantidadeRRNA() {
		
		BufferedReader leitura = null;
		try {
			FileReader arquivo = new FileReader(this.caminho);
			leitura = new BufferedReader(arquivo);
			String linha = "";
			
			try {
				
				linha = leitura.readLine();
				while(linha!=null) {
					if(linha.contains("  RNA  ")) {
						this.rrna = this.rrna + 1d;
					}

					linha = leitura.readLine();
				}
				arquivo.close();
			}catch(IOException ex) {
				ex.printStackTrace();
				System.exit(-1);
			
			}
			
		}catch(FileNotFoundException ex) {
			ex.printStackTrace();
			System.exit(-1);
		}
		JOptionPane.showMessageDialog(null, "Quantidade de rRNA: " + this.rrna);
		
	}

	public double getCds() {
		return cds;
	}

	public void setCds(double cds) {
		this.cds = cds;
	}

	public double getProduto() {
		return produto;
	}

	public void setProduto(double produto) {
		this.produto = produto;
	}

	public double getProdutoComGene() {
		return produtoComGene;
	}

	public void setProdutoComGene(double produtoComGene) {
		this.produtoComGene = produtoComGene;
	}

	public double getRrna() {
		return rrna;
	}

	public void setRrna(double rrna) {
		this.rrna = rrna;
	}

	public double getTrna() {
		return trna;
	}

	public void setTrna(double trna) {
		this.trna = trna;
	}
	
}
