import javax.swing.*;
import java.util.Scanner;

//Clase para el juego real de tres en raya
//Diseñado para que dos jugadores jueguen entre sí

public class Main {

	public static void main(String[] args) {
		new Tablero();

/*
		// Creamos un objeto Scanner para la entrada del usuario
		Scanner scanner = new Scanner(System.in);
		// mantener mover
		int m;

		if(args.length == 0){
			// comenzar un nuevo juego, tablero de visualización
			TicTacToeGame play = new TicTacToeGame();
			play.drawBoard();
			System.out.println();

			// bucle hasta que termine el juego
			do{
				// solicitar al jugador que se mueva hasta que se proporcione una entrada válida
				do{
					System.out.print("Jugador ");

					if(play.getPlayerTurn())
						System.out.print("1, ");
					else
						System.out.print("2, ");

					System.out.println();
					System.out.println();
					System.out.print("Introdusca un numero de (1-9): ");
					m = scanner.nextInt();
					System.out.println("----------------------------------------------");

				}while(!play.checkMove(m));	//movimiento válido

				// movimiento récord
				play.setMove(m);

				// mostrar el juego y las posiciones
				play.drawBoard();

			}while(!play.finished() && !play.gameWon());

			// Declarar ganador
			play.declareWinner();
		}
		else if(args.length != 2)	//uso inapropiado
		{
			System.out.println("Uso de java en el juego de TicTacToe [-c [1|2]]");
		}
		else if (args[0].equals("-c") && args[1].equals("1"))
		// La CPU va primero
		{
			// comenzar un nuevo juego, tablero de visualización
			TicTacToeGameCPU play = new TicTacToeGameCPU(true);
			play.drawBoard();

			// bucle hasta que termine el juego
			do{
				// movimientos de computadora
				play.setCPUmove();

				play.drawBoard();

				//si el juego no ha terminado
				if(!play.gameWon() && !play.finished())
				{
					// Jugador rápido para moverse
					// hasta que se proporcione una entrada válida
					do{
						System.out.print("Jugador");

						if(play.getPlayerTurn())
							System.out.print("1, ");
						else
							System.out.print("2, ");

						System.out.print("Ingrese un numero en el rango dado");
						System.out.print(" (1-9): ");
						m = scanner.nextInt();
						System.out.println();

					}while(!play.checkMove(m)); // movimiento válido

					// movimiento récord
					play.setMove(m);

					// mostrar el juego y las posiciones
					play.drawBoard();
				}

			}while(!play.finished() && !play.gameWon());

			// declarar ganador
			if(play.getPlayerTurn())
				play.declareWinner(false);
			else
				play.declareWinner(true);
		}
		else if (args[0].equals("-c") && args[1].equals("2"))
		// CPU va segundo
		{
			// comenzar un nuevo juego, tablero de visualización
			TicTacToeGameCPU play = new TicTacToeGameCPU(false);
			play.drawBoard();

			// bucle hasta que termine el juego
			do{
				// solicitar al jugador que se mueva hasta que se proporcione una entrada válida
				do{
					System.out.print("Jugador ");


					if(play.getPlayerTurn())
						System.out.print("1, ");
					else


						System.out.print("2, ");

					System.out.print("Introdusca un numero en el rango dado (1-9): ");
					m = scanner.nextInt();

					System.out.println("");


				}while(!play.checkMove(m));	// movimiento válido

				// movimiento récord
				play.setMove(m);

				// mostrar el juego y las posiciones
				play.drawBoard();

				//si el juego no ha terminado
				if(!play.gameWon() && !play.finished())
				{
					//movimientos de computadora
					play.setCPUmove();
					play.drawBoard();
				}

			}while(!play.finished() && !play.gameWon());

			// declarar ganador
			if(play.getPlayerTurn())
				play.declareWinner(true);  //la computadora gana
			else
				play.declareWinner(false); //el jugador gana
		}
		else	//uso inapropiado
		{
			System.out.println("Uso de juego en java TicTacToe [-c [1|2]]");
		}
*/
		}

	}
