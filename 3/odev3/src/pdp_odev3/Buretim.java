package pdp_odev3;

import java.util.Random;

public class Buretim extends Uretim{

	@Override
	int Uret() {

		Random rand = new Random();
		super.yemek = (rand.nextInt(1,10)/3)+5;
		return yemek;
		
	}

}
