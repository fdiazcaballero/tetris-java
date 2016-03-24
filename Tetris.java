

   import java.applet.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.util.Random;
   import tetris.*;

/*	
<applet code="Tetris" width=500 height=400>
</applet>
*/

   public class Tetris extends Applet implements Runnable,KeyListener{
   
      String msg = "Go!";
      int puntos = 0;
      Tablero ta = new Tablero();
      Marcador m = new Marcador();
      Thread t;
      boolean parar;
      Image img;
      Fichas fr1;
      Fichas fr2 = new FichaAzul(ta);
      Fichas fr3 = new FichaRoja(ta);
      Fichas fr4 = new FichaVerde(ta);
      Fichas fr5 = new FichaAzulM(ta);
      Fichas fr6 = new FichaMagenta(ta);
      Fichas fr7 = new FichaAmarilla(ta);
      Fichas fr8 = new FichaBlanca(ta);
      Fichas[]fr = {fr2,fr3,fr4,fr5,fr6,fr7,fr8};
      Random r = new Random();
      int next = 0;
   
      public void init(){
         setBackground(Color.gray);
         setForeground(Color.white);
         img = getImage(getCodeBase(),"nowy-start.jpg");
         addKeyListener(this);
      }
   
      public void start(){
         t= new Thread(this);
         parar = false;
         msg = "";
         showStatus("Juego en movimiento");
         next = r.nextInt(7);
         ta.setFicha(fr[next].copiar(ta));
         fr1 = fr[next].copiar(ta);
         m.setNext(fr1);
         t.start();
      }
   
      public void stop(){
         parar = true;
         t = null;
         msg = "Game Over";
         showStatus("Juego en Acabado");	
      }
   
      public void run(){
      
      
         while(!parar){
            Fichas[]c = ta.getFichas(); 
            repaint(ta.getActiva().xMin(),ta.getActiva().yMin(),ta.getActiva().xMax()-ta.getActiva().xMin()+30,ta.getActiva().yMax()-ta.getActiva().yMin()+30);
            try{
               t.sleep(500);
            }
               catch(InterruptedException ine){ 
                  showStatus("Juego Parado");}
            if(ta.esMovible(2)){			
               ta.getActiva().moverAbajo(); 
            }
            else{
               ta.colocarTablero();
               ta.setFicha(fr[next].copiar(ta));
               next = r.nextInt(7);
               fr1 = fr[next].copiar(ta);
               m.setMarcador(ta.getPuntos());
               m.setNext(fr1);
               repaint(340,100,150,190);
               repaint(50,0,270,397);
            
            }
         
         } 
      }
   
      public void update(Graphics g){
      
         g.drawImage(img,50,7,270,390,this);
         ta.pintar(g);
         m.pintar(g);
      }
   
      public void paint(Graphics g){
         update(g);
      }
   
   
      public void keyPressed(KeyEvent k){
      
         int tecla = k.getKeyCode();
      
         switch(tecla){
            case KeyEvent.VK_DOWN:
            
               if(ta.esMovible(2)){ 
                  ta.getActiva().moverAbajo();
               	repaint(ta.getActiva().xMin(),ta.getActiva().yMin()-30,ta.getActiva().xMax()-ta.getActiva().xMin()+30,ta.getActiva().yMax()-ta.getActiva().yMin()+60);
               }
               break;
            case KeyEvent.VK_LEFT:
               if(ta.esMovible(4)){
                  ta.getActiva().moverIzquierda();
               	repaint(ta.getActiva().xMin(),ta.getActiva().yMin(),ta.getActiva().xMax()-ta.getActiva().xMin()+60,ta.getActiva().yMax()-ta.getActiva().yMin());
               }
               break;
            case KeyEvent.VK_RIGHT:
               if(ta.esMovible(6)){
                  ta.getActiva().moverDerecha();
               	repaint(ta.getActiva().xMin()-30,ta.getActiva().yMin(),ta.getActiva().xMax()-ta.getActiva().xMin()+60,ta.getActiva().yMax()-ta.getActiva().yMin());
               }
               break;
            case KeyEvent.VK_CONTROL:
               ta.getActiva().rotar();
            	repaint(0,ta.getActiva().yMin()-30,ta.getAncho()*30+50,ta.getActiva().yMax()-ta.getActiva().yMin()+90);
               break;
            case KeyEvent.VK_P:
               stop();
               showStatus("Juego en Pausa");
               break;
            case KeyEvent.VK_Q:
               destroy();
               break;
         }
      }
   
      public void keyReleased(KeyEvent k){
      }
      public void keyTyped(KeyEvent k){
      }
   
   }

