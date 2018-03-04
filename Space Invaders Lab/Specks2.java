import java.awt.Color;
import java.awt.Graphics;
 
 
public class Specks2{
     
     int x;
	 int y;
	 
	
	 Color blue;
	 Color green;
	 Color grey;
	 
	 public Specks2(){
		 x= (int)(Math.random()*799); //random 0 to 800
		 y= (int)(Math.random()*596); //random 0 to 600
		 blue = new Color (173,216,230);
		 green = new Color(46,139,87);
		 grey = new Color(169,169,169);
	 }
	 
	 public void drawMe(Graphics g){
        //specks
        g.setColor(blue);
        g.fillOval(x,y,3,3);
        
        g.setColor(green);
        g.fillOval(x+30,y-14,3,3);
        
        g.setColor(grey);
        g.fillOval(x+112,y-32,2,2);
	 }
	 
	 public void move(){
		 y++;
		 
		 if(y > 600){
			 y = -5;
			 x = (int)(Math.random()*799);
		 }
		 
	 }
     
}










