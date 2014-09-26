package RunningDiedGame;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ItemRock {

	private Image image ;
	private float x ;
	private float y ;
	private int sizeX = 10;
	private int sizeY = 10;
	public ItemRock() throws SlickException {
		image = new Image("res/rock.png");
		x = 690 ;
		y = 310 ;
	}
	
	public void render(){
		image.draw(x,y,sizeX,sizeY);
	}
	
	public void update(){
		x -= 2*Math.cos(Math.toRadians(70));
		y += 2*Math.sin(Math.toRadians(70));
		if ( y >= 660){
			x = 690 ;
			y =310 ;
			sizeX=10;
			sizeY=10;
			 
		}
		sizeX+=1;
		sizeY+=1;
		x-=1;
		y-=1;
	}

}
