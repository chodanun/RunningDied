package RunningDiedGame;

import org.newdawn.slick.SlickException;

public class FastItemRock extends ItemRock {

	public FastItemRock (int x, int y) throws SlickException {
		super(x, y);
	}
	
	@Override
	public void moveRock() {
		extendSize();
		y+=4;
		if ( a==1 ) x-= 1.5 ;
		else if ( a==2) x-= 5 ;
		else x+= 2.3 ;
	}

}
