

	import java.applet.*;
	import java.awt.*;
	import java.awt.event.*;
	import tetris.*;
	
/*	
<applet code="Tetris" width=500 height=400>
</applet>
*/

	public class Tetris extends Applet implements Runnable,KeyListener{
		
		String msg = "Go!";
		int puntos = 0;
		Tablero ta = new Tablero();
		Thread t;
		boolean parar;
		Image img;
		
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
			try{
				Thread.sleep(1000);
				}catch(InterruptedException ine){ showStatus("Juego Parado");}
					if(ta.esMovible(2)){			
						ta.getActiva().moverAbajo();
						}
					else{
						ta.colocarTablero();
						ta.setFicha(new FichaRoja());
						puntos += 1000;
					}
				repaint();
			}
		}
			
	public void paint(Graphics g){
		
		ta.pintar(g,msg,new FichaRoja(),puntos);
	}
	
	public void keyPressed(KeyEvent k){
		
		int tecla = k.getKeyCode();
	
	switch(tecla){
		case KeyEvent.VK_DOWN:
							if(ta.esMovible(2)) ta.getActiva().moverAbajo();
							repaint();
							break;
		case KeyEvent.VK_LEFT:
							if(ta.esMovible(4)) ta.getActiva().moverIzquierda();
							repaint();
							break;
		case KeyEvent.VK_RIGHT:
							if(ta.esMovible(6)) ta.getActiva().moverDerecha();
							repaint();
							break;
		case KeyEvent.VK_CONTROL:
							((FichaRoja)ta.getActiva()).rotar(false);
							repaint();
							break;
		case KeyEvent.VK_ALT:
							((FichaRoja)ta.getActiva()).rotar(true);
							repaint();
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
	
	public void keyReleased(KeyEvent k){}
	public void keyTyped(KeyEvent k){}
	
}

			