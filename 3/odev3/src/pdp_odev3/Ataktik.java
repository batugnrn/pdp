package pdp_odev3;

import java.util.Random;

public class Ataktik extends Taktik{

	@Override
	int Savas() {
		
		Random rand = new Random();
		super.sonuc = (rand.nextInt(1,1000)/2) +270 ;
		return sonuc;
		
	}

}
