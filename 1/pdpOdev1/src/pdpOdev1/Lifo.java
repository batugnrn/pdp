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
/**
 * 
 * @author batuhan
 * regex ile fonksiyonun { indeksini verdikten sonra en son } parantezin indeksini döndürür.
 * 
 * !!!!!ÖNEMLİ!!!!
 * eğer çok satırlı ve javadoc içinde fonksiyon tanımlanmış ise 
 * başlangıç { parantezi ve } bitiş parantezi mutlaka olmalıdır.
 * Aksi takdirde program devamını okuyamaz. 
 *
 */
public class Lifo {
	
	/**
	 * 
	 * @param icerik  okutulan dosya
	 * @param ilkindex  ilk bulunan fonksiyonun { parantezinin indexi 
	 * @return     fonksiyonun } parantezinin indexini geri döndürür
	 * @throws IOException
	 */
	
public int inkexBulma(String icerik, int ilkindex) throws IOException {
		
		int sayac = 1;
		
	    int sonIndeks = 0;
	    String okunacak = icerik.substring(ilkindex);
	    
	    for (int i = 1; i < okunacak.length(); i++) {
	        char karakter = okunacak.charAt(i);
	        if (karakter == '{') {
	            sayac++;
	           // System.out.println("ARTTI");
	        } 
	        else if (karakter == '}') {
	            sayac--;
	            //System.out.println("AZALDI");
	        }
	        //System.out.println(sayac);
	        if (sayac == 0) {
	            sonIndeks = i;
	            break;
	        }
	    }
	    
	    return sonIndeks+ilkindex;  //okutulan dosyayı substring ile parçaladığımız için 
	    							//parametre ilkindexi ekleyerek geri döndürdük.
	}

}
