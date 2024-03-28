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
 * javadoc yorumlarını bulmayı sağlayan sınıf
 *
 */
public class JavaDocBulma {


	int adet;
	String javaDocRegex = "/\\*\\*(.|[\\s])+?\\*/";
	
	int javaDocBul(String cumle, String fonkAdi) throws IOException {
		adet=0;
		FileWriter writer = new FileWriter("javadoc.txt", true);
		
		Pattern oruntu = Pattern.compile(javaDocRegex);
		
		Matcher esleme = oruntu.matcher(cumle);
		
		while(esleme.find()) {
			if(adet==0) {
				 writer.write("Fonksiyon: " + fonkAdi);
				 writer.write(System.lineSeparator());
				 writer.write(System.lineSeparator());
				}
				 writer.write(esleme.group());
				 writer.write(System.lineSeparator());
				
	
			adet++;
		}
		if(adet!=0) {
			 writer.write("-------------------------");
			 writer.write(System.lineSeparator());
			 
			}
		writer.close();
		
		return adet;
	}
	
	
	public boolean javadocTekSatirvarmi(String cumle, int ilk, int son) { // javadoc içinde tek satırlı yorum tanımlanmış mı diye konrtrol eden yardımcı fonksiyon
		
		Pattern oruntu = Pattern.compile(javaDocRegex);

		Matcher esleme = oruntu.matcher(cumle);
		
		while(esleme.find()) {
			
			
			int index1 = esleme.start();
			int index2 = esleme.end()-1;
			
			
			
			if(index1<ilk && son<index2) {
				
				return true;
		}
			
			
		}
		
		return false;
	}
	
	
	public boolean javadocFonkvarmi(String cumle, int ilk, int son) { //javadoc içinde fonksiyon tanımlanmış mı diye kontrol eden yardımcı fonksiyon
		
		Pattern oruntu = Pattern.compile(javaDocRegex);

		Matcher esleme = oruntu.matcher(cumle);
		
		while(esleme.find()) {
			
			int ilkindex = esleme.start();
			int sonindex = esleme.end() -1;
			
			
			
			if(ilkindex<ilk && son<sonindex) {
				
				return true;
			}
		
			
		}
		
		return false;
	}
	
		public boolean javaDocSinifvarmi(String icerik, int ilk, int son) { //javadoc içinde sınıf kalıbı tanımlanmış mı diye kontrol eden yardımcı fonksiyon
		
		Pattern oruntu = Pattern.compile(javaDocRegex);

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
