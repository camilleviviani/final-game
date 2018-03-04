import java.awt.Color;
import java.awt.Graphics;
 
 
public class Fish{
     
     int x;
	 int y;
	 
	
	 Color red;
	 Color black;
	 
	 public Fish(){
		 x= (int)(Math.random()*799); //random 0 to 800
		 y= (int)(Math.random()*596); //random 0 to 600
		 red = new Color (250,128,114);
		 black = new Color(0,0,0);
	 }
	 
	 public void drawMe(Graphics g){
        //specks
        g.setColor(red);
        g.fillOval(x,y,10,14);
        g.fillOval(x+2,y+10,7,7);
        
        g.setColor(black);
        g.fillOval(x+3,y+3,3,3);
        
        
	 }
	 
	 public void move(){
		 y--;
		 
		 if(y < 0){
			 y = 605;
			 x = (int)(Math.random()*799);
		 }
		 
	 }
     
}










