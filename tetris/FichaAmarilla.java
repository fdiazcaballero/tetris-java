   package tetris;

   import java.awt.*;

   public class FichaAmarilla extends Fichas{
   
      private int giro;   
   
      public FichaAmarilla(Tablero t){
      
         super(t);
         Coord[] coord = {new Coord(3,0), new Coord(4,0), new Coord(5,0), new Coord(5,1)};
         setCoordenadas(coord);
         setColor(Color.yellow);
         giro = 0;
      }
   
   
      public void rotar(){
      
         int cont = 0;
         boolean valido = true;
         Coord[]cds = getCoordenadas();
         Coord c0 = null;
         Coord c1 = null;
         Coord c2 = null;
         Coord c3 = null;
      
         switch(giro){
         
            case 0:
               c0 = new Coord(cds[0].getX()+1,cds[0].getY());
               c1 = new Coord(cds[1].getX(),cds[1].getY()+1);
               c2 = new Coord(cds[2].getX()-1,cds[2].getY()+2);
               c3 = new Coord(cds[3].getX()-2,cds[3].getY()+1);
               break;
            case 1:
               c0 = new Coord(cds[0].getX()+1,cds[0].getY()+1);
               c2 = new Coord(cds[2].getX()-1,cds[2].getY()-1);
               c1 = cds[1];
               c3 = new Coord(cds[3].getX(),cds[3].getY()-2);
               break;
            case 2:
               c0 = new Coord(cds[0].getX()-1,cds[0].getY()+1);
               c2 = new Coord(cds[2].getX()+1,cds[2].getY()-1);
               c1 = cds[1];
               c3 = new Coord(cds[3].getX()+2,cds[3].getY());
               break;
            case 3:
               c0 = new Coord(cds[0].getX()-1,cds[0].getY()-2);
               c1 = new Coord(cds[1].getX(),cds[1].getY()-1);
               c2 = new Coord(cds[2].getX()+1,cds[2].getY());
               c3 = new Coord(cds[3].getX(),cds[3].getY()+1);
               break;
         }
      
         Coord[] ncds = {c0,c1,c2,c3};
         while(cont<ncds.length && valido){
            if(!esRotar(ncds[cont])) valido = false;
            else cont++;
         }
         if(valido){
            setCoordenadas(ncds);
            if(giro == 3) giro=0;
            else giro++;
         }
      
      }
   }