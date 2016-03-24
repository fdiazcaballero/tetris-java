
   package tetris;
   import java.awt.*;


   public class Numero{
   
      private byte[]numero;
   
      public Numero(int valor){
      
         switch(valor){
         
            case 0:
               byte[]numero0 = {0,0,1,1,1,0,
                  0,1,0,0,0,1,
                  0,1,0,0,0,1,
                  0,1,0,0,0,1,
                  0,0,1,1,1,0};
               numero = numero0;
               break;
            case 1:  byte[]numero1 = {0,0,0,1,0,0,
                  0,0,1,1,0,0,
                  0,0,0,1,0,0,
                  0,0,0,1,0,0,
                  0,0,1,1,1,0};
               numero = numero1;
               break;
            case 2: byte[]numero2 = {0,0,1,1,1,0,
                  0,0,0,0,0,1,
                  0,0,0,0,1,0,
                  0,0,0,1,0,0,
                  0,0,1,1,1,1};
               numero = numero2;
               break;
            case 3: byte[]numero3 = {0,0,1,1,1,0,
                  0,1,0,0,0,1,
                  0,0,0,1,1,0,
                  0,1,0,0,0,1,
                  0,0,1,1,1,0};
               numero = numero3;
               break;
            case 4: byte[]numero4 = {0,0,0,0,1,0,
                  0,0,0,1,1,0,
                  0,0,1,0,1,0,
                  0,1,1,1,1,1,
                  0,0,0,0,1,0};
               numero = numero4;
               break;
            case 5: byte[]numero5 = {0,1,1,1,1,1,
                  0,1,0,0,0,0,
                  0,1,1,1,1,1,
                  0,0,0,0,0,1,
                  0,1,1,1,1,0};
               numero = numero5;
               break;
            case 6:  byte[]numero6 = {0,0,1,1,1,0,
                  0,1,0,0,0,0,
                  0,1,1,1,1,0,
                  0,1,0,0,0,1,
                  0,0,1,1,1,0};
               numero = numero6;
               break;
            case 7: byte[]numero7 = {0,1,1,1,1,1,
                  0,0,0,0,0,1,
                  0,0,0,0,1,0,
                  0,0,0,1,0,0,
                  0,0,0,1,0,0};
               numero = numero7;
               break;
            case 8: byte[]numero8 = {0,0,1,1,1,0,
                  0,1,0,0,0,1,
                  0,0,1,1,1,0,
                  0,1,0,0,0,1,
                  0,0,1,1,1,0};
               numero = numero8;
               break;
            case 9 : byte[]numero9 = {0,0,1,1,1,0,
                  0,1,0,0,0,1,
                  0,0,1,1,1,1,
                  0,0,0,0,0,1,
                  0,0,1,1,1,0};
            
               numero = numero9;
               break;
            default:
               numero = new byte[30];
               break;
         }
      
      }
   
      public void pintar(Graphics g,int w,int h){
      
      
         for(int a=0,b=(h/4),c=(w/4);a<30;a++,c++){
            if(numero[a]==1){
            
               g.setColor(Color.orange);
               g.fillOval(c*4,b*4,4,4);
               g.setColor(Color.red);
               g.drawOval(c*4,b*4,4,4);
               g.drawOval(c*4+1,b*4+1,3,3);
               g.drawOval(c*4+2,b*4+2,2,2);
               g.drawOval(c*4+3,b*4+3,1,1);
               g.setColor(Color.white);
               g.fillOval(c*4+2,b*4+2,1,1);
            
            }
            if(c==5+(w/4)){
               c=(w/4)-1;
               b++;
            }			
         }
      }
   }