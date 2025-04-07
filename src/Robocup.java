import java.util.Scanner;

public class Robocup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner teclado = new Scanner (System.in);
		int quantidadeEquipes, quantidadeCombates;
		int somaPontos;
		String resultado;
		int aux, aux2, aux3;
		boolean numeroRepetido;
		System.out.print("Quantidade de Equipes --> ");
		quantidadeEquipes = teclado.nextInt();
		
		int[] numeroEquipes = new int[quantidadeEquipes];
		int[] pontoTotal = new int[quantidadeEquipes];
		int[] notaDesign = new int[quantidadeEquipes];
		
		//Cadastro de número das equipes
		for(int i = 0; i < numeroEquipes.length; i++) {
			numeroRepetido = false;
			
			while (numeroEquipes[i] < 11 || numeroEquipes[i] > 99 || numeroRepetido == true) {
				numeroRepetido = false;
				System.out.print("Numero de identificação da equipe " + (i+1) + " --> ");
				numeroEquipes[i] = teclado.nextInt();
				for (int j = 0; j < i; j++) {
					if(numeroEquipes[i] == numeroEquipes[j]) {
						numeroRepetido = true;
					}
				}
				if (numeroEquipes[i] < 11 || numeroEquipes[i] > 99) {
					System.out.println("Numero inválido");
				}
				else if(numeroRepetido == true) {
					System.out.println("Número existente");
				}
	
			}
		}
		
		//Ordenação dos números das Equipes
		for (int i = 0; i < numeroEquipes.length; i++) {
			for (int j = 0; j < numeroEquipes.length - 1; j++) {
				if (numeroEquipes[j] > numeroEquipes[j+1]) {
					aux = numeroEquipes[j];
					numeroEquipes[j] = numeroEquipes[j+1];
					numeroEquipes[j+1] = aux;
				}
			}
		}
		
		//Entrada para informar quantidade de combates
		System.out.print("Quantidade de combates --> ");
		quantidadeCombates = teclado.nextInt();
		
		
		for (int i = 0; i < numeroEquipes.length; i++) {
			somaPontos = 0;
			for (int j = 0; j < quantidadeCombates; j++) {
				System.out.println("Resultado do combate " + (j+1) + " da Equipe " + numeroEquipes[i]);
				System.out.print("Digite somente V, D ou E --> ");
				resultado = teclado.next();
				if (resultado.equalsIgnoreCase("V")) {
					somaPontos += 5;
				}
				else if (resultado.equalsIgnoreCase("E")) {
					somaPontos += 3;
				}
				else if (resultado.equalsIgnoreCase("D")) {
					
				}
			}
			System.out.println("Pontuação da Equipe " + numeroEquipes[i] + " : " + somaPontos + " pontos");
			//Armazenamento do total de pontos de cada equipe
			pontoTotal[i] = somaPontos;
			
			System.out.print("Nota de design da Equipe " + numeroEquipes[i] + " : ");
			notaDesign[i] = teclado.nextInt();
		}
		
		for (int i = 0; i < numeroEquipes.length; i++) {
			for (int j = 0; j < numeroEquipes.length - 1; j++) {
				if(pontoTotal[j] < pontoTotal[j+1]) {
					aux = pontoTotal[j+1];
					pontoTotal[j+1] = pontoTotal[j];
					pontoTotal[j] = aux;
					aux2 = notaDesign[j+1];
					notaDesign[j+1] = notaDesign[j];
					notaDesign[j] = aux2;
					aux3 = numeroEquipes[j+1];
					numeroEquipes[j+1] = numeroEquipes[j];
					numeroEquipes[j] = aux3;
				}
				if(pontoTotal[j] == pontoTotal[j+1]) {
					if(notaDesign[j] < notaDesign[j+1]) {
						aux = pontoTotal[j+1];
						pontoTotal[j+1] = pontoTotal[j];
						pontoTotal[j] = aux;
						aux2 = notaDesign[j+1];
						notaDesign[j+1] = notaDesign[j];
						notaDesign[j] = aux2;
						aux3 = numeroEquipes[j+1];
						numeroEquipes[j+1] = numeroEquipes[j];
						numeroEquipes[j] = aux3;
					}
				}
			}
		}
		System.out.println("-------x-------Classificação das Equipes-------x-------");
		System.out.println();
		for (int i = 0; i < quantidadeEquipes; i++) {
			System.out.println("Equipe " + (numeroEquipes[i]) + " --> " + pontoTotal[i] + " pontos");
		}
	}

}
