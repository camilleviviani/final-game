import java.awt.Color;
import java.awt.Graphics;
 
public class Projectile2{
    int x;
    int y;
     
    int width;
    int height;
    
    boolean visible;
     
    Color red;
 
     
    public Projectile2(int x, int y){
         
        this.x = x;
        this.y = y;
         
        this.width = 10;
        this.height = 10;
         
        this.red = new Color(255,0,0);
        
        visible= false;
 
    }
     
 
    public void drawMe(Graphics g){
 
        g.setColor(red);
        g.fillOval(x,y,width,height);
         
    }
     
     
     
    public int getX2(){
        return x;
    }
     
    public int getY2(){
        return y;
    }
     
    public int getWidth2(){
        return width;
    }
     
    public int getHeight2(){
        return height;
    }
    
    public void moveRight2(){
    	if(visible){
    		y-=28;
    		
    		if(y < -7 ){
    			visible = false;
    		}
    	}
    }
    
    public void fire2(int playerX, int playerY){
		if(visible==false){
    		x = playerX-5;
    		y = playerY;
    		visible = true;
    	}
    }
    
    public boolean getVisible2(){
    	return visible;
    } 
}