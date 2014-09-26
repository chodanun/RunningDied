package RunningDiedGame;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class RunningDied extends BasicGame {
	
	private Image image ;
	private BoyDied boy ;
	private Tree[] trees = new Tree[5] ; 
	private int delayTime = 0 ;
	private ItemRock rock ;
	
	public RunningDied(String title){
		super(title);
	}
	
	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		image.draw(0,-5);
		for (Tree tree : trees){
			tree.render();
		}
		boy.render();
		rock.render();
			
	}

	@Override
	public void init(GameContainer arg) throws SlickException {
		image = new Image("res/background.png");
		boy = new BoyDied(440,440);
		initTree();
		rock = new ItemRock() ;
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
		for (Tree tree : trees){
			tree.update();
		}
		boy.checkJump();
		rock.update();
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
