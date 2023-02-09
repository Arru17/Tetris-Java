/**Clase que representa una pieza compuesta por 4 Bloques
Atributos: tipo entero que representa el tipo de la Pieza (si es una pieza O, T o Z por ejemplo)
           rotaciones entero que representa la cantidad de rotaciones realizadas a la Pieza
		   bloques arreglo de 4 Bloques que corresponden a las 4 posiciones que ocupa la pieza dentro del Tablero**/
public class Pieza {
    private int tipo;
    private int rotaciones;
    Bloque[] bloques;
    
	/*Metodo que crea un objeto de la Clase Pieza a aprtir de un entero
	@param tipo entero que representa el tipo de la Pieza
	@return piece objeto de la Clase Pieza compuesta ya por los 4 Bloques*/
    public Pieza Pieza(int tipo){
        Pieza piece= new Pieza();
        piece.bloques=new Bloque[4];
        Bloque aux=new Bloque();
        int result= tipo % 7;
        switch (result){
            case 0:
                piece.bloques[0]= aux.Bloque(0, 0);
                piece.bloques[1]= aux.Bloque(0, 1);
                piece.bloques[2]= aux.Bloque(1, 0);
                piece.bloques[3]= aux.Bloque(1, 1);
                break;
            case 1:
                piece.bloques[0]= aux.Bloque(0, 0);
                piece.bloques[1]= aux.Bloque(1, 0);
                piece.bloques[2]= aux.Bloque(2, 0);
                piece.bloques[3]= aux.Bloque(3, 0);
                break;
            case 2:
                piece.bloques[0]= aux.Bloque(0, 0);
                piece.bloques[1]= aux.Bloque(0, 1);
                piece.bloques[2]= aux.Bloque(1, 1);
                piece.bloques[3]= aux.Bloque(1, 2);
                break;    
            case 3:
                piece.bloques[0]= aux.Bloque(0, 1);
                piece.bloques[1]= aux.Bloque(0, 2);
                piece.bloques[2]= aux.Bloque(1, 0);
                piece.bloques[3]= aux.Bloque(1, 1);
                break;
            case 4:
                piece.bloques[0]= aux.Bloque(0, 0);
                piece.bloques[1]= aux.Bloque(0, 1);
                piece.bloques[2]= aux.Bloque(1, 0);
                piece.bloques[3]= aux.Bloque(2, 0);
                break;
            case 5:
                piece.bloques[0]= aux.Bloque(0, 0);
                piece.bloques[1]= aux.Bloque(0, 1);
                piece.bloques[2]= aux.Bloque(1, 1);
                piece.bloques[3]= aux.Bloque(2, 1);
                break;
            case 6:
                piece.bloques[0]= aux.Bloque(0, 1);
                piece.bloques[1]= aux.Bloque(1, 0);
                piece.bloques[2]= aux.Bloque(1, 1);
                piece.bloques[3]= aux.Bloque(1, 2);
                break;
        }
        piece.tipo=result;
        piece.rotaciones=0;
        return piece;
    }
	/**Metodo que rota una pieza hacia la derecha cambiado la posicion que ocupan sus bloques dentro del Tablero
	@param piece es la Pieza a rotar**/

    public void rotarPieza(Pieza piece){
        int type= piece.tipo;
        int rotacion;
        switch (type){
            case 0:
                break;
            case 1:
                rotacion=piece.rotaciones;
                switch (rotacion){
                    case 0:
                       piece.bloques[0].modificarPosicion(0, 0);
                       piece.bloques[1].modificarPosicion(0, 1);
                       piece.bloques[2].modificarPosicion(0, 2);
                       piece.bloques[3].modificarPosicion(0, 3); 
                       piece.rotaciones=1;
                       break;
                    case 1:
                       piece.bloques[0].modificarPosicion(0, 0);
                       piece.bloques[1].modificarPosicion(1, 0);
                       piece.bloques[2].modificarPosicion(2, 0);
                       piece.bloques[3].modificarPosicion(3, 0); 
                       piece.rotaciones=0;
                       break;
                }
                break;
            case 2: //Pieza S
                rotacion=piece.rotaciones;
                switch (rotacion){
                    case 0:
                       piece.bloques[0].modificarPosicion(0, 1);
                       piece.bloques[1].modificarPosicion(1, 0);
                       piece.bloques[2].modificarPosicion(1, 1);
                       piece.bloques[3].modificarPosicion(2, 0); 
                       piece.rotaciones=1;
                       break;
                    case 1:
                       piece.bloques[0].modificarPosicion(0, 0);
                       piece.bloques[1].modificarPosicion(0, 1);
                       piece.bloques[2].modificarPosicion(1, 1);
                       piece.bloques[3].modificarPosicion(1, 2); 
                       piece.rotaciones=0;
                       break;
                }
                break;
            case 3: //Pieza Z.
                rotacion=piece.rotaciones;
                switch (rotacion){
                    case 0:
                       piece.bloques[0].modificarPosicion(0, 0);
                       piece.bloques[1].modificarPosicion(1, 0);
                       piece.bloques[2].modificarPosicion(1, 1);
                       piece.bloques[3].modificarPosicion(2, 0); 
                       piece.rotaciones=1;
                       break;
                    case 1:
                       piece.bloques[0].modificarPosicion(0, 1);
                       piece.bloques[1].modificarPosicion(0, 2);
                       piece.bloques[2].modificarPosicion(1, 0);
                       piece.bloques[3].modificarPosicion(1, 1); 
                       piece.rotaciones=0;
                       break;
                }
                break;
            case 4: //Pieza L.
                rotacion=piece.rotaciones;
                switch (rotacion){
                    case 0:
                       piece.bloques[0].modificarPosicion(0, 0);
                       piece.bloques[1].modificarPosicion(1, 0);
                       piece.bloques[2].modificarPosicion(1, 1);
                       piece.bloques[3].modificarPosicion(1, 2); 
                       piece.rotaciones=1;
                       break;
                    case 1:
                       piece.bloques[0].modificarPosicion(0, 1);
                       piece.bloques[1].modificarPosicion(1, 1);
                       piece.bloques[2].modificarPosicion(2, 0);
                       piece.bloques[3].modificarPosicion(2, 1); 
                       piece.rotaciones=2;
                       break;
                    case 2:
                       piece.bloques[0].modificarPosicion(0, 0);
                       piece.bloques[1].modificarPosicion(0, 1);
                       piece.bloques[2].modificarPosicion(0, 2);
                       piece.bloques[3].modificarPosicion(1, 2); 
                       piece.rotaciones=3;
                       break;
                    case 3:
                       piece.bloques[0].modificarPosicion(0, 0);
                       piece.bloques[1].modificarPosicion(0, 1);
                       piece.bloques[2].modificarPosicion(1, 0);
                       piece.bloques[3].modificarPosicion(2, 0); 
                       piece.rotaciones=0;
                       break;
                }
                break;
            case 5: //Pieza J.
                rotacion=piece.rotaciones;
                switch (rotacion){
                    case 0:
                       piece.bloques[0].modificarPosicion(0, 0);
                       piece.bloques[1].modificarPosicion(0, 1);
                       piece.bloques[2].modificarPosicion(0, 2);
                       piece.bloques[3].modificarPosicion(1, 0); 
                       piece.rotaciones=1;
                       break;
                    case 1:
                       piece.bloques[0].modificarPosicion(0, 0);
                       piece.bloques[1].modificarPosicion(1, 0);
                       piece.bloques[2].modificarPosicion(2, 0);
                       piece.bloques[3].modificarPosicion(2, 1); 
                       piece.rotaciones=2;
                       break;
                    case 2:
                       piece.bloques[0].modificarPosicion(0, 2);
                       piece.bloques[1].modificarPosicion(1, 0);
                       piece.bloques[2].modificarPosicion(1, 1);
                       piece.bloques[3].modificarPosicion(1, 2); 
                       piece.rotaciones=3;
                       break;
                    case 3:
                       piece.bloques[0].modificarPosicion(0, 0);
                       piece.bloques[1].modificarPosicion(0, 1);
                       piece.bloques[2].modificarPosicion(1, 1);
                       piece.bloques[3].modificarPosicion(2, 1); 
                       piece.rotaciones=0;
                       break;
                }
                break;
            case 6: //Pieza T.
                rotacion=piece.rotaciones;
                switch (rotacion){
                    case 0:
                       piece.bloques[0].modificarPosicion(0, 1);
                       piece.bloques[1].modificarPosicion(1, 0);
                       piece.bloques[2].modificarPosicion(1, 1);
                       piece.bloques[3].modificarPosicion(2, 1); 
                       piece.rotaciones=1;
                       break;
                    case 1:
                       piece.bloques[0].modificarPosicion(0, 0);
                       piece.bloques[1].modificarPosicion(0, 1);
                       piece.bloques[2].modificarPosicion(0, 2);
                       piece.bloques[3].modificarPosicion(1, 1); 
                       piece.rotaciones=2;
                       break;
                    case 2:
                       piece.bloques[0].modificarPosicion(0, 0);
                       piece.bloques[1].modificarPosicion(1, 0);
                       piece.bloques[2].modificarPosicion(1, 1);
                       piece.bloques[3].modificarPosicion(2, 0); 
                       piece.rotaciones=3;
                       break;
                    case 3:
                       piece.bloques[0].modificarPosicion(0, 1);
                       piece.bloques[1].modificarPosicion(1, 0);
                       piece.bloques[2].modificarPosicion(1, 1);
                       piece.bloques[3].modificarPosicion(1, 2); 
                       piece.rotaciones=0;
                       break;
                }
                break;
        }
    }
	/*Metodo que desplaza una pieza hacia arriba, abajo, derecha o izquierda o la acomoda para poder ser colocada en el Tablero
	@param piece es la pieza que sera desplazada
	@param direccion es un entero que indica que tipo de desplazamiento se realizara
	@param N entero que corresponde a la cantidad de filas del Tablero sobre lo cual se acomodara la pieza
	@param columna entero que representa la columna sobre la cual se acomodara la pieza*/
    public void correrPieza(Pieza piece, int direccion, int N, int columna){
        switch (direccion){
            case 0: //Subir
                for(int x=0;x<4;x++){
                    int newX= piece.bloques[x].getX() -1;
                    piece.bloques[x].setX(newX);
                }
                break;
            case 1: //Bajar
                for(int x=0;x<4;x++){
                    int newX= piece.bloques[x].getX() +1;
                    piece.bloques[x].setX(newX);
                }
                break;
            case 2: //Derecha
                for(int x=0;x<4;x++){
                    int newY= piece.bloques[x].getY() +1;
                    piece.bloques[x].setY(newY);
                } 
                break;
            case 3: //Izquierda
                for(int x=0;x<4;x++){
                    int newY= piece.bloques[x].getY() -1;
                    piece.bloques[x].setX(newY);
                }    
                break;
            case 4: //Filas
                for(int x=0;x<4;x++){
                    int newX;
                    newX= N - 1 - piece.bloques[x].getX();
                    piece.bloques[x].setX(newX);
                }
                break;
            case 5:  //Columnas
                for(int x=0;x<4;x++){
                    int newY= columna + piece.bloques[x].getY();
                    piece.bloques[x].setY(newY);
                }
                break;
        }
    }
	/*Metodo que permite ver ne pantalla las posiciones que ocupa una pieza dentro del Tablero*/
    public void visualizarPieza(){
        for(int i=0; i<4;i++){
            System.out.println("("+this.bloques[i].getX()+","+this.bloques[i].getY()+")");
        }
    }
	/*Metodo que retorna el atributo tipo de la Pieza
	  @return atributo tipo*/
    public int getTipo(){
        return this.tipo;
    }
	/*Metodo que retorna el atributo rotaciones de la Pieza
	  @return atributo rotaciones*/
    public int getRotaciones(){
        return this.rotaciones;
    }
	/*Metodo que retorna el atributo bloques de la Pieza
	  @return atributo bloques*/
    public Bloque[] getBloques(){
        return this.bloques;
    }
	/*Metodo que asigna el valor de tipo en el atributo tipo de la Pieza
	@param tipo representa el nuevo tipo de la Pieza*/
    public void setTipo(int tipo){
      this.tipo= tipo; 
    }
	/*Metodo que asigna el valor de rot en el atributo rotaciones de la Pieza
	@param rot representa la nueva cantidad de rotaciones de la Pieza*/
    public void setRotaciones(int rot){
        this.rotaciones=rot;
    }
	/*Metodo que asigna el valor de blocks en el atributo bloques de la Pieza
	@param blocks representa los nuevos bloques que componen la Pieza*/
    public void setBloques(Bloque[] blocks){
        this.bloques=blocks;
    }
}