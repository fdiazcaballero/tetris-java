
	package tetris;
	import java.awt.*;
	import java.applet.Applet;
	
	
	public class Marcador{
		
		private int[]puntos;
		private Fichas siguiente;
		
		
		public Marcador(){
			puntos = new int[6];
		}
		
		public void setMarcador(int valor){
			
				String largo = String.valueOf(valor);
				int[]total = new int[largo.length()];
				int dividendo = valor;
				int copia = 0;
				
			for(int a=total.length-1;a>-1;a--){
				total[a] = dividendo%10;
				dividendo /= 10;
			}
			puntos = new int[6];
			if(total.length < puntos.length) puntos=total;
			else{
			   copia = puntos.length;
			   System.arraycopy(total,0,puntos,0,copia);
			}
		}
		
		
		public void setNext(Fichas fi){
		
			siguiente = fi;	
			for(int b=0;b<8;b++){
				siguiente.moverDerecha();
			}
			for(int c=0;c<4;c++){
			   siguiente.moverAbajo();
			}
		
		}
		
		public void pintar(Graphics g){
			
			
			for(int a=0;a<puntos.length;a++){
				Numero n = new Numero(puntos[a]);
				n.pintar(g,a*24+340,270);
			}
		
				siguiente.pintar(g);
		}
	}