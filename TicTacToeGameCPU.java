import java.util.Random;

public class TicTacToeGameCPU extends TicTacToeGame  {
	
	// mantiene todos los movimientos posibles para un turno
		boolean [] moves = new boolean [9];
		
		//sostiene el tipo de movimiento de la computadora 'X' u 'O'
		char mType;
		// tipo opuesto
		char oType;
		
		
		//Constructor
		//Implementa el constructor de la clase padre
		//@param CPUfirst La CPU va primero
		
		public TicTacToeGameCPU(boolean CPUfirst){
			
			super();	// llama al constructor principal
			
			if(CPUfirst)
			{
				mType = 'X';
				oType = 'O';
			}
			else
			{
				mType = 'O';
				oType = 'X';
			}
		}
		
		
		// Método para determinar y configurar el movimiento de la CPU
		
		public void setCPUmove(){		
		
			// jugar jugada ganadora si está disponible
			winningMove(mType);

			for(int i = 0; i < 9; i++)
			{
				if(moves[i] == true)
				{
					setMove(i + 1);
					displayCPUmove(i + 1);
					resetMoves();
					return;
				}
			}

			// bloquear el juego ganador si es posible
			winningMove(oType);

			for(int i = 0; i < 9; i++)
			{
				if(moves[i] == true)
				{
					setMove(i + 1);
					displayCPUmove(i + 1);
					resetMoves();
					return;
				}
			}
		
			// establecer mover a la posición central
			if(game[1][1] == ' ')
			{
				setMove(5);
				displayCPUmove(5);
				return;
			}
		
			// elegir al azar si ninguno de los anteriores
			boolean found = false;		//posición utilizable
			Random rand = new Random();	
			int p;				//posición aleatoria

			do
			{
				//número aleatorio entre 1 y 9
				p = rand.nextInt(9) + 1;

				if(positionEmpty(p))
				{
					setMove(p);
					displayCPUmove(p);
					found = true;
				}
			}while(!found);
				
		}

		
		//Muestra un mensaje para las marcas de movimiento de la CPU.
	   // @param dM mover para mostrar.
		
		public void displayCPUmove(int dM){
			System.out.println("CPU Jugador " + dM + "."); 
			System.out.println();
		}

		
		 //Método para agregar movimientos ganadores a la matriz de movimientos.
		 //@return si el movimiento ganador está disponible.
		
		public void winningMove(char mT){
			
			// ver todas las combinaciones ganadoras disponibles
			// pasando por el centro
			if(game[1][1] == mT)
			{
				if(game[0][1] == mT && game[2][1] == ' ')
					moves[7] = true; // 8 es jugada ganadora
				if(game[2][1] == mT && game[0][1] == ' ')
					moves[1] = true; // 2
				if(game[0][2] == mT && game[1][2] == ' ')
					moves[6] = true; // 6
				if(game[2][0] == mT && game[0][2] == ' ')
					moves[2] = true; // 3
				if(game[1][2] == mT && game[1][0] == ' ')
					moves[3] = true; // 4
				if(game[1][0] == mT && game[1][2] == ' ')
					moves[5] = true; // 6
				if(game[2][2] == mT && game[0][0] == ' ')
					moves[0] = true; // 1
				if(game[0][0] == mT && game[2][2] == ' ')
					moves[8] = true; // 9
			}
			// comprobar todas las combinaciones ganadoras pasando
			// Esquina superior izquierda
			if(game[0][0] == mT)
			{
				if(game[0][1] == mT && game[0][2] == ' ')
					moves[2] = true; // 3
				if(game[0][2] == mT && game[0][1] == ' ')
					moves[1] = true; // 2
				if(game[1][0] == mT && game[2][0] == ' ')
					moves[6] = true; // 7
				if(game[2][0] == mT && game[1][0] == ' ')
					moves[3] = true; // 4
			}
			// comprobar todas las combinaciones ganadoras pasando
			// esquina izquierda inferior
			if(game[2][0] == mT)
			{
				if(game[1][0] == mT && game[0][0] == ' ')
					moves[0] = true; // 1 
				if(game[0][0] == mT && game[1][0] == ' ')
					moves[3] = true; // 4
				if(game[2][1] == mT && game[2][2] == ' ')
					moves[8] = true; // 9
				if(game[2][2] == mT && game[2][1] == ' ')
					moves[7] = true; // 8
			}
			// comprobar todas las combinaciones ganadoras pasando
			// esquina inferior derecha
			if(game[2][2] == mT)
			{
				if(game[1][2] == mT && game[0][2] == ' ')
					moves[2] = true; // 3 
				if(game[0][2] == mT && game[1][2] == ' ')
					moves[5] = true; // 6
				if(game[2][1] == mT && game[2][0] == ' ')
					moves[6] = true; // 7
				if(game[2][0] == mT && game[2][1] == ' ')
					moves[7] = true; // 8
			}
			// comprobar todas las combinaciones ganadoras pasando
			//esquina superior derecha
			if(game[0][2] == mT)
			{
				if(game[0][1] == mT && game[0][0] == ' ')
					moves[0] = true; // 1 
				if(game[0][0] == mT && game[0][1] == ' ')
					moves[1] = true; // 2
				if(game[1][2] == mT && game[2][2] == ' ')
					moves[8] = true; // 9
				if(game[2][2] == mT && game[1][2] == ' ')
					moves[5] = true; // 6
			}
			
		}
		
		
		//Restablecer mueve la matriz a valores 'nulo'.
		
		public void resetMoves(){	
			
			for(int i = 0; i < 9; i++)
			{
				moves[i] = false;
			}
		}
		
		
	    // Declara ganador del juego si hay uno, de lo contrario
		// declara un empate.
		// @param w computadora ha ganado.
		
		public void declareWinner(boolean w){
			
			// Compruebe si hay un ganador o el juego está empatado

			if(gameWon())
			{
				// Jugador 1 o 2
				if(w)
					System.out.print("Lo siento, la CPU tiene ");
				else
					System.out.print("Genial lo tienes ");

				System.out.println("Gano el juego!");
			}
			else
				System.out.println("El juego termino en un EMPATE thank!");
		}

}
