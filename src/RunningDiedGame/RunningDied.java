package RunningDiedGame;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class RunningDied extends BasicGame {
	
	private Image image , overImage;
	private BoyDied boy ;
	private Tree[] trees = new Tree[5] ; 
	private ItemRock rock , rock2;
	private Boolean isGameOver = false;
	private FastItemRock fastrock ;
	private static int score = 0 ;
	
	public RunningDied(String title){
		super(title);
	}
	
	@Override
	public void render(GameContainer arg0, Graphics point) throws SlickException {
		if ( isGameOver == false){
			image.draw(0,-5);
			for (Tree tree : trees){
				tree.render();
			}
			rock.render();
			fastrock.render();
			boy.render();	
			
			point.drawString("" + score , 540, 35);
		}
		else{
			overImage.draw(0,0);
		}
	}

	@Override
	public void init(GameContainer arg) throws SlickException {
		image = new Image("res/background.png");
		overImage = new Image("res/gameover.png");
		initTree();
		rock = new ItemRock(620,230) ;
		fastrock = new FastItemRock (620,230);
		boy = new BoyDied(440,440);
		
	}
	
	private void initTree() throws SlickException {
		trees[0] = new Tree(420,60);
		trees[1] = new Tree(336,110);
		trees[2] = new Tree(246,164);
		trees[3] = new Tree(104,222);
		trees[4] = new Tree(-24,286);
	}

	@Override
	public void update(GameContainer arg0, int arg1) throws SlickException {
		if(isGameOver == false){
			for (Tree tree : trees){
				tree.update();
			}
			boy.checkJump();
			rock.update();
			fastrock.update();
			checkCollisionRock();
			score++;
		}
	}
	
	private void checkCollisionRock(){
		if ( rock.getY() >=500 && rock.getY()<=630){
			if (Math.abs(boy.getX()-rock.getX())<=50 ){
				isGameOver = true ;
			}
		}
		if ( fastrock.getY() >=520 && fastrock.getY()<=650){
			if (Math.abs(boy.getX()-fastrock.getX())<=50 ){
				isGameOver = true ;
			}
		}
		
	}
	@Override
	public void keyPressed (int key, char c) {
		if (key == Input.KEY_RIGHT) {
			boy.moveRight();
	    }
		else if (key == Input.KEY_LEFT){
			boy.moveLeft();
		}else if (key == Input.KEY_SPACE){
			if (boy.getY()==440){
				boy.jump();
			}
		}
		else if (key == Input.KEY_ENTER){
			try {
				init(null);
			} catch (SlickException e) {}
			isGameOver = false ;
		}
		
	}
	public static void main (String[] args){
		 try {
		    	RunningDied game = new RunningDied("Running Too Died Guys GG!!");
		      	AppGameContainer appgc = new AppGameContainer(game);
		      	appgc.setDisplayMode(1024,650,false);
		      	appgc.setTargetFrameRate(100);
		      	appgc.start();
		    } catch (SlickException e) {
		    	  e.printStackTrace();
		    }
	}

}
