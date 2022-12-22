 public class TicTacToeGame {
	
	//Construido para que un jugador sea una CPU


	// tiene X y O para poder jugar
	protected char [][] game = new char [3][3];

	// verdadero si es el turno del jugador 1
	protected boolean p1Turn;

	
	// Constructor
	// Establezca todos los valores a bordo en ' ' y
	// establece al jugador uno para comenzar.
	
	public TicTacToeGame()
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				game[i][j] = ' ';
			}
		}

		p1Turn = true;
	}

	
	//Dibuja el tablero de juego y el tablero que muestra los números de posición.

	public void drawBoard(){
		System.out.println("Juego de Mesa:            Posiciones:");
		System.out.println();
		
		int p  = 1;	// número de posición

		for( int i = 0; i < 3; i++)
		// recorrer filas
		{
			for(int j = 0; j < 3; j++)
			// imprimir fila de juego a bordo
			{
				System.out.print(" " + game[i][j] + " ");
				if(j < 2)
					System.out.print("|");
			}
			
			System.out.print("               ");

			for(int j = 0; j < 3; j++)
			// imprimir fila de posición 
			{
				System.out.print(" " + p + " ");
				p++;

				if(j < 2)
					System.out.print("|");
			}
	
			System.out.println();			
			
			if(i < 2)
			// imprimir divisores de fila
			{
				System.out.print("-----------");
				System.out.print("               ");
				System.out.println("-----------");
			}

		}
	}

	
	// Verifique si el movimiento es válido y luego establece el movimiento
	// si esto es.
	// @param mueve la posición en la que el usuario quiere hacer el movimiento.
	// @return si el movimiento se registra o no.
	
	public boolean checkMove(int move){
		// solo las posiciones del  1-9 son válidas
		if(move < 1 || move > 9)
		{
			System.out.println("ERROR: entra invalida!");
			return false;
		}
	
		// la posición no está vacía
		if(!positionEmpty(move))
		{
			System.out.println("ERROR: posicion ya ocupado");
			return false;
		}
		
		//la posición está vacía
		return true;
	}

	
	 //Compruebe si la posición está vacía.
	 //@param p siendo verificado
	
	public boolean positionEmpty(int move)
	{
		// comprobar si la posición está vacía
		boolean empty = true;
		switch (move){
			case 1: 
				if( game[0][0] != ' ' )
					empty = false;
				break;
			case 2: 
				if( game[0][1] != ' ' )
					empty = false;
				break;
			case 3: 
				if( game[0][2] != ' ' )
					empty = false;
				break;
			case 4: 
				if( game[1][0] != ' ' )
					empty = false;
				break;
			case 5: 
				if( game[1][1] != ' ' )
					empty = false;
				break;
			case 6: 
				if( game[1][2] != ' ' )
					empty = false;
				break;
			case 7: 
				if( game[2][0] != ' ' )
					empty = false;
				break;
			case 8: 
				if( game[2][1] != ' ' )
					empty = false;
				break;
			case 9: 
				if( game[2][2] != ' ' )
					empty = false;
				break;
		}
		
		return empty;	
	}

	
	//Método para establecer el movimiento.
   // @param move movimiento que se está grabando.
	
	public void setMove(int move){
		
		char m;	// retiene el tipo de movimiento que se agrega
		
		if(p1Turn)
			m = 'X';
		else
			m = 'O';

		// sets move
		switch (move){
			case 1: game[0][0] = m;
				break;
			case 2: game[0][1] = m;
				break;
			case 3: game[0][2] = m;
				break;
			case 4: game[1][0] = m;
				break;
			case 5: game[1][1] = m;
				break;
			case 6: game[1][2] = m;
				break;
			case 7: game[2][0] = m;
				break;
			case 8: game[2][1] = m;
				break;
			case 9: game[2][2] = m;
				break;
		}

		// cambia el turno de juego
		p1Turn ^= true;	
	}

	//Método para comprobar si el juego está completo.
	public boolean finished(){
		
		// recorrer todas las posiciones del juego
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				// posición vacía
				if(game[i][j] == ' ')
					return false;
			}
		}

		return true;
	}

	
	//Método accesorio para determinar el turno del jugador.
	//@return si es el turno del jugador 1.
	
	public boolean getPlayerTurn()
		{ return p1Turn; }

	
	//Método para comprobar si se gana el juego
	
	public boolean gameWon(){

		char m = 'X';	// jugador 1

		//bucle una vez para cada jugador(un turno de juego)
		for(int i = 0; i < 2; i++)
		{
			// comprobar todas las combinaciones ganadoras
			// pasando por el centro
			if(game[1][1] == m)
			{
				if(game[0][1] == m && game[2][1] == m)
					return true;	// columna central
				if(game[0][2] == m && game[2][0] == m)
					return true;	// /
				if(game[1][2] == m && game[1][0] == m)
					return true;	// fila central
				if(game[2][2] == m && game[0][0] == m)
					return true;	// \
			}
			// comprobar todas las combinaciones ganadoras pasando
			//Esquina superior izquierda
			if(game[0][0] == m)
			{
				if(game[0][1] == m && game[0][2] == m)
					return true;	// top row
				if(game[1][0] == m && game[2][0] == m)
					return true;	// left column
			}
			// comprobar todas las combinaciones ganadoras pasando
			// esquina inferior derecha
			if(game[2][2] == m)
			{
				if(game[1][2] == m && game[0][2] == m)
					return true;	// columna derecha
				if(game[2][1] == m && game[2][0] == m)
					return true;	// fila inferior
			}

			m = 'O';	//Cambiar al jugador 2
		}

		// no se encontró ganador
		return false;
	}

	
	//Declara ganador del juego si hay uno, de lo contrario.
	 //declara un empate.
	
	public void declareWinner(){
		
		// Compruebe si hay un ganador o el juego está empatado
		
		if(gameWon())
		{
			System.out.print("Jugador ");

			// Jugador 1 o 2
			if(!p1Turn) //p1Turn representa el turno del jugador humano

				System.out.print("1 ");
			else
				System.out.print("2 ");

			System.out.println("Felicitaciones Ud. Gano el juego!");
		}
		else
			System.out.println("El juego termo en un EMPATE Thanks!");
	}
}




