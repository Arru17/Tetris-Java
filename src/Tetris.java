//Clase que representa una partida de Tetris.
//Atributos: board (Tablero de juego del tetris)
//           puntaje (puntaje acumulado durante la partida de Tetris)
public class Tetris {
    private Tablero board;
    private int puntaje;
    
    /**Metodo que crea un objeto de la Clase Tetris
	* @param N es la cantidad de filas del tablero
	  @param M es la cantidad de columnas del tablero
	  @param gamePieces es la cantidad de piezas preposicionadas en el tablero
	  @param seed es el valor con el que se le da inicio al random para obtener las piezas
	  @return tetris objeto de la clase Tetris*/
    public Tetris Tetris(int N, int M, int gamePieces, int seed){
        Tetris tetris=new Tetris();
        Tablero tab= new Tablero();
		tetris.board=new Tablero();
        tetris.board=tab.Tablero(N, M, gamePieces, seed);
        tetris.setPuntaje(0);
        return tetris;
    }
    
	/**Metodo que aumenta el puntaje de la partida en la cantidad indicada en points
	   @param points indica la cantidad de puntos que se aumentara al puntaje**/
    public void aumentarPuntaje(int points){
        int puntajeAnt= this.getPuntaje();
        int newPuntaje= puntajeAnt + points;
        setPuntaje(newPuntaje);
    }
    /**Metodo para realizar una jugada en el tablero
	   @param board tablero de juego
	   @param piece pieza a posicionar dentro del tablero
	   @param posHoriz entero que indica la posicion de la columna donde se colocara la pieza
	   @return 10 si la pieza fue colocada correctamente y 100 si es que la pieza no se puede colocar**/
    public int play(Tablero board, Pieza piece, int posHoriz){
        piece.correrPieza(piece, 5, 0, posHoriz);
        piece.correrPieza(piece, 4, board.getN(), posHoriz);
        int aux=0;
        while((aux !=10) && (aux != 100)){
            if(board.esValido(board, piece)){
                if(board.revisarPosiciones(board, piece)){
                    board.colocarPieza(board, piece);
                    aux=10;
                }else{
                    piece.correrPieza(piece, 0, 0, 0);
                }
            }else{
                aux=100;
            }
        }
        return aux;
    }
    
	/**Metodo que retorna el atributo board
	@return atributo board**/
    public Tablero getBoard(){
        return this.board;
    }
	/**Metodo que retorna el atributo puntaje
	@return atributo puntaje**/
    public int getPuntaje(){
        return this.puntaje;
    }
	/**Metodo que asigna el valor del board en el atributo board
	@param board Tablero cuyo valor asignaremos**/
    public void setBoard(Tablero board){
        this.board=board;
    }
	/**Metodo que asigna el parametro puntaje en el atributo puntaje
	@param puntaje entero cuyo valor asignaremos**/
    public void setPuntaje(int puntaje){
        this.puntaje=puntaje;
    }
}
