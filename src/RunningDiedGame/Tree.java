package RunningDiedGame;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Tree {
	
	Image image ;
	private float x ;
	private float y ;
	private float sizeX = 158 ,sizeY = 199 ;
	
	public Tree(float x , float y) throws SlickException {
		image = new Image("res/tree1.png");
		this.x = x ;
		this.y = y ;
	}
	
	public void render (){
		image.draw(x,y,sizeX,sizeY);
	}
	
	public void update (){
		this.x -= Math.cos(Math.toRadians(25));
		this.y += Math.sin(Math.toRadians(25));
		if ( x <= -100){
			x = 440 ;
			y = 56 ; 
		}
			
	}
}
