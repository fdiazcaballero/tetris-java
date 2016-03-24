

   package tetris;

   import java.awt.*;

   public class FichaAzul extends Fichas{
   
   
   
      public FichaAzul(Tablero t){
      
      
         super(t);
         Coord[] coord = {new Coord(3,0), new Coord(4,0), new Coord(3,1), new Coord(4,1)};
         setCoordenadas(coord);
         setColor(Color.cyan);
      }
   
   
      public void rotar(){
      }
   
   }