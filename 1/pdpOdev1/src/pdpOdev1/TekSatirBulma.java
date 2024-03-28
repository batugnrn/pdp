/*
 * 
 * PDP 1.Odev Mart 2023
 * Bahri Batuhan Güneren
 * G201210059
 * bahri.guneren@ogr.sakarya.edu.tr
 * 2.ögretim A grubu
 * 
 * */
package pdpOdev1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 
 * @author batuhan
 * tek satırlı yorumların yakalandıgı sınıf
 *
 */
public class TekSatirBulma {



	int ilkindex=0;
	int sonindex=0;
	int adet;
	String tekSatirRegex = "//(.+)";
			
	int tekSatirBul(String cumle, String fonkAdi) throws IOException {
		adet=0;
		FileWriter writer = new FileWriter("teksatir.txt", true);
		CokSatirBulma cokSatir = new CokSatirBulma();
		JavaDocBulma javaDoc = new JavaDocBulma();
		
		Pattern oruntu = Pattern.compile(tekSatirRegex);
		
		Matcher esleme = oruntu.matcher(cumle);
		
		while(esleme.find()) {
			ilkindex = esleme.start();
			sonindex = esleme.end() -1;
			if(cokSatir.cokSatirTekSatirvarmi(cumle, ilkindex, sonindex)) {  // tek satır içinde çok satır tanımlanmış mı diye kontrol edilir
				continue;														// örnek =>   //teksatır  /*deneme123*/
			}
			else if(javaDoc.javadocTekSatirvarmi(cumle, ilkindex, sonindex)) {   // aynısının javadoc hali var mı diye kontrol edilir.
				continue;
			}
			else {
				if(adet==0) {
					 writer.write("Fonksiyon: " + fonkAdi);
					 writer.write(System.lineSeparator());
					 writer.write(System.lineSeparator());
					}
					 writer.write(esleme.group());
					 writer.write(System.lineSeparator());
					
			}
		
			adet++;
		}
		if(adet!=0) {
		 writer.write("-------------------------");
		 writer.write(System.lineSeparator());
		 
		}
		writer.close();
		
		return adet;
	}
	
	
	public boolean tekSatirSinifvarmi(String icerik, int ilk, int son) {   //tek satırın içinde sınıf kalıbı tanımlanmış mı diye kontrol eden yardımcı fonksiyon
		
		Pattern oruntu = Pattern.compile(tekSatirRegex);

		Matcher esleme = oruntu.matcher(icerik);
		
		while(esleme.find()) {
			
			int ilkindex4 = esleme.start();
			int sonindex4 = esleme.end() -1;
			
			if(ilkindex4<ilk && son<=sonindex4) {
				
					return true;
			}
			
		}
		
		return false;
		
	}
	
	
	
public boolean tekSatirCokSatirvarmi(String icerik, int ilk, int son) { // tek satır içinde çok satır tanımlanmış mı diye kontrol eden yardımcı fonksiyon
		
		Pattern oruntu = Pattern.compile(tekSatirRegex);

		Matcher esleme = oruntu.matcher(icerik);
		
		while(esleme.find()) {
			
			int ilkindex5 = esleme.start();
			int sonindex5 = esleme.end() -1;
			
			
			
			
			if(ilkindex5<ilk && son<=sonindex5) {
				
					return true;
			}
			
		}
		
		return false;
		
	}
	
	
	
}
