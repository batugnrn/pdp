package pdp_odev3;

import java.util.Random;

public class Auretim extends Uretim{

	@Override
	int Uret() {
		
		Random rand = new Random();
		super.yemek = (rand.nextInt(1,10)/2)+4;
		return yemek;
		
	}

}
