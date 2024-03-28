package pdp_odev3;

import java.util.Random;

public class Koloni {

	private char sembol;
	private int populasyonSay;
	private int yemekSay;	
	private Taktik t;
	private Uretim u;
	private boolean durum;
	private int kazanmaSay;
	private int kaybetmeSay;
	
	Koloni(int sayi){
		
		Random rand = new Random();
		this.sembol = (char)(rand.nextInt(34) + 33);
		this.populasyonSay = sayi;
		this.yemekSay  = sayi * sayi;
		this.durum = true;
		this.kazanmaSay = 0;
		this.kaybetmeSay = 0;
	}
	public int kazanmaSayisi() {
		return kazanmaSay;
	}
	public void setKazanmaSayisiArttır() {
		this.kazanmaSay = this.kazanmaSay + 1;
	}
	public int kaybetmeSayisi() {
		return kaybetmeSay;
	}
	public void setKaybetmeSayisiArttır() {
		this.kaybetmeSay = this.kaybetmeSay +1;
	}
	public boolean koloniDurumu() {
		return durum;
	}
	public void setKoloniDurum(boolean deger) {
		this.durum = deger;
	}
	public char koloniSembol(){
		return sembol;
	}
	public int koloniSayisi() { 
		return populasyonSay;
	}
	public void SetKoloniSayisi(int say) {
		this.populasyonSay = say;
	}
	public int koloniYemek() {
		return yemekSay;
	}
	public void setKoloniYemek(int say) {
		this.yemekSay = say;
	}
	public int koloniSavas() {
		return t.Savas();
	}
	public Taktik getTaktik() {
		return this.t;
	}
	public void taktikSec() { 
		Random r = new Random();
		int random  = r.nextInt(2);
		
		if(random==1) {
			this.t = new Ataktik();
		}
		else {
			this.t = new Btaktik();
		}
	}
	public int uret() {
		return u.Uret();
	}
	public Uretim getUretim() {
		return this.u;
	}
	public void uretimSec() {
		Random r = new Random();
		int random  = r.nextInt(2);
		if(random==1) {
			this.u = new Auretim();
		}
		else {
			this.u = new Buretim();
		}
	}
}
