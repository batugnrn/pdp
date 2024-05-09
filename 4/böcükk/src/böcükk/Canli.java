package böcükk;

public abstract class Canli {

	public boolean hayatta_mi = false;
	public int X_koordinat = 0;
	public int Y_koordinat = 0;
	public String adi = "";
	public int deger = 0;
	Canli(int x, int y, int Deger){
		X_koordinat = x;
		Y_koordinat = y;
		deger = Deger;
		
		//System.out.println(X_koordinat);
		//System.out.println(Y_koordinat);
	}
	
}
