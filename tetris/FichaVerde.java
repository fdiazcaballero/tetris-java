   package tetris;

   import java.awt.*;

   public class FichaVerde extends Fichas{
   
   
   
      public FichaVerde(Tablero t){
      
      
         super(t);
         Coord[] coord = {new Coord(4,0), new Coord(3,1), new Coord(4,1), new Coord(3,2)};
         setCoordenadas(coord);
         setColor(Color.green);
      }
   
   
      public void rotar(){
      
         int cont = 0;
         boolean valido = true;
         Coord[]cds = getCoordenadas();
      
      
         if(esGirada()){
            Coord c0 = new Coord(cds[0].getX()+2,cds[0].getY());
            Coord c1 = cds[1];
            Coord c2 = new Coord(cds[2].getX()+1,cds[2].getY()+1);
            Coord c3 = new Coord(cds[3].getX()-1,cds[3].getY()+1);
            Coord [] ncds = {c0,c1,c2,c3};
         
            while(cont<ncds.length && valido){
               if(!esRotar(ncds[cont])) valido = false;
               else cont++;
            }
            if(valido){
               setCoordenadas(ncds);
               setGirada(false);
            }
         }
         else{
            Coord c0 = new Coord(cds[0].getX()-2,cds[0].getY());
            Coord c1 = cds[1];
            Coord c2 = new Coord(cds[2].getX()-1,cds[2].getY()-1);
            Coord c3	= new Coord(cds[3].getX()+1,cds[3].getY()-1);
            Coord[]ncds = {c0,c1,c2,c3};
            while(cont<ncds.length && valido){
               if(!esRotar(ncds[cont])) valido = false;
               else cont++;
            }
            if(valido){
               setCoordenadas(ncds);
               setGirada(true);
            }
         }   
      }
   }