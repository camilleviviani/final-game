import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
 
public class Enemy{
    int x;
    int y;
    int lives;
    int tempY;
    double move;
    
    int score;
    int toggle;
     
    int width;
    int height;
     
    Color purple;
    Color black;
    Color white;
    
    boolean visible;
    boolean visible2;
    boolean bottom;
     
    public Enemy(){
         
        this.x = (int)(Math.random()*650+50);
        this.y = (int)(Math.random()*150+20);
        this.tempY = y;
         
        this.width = 50;
        this.height = 50;
         
 
        this.purple = new Color(128,0,128);
        this.black = new Color(0,0,0);
        this.white = new Color(255,255,255);
            
        this.visible = true; 
        this.visible2 = true;
        this.score = 0;
        this.toggle = 1;
        
        this.lives=3;
        this.bottom = false;
        
        
    }
     
 
    public void drawMe(Graphics g){
     	
     	if(visible){
       		g.setColor(white);
        	g.fillRect(x,y,width,height); 	
        	
        	g.setColor(black);
        	g.fillRect(x+12,y+15, width-42,height-42);
        	g.fillRect(x+28,y+15, width-42,height-42);
        	g.fillRect(x+13,y+32, width-27,height-45);
        	
        }
         
    }
     
    public void playSound() {

        try {
            URL url = this.getClass().getClassLoader().getResource("sound/lose2.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }
    
    public void checkCollision(Projectile projectile){
    	if(visible == true && projectile.getVisible()==true){
    		int pX = projectile.getX();
    		int pY = projectile.getY();
    		int pWidth = projectile.getWidth();
    		int pHeight = projectile.getHeight();
    		
    		if(pX + pWidth >= x && pX <= x+width
    			&&pY+pHeight>= y && pY <= y+height){
    			visible = false;
    			score= score+1;
    			this.playSound();
    			
    		}
    	}
    }
    
    public void checkCollision2(Projectile2 projectile2){
    	if(visible == true && projectile2.getVisible2()==true){
    		int pX = projectile2.getX2();
    		int pY = projectile2.getY2();
    		int pWidth = projectile2.getWidth2();
    		int pHeight = projectile2.getHeight2();
    		
    		if(pX + pWidth >= x && pX <= x+width
    			&&pY+pHeight>= y && pY <= y+height){
    			visible = false;
    			score= score+1;
    			this.playSound();
    			
    		}
    	}
    }
    
    public boolean checkPlayerCollision(Player player){
    	if(visible2 == true){
    		int pX = player.getX();
    		int pY = player.getY();
    		int pWidth = player.getWidth();
    		int pHeight = player.getHeight();
    		
    		if(pX + pWidth >= x && pX <= x+width
    			&&pY+pHeight>= y && pY <= y+height){
    			visible2 = false;
    			return true;	
    		}
    	}
    	return false;
    }
    
    public boolean checkPlayerCollision2(Player2 player2){
    	if(visible2 == true){
    		int pX = player2.getX2();
    		int pY = player2.getY2();
    		int pWidth = player2.getWidth2();
    		int pHeight = player2.getHeight2();
    		
    		if(pX + pWidth >= x && pX <= x+width
    			&&pY+pHeight>= y && pY <= y+height){
    			visible2 = false;
    			return true;	
    		}
    	}
    	return false;
    }
    
    public boolean getVisible(){
    	return visible;
    }
    
    public boolean getVisible2(){
    	return visible2;
    }
    
    public int getScore(){
    	return score;
    }
    
    public void move(){
    	if(x<730 && toggle==1){
    		x++;
    		if(x==730){
    			toggle=0;
    		}
    	}
    			
    	else if(x>50 && toggle==0){
    		x--;
    		if(x==50){
    			toggle=1;
    		}
    	}
    	y++;
    	
    }
    
    public void move2(){
    	if(x<730 && toggle==1){
    		x+=2;
    		if(x==730){
    			toggle=0;
    		}
    	}
    			
    	else if(x>50 && toggle==0){
    		x-=2;
    		if(x==50){
    			toggle=1;
    		}
    	}
    	y++;
    	
    }
    
    public void gameOver(){
    	visible = false;
        tempY = 800;
    
    }
    
    public void startOver(){
    	visible = true;
        y = (int)(Math.random()*150+20);
    
    }
    
    public int lives(){
    	return lives;
    }
    
    public boolean reachBottom(){
    
    	if(y>550){
    		bottom=true;
    	}
    		return bottom;
    }
    
    
    public int spot(){
    	return y;
    }

}