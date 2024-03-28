package pdp_odev3;

import java.util.Random;
import java.lang.Thread;

public class Oyun {
	
	private void OyunKurallari(Koloni a, Koloni b) {
		
		a.taktikSec();
		b.taktikSec();
		
		int aSavasSonucu = a.koloniSavas();
		int bSavasSonucu = b.koloniSavas();
		
		if(aSavasSonucu>bSavasSonucu) {       // a kolonisin kazanması
			int yeniOran= (int)(((aSavasSonucu-bSavasSonucu)/10));
			int q =b.koloniSayisi()-yeniOran;
			b.SetKoloniSayisi(q);
			int ganimet = b.koloniYemek() /10;
			a.setKoloniYemek(a.koloniYemek()+ganimet);
			b.setKoloniYemek(b.koloniYemek()-ganimet);
			a.setKazanmaSayisiArttır();
			b.setKaybetmeSayisiArttır();
			if(b.koloniYemek()<0||b.koloniSayisi()<0) {
				b.setKoloniDurum(false);
			}
		}
		else if(aSavasSonucu<bSavasSonucu) {     // b kolonisinin kazanması 
			int yeniOran =(int)(((bSavasSonucu-aSavasSonucu)/10));
			int q =a.koloniSayisi()-yeniOran;
			a.SetKoloniSayisi(q);
			int ganimet = a.koloniYemek()/10;
			b.setKoloniYemek(a.koloniYemek()+ganimet);
			a.setKoloniYemek(a.koloniYemek()-ganimet);
			b.setKazanmaSayisiArttır();
			a.setKaybetmeSayisiArttır();
			if(a.koloniYemek()<0||a.koloniSayisi()<0) {
				a.setKoloniDurum(false);
			}
		}
		else if(aSavasSonucu==bSavasSonucu) {    // berabere olma durumu
			if(a.koloniSayisi()>b.koloniSayisi()) {     //populasyonu fazla olanın kazanması
				int ganimet = b.koloniYemek()/10;
				a.setKoloniYemek(a.koloniYemek()+ganimet);
				b.setKoloniYemek(b.koloniYemek()-ganimet);
				a.setKazanmaSayisiArttır();
				b.setKaybetmeSayisiArttır();
				if(b.koloniYemek()<0||b.koloniSayisi()<0) {
					b.setKoloniDurum(false);
				}
			}
			else if(a.koloniSayisi()<b.koloniSayisi()) {
				int ganimet = a.koloniYemek()/10;
				b.setKoloniYemek(b.koloniYemek()+ganimet);
				a.setKoloniYemek(a.koloniYemek()-ganimet);
				b.setKazanmaSayisiArttır();
				a.setKaybetmeSayisiArttır();
				if(a.koloniYemek()<0||a.koloniSayisi()<0) {
					a.setKoloniDurum(false);
				}
			}
			else if(a.koloniSayisi()==b.koloniSayisi()) {    // populasyonlarında eşit olma durumu
				Random rand = new Random();
				int random  = rand.nextInt(2);
	    		System.out.println(random);
	    		if(random==0) {
	    			int ganimet = b.koloniYemek()/10;
					a.setKoloniYemek(a.koloniYemek()+ganimet);
					b.setKoloniYemek(b.koloniYemek()-ganimet);
					a.setKazanmaSayisiArttır();
					b.setKaybetmeSayisiArttır();
					if(b.koloniYemek()<0||b.koloniSayisi()<0) {
						b.setKoloniDurum(false);
					}
	    		}
	    		else {
	    			int ganimet = a.koloniYemek()/10;
					b.setKoloniYemek(a.koloniYemek()+ganimet);
					a.setKoloniYemek(a.koloniYemek()-ganimet);
					b.setKazanmaSayisiArttır();
					a.setKaybetmeSayisiArttır();
					if(a.koloniYemek()<0||a.koloniSayisi()<0) {
						a.setKoloniDurum(false);
					}
	    		}
			}
		}
			
	}
	
	public void oyunOyna(Koloni[] koloniler) throws InterruptedException {
		int tur=0;
        int aktifKoloni=0;

        
        
        do {
        	 
        	aktifKoloni=0;
        	tur++;
        	
        	for(int w=0; w<koloniler.length; w++) {
            	if(koloniler[w].koloniDurumu()==true) {
            		koloniler[w].uretimSec();
            		koloniler[w].setKoloniYemek(koloniler[w].koloniYemek()+koloniler[w].uret());
            	}
            }
        	
        	for(int h=0; h<koloniler.length; h++) {       //Yemek stoğu (GüncelPopülasyon x 2) oranında azalır.
            	if(koloniler[h].koloniDurumu()==true) {
            		koloniler[h].setKoloniYemek(koloniler[h].koloniYemek()-(koloniler[h].koloniSayisi()*2));
            		if(koloniler[h].koloniYemek()<0) {
            			koloniler[h].setKoloniDurum(false);
            		}
            	}
            }
        	
        	for(int p=0; p<koloniler.length; p++) {
        		if(koloniler[p].koloniDurumu()==true) {
        			for(int l=p+1; l<koloniler.length; l++) {
        				if(koloniler[p].koloniDurumu()==false) {
        					break;
        				}
        				if(koloniler[l].koloniDurumu()==true) {
        					OyunKurallari(koloniler[p], koloniler[l]);
        				}
        				continue;
        			}
        			continue;
        		}
        	}
        	

            
            for(int u=0; u<koloniler.length;u++) {  // her turda %20 koloni sayısını arttırma
            	if(koloniler[u].koloniDurumu()==true) {
            		koloniler[u].SetKoloniSayisi(koloniler[u].koloniSayisi()+(koloniler[u].koloniSayisi()/5));
            	}
            }
            
            
            
            for(int t=0; t<koloniler.length;t++) {
           		if(koloniler[t].koloniDurumu()==true) {
           			aktifKoloni++;                       // hayatta olan koloni sayısını bulma
           		}
           	}
            
         	if(aktifKoloni==0) {
         		System.out.println("Sona kalan kolonilerin yemekleri bittiği için berabere");
         		break;
         	}
         	Thread.sleep(500);
            KonsolTemizleme.temizle();
            System.out.println("*******************************************************");
        	System.out.println("Tur sayisi: " + tur);
    		System.out.println("KOLONI   POPULASYON    YEMEK     KAZANMA     KAYBETME");

            for(int y=0;y<koloniler.length;y++) {
            	
            	if(koloniler[y].koloniDurumu()==true) {
            		System.out.println(String.format("%-" + 9 + "s", koloniler[y].koloniSembol())+String.format("%-" + 14 + "s", koloniler[y].koloniSayisi())
            		+String.format("%-" + 10 + "s", koloniler[y].koloniYemek())+String.format("%-" + 12 + "s", koloniler[y].kazanmaSayisi())
            		+String.format("%-" + 1 + "s", koloniler[y].kaybetmeSayisi()));
            		
            		
                    
            	}
            	else {
            		System.out.println(String.format("%-" + 9 + "s", koloniler[y].koloniSembol())+String.format("%-" + 14 + "s", "----")
            		+String.format("%-" + 10 + "s", "----")+String.format("%-" + 12 + "s", "----")
            		+String.format("%-" + 1 + "s", "----"));
            		
            	}
            	
            }
            System.out.println(" ");
            System.out.println("*******************************************************");
            
           
            
            
        	}while(aktifKoloni!=1);
	}
}
