/**
*Clase Fichas, incluida en el paquete "tetris", crea las instancias de las fichas necesarias para
*el desarrollo del juego. Existiran 7 tipos diferentes del fichas.
*
*@author Fernando Diaz Caballero
*@version 1.0
*@see package tetris
*/

/**
*Se incluye la clase en el paquete tetris.
*/
   package tetris;

/**
*Importamos el apquete de clases java.awt para la representacion grafica de las fichas en el juego.
*/		
   import java.awt.*;        


   public abstract class Fichas{
   
   /*
   *Cada instancia de fichas contiene un array con las coordenadas de sus modulos y un booleano que
   *indica si la ficha ha sido eliminada en su totalidad del juego.Ademas cada tipo de ficha contara
   *con un color distintivo.
   */ 
      private Coord [] coordenadas;
      private boolean girada;
      private Color color;
      private Tablero tab;
   
   /*
   *Constructor de la clase Fichas, contenpla la posibilidad de crear diferentes instancias de fichas
   *segun le valor de la constante entera que se le pase por parametro.
   *
   *@param int tipo Define el contorno y las dimensiones de la figura.
   */
   
      public Fichas(Tablero tab1){
      
         coordenadas = new Coord[4];						                 
         girada = false;
         tab = tab1;
      }
   
      public Fichas copiar(Tablero tab2){
      
         Fichas fi = null;
      
         if(color.equals(Color.red)){
            fi = new FichaRoja(tab2);
         }
         else if(color.equals(Color.cyan)){
            fi = new FichaAzul(tab2);
         }
         else if(color.equals(Color.green)){
            fi = new FichaVerde(tab2);
         }
         else if(color.equals(Color.blue)){
            fi = new FichaAzulM(tab2);
         }
         else if(color.equals(Color.magenta)){
            fi = new FichaMagenta(tab2);
         }
         else if(color.equals(Color.yellow)){
            fi = new FichaAmarilla(tab2);
         }
         else if(color.equals(Color.white)){
            fi = new FichaBlanca(tab2);
         }
      
         return fi;
      }
   
   /**
   *Metodo que evalua si la instancia de ficha se puede eliminar del juego.
   */
   
      public boolean esBorrada(){
      
         boolean vacia = false;
         if(coordenadas.length < 1) vacia = true;
      
         return vacia;
      }
   
   
   /**
   *Metodo que devuelve las coordenadas de la ficha.
   *@return coordenadas Array de las coordenadas de los modulos de la ficha.
   */
   
      public Coord[] getCoordenadas(){ 
         return coordenadas;
      }
   
   /**
   *Metodo que establece el color de la ficha.
   *
   *@param	color	Objeto Color que establece el color de la ficha.
   */
   
      public void setColor(Color color){
         this.color = color;
      }
   
   /**
   *Metodo que devuelve el color de la ficha.
   *@return	color	Color de la ficha.
   */
   
      public Color getColor(){
         return color;
      }
   /**
   *Metodo que establece  las coordenadas de la ficha;
   *@param	cor	Array con las coordenadas de la ficha;
   */
   
      public void setCoordenadas(Coord[] cor){
         coordenadas = cor;
      }
   
   
   /**
   *Metodo para saber si una ficha esta girada o no;
   *@return	girada	Booleano que determina el estado del objeto;
   */
   
      public boolean esGirada(){
         return girada;
      }
   
   /**
   *Metodo para establecer que la ficha ya ha sido girada con antelacion;
   *@param giro	Booleano que establece el giro;
   */
   
      public void	setGirada(boolean giro){
         girada = giro;
      }
   
      public Tablero getTablero(){ 
         return tab; }
   
   /**
   *Metodo para desplazar la ficha a la derecha del tablero.
   */
   
      public void moverDerecha(){
      
         for(int b=0;b<coordenadas.length;b++){
            if(coordenadas[b]!=null){
               coordenadas[b].setX(coordenadas[b].getX()+1);
            }
         }
      }
   
   /**
   *Metodo para desplazar la ficha a la izquierda del tablero.
   */
   
   
      public void moverIzquierda(){
         for(int c=0;c<coordenadas.length;c++){
            if(coordenadas[c]!=null){
               coordenadas[c].setX(coordenadas[c].getX()-1);
            }
         }
      }
   
   
   /**
   *Metodo para desplazar hacia abajo la ficha en	el tablero.
   */			
   
   
      public void moverAbajo(){
         for(int e=0;e<coordenadas.length;e++){
            if(coordenadas[e]!=null){
               coordenadas[e].setY(coordenadas[e].getY()+1);
            }
         }
      }
   
   /**
   *Metodo para rotar la ficha. Dependiendo de la variable "dir" que se pase al metodo la rotacion
   *se realizara en un sentido u otro.
   *Este metodo abstracto debera de ser implementado para cada clase especializada de ficha, las
   *cuales derivaran de esta superclase.
   *@param dir Indica el sentido de giro de la rotacion.
   */
   
      public abstract void rotar();
   
   /**
   *Metodo para eliminar los modulos de la ficha que estan en una determinada fila, esto se produce
   *cuando el jugador completa una fila con modulos de las diferentes piezas.
   *
   *@param linea Linea que se desea vaciar tanto en la ficha como el tablero.
   *@see Tablero
   */
   
      public void borrarLinea(int linea){
         int count = 0;
      
         for(int k = 0;k<coordenadas.length;k++){ 
            if(coordenadas[k].getY() == linea){
               coordenadas[k] = null;
               count++;
            }
         
         }
      
         removeElement(count);
      }	
   
   /**
   *Metodo que desplaza una linea de modulos de una ficha, se llamara a este metodo posteriormente
   *a que una de las lineas del tablero halla sido vaciado, para desplazar hacia abajo las fichas
   *que esten en las posiciones superiores a la linea eliminada.
   *
   *@param linea2 Linea que se desea desplazar hacia abajo.
   *@see Tablero
   */ 					
      public void bajarLinea(int linea2){
      
         for(int j=0;j<coordenadas.length;j++){
         
            if(coordenadas[j].getY()==linea2){
               coordenadas[j].setY(linea2+1);
            }
         
         }
      }
   
   /**
   *Metodo para pintar las fichas en la GUI del juego.
   *
   *@param pincel Instancia de la clase Graphics que gestiona la salida en la GUI.
   *@see Tetris
   */				
      public void pintar(Graphics pincel){
      
         for(int i=0;i<coordenadas.length;i++){
            pincel.setColor(color);       
            pincel.fill3DRect((coordenadas[i].getX()*30)+50,(coordenadas[i].getY()*30)+7,30,30,true);
            pincel.setColor(Color.gray);
            pincel.draw3DRect((coordenadas[i].getX()*30)+50,(coordenadas[i].getY()*30)+7,30,30,true);      
            pincel.draw3DRect((coordenadas[i].getX()*30)+51,(coordenadas[i].getY()*30)+8,30,30,true);
         }
      }
   
      public void removeElement(int pos){
      
         Coord[] nuevas = new Coord[coordenadas.length-pos];
      
         for(int i=0,j=0;i<coordenadas.length;i++){
         
            if(coordenadas[i]==null) j++;
            else	nuevas[i-j] = coordenadas[i];
         }	
         coordenadas = nuevas;
      }
   
      public boolean fueraRango(Coord c1){
      
         int xo = c1.getX();
         int yo = c1.getY();
         boolean fuera = false;
      
         if(xo<0 || xo>tab.getAncho()-1 || yo> tab.getAlto()-1) fuera = true;
         return fuera;
      }
   
      public boolean esRotar(Coord c1){
      
         int pos = 0;
         boolean rotar = true;
         boolean propia = false;
      
         while(pos<coordenadas.length && !propia){
            if(coordenadas[pos].equals(c1)) propia = true;
            else pos++;
         }
         if(!propia){
            if(tab.esOcupada(c1) || fueraRango(c1)) rotar = false;
         }
      
         return rotar;
      }
   
      public int xMin(){
      
         int x = coordenadas[0].getX();
      
         for(int i=1;i<coordenadas.length;i++){
         
            if(x>coordenadas[i].getX()) x = coordenadas[i].getX();
         }
      
         return (x-1)*30+50;
      }
   
      public int xMax(){
      	
      	int x = coordenadas[0].getX();
      		for(int j=0;j<coordenadas.length;j++){
      			if(x<coordenadas[j].getX()) x = coordenadas[j].getX();
      		}
      	
      	return (x+1)*30+50;
      }
      public int yMin(){
      
         int y = coordenadas[0].getY();
      
         for(int k=1;k<coordenadas.length;k++){
            if(y>coordenadas[k].getY()) y = coordenadas[k].getY();
         }
      
         return (y-1)*30+7;
      }
   
      public int yMax(){
      	
      	int y = coordenadas[0].getY();
      		for(int l=0;l<coordenadas.length;l++){
      			if(y<coordenadas[l].getY()) y = coordenadas[l].getY();
      		}
      	
      	return (y+1)*30+7;
      }
   }

//Fin de la clase ficha.



