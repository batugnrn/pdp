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

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 
 * @author batuhan
 * sınıf adının bulunduğu sınıf
 *
 */
public class SinifAdiBulma {
	
	String sonHal="";
	String classAd="";
	String classAdiRegex = "class\\s(\\w*)";
	
	
public void sinifAdiGetir(String icerik) {
		
		TekSatirBulma tekSatir = new TekSatirBulma();
		CokSatirBulma cokSatir = new CokSatirBulma();
		JavaDocBulma javaDoc = new JavaDocBulma();
		
		Pattern oruntu = Pattern.compile(classAdiRegex);
		
		Matcher esleme = oruntu.matcher(icerik);
		
		while(esleme.find()) {
			 
			int ilk = esleme.start();
			int son = esleme.end()-1;
			
			
			if(tekSatir.tekSatirSinifvarmi(icerik, ilk, son)) {  // tek satırlı yorum içerisinde sınıf kalıbının yazılıp yazılmadığı kontrol edildi.
				continue;										//  örnek =>  " //public class motor2 "    gibi örnek verilebilir.
			}
			else {
				if(cokSatir.cokSatirSinifvarmi(icerik, ilk, son)) {    //aynı durum bu sefer cok satırlı yorum içerisinde sınıf kalıbı var mı diye kontrol ediliyor.
					continue;

				}
				else {
					if(javaDoc.javaDocSinifvarmi(icerik, ilk, son)) {   // son olarak javaDoc içerisinde sınıf kalıbı var mı diye kontrol ediliyor.
						continue;
					}
					else {
						sonHal = esleme.group();
						int ilkindex = sonHal.indexOf("ss") + 2;
					
						int sonindex = sonHal.length();
										
						classAd  = sonHal.subSequence(ilkindex, sonindex) + " ";
						System.out.println("Sınıf: " + classAd);
					}
				}
					
			}
			
			

		}
	}
	

}
