package RunningDiedGame;

import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ItemRock {

	private Image image ;
	protected float x ;
	protected float y ;
	protected float sizeX = 50;
	protected float sizeY = 50;
	protected int a ;
	Random random = new Random ();
	BoyDied boy = new BoyDied (1,1);
	
	public ItemRock(int x , int y) throws SlickException {
		image = new Image("res/rock.png");
		a = random.nextInt(3);
		this.x = x ;
		this.y = y ;
		
	}
	
	public void render(){
		image.draw(x,y,sizeX,sizeY);
	}
	
	public void update(){
		moveRock();
		outOfScreen();
	}

	public void moveRock() {
		extendSize();
		y+=2;
		if ( a==1 ) x-=0.7 ;
		else if ( a==2) x-=2.8 ;
		else x+=1.1 ;
	}

	protected void extendSize() {
		sizeX+=0.2;
		sizeY+=0.2;
	}

	private void outOfScreen() {
		if ( y>=660){
			x = 620;
			y = 230;
			System.out.println(sizeX);
			sizeX = 50;
			sizeY = 50;
			a = random.nextInt(3);
		}
	}
	
	public float getX (){
		return this.x ;
	}
	
	public float getY (){
		return this.y ;
	}

}
