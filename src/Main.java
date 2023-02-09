import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author arru
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
       
        System.out.println("Ingresa tu nickname: ");
        String nick=input.nextLine();
        String pass, pass2;
        int again=0;
        do{
            if(again==1){
                System.out.println("Las passwords no coincidieron, intente nuevamente. ");
            }
            again=1;
            System.out.println("Ingresa una password: ");
            pass=input.nextLine();
            System.out.println("Ingresa nuevamente la password:");
            pass2=input.nextLine();
        }while(!pass.equals(pass2));
        Jugador player=new Jugador();
        player=player.Jugador(nick, pass);
        int eleccionPrincipal;
        do{
            do{
                System.out.println("----------Menu Principal----------");
                System.out.println("Para elegir una accion debe ingresar el numero correspondiente:");
                System.out.println("1- Iniciar partida.");
                System.out.println("2- Ver lineas eliminadas.");
                System.out.println("3- Ver partidas jugadas.");
                System.out.println("4- Revisar puntajes.");
                System.out.println("5- Salir.");
                eleccionPrincipal=input.nextInt();
            }while(eleccionPrincipal<1 || eleccionPrincipal>5);
            switch (eleccionPrincipal) {
                case 1:
                    int N,M,gamePieces,seed;
                    System.out.println("Ingrese la cantidad de filas del tablero (minimo permitido = 5):");
                    N= input.nextInt();
                    System.out.println("Ingrese la cantidad de columnas del tablero (minimo permitido = 10):");
                    M= input.nextInt();
                    gamePieces=4;
                    System.out.println("Ingrese un numero entero (seed):");
                    seed= input.nextInt();
					Tetris auxiliar= new Tetris();
					auxiliar=player.getTetris().Tetris(N, M, gamePieces, seed);
                    player.setTetris(auxiliar);
					//Funcionalidad nextPiece()
                    Pieza piece=new Pieza();
                    piece=piece.Pieza(seed);
                    int eleccion, posHoriz;
                    if(player.getTetris().getBoard()!=null && player.getTetris().getBoard().checkBoard(player.getTetris().getBoard())){
						do{
							do{                        
								System.out.println("----------Menu Tetris----------");
								System.out.println("Para elegir una accion debe ingresar el numero correspondiente:");
								System.out.println("1- Visualizar siguiente pieza.");
								System.out.println("2- Colocar pieza.");
								System.out.println("3- Rotar pieza (Rota hacia la derecha).");
								System.out.println("4- Visualizar tablero.");
								System.out.println("5- Terminar partida.");
								eleccion=input.nextInt();
							}while(eleccion<1 || eleccion >5);
							switch(eleccion){
								case 1:
									System.out.println("Siguiente pieza:");
									piece.visualizarPieza();
									eleccion=0;
									break;
							    //Funcionalidad play()
								case 2:
								
									System.out.println("Ingrese el valor de la columna donde se colocara la pieza:");
									posHoriz=input.nextInt();
									int resultado=player.getTetris().play(player.getTetris().getBoard(), piece, posHoriz);
									if(resultado==10){
										System.out.println("Pieza colocada exitosamente.");
										int puntajeColoc=150;
										int puntajeActual= player.getTetris().getPuntaje();
										ArrayList<Integer> listaFilas= player.getTetris().getBoard().lineasCompletas(player.getTetris().getBoard());
										if(listaFilas==null){
											player.getTetris().setPuntaje(puntajeColoc+puntajeActual);
										}else{
											int cantFilas= listaFilas.size();
											int filasBorradas= player.getLineas();
											player.setLineas(filasBorradas+cantFilas);
											player.getTetris().getBoard().borrarFilas(listaFilas, M);
											player.getTetris().getBoard().obtenerBloques(player.getTetris().getBoard());
											player.getTetris().getBoard().bajarBloques(player.getTetris().getBoard().getExistentes(), listaFilas);
											player.getTetris().getBoard().colocarBloques(player.getTetris().getBoard().getExistentes());
											player.getTetris().setPuntaje(puntajeColoc+puntajeActual+ (750*cantFilas));
										}
										//Funcionalidad nextPiece()
										int rando=new Random().nextInt(7);
										piece= piece.Pieza(rando);
										eleccion=0;
										break;
									}else if(resultado==100){
										System.out.println("Has perdido...");
										int cantPart= player.getPartidas();
										player.setPartidas(cantPart+1);
										player.terminarPartida();
										break;
									}else{
										break;
									}//Fin Funcionalidad play()
								case 3:
									System.out.println("Pieza correctamente rotada.");
									piece.rotarPieza(piece);
									eleccion=0;
									break;
								case 4:
									String str= player.getTetris().getBoard().boardToString(player.getTetris().getBoard());
									System.out.println("Tablero:              Puntaje: "+player.getTetris().getPuntaje());
									System.out.print(str);
									eleccion=0;
									break;
								case 5:
									player.terminarPartida();
									int canPar=player.getPartidas();
									player.setPartidas(canPar+1);
									break;
							}
						}while(eleccion!=1 && eleccion!=2 && eleccion!=3 && eleccion!=4 && eleccion!=5);
                    }else{
						System.out.println("Ingrese dimensiones validas.");
					}
					eleccionPrincipal=0;
                    break;
                case 2:
                    System.out.println("Cantidad de lineas eliminadas: "+player.getLineas());
                    eleccionPrincipal=0;
                    break;
                case 3:
                    System.out.println("Cantidad de partidas jugadas: "+player.getPartidas());
                    eleccionPrincipal=0;
                    break;
                case 4:
                    System.out.println("Puntajes mas altos: ");
                    player.revisarPuntaje();
                    eleccionPrincipal=0;
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Ninguna opcion valida seleccionada.");
                    break;
            }
        }while(eleccionPrincipal!=1 && eleccionPrincipal!=2 && eleccionPrincipal!=3 && eleccionPrincipal!=4 && eleccionPrincipal!=5);
       
    }
    
}