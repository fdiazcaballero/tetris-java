

   package tetris;
   import java.awt.*;
   import java.util.Vector;

   public class Tablero{
   
      private Fichas[]tablero;
      private int alto;
      private int ancho;
      private Fichas activa;
      private int puntos;
   
      public Tablero(){
      
         tablero = new Fichas[1];
         ancho = 9;
         alto = 13;
         puntos = 0;
      }
   
      public Tablero(Fichas [] niveles){
         tablero = niveles;
         ancho = 9;
         alto = 13;
      }
   
      public void setFicha(Fichas fi){
      
         addElement(fi);
         activa = tablero[tablero.length-1];
      
      }
   
      public int getAncho(){ 
         return ancho; }
      public int getAlto(){ 
         return alto; }
      public Fichas getActiva(){ 
         return activa;}
      public Fichas[] getFichas(){ 
         return tablero;}
   
      public int getPuntos(){
         return puntos;
      }
   
      protected boolean esOcupada(Coord c){
      
         boolean ocupada = false;
         int pos = 0;
         while(pos<tablero.length && !ocupada){					
            Coord[]cds = tablero[pos].getCoordenadas();
            int pos2 = 0;
            while(pos2<cds.length && !ocupada){
               if(cds[pos2].equals(c)) ocupada = true;
               else pos2++; 
            }
            pos++;
         }
         return ocupada; 
      }
   
      private boolean lineaLlena(int linea){
      
         boolean llena = true;
         int x = 0;
      
      
         while(x<ancho && llena){
            Coord c1 = new Coord(x,linea);
            if(esOcupada(c1)) x++;
            else llena = false;
         }
         return llena;
      }
   
   
      private int[] buscarLlenas(){
      
         int[]llenadas = {-1,-1,-1,-1};
         int pos = 0;
         int count = 0;
      
         while(pos<alto && count<llenadas.length){
            if(lineaLlena(pos)){
               llenadas[count] = pos; 
               count++;								
            }
            pos++;
         }
      
         return llenadas;
      }
   
   
      private void borrarOcupadas(int[]ocupadas){
      
         for(int a = 0;a<ocupadas.length;a++){
            for(int b = 0;b<tablero.length;b++){
               if(ocupadas[a] != -1){						
                  tablero[b].borrarLinea(ocupadas[a]);						
               }
            }
         }
      }
   
   
      private void bajarLinea(int linea){
      
         for(int u=linea-1;u>-1;u--){
            for(int v=0;v<tablero.length;v++){
               tablero[v].bajarLinea(u);
            }
         }
      }
   
      public void colocarTablero(){
         int[]encontradas = buscarLlenas();
         int count = 0;
         borrarOcupadas(encontradas);
         for(int c=0;c<encontradas.length;c++){
            if(encontradas[c]!=-1){
               bajarLinea(encontradas[c]);
               puntos++;
            }
         }
         for(int d = 0;d<tablero.length;d++){
            if(tablero[d].esBorrada()){
               tablero[d] = null;
               count++;
            }	
         }
      
         removeElement(count);
      }
   
   
      public boolean esMovible(int tipo){
      
         Coord[] cds2 = activa.getCoordenadas();
         boolean mov = true;
         int pos3 = 0;
         int x =0;
         int y =0;
      
         while(pos3<cds2.length && mov){
         
            switch(tipo){
               case 2:
                  x=0;
                  y=1;
                  if(cds2[pos3].getY()== alto-1) mov = false;
                  break;
               case 4:
                  x=-1;
                  y=0;
                  if(cds2[pos3].getX()== 0) mov = false;
                  break;
               case 6: 
                  x=1;
                  y=0;
                  if(cds2[pos3].getX() == ancho-1) mov = false;
                  break;
            }
         
            if(mov){
               Coord c3 = new Coord(cds2[pos3].getX()+x, cds2[pos3].getY()+y);
               boolean propia = false;
               int var = 0;
               while(var<cds2.length && !propia){
                  if(cds2[var].equals(c3)) propia = true;
                  else var++;
               }               
            
               if(esOcupada(c3) && !propia) mov = false;
               else pos3++;
            }      
         }
      
         return mov;
      }
   
      public void pintar(Graphics g){
      
         g.setColor(Color.black);			
         g.fillRect(340,100,150,120);
         g.fillRect(340,230,150,70);			
         g.drawLine(47,7,47,399);
         g.drawLine(323,7,323,399);
         g.drawLine(47,399,323,399);
         g.drawRect(338,98,152,124);
         g.drawRect(338,228,152,74);
         g.setColor(Color.orange);
         g.draw3DRect(49,6,272,392,false);
         g.draw3DRect(48,5,274,394,false);
         g.draw3DRect(339,99,150,122,false);
         g.draw3DRect(339,229,150,72,false);
         g.setColor(Color.white);
         g.drawString("NEXT",350,120);
         g.drawString("LINES",350,250);
         g.setColor(Color.gray);
         g.drawLine(47,6,322,6);
         g.drawLine(47,5,322,5);
      
      
         for(int p=0;p<tablero.length;p++){
            if(tablero[p]!=null)
               tablero[p].pintar(g);
         }		
      }	
   
      public int indexNull(){
         int vacio = 0;
         boolean encontrado = false;
      
         while(!encontrado && vacio<tablero.length){
            if(tablero[vacio]==null) encontrado = true;
            else vacio++;
         }
         if(vacio == tablero.length) vacio = -1;
      
         return vacio;
      }
   
      public void addElement(Fichas f){
         if(indexNull() == -1){
            Fichas[] nuevo = new Fichas[tablero.length+1];
            System.arraycopy(tablero,0,nuevo,0,tablero.length);
            nuevo[tablero.length] = f;
            tablero = nuevo;
         }
         else tablero[indexNull()] = f;
      }	
   
      public void removeElement(int pos){
      
         Fichas[] nuevo = new Fichas[tablero.length-pos];
         for(int i=0,j=0;i<tablero.length;i++){
         
            if(tablero[i]==null) j++;
            else nuevo[i-j]= tablero[i];
         }
      
      
         tablero = nuevo;
      }
   }			



