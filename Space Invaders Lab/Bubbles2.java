import java.awt.Color;
import java.awt.Graphics;
 
 
public class Bubbles2{
     
     int x;
	 int y;
	 
	
	 Color blue;
	 
	 public Bubbles2(){
		 x= (int)(Math.random()*799); //random 0 to 800
		 y= (int)(Math.random()*596); //random 0 to 600
		 blue = new Color (30,144,255);
	 }
	 
	 public void drawMe(Graphics g){
        //specks
        g.setColor(blue);
        g.drawOval(x,y,5,5);
        
        
	 }
	 
	 public void move(){
		 y++;
		 
		 if(y > 600){
			 y = -5;
			 x = (int)(Math.random()*799);
		 }
		 
	 }
     
}










