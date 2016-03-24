/**
*Clase Coord, sus instancias almacenan una posicion de coordenadas dada por las variable x e y.
*
*@author Fernando Diaz Caballero
*@version 1.0
*@see package tetris
*/

package tetris;
   public class Coord{
   /**
   *Coordenadas que denotan la posicion de un objeto en un sistema de referencia cartesiana.
   */		
      private int x;
      private int y;
   
   /**
   *Constructor de las coordenadas.
   *
   *@param	int x Coordenada en el eje x
   *@param int y Coordenada en el eje y
   *
   */
   
      public Coord(int x, int y){
      
         this.x = x;
         this.y = y;
      
      }
   
   /**
   *Metodo que devuelve la coordenada x almacenada.
   *@return int x Coordenada en le eje x almacenada.
   */
   
      public int getX(){ 
         return x; }
   
   /**
   *Metodo que devuelve la coordenada y almacenada.
   *@return int y Coordenada en el eje de las y almacenada.
   */
   
   
      public int getY(){ 
         return y; }
   
   
   /**
   *Metodo que compara dos coordenadas, la del objeto llamante y la que se pasa por parametro.
   *
   *@param Coord c Instancia de coord que queremos comparar.
   *@return boolean igual True si las coordenadas son identicas, si no devuelve false.
   */
   
      public boolean equals(Coord c){
      
         boolean igual = false;
         if(c.getX()==x && c.getY()==y) igual = true;
         return igual;
      }
   
   /**
   *Metodo para establecer la coordenada x del objeto coord.
   *@param int nx Nueva coordenada x.
   *
   */
   
      public void setX(int nx){
         x = nx;
      }
   
   /**
   *Metodo para establecer la coordenada y del objeto cood.
   *@param int ny Nueva coordenada y.
   *
   */
   
      public void setY(int ny){
         y = ny;
      }
   
   
   }//fin de la clase Coord.
