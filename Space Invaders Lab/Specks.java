import java.awt.Color;
import java.awt.Graphics;
 
 
public class Specks{
     
     int x;
	 int y;
	 
	
	 Color black;
	 
	 public Specks(){
		 x= (int)(Math.random()*799); //random 0 to 800
		 y= (int)(Math.random()*596); //random 0 to 600
		 black = new Color (0,0,0);
	 }
	 
	 public void drawMe(Graphics g){
        //specks
        g.setColor(black);
        g.fillOval(x,y,3,3);
        
        
	 }
	 
	 public void move(){
		 y++;
		 
		 if(y > 600){
			 y = -5;
			 x = (int)(Math.random()*799);
		 }
		 
	 }
     
}










