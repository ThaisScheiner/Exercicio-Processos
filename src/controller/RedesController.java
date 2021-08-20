package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController 
{
	public RedesController()
	{
		super();
	}
	
	public String Os()
	{
		String os = System.getProperty("os.name"); 
			
		return os;
	}
	
	public String ping(String os)
	{
		
		double soma = 0;
		double media = 0f;
		int pct = 0;
		
		if(os.contains("Windows"))
		{
		
		try
		{
			Process p = Runtime.getRuntime().exec("ping -4 -n 10 www.google.com.br"); 
			InputStream fluxo = p.getInputStream(); 
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine(); 
			System.out.println(linha);
			
			while(linha != null)
			{
				
				if (linha.contains("tempo"))
				{
					int inicioValor = linha.indexOf("o="); 
					int finalValor = linha.indexOf("ms");

					soma += Double.parseDouble(linha.substring(inicioValor + 2, finalValor));
					pct ++;
				}

				linha = buffer.readLine();
			}

			media = soma / pct;
			
			System.out.println("O tempo médio de PING, considerando "+ pct +" pacotes enviados" + " para www.google.com.br foi de: " + media + "ms" + "\n" );
			
			buffer.close();
			leitor.close();
			fluxo.close();

				
			}
			catch(IOException e)
			{
				System.out.println(e.getMessage());
			}
		}
		
		else if(os.contains("Linux"))
		{
			try
			{
				Process p = Runtime.getRuntime().exec("ping -c 10 www.google.com.br"); 
				InputStream fluxo = p.getInputStream(); 
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine(); 
				
				System.out.println(linha);
				
				while(linha != null)
				{
					
					if (linha.contains("seq"))
					{
						int inicioValor = linha.indexOf("e="); 
						int finalValor = linha.indexOf("ms");

						soma += Double.parseDouble(linha.substring(inicioValor + 2, finalValor));
						pct ++;
					}

					linha = buffer.readLine();
				}

				media = soma / pct;
				
				System.out.println(media);
				
				buffer.close();
				leitor.close();
				fluxo.close();

				
				System.out.println("O tempo médio de PING, considerando "+ pct +" pacotes enviados" + " para www.google.com.br foi de: " + media + "ms" + "\n" );
					
				}
				catch(IOException e)
				{
					System.out.println(e.getMessage());
				}
		}
		else
		{
			System.out.println("Sistema operacional não identificado");
		}
		return os;
		
			
		}
	
	public String ip(String os)
	{
		String ipconfig = " ";
		
		if(os.contains("Windows"))
		{
	
			try
			{
				Process p = Runtime.getRuntime().exec("ipconfig"); 
				InputStream fluxo = p.getInputStream(); 
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine(); 
				System.out.println(linha);
				
				while(linha != null)
				{
					
					if (linha.contains("Ethernet"))
					{
						ipconfig += linha + "\n";
						
					}
						
					if(linha.contains("IPv4"))
					{
						
						ipconfig += linha + "\n";
					}
					
					linha = buffer.readLine();
				}
				
				buffer.close();
				leitor.close();
				fluxo.close();
				
				System.out.println(ipconfig);
				
			} 
			catch (IOException e) 
			{
				ipconfig = e.getMessage();
			}

		}
		else if (os.contains("Linux"))
		{
			
			try
			{
				Process p = Runtime.getRuntime().exec("ifconfig"); 
				InputStream fluxo = p.getInputStream(); 
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine(); 
				
				while(linha != null)
				{
					
					if (linha.contains("flags"))
					{
						ipconfig += linha + "\n";
						
					}
						
					if(linha.contains("netmask"))
					{
						
						ipconfig += linha + "\n";
					}
					System.out.println(linha);
					linha = buffer.readLine();
				}
				
				buffer.close();
				leitor.close();
				fluxo.close();
				
			} 
			catch (IOException e) 
			{
				ipconfig = e.getMessage();
			}
		}
		else
		{
			ipconfig = "Sistema operacional não encontrado";
		}
		
		return ipconfig;
	}
		
	
	}