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

	BoyDied boy ;
	Image image ;
	
	public RunningDied(String title){
		super(title);
	}
	
	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		image.draw(0,-5);
		boy.render();
	}

	@Override
	public void init(GameContainer arg) throws SlickException {
		image = new Image("res/background.png");
		boy = new BoyDied(440,440);
	}

	@Override
	public void update(GameContainer arg0, int arg1) throws SlickException {
		
	}
	
	@Override
	public void keyPressed (int key, char c) {
		if (key == Input.KEY_RIGHT) {
			boy.moveRight();
	    }
		else if (key == Input.KEY_LEFT){
			boy.moveLeft();
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
