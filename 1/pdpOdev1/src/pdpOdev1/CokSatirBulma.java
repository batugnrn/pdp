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
 * çok satırlı yorumları bulmayı sağlayan sınıf
 *
 */
public class CokSatirBulma {


	
	
	int ilkindex=0;
	
	int sonindex=0;
	
	int adet;
	String cokSatirRegex = "[/][*][^*][\\s\\S]*?[*][/]";
	
	
	public int cokSatirBul(String cumle, String fonkAdi) throws IOException {
		adet=0;
		TekSatirBulma tekSatir = new TekSatirBulma();
		FileWriter writer = new FileWriter("coksatir.txt", true);
		
		Pattern oruntu = Pattern.compile(cokSatirRegex);
		
		Matcher esleme = oruntu.matcher(cumle);
	
		
		
		while(esleme.find()) {
			

			int ilk7 = esleme.start();
			int son7 = esleme.end()-1;
			if(tekSatir.tekSatirCokSatirvarmi(cumle, ilk7, son7)) {
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
					 writer.write(System.lineSeparator());
			 adet++; 
			}
			
				
		}
			
				
		if(adet!=0) {
			 writer.write("-------------------------");
			 writer.write(System.lineSeparator());
			 
			}
		writer.close();
		
		
		
		
		return adet;
	}
	
	
	
	public boolean cokSatirFonkvarmi(String icerik, int ilk, int son) {  //çok satırın içinde fonksiyon tanımlanmış mı diye kontrol eden yardımcı fonksiyon
		
	
		Pattern oruntu = Pattern.compile(cokSatirRegex);

		Matcher esleme = oruntu.matcher(icerik);
		
		
		while(esleme.find()) {
			
			
			ilkindex = esleme.start();
			sonindex = esleme.end() -1;
			
			if(ilkindex<ilk && son<sonindex) {
				return true;
			}
		
			
		}
		
		return false;
		
	}
	
	
	public boolean cokSatirTekSatirvarmi(String icerik, int ilk, int son) { //çok satırlı yorum içinde tek satırlı yorum kullanılmış mı diye kontrol eden yardımcı fonksiyon 
		
		Pattern oruntu = Pattern.compile(cokSatirRegex);

		Matcher esleme = oruntu.matcher(icerik);
		
		while(esleme.find()) {
			int index1 = esleme.start();
			int index2 = esleme.end()-1;
			
			if(index1<ilk && son<index2) {
				
				return true;
			}
		}
		
		return false;
		
	}
	
	public boolean cokSatirSinifvarmi(String icerik, int ilk, int son) { // çok satırlı yorum içinde sınıf kalıbı tanımlanmış mı diye kontrol eden yardımcı fonksiyon
		
		Pattern oruntu = Pattern.compile(cokSatirRegex);

		Matcher esleme = oruntu.matcher(icerik);
		
		while(esleme.find()) {
			
			int ilk3 = esleme.start();
			int son3 = esleme.end() -1;
			
			
			
			if(ilk3<ilk && son<son3) {
				
					return true;
			}
			
		}
		
		return false;
		
	}
	
	
}
