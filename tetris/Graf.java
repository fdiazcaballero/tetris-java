	import java.applet.*;
   import java.awt.*;
	import tetris.*;

	/*
	<applet code= "Graf" width=500 height=400>
	</applet>
	*/
   public class Graf extends Applet{
      Image img;
      Font f;
   	Numero n;
      public void init(){
         img = getImage(getCodeBase(),"nowy-start.jpg");
         setBackground(Color.gray);
         setForeground(Color.white);
         f = new Font("Times New Roman",Font.ITALIC,10);
         setFont(f);
      	n = new Numero(5);
      }
   
      public void paint(Graphics g){
      
     /*    g.setColor(Color.black);			
         g.fillRect(50,7,9*30,13*30);
         g.fillRect(340,100,130,100);
         g.fillRect(340,230,130,70);			
         g.drawLine(47,7,47,399);
         g.drawLine(323,7,323,399);
         g.drawLine(47,399,323,399);
         g.drawRect(338,98,134,104);
         g.drawRect(338,228,134,74);
         g.setColor(Color.orange);
         g.draw3DRect(49,6,272,392,false);
         g.draw3DRect(48,5,274,394,false);
         g.draw3DRect(339,99,132,102,false);
         g.draw3DRect(339,229,132,72,false);
         g.drawImage(img,50,7,270,390,this);
         g.setColor(Color.white);
         g.drawString("NEXT",350,120);
         g.drawString("LINES",350,250);
         g.setColor(Color.gray);
         g.drawLine(47,6,322,6);
         g.drawLine(47,5,322,5);*/
      	n.pintar(g);
      }
   }
