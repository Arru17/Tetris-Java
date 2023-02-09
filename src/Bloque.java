/**Clase que representa la posicion que ocupa un Bloque dentro del Tablero
   Atributos: x entero que corresponde a la posicion en filas del Bloque
              y entero que corresponde a la posicion en columnas del Bloque**/
public class Bloque {
    private int x;
    private int y;
    
    /*Metodo con el cual se crea un objeto de la Clase Bloque
	  @param x entero que representa la posicion en filas
	  @param y entero que representa la posicion en columnas
	  @return block objeto de la Clase Bloque con los valores de x e y*/
    public Bloque Bloque(int x, int y){
        Bloque block = new Bloque();
        block.x=x;
        block.y=y;
        return block;
    }
	/*Metodo que modifica la posicion de un Bloque
	  @param x entero que representa la nueva posicion x del Bloque
	  @param y entero que representa la nueva posicion y del Bloque*/
    public void modificarPosicion(int x, int y){
        setX(x);
        setY(y);
    }
	/*Metodo que retorna el atributo x del Bloque
	  @return atributo x*/
    public int getX(){
        return this.x;
    }
	/*Metodo que retorna el atributo y del Bloque
	  @return atributo y*/
    public int getY(){
        return this.y;
    }
	/*Metodo que asigna el valor de x en el atributo x del Bloque
	@param x entero que representa la nueva posicion x del Bloque*/
    public void setX(int x){
        this.x=x;
    }
	/*Metodo que asigna el valor de y en el atributo y del Bloque
	@param y entero que representa la nueva posicion y del Bloque*/
    public void setY(int y){
        this.y=y;
    }
    
}