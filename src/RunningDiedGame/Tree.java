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
		moveTree();
		outOfScreen();
	}

	private void moveTree() {
		this.x -= Math.cos(Math.toRadians(25));
		this.y += Math.sin(Math.toRadians(25));
		
		sizeX+=1;
		sizeY+=1;
		x-=1;
		y-=1;
	}

	private void outOfScreen() {
		if ( x <= -200){
			x = 440 ;
			y = 56 ;
			sizeX=158;
			sizeY=199;
		}
	}
	
}
