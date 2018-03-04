import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
 
public class Enemy2{
    int x;
    int y;
    int tempY;
    double move;
    
    int score;
    int toggle;
     
    int width;
    int height;
     
    Color purple;
    Color black;
    Color white;
    Color red;
    
    boolean visible;
    boolean visible2;
     
    public Enemy2(){
         
        this.x = (int)(Math.random()*650+50);
        this.y = (int)(Math.random()*150+20);
        this.tempY = y;
         
        this.width = 50;
        this.height = 50;
         
 
        this.purple = new Color(219,112,147);
        this.black = new Color(0,0,0);
        this.white = new Color(255,255,255);
        this.red = new Color(255,69,0);
            
        this.visible = true; 
        this.visible2 = true;
        this.score = 0;
        this.toggle = 1;
        
        
    }
     
 
    public void drawMe(Graphics g){
     	
     	if(visible){
     		//face
       		g.setColor(white);
        	g.fillRect(x,y,width,height); 
        	g.fillOval(x,y-6,width-31,height-30);
        	g.fillOval(x+15,y-6,width-31,height-30);
        	g.fillOval(x+30,y-6,width-31,height-30);
        	
        	//eyes	
        	g.setColor(red);
        	g.fillRect(x+12,y+15, width-42,height-42);
        	g.fillRect(x+28,y+15, width-42,height-42);
        	
        	//eyebrows
        	g.setColor(black);
        	g.fillRect(x+10,y+9,width-40,height-47);
        	g.fillRect(x+26,y+9,width-40,height-47);
        	
        	//mouth
        	g.setColor(red);
        	g.fillRect(x+13,y+32, width-27,height-45);
        	g.fillRect(x+10,y+32, width-47,height-40);
        	g.fillRect(x+35,y+32, width-47,height-40);
        	
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
    
    //projectile hits enemy
    public void checkCollision(Projectile projectile){
    	if(visible == true && projectile.getVisible()==true){
    		int pX = projectile.getX();
    		int pY = projectile.getY();
    		int pWidth = projectile.getWidth();
    		int pHeight = projectile.getHeight();
    		
    		if(pX + pWidth >= x && pX <= x+width
    			&&pY+pHeight>= y && pY <= y+height){
    			visible = false;
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
    
    //enemy hits player
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
    	if(x<749 && toggle==1){
    		x+=4;
    		if(x>748){
    			toggle=0;
    		}
    	}
    			
    	if(x>51 && toggle==0){
    		x-=2;
    		if(x<52){
    			toggle=1;
    		}
    	}
    	y++;
    	
    }
    
    public void startOver(){
    	visible = true;
        y = (int)(Math.random()*150+20);
    
    }
    
    public void gameOver(){
    	visible = false;
        tempY = 800;
    
    }
    
    public int spot(){
    	return y;
    }

}