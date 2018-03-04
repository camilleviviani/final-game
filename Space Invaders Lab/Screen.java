import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
 
 
public class Screen extends JPanel implements KeyListener{

	Player p1;
	Player2 p2;
	Projectile projectile;
	Projectile2 projectile2;
	Enemy[] enemy;
	Enemy2[] enemy2;
	boolean promove;
	boolean visible;
	boolean visible2;
	boolean level1;
	boolean level2;
	int score;
	int lives;
	int x;
	int proY;
	int proY2;
	boolean promove2;
	boolean promove3;
	int level;
	Background[] background;
	Specks[] specks;
	Specks2[] specks2;
	Bubbles[] bubbles;
	Bubbles2[] bubbles2;
	Fish[] fish;
	boolean player2;
	
	
	Color blue;
	Color yellow;
	Color orange;
	Color tan;
	Color tan2;
	Color black;
	Color red;
	Color red2;
	Color darkblue;
	Color lightblue;
	Color salmon;
	Color grey;
	
	public Screen(){
		p1 = new Player(385,440);
		p2 = new Player2(200,440);
		projectile = new Projectile(425,520);
		projectile2 = new Projectile2(390,520);
		enemy = new Enemy[6];
		enemy2 = new Enemy2[15];
		visible=false;
		visible2=false;
		proY= 320;
		proY2=320;
		promove2= false;
		promove3=false;
		lives=3;
		level=0;
		level1=false;
		level2=false;
		background = new Background[20];
		specks = new Specks[150];
		specks2 = new Specks2[150];
		bubbles = new Bubbles[150];
		bubbles2 = new Bubbles2[150];
		fish = new Fish[20];
		player2=false;

		
		
		blue= new Color(173,216,230);
		yellow = new Color(216,191,216);
		orange = new Color(255,127,80);
		tan = new Color(245,222,179);
		tan2 = new Color(222,184,135);
		black = new Color(0,0,0);
		red = new Color(250,128,114);
		red2 = new Color(255,69,0);
		darkblue = new Color(72,61,139);
		lightblue = new Color(173,216,230);
		salmon = new Color(255,160,122);
		grey = new Color(169,169,169);
		
		for(int spot=0; spot<enemy.length; spot++){
       		enemy[spot] = new Enemy();
       	}
       	
       	for(int spot=0; spot<enemy2.length; spot++){
       		enemy2[spot] = new Enemy2();
       	}
       	
       	for(int spot=0; spot<background.length; spot++){
        		background[spot] = new Background();
        }
        
        for(int spot=0; spot<specks.length; spot++){
        		specks[spot] = new Specks();
        }
        
        for(int spot=0; spot<specks2.length; spot++){
        		specks2[spot] = new Specks2();
        }
        
        for(int spot=0; spot<bubbles.length; spot++){
        		bubbles[spot] = new Bubbles();
        }
        
        for(int spot=0; spot<bubbles2.length; spot++){
        		bubbles2[spot] = new Bubbles2();
        }
        
        for(int spot=0; spot<fish.length; spot++){
        		fish[spot] = new Fish();
        }
        
        
		
		
		setFocusable(true);
		addKeyListener(this);
	}
 
    public Dimension getPreferredSize() {
        //Sets the size of the panel
        return new Dimension(800,600);
    }
     
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(level==0){
        	g.setColor(grey);
        	g.fillRect(0,0,800,600);
        	Font font7 = new Font("Rockwell", Font.PLAIN, 50);
			g.setFont(font7);
			Font font8 = new Font("Rockwell", Font.PLAIN, 160);
			g.setFont(font8);
        	g.setColor(darkblue);
        	g.drawString("READY",145,275);
        	g.setFont(font7);
        	g.drawString("press 1 for 1 player",145,355);
        	g.drawString("press 2 for 2 players",137,430);
        
        }
        
        
        if(level==1){
      	 	//background
        	g.setColor(darkblue);
        	g.fillRect(0,0,800,600);
        	
        	for(int spot=0; spot<background.length; spot++){
        		background[spot].drawMe(g);
        	}
        	for(int spot=0; spot<specks.length; spot++){
        		specks[spot].drawMe(g);
        	}
        	for(int spot=0; spot<specks2.length; spot++){
        		specks2[spot].drawMe(g);
        	}
        }
        
        //level 2
        if(level==2){
        	g.setColor(lightblue);
        	g.fillRect(0,0,800,600);
        	for(int spot=0; spot<bubbles.length; spot++){
        		bubbles[spot].drawMe(g);
        	}
        	
        	for(int spot=0; spot<bubbles2.length; spot++){
        		bubbles2[spot].drawMe(g);
        	}
        	
        	for(int spot=0; spot<fish.length; spot++){
        		fish[spot].drawMe(g);
        	}
        }
        
        //score
        Font font = new Font("Rockwell", Font.PLAIN, 30);
		g.setFont(font);
        g.setColor(orange);
        g.drawString("score: ",50,100);
        Font font2 = new Font("Book Antiqua", Font.PLAIN, 45);
		g.setFont(font2);
		g.setColor(orange);
        g.drawString(""+score,50,150);
        
        //lives
        Font font5 = new Font("Rockwell", Font.PLAIN, 30);
		g.setFont(font5);
        g.setColor(orange);
        g.drawString("lives: ",50,200);
        
		g.setFont(font2);
		g.setColor(orange);
        g.drawString(""+lives,50,250);
        
        //level
		g.setFont(font5);
        g.setColor(orange);
        g.drawString("level: ",50,300);
        
		g.setFont(font2);
		g.setColor(orange);
        g.drawString(""+level,50,350);
        
        //if player wins
        if(score==21 && lives>0){
        	Font font3 = new Font("Arial", Font.PLAIN, 100);
			g.setFont(font3);
     		g.setColor(orange);
     		g.drawString("YOU WIN",150,300);
     		Font font10 = new Font("Arial", Font.PLAIN, 50);
			g.setFont(font10);
     		g.drawString("press r to restart",200,500);
     	}
       
        //if player loses 
        if(lives<1){
     		Font font3 = new Font("Arial", Font.PLAIN, 100);
			g.setFont(font3);
     		g.setColor(orange);
     		g.drawString("GAME OVER",150,300);
     		Font font10 = new Font("Arial", Font.PLAIN, 50);
			g.setFont(font10);
     		g.drawString("press r to restart",200,500);
     		
     		for(int spot=0; spot<enemy.length; spot++){
     			enemy[spot].gameOver();
     		}
     		
     		for(int spot=0; spot<enemy2.length; spot++){
     			enemy2[spot].gameOver();
     		}
     	}
        
        p1.drawMe(g);
        
        if(player2==true){
        	p2.drawMe(g);
        }
        
        if(visible==true){
        	projectile.drawMe(g);
        }
        
        if(visible2==true){
        	projectile2.drawMe(g);
        }
        
        if(level1==true && lives>0){
        	for(int spot=0; spot<enemy.length; spot++){
        		enemy[spot].drawMe(g);
        	}
        }
        
        if(level2==true){
        	for(int spot=0; spot<enemy2.length; spot++){
        			enemy2[spot].drawMe(g);
        	}
        }
        
        
    } 
    
    public void playSound() {

        try {
            URL url = this.getClass().getClassLoader().getResource("sound/laser.wav");
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }
    
    
    public void keyPressed(KeyEvent e){
    	//System.out.println( e.getKeyCode());
    	if(e.getKeyCode()==39){
    		//move player1 right
    		p1.moveRight();
    		proY = proY-15;
    	}
    	
    	if(e.getKeyCode()==37){
    		//move player2 left
    		p1.moveLeft();
    		proY = proY+15;
    	}
    	
    	if(e.getKeyCode()==68){
    		//move player2 right with d
    		if(player2==true){
    			p2.moveRight2();
    			proY2 = proY2-15;
    		}
    	}
    	
    	if(e.getKeyCode()==65){
    		//move player2 left with a 
    		if(player2==true){
    			p2.moveLeft2();
    			proY2 = proY2+15;
    		}
    	} 
    	
    	//press space bar to shoot first projectile
    	if(e.getKeyCode()==32){
    		visible=true;
    		//visible2=true;
    		//shoots the projectile;
    		projectile.fire(p1.getX(), p1.getY());
    		
    		promove2=true;
    		
    		this.playSound();
    	}
    	
    	//press s to shoot second projectile
    	if(e.getKeyCode()==83){
    		visible2=true;
    		visible=true;
    		//shoots the projectile;
    		
    		if(player2==true){
    			projectile2.fire2(p2.getX2(), p2.getY2());
    			promove3=true;
    		}
    		
    		this.playSound();
    	}
    	
    	
    	
    	//press p to go to level 2
    	if(e.getKeyCode()==80){
    		level1 = false;
    		level2 = true;
    		level = 2;
    		score = 6;
    		p1.levelCostume2();
    		
    		if(player2==true){
    			p2.levelCostume2();
    		}	
    		
    		for(int spot=0; spot<enemy.length; spot++){
        		enemy[spot].gameOver();
        	}
        	for(int i=0; i<enemy2.length; i++){
        		enemy2[i].startOver();
        	}
        	
    	}
    	
    	//press 1 to start with one player
    	if(e.getKeyCode()==49){
    		level = 1;
    		level2 = false;
    		level1 = true;
				
    	}
    	
    	//press 2 to start with two players
    	if(e.getKeyCode()==50){
    		level = 1;
    		level2 = false;
    		level1 = true;
    		player2 = true;
				
    	}
    	
    	//press r to start over
    	if(e.getKeyCode()==82){
    		lives = 3;
    		score = 0;
    		level = 0;
    		level1 = false;
    		level2 = false;
    		for(int i=0; i<enemy.length; i++){
        		enemy[i].startOver();
        	}
        	for(int i=0; i<enemy2.length; i++){
        		enemy2[i].startOver();
        	}
        	p1.levelCostume1();
    	}
    	
    	repaint();
    
    }
    
    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}
    
     public void animate(){
        while(true)
        {	
        		projectile.moveRight();
        		projectile2.moveRight2();
        		
        		
        		if(level1==true && level==1){
        			for(int spot=0; spot<enemy.length; spot++){
        				enemy[spot].move();
        			}
        			
        			for(int spot=0; spot<background.length; spot++){
        				background[spot].move();
        			}
        			
        			for(int spot=0; spot<specks.length; spot++){
        				specks[spot].move();
        			}
        			
        			for(int spot=0; spot<specks2.length; spot++){
        				specks2[spot].move();
        			}
        		}
        		
        		if(level2==true && level==2){
        			for(int spot=0; spot<enemy2.length; spot++){
        				enemy2[spot].move();
        			}
        			
        			for(int spot=0; spot<enemy.length; spot++){
        				enemy[spot].gameOver();
        			}
        		}
        		
        		int tempY = proY;
        		int tempY2 = proY2;
        		if(promove2==true){
        			proY--;
        			if(proY==305){
        				proY=320;
        				promove2=false;
        			}
        		}
        		
        		if(promove3==true){
        			proY2--;
        			if(proY2==305){
        				proY2=320;
        				promove3=false;
        			}
        		}
        		
        		x++;
        		//check collision
        		
        		if(level1==true){
        			for(int spot=0; spot<enemy.length; spot++){
        				enemy[spot].checkCollision(projectile);
        				enemy[spot].checkCollision2(projectile2);
        			}
        		}
        		
        		for(int spot=0; spot<enemy.length; spot++){
        			boolean result = enemy[spot].checkPlayerCollision(p1);
        			if(result == true){
        				lives--;
        				for(int i=0; i<enemy.length; i++){
        					enemy[i].startOver();
        				}
        				break;
        			}
        		}
        		
        		if(player2==true && level1==true){
        			for(int spot=0; spot<enemy.length; spot++){
        				boolean result = enemy[spot].checkPlayerCollision2(p2);
        				if(result == true){
        					lives--;
        					for(int i=0; i<enemy.length; i++){
        						enemy[i].startOver();
        					}
        					break;
        				}
        			}
        		}
        		
        		for(int spot=0; spot<enemy.length; spot++){
        			if(enemy[spot].spot()>550){
        				lives--;
        				for(int i=0; i<enemy.length; i++){
        					enemy[i].startOver();
        				}
        				break;
        			}
        		}

        		
        		if(level2==true){
        			for(int spot=0; spot<enemy2.length; spot++){
        				enemy2[spot].checkCollision(projectile);
        				enemy2[spot].checkCollision2(projectile2);
        				//enemy2[spot].checkPlayerCollision(p1);
        				//enemy2[spot].checkPlayerCollision2(p2);
        			}
        		}
        		
        		for(int spot=0; spot<enemy2.length; spot++){
        			boolean result2 = enemy2[spot].checkPlayerCollision(p1);
        			if(result2 == true && lives>1){
        				lives--;
        				for(int i=0; i<enemy2.length; i++){
        					enemy2[i].startOver();
        				}
        				break;
        			}
        			
        			if(result2 == true && lives<2){
        				for(int i=0; i<enemy.length; i++){
        					enemy[i].startOver();
        				}
        				lives = 3;
        				score = 0;
        				level = 1;
        				level2 = false;
        				level1 = true;
        			}
        		}
        		
        		if(player2==true){
        			for(int spot=0; spot<enemy2.length; spot++){
        				boolean result2 = enemy2[spot].checkPlayerCollision2(p2);
        				if(result2 == true && lives>0){
        					lives--;
        					for(int i=0; i<enemy2.length; i++){
        						enemy2[i].startOver();
        					}
        					break;
        				}
        			}
        		}
        		
        		for(int spot=0; spot<enemy2.length; spot++){
        			if(enemy2[spot].spot()>550){
        				lives--;
        				for(int i=0; i<enemy2.length; i++){
        					enemy2[i].startOver();
        				}
        				break;
        			}
        		}
        		
    			score=0;
    	
    			
    			if(level1==true){
    			//level 1
    				for(int i=0; i<enemy.length; i++){
    					if(enemy[i].getVisible()==false){
    						score++;
    					}
    				}
    			
    				
    				if(score==6){
    					level1 = false;
    					level2 = true;
    					level = 2;
    					score=6;
    					for(int spot=0; spot<enemy.length; spot++){
        					enemy[spot].gameOver();
        				}
        				for(int spot=0; spot<enemy2.length; spot++){
        					enemy2[spot].startOver();
        				}
        			}	
        			
        			p1.levelCostume1();
        			
        			if(player2==true){
        				p2.levelCostume1();
        			}
    			}
    			
    			
    			if(level2==true){
    				//level 2
    				score = 6;
    				for(int i=0; i<enemy2.length; i++){
    					if(enemy2[i].getVisible()==false){
    						score++;
    					}
    				}
    				
    				for(int i=0; i<bubbles.length; i++){
    					bubbles[i].move();
    				}
    				
    				for(int i=0; i<bubbles2.length; i++){
    					bubbles2[i].move();
    				}
    				
    				for(int i=0; i<fish.length; i++){
    					fish[i].move();
    				}
    				
    				p1.levelCostume2();
    				
    				if(player2==true){
    					p2.levelCostume2();
    				}
    				
    			}
        	
            //wait for .01 second
            try {
                Thread.sleep(40);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
 
            //repaint the graphics drawn
            repaint();
        }
    }    
}