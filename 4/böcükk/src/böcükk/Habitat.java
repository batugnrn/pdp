package böcükk;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Habitat 	
{
    private Canli[] canlilar;
    private int[] satirElemanSayisi;
    private int satirSayisi=0;
    

   private int kacElemanVar(){
    
    String dosyaYolu = "veriler.txt";
	int elemanSayisi=0;
    try {
        // Dosya nesnesi oluştur
        File dosya = new File(dosyaYolu);

        // FileReader ile dosyayı oku
        FileReader fileReader = new FileReader(dosya);

        // BufferedReader kullanarak satır satır oku
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String satir;

        // Dosyanın sonuna kadar her satırı oku
        while ((satir = bufferedReader.readLine()) != null) {
            // Satırı boşluklara göre ayır
            String[] sayilar = satir.split(" ");
            
            // Her bir sayıyı ekrana yazdır
            
            for (String sayi : sayilar) {
                elemanSayisi++;
            }
           satirSayisi++;
        }

        // Kullanılan kaynakları serbest bırak
        bufferedReader.close();
    } catch (IOException e) {
        System.out.println("Dosya okuma hatası: " + e.getMessage());
    }

    return elemanSayisi;
   } 

   public Canli[] HabitatOlustur()
   {
    
    String dosyaYolu = "veriler.txt";
    int elemanSayisi = kacElemanVar();
    
    
    
    
    
    
    canlilar = new Canli[elemanSayisi];
    satirElemanSayisi = new int[satirSayisi];
    
    
    try {
        // Dosya nesnesi oluştur
        File dosya = new File(dosyaYolu);

        // FileReader ile dosyayı oku
        FileReader fileReader = new FileReader(dosya);

        // BufferedReader kullanarak satır satır oku
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String satir;
        int sayac_x =0;
        int sayac_y =0;
        int elemanSayac=0;
        // Dosyanın sonuna kadar her satırı oku
        while ((satir = bufferedReader.readLine()) != null) {
            // Satırı boşluklara göre ayır
            String[] sayilar = satir.split(" ");
            
            // Her bir sayıyı ekrana yazdır
            for (String sayi : sayilar) {
                int sayiInt = Integer.parseInt(sayi);
                if(sayiInt >= 1 && sayiInt <= 9){
                    Bitki b = new Bitki(sayac_x,sayac_y,sayiInt);
                    canlilar[elemanSayac]=b;
                }
                else if(sayiInt >= 10 && sayiInt <= 20){
                    Böcek b = new Böcek(sayac_x,sayac_y,sayiInt);
                    canlilar[elemanSayac]=b;
                }
                else if(sayiInt >= 21 && sayiInt <= 50){
                    Sinek b = new Sinek(sayac_x,sayac_y,sayiInt);
                    canlilar[elemanSayac]=b;
                }
                else if(sayiInt >= 51 && sayiInt <= 99){
                    Pire b = new Pire(sayac_x,sayac_y,sayiInt);
                    canlilar[elemanSayac]=b;
                }

                sayac_y++;
                elemanSayac++;
            }
            satirElemanSayisi[sayac_x]=sayac_y;
            sayac_y=0; 
            sayac_x++;
        }

        /*  for (int i = 0; i <= elemanSayisi; i++) {
            System.out.println("adi:"+canlilar[i].adi);
            System.out.println("x:"+canlilar[i].X_koordinat);
            System.out.println("y:"+canlilar[i].Y_koordinat);   
            System.out.println("deger:"+canlilar[i].deger);
            System.out.println("********");


        }     */  
       // System.out.println(elemanSayisi);
        // Kullanılan kaynakları serbest bırak
        bufferedReader.close();
    } catch (IOException e) {
        System.out.println("Dosya okuma hatası: " + e.getMessage());
    }






    return canlilar;



    
   }




   public int[] satirdakiElemanSayisi(){
    return satirElemanSayisi;
}
    
}
	

