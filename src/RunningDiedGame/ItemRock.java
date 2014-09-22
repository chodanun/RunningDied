package RunningDiedGame;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ItemRock {

	private Image image ;
	private float x ;
	private float y ;
	private int scale ;
	public ItemRock(float x , float y , int scale) throws SlickException {
		image = new Image("res/rock.png");
		this.x = x ;
		this.y = y ;
		this.scale= scale ;
	}
	
	public void render(){
		image.draw(x,y);
	}

}
