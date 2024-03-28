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

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 
 * @author batuhan
 * fonksiyon kalıbını bulmaya yarayan sınıf
 *
 */
public class FonkAdiBulma {

	
	int sonuncu=0;
	int ilk,son =0;
	String fonkAd="";          
	String sonHal="";                                  
	String fonkAdiRegex = "[\\s]{1}\\w+[^(!?.else).*][\\s]{1}[\\w]+\\s*[(].*[)].?[\\r\\n\\s]*[\\s*\\w*]*[{]";
	
	
	public void fonkAdiGetir(String icerik) throws IOException {
		
		Lifo lifo = new Lifo();
		TekSatirBulma tekSatir = new TekSatirBulma();
		CokSatirBulma cokSatir = new CokSatirBulma();
		JavaDocBulma javaDoc = new JavaDocBulma();
		
		Pattern oruntu = Pattern.compile(fonkAdiRegex);

		Matcher esleme = oruntu.matcher(icerik);
		
		while(esleme.find())
		{
		
			int ilkindex = esleme.start();
			int sonindex = lifo.inkexBulma(icerik, esleme.end());   // fonksiyonun en sondaki } parantezin indexi bulunuyor

			
			
			son=sonindex;
			
			if(cokSatir.cokSatirFonkvarmi(icerik, ilkindex, sonindex)) {  // çok satırlı yorum içerisinde fonksiyon olup olmadığı kontrol ediliyor

				continue;
			}
			else {
				if(javaDoc.javadocFonkvarmi(icerik, ilkindex, sonindex)) {  // javaDoc içerisinde fonksiyon olup olmadığı kontrol ediliyor
					
					continue;
				}
				else {
					
					sonHal = esleme.group();
					
					String pattern = "\\b(\\w+)\\s*\\(";
					Pattern r = Pattern.compile(pattern);
					Matcher m = r.matcher(sonHal);
					if(m.find()) {
						fonkAd=m.group();
						fonkAd=fonkAd.substring(0, fonkAd.length()-1);
					}
					
					
					tekSatir.tekSatirBul(icerik.substring(ilk, son), fonkAd);
					cokSatir.cokSatirBul(icerik.substring(ilk, son), fonkAd);
					javaDoc.javaDocBul(icerik.substring(ilk, son), fonkAd);
					
					System.out.println("	Fonksiyon: " + fonkAd);
				}
				
			 }
				
			System.out.println("		Tek Satır Yorum Sayısı:    " + tekSatir.adet);
			System.out.println("		Çok Satırlı Yorum Sayısı:  " + cokSatir.adet);
			System.out.println("		javaDoc Yorum Sayısı:      " + javaDoc.adet);
			System.out.println("********************************************");
			ilk=son;
		}
		
		
		
	}
	
}
