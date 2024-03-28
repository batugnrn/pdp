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
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;


/**
 * 
 * @author batuhan
 * main class
 *
 */
public class MainClass {

	public static void main(String[] args) throws IOException {

		Scanner scanner = new Scanner(System.in);
	    String filePath = args[0];
	    scanner.close();
  
		String dosya = new String(Files.readAllBytes(Paths.get(filePath)),StandardCharsets.UTF_8);

		
		SinifAdiBulma sinif = new SinifAdiBulma();
		sinif.sinifAdiGetir(dosya);
		
		FonkAdiBulma fonkAdi = new FonkAdiBulma();
		fonkAdi.fonkAdiGetir(dosya);
	
	
		
	}

}
