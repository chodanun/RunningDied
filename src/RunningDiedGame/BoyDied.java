package RunningDiedGame;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class BoyDied  {

	private Image image ;
	private float x ;
	private float y ;
	private int delaytime = 0 ;
	private String action = "res/boy.png" ;
	
	public BoyDied(float x, float y) throws SlickException{
		image = new Image(action);
		this.x = x ;
		this.y = y ;
	}
	
	public void render () throws SlickException{
		image.draw(x,y);
		changeAction();
	}
	public void changeAction () throws SlickException{
		if ( delaytime > 10 ){
			image = new Image(action);
			if ( action == "res/boy.png"){ 
				action = "res/boy2.png";
			}
			else {
				action = "res/boy.png";
			}
			delaytime = 0 ;
		}
		delaytime++;
	}
	
	public void moveRight (){
		if ( x == 100 ){
			x = 440;
		}
		else {
			x = 750 ;
		}
	}
	
	public void moveLeft (){
		if ( x == 750){
			x = 440 ;
		}
		else {
			x = 100 ;
		}
	}
	
	public void jump (){
		y-=200;
	}
	
	public void checkJump(){
		if (y<440){
			y+=5;
		}
	}
	
	public float getX (){
		return this.x;
	}
	
	public float getY (){
		return this.y;
	}
	
}
