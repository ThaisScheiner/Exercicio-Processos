package view;



import java.util.Scanner;

import controller.RedesController;

public class Principal 
{

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner (System.in);
		
		RedesController pCont = new RedesController();
		
		int opc = 0;
		String os = pCont.Os();
		
		System.out.println("Seu sistema operacional é: " + os + "\n");
		
		while(opc != 9)
		{
			System.out.println("1 para obter a média de PING com Google\n"
					+ "2 para listar os adaptadores (nome e IPV4)" + "\n9 para finalizar \n");
			opc = scanner.nextInt();
			
			switch(opc)
			{
				case 1:
					pCont.ping(os);
					break;
				
				case 2:
					pCont.ip(os);
					break;
				
				case 9:
					System.out.println("Finalizar aplicação");
					break;
					
				default:
					System.out.println("Opção inválida! \n");
					break;
			}	
			
		}
		
	}

}
