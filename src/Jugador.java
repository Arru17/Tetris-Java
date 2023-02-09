/*Clase que representa a un Jugador y todos sus atributos
  Atributos: nickname representa el alias del Jugador
             clave representa la contraseña del Jugador
			 masAltos representa los 3 puntajes mas altos del Jugador
			 cantPartidas representa la cantidad de partidas jugadas por el Jugador
			 numeroLineas representa la cantidad de lineas borradas por el Jugador
			 tetris representa la partida actual que pueda estar jugadno el Jugador*/
public class Jugador {
    String nickname;
    String clave;
    int[] masAltos;
    int cantPartidas;
    int numeroLineas;
    Tetris tetris;
    
	/*Metodo que crea un objeto de la Clase Jugador contodos sus atributos inicializados
	 @param nick String que corresponde al alias del Jugador
	 @param clave String que corresponde a la clave del Jugador
	 @return player objeto de la Clase Jugador	 */
    public Jugador Jugador(String nick, String clave){
        Jugador player= new Jugador();
        player.setNick(nick);
        player.setPass(clave);
        player.masAltos=new int[3];
        for(int i=0;i<3;i++){
            player.masAltos[i]=0;
        }
        player.setLineas(0);
        player.setPartidas(0);
        player.tetris= new Tetris();
        return player;
    }
    /*Metodo que inicializa una partida creando un nuevo objeto de la Clase Tetris que se asocia al Jugador
	  @param N entero que indica la cantidad de filas que tendra la partida de Tetris
	  @param M entero que indica la cantidad de columnas que tendra la partida de Tetris 
	  @param gamePieces entero que indica la cantidad de piezas preposicionadas que habran en el Tablero
	  @param seed entero con el cual se da inicion al random que genera las piezas
	  */
	  
    public void iniciarPartida(int N, int M, int cantPiezas, int seed){
        Tetris tetrix=  new Tetris();
        this.tetris= tetrix.Tetris(N, M, cantPiezas, seed);
    }
	/*Metodo que finaliza la partida y revisa si es que el puntaje obtenido durante la partida 
	logra entrar entre los 3 mas altos puntajes del Jugador*/
    public void terminarPartida(){
        int puntaje=this.tetris.getPuntaje();
        this.ordenarPuntajes(puntaje);
    }
	/**Metodo que muestra por pantalla los 3 puntajes mas altos del Jugador*/
    public void revisarPuntaje(){
        int[] puntajes=this.masAltos;
        for(int i=0;i<3;i++){
            System.out.println(puntajes[i]);
        }
    }
	/*Metodo que ordena los puntajes del Jugador y revisa si es que el puntaje nuevo entra o no entre los 3 as altos
	@param nuevo entero que representa un nuevo puntaje que podria ser uno de los 3 mas altos*/
     public void ordenarPuntajes(int nuevo){
         int[] ptjs=this.getPuntajes();
         if(nuevo>ptjs[0]){
             int aux=ptjs[0];
             ptjs[0]=nuevo;
             int aux2=ptjs[1];
             ptjs[1]=aux;
             ptjs[2]=aux2;
         }
         else if(nuevo> ptjs[1]){
             int aux=ptjs[1];
             ptjs[1]=nuevo;
             ptjs[2]=aux;
         }else if(nuevo> ptjs[2]){
             ptjs[2]=nuevo;
         }else{
             
         }
         this.setPuntajes(ptjs);
     }
	 /*Metodo que retorna el atributo nickname del Jugador
	  @return atributo nickname*/
    public String getNick(){
        return this.nickname;
    }
	/*Metodo que retorna el atributo clave del Jugador
	  @return atributo clave*/
    public String getPass(){
        return this.clave;
    }
	/*Metodo que retorna el atributo masAltos del Jugador
	  @return atributo masAltos*/
    public int[] getPuntajes(){
        return this.masAltos;
    }
	/*Metodo que retorna el atributo cantPartidas del Jugador
	  @return atributo cantPartidas*/
    public int getPartidas(){
        return this.cantPartidas;
    }
	/*Metodo que retorna el atributo numeroLineas del Jugador
	  @return atributo numeroLineas*/
    public int getLineas(){
        return this.numeroLineas;
    }
	/*Metodo que retorna el atributo tetris del Jugador
	  @return atributo tetris*/
    public Tetris getTetris(){
        return this.tetris;
    }
	/*Metodo que asigna el valor de nick en el atributo nickname del Jugador
	@param nick representa el nuevo valor del atributo nickname del jugador*/
    public void setNick(String nick){
        this.nickname=nick;
    }
	/*Metodo que asigna el valor de clave en el atributo clave del Jugador
	@param clave representa el nuevo valor del atributo clave del jugador*/
    public void setPass(String clave){
        this.clave=clave;
    }
	/*Metodo que asigna el valor de puntajes en el atributo masAltos del Jugador
	@param puntajes representa el nuevo atributo masAltos del jugador*/
    public void setPuntajes(int[] puntajes){
        this.masAltos=puntajes;
    }
	/*Metodo que asigna el valor de partidas en el atributo cantPartidas del Jugador
	@param partidas representa el nuevo valor del atributo cantPartidas del jugador*/
    public void setPartidas(int partidas){
        this.cantPartidas=partidas;
    }
	/*Metodo que asigna el valor de lineas en el atributo numeroLineas del Jugador
	@param lineas representa el nuevo valor del atributo numeroLineas del jugador*/
    public void setLineas(int lineas){
        this.numeroLineas=lineas;
    }
	/*Metodo que asigna el valor de tetris en el atributo tetris del Jugador
	@param tetris representa el nuevo tetris del jugador*/
    public void setTetris(Tetris tetris){
        this.tetris=tetris;
    }
}
