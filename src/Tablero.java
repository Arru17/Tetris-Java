import java.util.ArrayList;
import java.util.Random;

/*Clase que representa un Tablero de Tetris
Atributos: matriz array de array de enteros que corresponden al Tablero sobre el cual se realizan las jugadas
           bloquesPresentes ArrayList de Bloques que contiene a todos los bloques posicionados sobre el Tablero
		   N entero que representa la cantidad de Filas del Tablero
		   M entero que representa la cantidad de columnas que posee el Tablero*/
public class Tablero {
    int[][] matriz;
    ArrayList<Bloque> bloquesPresentes;
    private int N;
    private int M;
	
    // Funcionalidad createBoard()
    /*Metodo con el cual se crea un objeto de la clase Tablero con todos sus atributos inicializados
	@param N entero que indica la cantidad de filas que tendra el Tablero
	@param M entero que indica la cantidad de columnas que tendra el Tablero
	@param gamePieces entero que indica la cantidad de piezas preposicionadas que tendra el Tablero
	@param seed entero con el cual se realiza el random para generar las piezas
	@return board objeto de la clase Tablero listo para jugar*/
    public Tablero Tablero(int N, int M, int gamePieces, int seed){
        Tablero board= new Tablero();
        board.matriz=new int[N][M];
        board.setN(N);
        board.setM(M);
        for(int x=0;x<N;x++){
            for(int y=0;y<M;y++){
                board.matriz[x][y]=0;
            }
        }
        Pieza piece= new Pieza();
        ArrayList<Pieza> piezasColocar=new ArrayList<>(gamePieces);
        int rand;
        for(int i=0;i<gamePieces;i++){
            rand=new Random().nextInt(seed);
            piece=piece.Pieza(rand);
            piece.correrPieza(piece, 4, N, rand);
            piezasColocar.add(piece);
        }
        while(!piezasColocar.isEmpty()){
            if(esValido(board,piezasColocar.get(0))){
                if(revisarPosiciones(board,piezasColocar.get(0))){
                    colocarPieza(board,piezasColocar.get(0));
                    piezasColocar.remove(0);
                }else{
                    piezasColocar.get(0).correrPieza(piezasColocar.get(0), 2, N, 0);
                }
            }else{
                Pieza aux = piezasColocar.get(0);
                for(int e=0;e<4;e++){
                    if(aux.getBloques()[e].getX() == 0){
                        System.out.println("No se pudieron agregar las piezas debido a que no alcanzo el espacio disponible\n");
                        return null;
                    }else if(aux.getBloques()[e].getY()== M){
                        piezasColocar.get(0).correrPieza(piezasColocar.get(0), 0, N, 0);
                        break;
                    }else{
                        break;
                    }
                }
            }
        }
        board.bloquesPresentes=new ArrayList<>();
        return board;
    }
	//Parte de la funcionalidad checkBoard()
	/*Metodo que revisa si un Tablero es valido o no a partir de distintas restricciones
	@param board es el Tablero cuya valides se quiere revisar
	@return true si el Tablero es valido, false en caso contrario*/
    public boolean checkBoard(Tablero board){
        int contFilas=0;
        if ((board.getM() >= 10) && (board.getN() >=5)){
            for(int x=0;x<board.getN();x++){
                int contColumnas=0;
                for(int y=0;y<board.getM();y++){
                    if((board.matriz[x][y] ==0) || (board.matriz[x][y] ==1)){
						contColumnas++;
                    }else{
                        return false;
                    }
                }
                if(contColumnas == board.getM()){
					contFilas++;
					
                }else{
                    return false;
                }
            }
            if(contFilas == board.getN()){
                return true;
            }else{
                return false;
            }
        }
        else{
            return false;
        }
    }
	/*Metodo que obtiene todos los bloques colocados dentro del Tablero
	@param board es el Tablero desde el cual se quiere extraer las posiciones ocupadas*/
    public void obtenerBloques(Tablero board){
        for(int x=0;x<board.getN();x++){
            for(int y=0;y<board.getM();y++){
                if(board.matriz[x][y]==1){
                    Bloque block=new Bloque();
                    block.modificarPosicion(x, y);
                    this.agregarExistente(block);
                }else{
                    
                }
            }
        }
    }
	//Parte de la funcionalidad checkBoard()
    /*Metodo que revisa el Tablero en busca de todas las filas que esten completas y las guarda en un ArrayList
	@param board Tablero del cual se busca obtener las filas completas
	@return lista ArrayList que contiene todas las posiciones de las filas completas*/
    public ArrayList<Integer> lineasCompletas(Tablero board){
        ArrayList<Integer> lista= new ArrayList<>(board.getN());
        for(int x=0;x<board.getN();x++){
            int contCol=0;
            for(int y=0;y<board.getM();y++){
                if(board.matriz[x][y]==1){
                    contCol=contCol + 1;
                }else{
                    y=board.getM();
                }
            }
            if(contCol== board.getM()){
                lista.add(x);
            }
        }
        return lista;
    }
	//Funcionalidad boardToString()
    /*Metodo que genera una representacion en String del Tablero para poder ser visto en pantalla
	@param board Tablero del cual se busca obtener la representacion en String
	@return salida String que contiene la representacion del Tablero*/
    public String boardToString(Tablero board){
        String salida="";
        for(int x=0;x<board.N;x++){
            for(int y=0;y<board.getM();y++){
                if(board.matriz[x][y] != 1){
                    salida=salida + "|0|";
                }else{
                    salida=salida + "|1|";
                }
            }
            salida= salida + "\n";
        }
        return salida;
    }
    /*Metodo que revisa si la posicion donde se busca colocar la pieza esta disponible o ocupada
	@param board Tablero de juego
	@param piece Pieza que se quiere revisar si se puede colocar o no
	@return true si la posicion esta disponible y false si la posicion no esta disponible*/
    public boolean revisarPosiciones(Tablero board, Pieza piece){
        int i;
        for(i=0;i<4;i++){
            int x=piece.bloques[i].getX();
            int y=piece.bloques[i].getY();
            if(board.matriz[x][y] == 1){
                i=10;
            }else{
            }
        }
        return i==4;
    }
	/*Metodo que coloca una pieza en la posicion correspondiente
	@param board Tablero de juego
	@param piece Pieza que se colocara*/
    public void colocarPieza(Tablero board, Pieza piece){
        for(int i=0;i<4;i++){
            int x=piece.bloques[i].getX();
            int y=piece.bloques[i].getY();
            board.matriz[x][y]=1;
        }
    }
	/*Metodo que revisa si la pieza esta dentro de los limites del Tablero para saber si se puede colocar o no
	@param board Tablero de juego
	@param piece Pieza que se revisara
	@return true si la pieza esta dentro de los limites y false si la pieza sale de los limites*/
    public boolean esValido(Tablero board, Pieza piece){
        for(int i=0;i<4;i++){
            if((piece.bloques[i].getX()<board.N) && (piece.bloques[i].getY() < board.M)){
            }else{
                return false;
            }
        }
        return true;
    }
	/*Metodo que coloca un ArrayList de Bloques uno por uno dentro del Tablero
	@param bloques ArrayList de bloques que se busca colocar dentro del Tablero*/
    public void colocarBloques(ArrayList<Bloque> bloques){
        while(!bloques.isEmpty()){
            int x=bloques.get(0).getX();
            int y=bloques.get(0).getY();
            this.matriz[x][y]=1;
            bloques.remove(0);
        }
    }
    /*Metodo con el cual se hace caer a las piezas que estan por encima de las filas borradas para que asi queden un nivel mas abajo
	@param bloques es un ArrayList de Bloques que contiene todas laspiezas presentes en el Tablero
	@param listaFilas es un ArrayList que contiene todas las filas que fueron borradas*/
    public void bajarBloques(ArrayList<Bloque> bloques, ArrayList<Integer> listaFilas){
        int largo=bloques.size();
        while(!listaFilas.isEmpty()){
            for(int i=0;i<largo;i++){
                if(bloques.get(i).getX() < listaFilas.get(0)){
                    int newX=bloques.get(i).getX();
                    bloques.get(i).setX(newX+1);
                }
            }
            listaFilas.remove(0);
        }
    }
	/*Metodo que coloca una matriz llena de ceros en el atributo matriz del Tablero*/
    public void setMatrizNula(){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                this.matriz[i][j]=0;
            }
        }
    }
	//Parte de la funcionalidad checkBoard()
	/*Metodo que borra del tablero todas las filas completas de 1s
	@param listaFilas es un ArrayList que contiene todas las posiciones de filas completas
	@param M entero que indica la cantidad de columnas que posee el Tablero*/
    public void borrarFilas(ArrayList<Integer> listaFilas, int M){
        int size=listaFilas.size();
        for(int i=0;i<size;i++){
            int fila= listaFilas.get(i);
            for(int j=0;j<M;j++){
                this.matriz[fila][j]=0;
            }
        }
    }
	/*Metodo que retorna el atributo matriz del Tablero
	  @return atributo matriz*/
    public int[][] getMatriz(){
        return this.matriz;
    }
	/*Metodo que retorna el atributo bloquesPresentes del Tablero
	  @return atributo bloquesPresentes*/
    public ArrayList<Bloque> getExistentes(){
        return this.bloquesPresentes;
    }
	/*Metodo que retorna el atributo N del Tablero
	  @return atributo N*/
    public int getN(){
        return this.N;
    }
	/*Metodo que retorna el atributo M del Tablero
	  @return atributo M*/
    public int getM(){
        return this.M;
    }
	/*Metodo que asigna el valor de matriz en el atributo matriz del Tablero
	@param matriz representa la nueva matriz del Tablero*/
    public void setMatriz(int[][] matriz){
        this.matriz=matriz;
    }
	/*Metodo que asigna el valor de blocks en el atributo bloquesPresentes del Tablero
	@param blocks representa el nuevo valor de bloquesPresentes del Tablero*/
    public void setExistentes(ArrayList<Bloque> blocks){
        this.bloquesPresentes=blocks;
    }
	/*Metodo que agrega un Bloque al atributo bloquesPresentes del Tablero
	@param block representa el nuevo Bloque del atributo*/
    public void agregarExistente(Bloque block){
        this.bloquesPresentes.add(block);
    }
	/*Metodo que asigna el valor de N en el atributo N del Tablero
	@param N representa el nuevo valos N del Tablero*/
    public void setN(int N){
        this.N=N;
    }
	/*Metodo que asigna el valor de M en el atributo M del Tablero
	@param M representa el nuevo valos M del Tablero*/
    public void setM(int M){
        this.M=M;
    }
}