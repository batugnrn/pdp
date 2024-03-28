package pdp_odev3;

import java.util.Random;

public class Btaktik extends Taktik{

	@Override
	int Savas() {
		
		Random rand = new Random();
		super.sonuc = (rand.nextInt(1,1000)/3)+471;
		return sonuc;
		
	}

}
