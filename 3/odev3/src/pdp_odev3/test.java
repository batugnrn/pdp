/*****************************************************************************************************
** SAKARYA ÜNİVERSİTESİ
** BİLGİSAYAR VE BİLİŞİM BİLİMLERİ FAKÜLTESİ
** BİLGİSAYAR MÜHENDİSLİĞİ BÖLÜMÜ
** PROGRAMLAMA DİLLERİNİN PRENSİPLERİ DERSİ
** 2022-2023 BAHAR DÖNEMİ
**
**
** ÖDEV ..................: 3. ÖDEV
** ÖĞRENCİ ADI............: BAHRİ BATUHAN GÜNEREN
** ÖĞRENCİ NUMARASI.......: G201210059
** DERSİN ALINDIĞI GRUP...: 2.ÖĞRETİM A GRUBU
****************************************************************************************************/
package pdp_odev3;

import java.util.Scanner;

public class test {

	public static void main(String[] args) throws InterruptedException {
		Scanner scanner = new Scanner(System.in);

        System.out.print("Aralarinda bosluk birakarak sayi dizisini girin: ");
        String input = scanner.nextLine();
        String[] numbers = input.split(" ");
        int[] array = new int[numbers.length];
        for (int j = 0; j < numbers.length; j++) {
            array[j] = Integer.parseInt(numbers[j]);
        }
        scanner.close();
        Koloni[] koloniler = new Koloni[array.length];
       
        
        for (int i=0; i<array.length;i++) {
            int num = array[i]; 
            Koloni k = new Koloni(num);
            koloniler[i]=k;
    		
        }
        
        Oyun o = new Oyun();
        
        o.oyunOyna(koloniler);

	}

}
