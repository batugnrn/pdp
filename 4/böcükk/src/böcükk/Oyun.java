package böcükk;

public class Oyun {
    int tur =0;

    public void oyna(Canli[] canlilar, int[] satirdakiElemanSayisi){
        int aktifCanliSayisi=0;
        
        do{
            aktifCanliSayisi=0;



            // görünüm fonksiyonu canlı sınıfında tanımlanmalı !!!!!
            for (int i = 0; i <satirdakiElemanSayisi.length; i++){

                for (int j = 0; j < satirdakiElemanSayisi[i] ; j++) {
                    System.out.print(canlilar[tur].adi + " "); 
                    tur++;        
                }            
                System.out.println();
            }   
            tur=0;



        /*     for (int i = 0; i < canlilar.length; i+=canlilar[canlilar.length-1].Y_koordinat+1){

                for (int j = i; j < i + canlilar[canlilar.length-1].Y_koordinat+1 && j < canlilar.length; j++) {
                    System.out.print(canlilar[j].adi + " ");
                   
                }            
                System.out.println();
            }         */

            for (int i = 0; i < canlilar.length; i++) {
                if(canlilar[i].hayatta_mi==true){
                    for (int f = i+1; f < canlilar.length; f++) {
                        if(canlilar[f].hayatta_mi==true){
                            kimOldu(canlilar[i],canlilar[f],canlilar);
                            i=canlilar.length;
                            break;
                        }
                    }      
                }
                
            }

            

            for(int t=0; t<canlilar.length;t++) {
                if(canlilar[t].hayatta_mi==true) {
                    aktifCanliSayisi++;                       // hayatta olan canli sayısını bulma
                }
            }
          
            System.out.println("*************************");
        }while(aktifCanliSayisi!=1);

        for (int i = 0; i <satirdakiElemanSayisi.length; i++){

            for (int j = 0; j < satirdakiElemanSayisi[i] ; j++) {
                System.out.print(canlilar[tur].adi + " "); 
                tur++;        
            }            
            System.out.println();
        }   
        tur=0;

        for(int k=0; k<canlilar.length;k++) {
            if(canlilar[k].hayatta_mi==true) {
                System.out.println("Kazanan: " + canlilar[k].adi + " : " + "(" +canlilar[k].X_koordinat +"," + canlilar[k].Y_koordinat +")" );                   
            }
        }
        

    }

    private void kimOldu(Canli a, Canli b, Canli[] canlilar){
        if(a.adi=="B"){            ///////bitki
            if(b.adi=="P"){
                b.hayatta_mi=false;
                b.adi="X";
            }
            else if(b.adi=="S"){
                b.hayatta_mi=false;
                b.adi="X";
            }
            else if(b.adi=="C"){
                a.hayatta_mi=false;
                a.adi="X";
            }
            else if(b.adi=="B"){
                if(a.deger>b.deger){
                    b.hayatta_mi= false;
                    b.adi="X";
                }
                else if(a.deger<b.deger){
                    a.hayatta_mi= false;
                    a.adi="X";
                }
                else if(a.deger==b.deger){
                    int Auzaklık = (canlilar[canlilar.length].X_koordinat-a.X_koordinat)+(canlilar[canlilar.length].Y_koordinat-a.Y_koordinat);
                    int Buzaklık = (canlilar[canlilar.length].X_koordinat-b.X_koordinat)+(canlilar[canlilar.length].Y_koordinat-b.Y_koordinat);
                    if(Auzaklık<Buzaklık){
                        a.hayatta_mi = false;
                        a.adi = "X";
                    }
                    else{
                        b.hayatta_mi = false;
                        b.adi = "X";
                    }
                }
            }
        }
        else if(a.adi=="C"){      ///////////böcek
            if(b.adi=="B"){
                b.hayatta_mi=false;
                b.adi="X";
            }
            else if(b.adi=="P"){
                b.hayatta_mi=false;
                b.adi="X";
            }
            else if(b.adi=="S"){
                a.hayatta_mi=false;
                a.adi="X";
            }
            else if(b.adi=="C"){
                if(a.deger>b.deger){
                    b.hayatta_mi= false;
                    b.adi="X";
                }
                else if(a.deger<b.deger){
                    a.hayatta_mi= false;
                    a.adi="X";
                }
                else if(a.deger==b.deger){
                    int Auzaklık = (canlilar[canlilar.length].X_koordinat-a.X_koordinat)+(canlilar[canlilar.length].Y_koordinat-a.Y_koordinat);
                    int Buzaklık = (canlilar[canlilar.length].X_koordinat-b.X_koordinat)+(canlilar[canlilar.length].Y_koordinat-b.Y_koordinat);
                    if(Auzaklık<Buzaklık){
                        a.hayatta_mi = false;
                        a.adi = "X";
                    }
                    else{
                        b.hayatta_mi = false;
                        b.adi = "X";
                    }
                }
            }
        }
        else if(a.adi=="S"){      ///////////sinek
            if(b.adi=="P"){
                b.hayatta_mi=false;
                b.adi="X";
            }
            else if(b.adi=="C"){
                b.hayatta_mi=false;
                b.adi="X";
            }
            else if(b.adi=="B"){
                a.hayatta_mi=false;
                a.adi="X";
            }
            else if(b.adi=="S"){
                if(a.deger>b.deger){
                    b.hayatta_mi= false;
                    b.adi="X";
                }
                else if(a.deger<b.deger){
                    a.hayatta_mi= false;
                    a.adi="X";
                }
                else if(a.deger==b.deger){
                    int Auzaklık = (canlilar[canlilar.length].X_koordinat-a.X_koordinat)+(canlilar[canlilar.length].Y_koordinat-a.Y_koordinat);
                    int Buzaklık = (canlilar[canlilar.length].X_koordinat-b.X_koordinat)+(canlilar[canlilar.length].Y_koordinat-b.Y_koordinat);
                    if(Auzaklık<Buzaklık){
                        a.hayatta_mi = false;
                        a.adi = "X";
                    }
                    else{
                        b.hayatta_mi = false;
                        b.adi = "X";
                    }
                }
            }
        }
        else if(a.adi=="P"){      ///////////PİRE
            if(b.adi=="B"){
                a.hayatta_mi=false;
                a.adi="X";
            }
            else if(b.adi=="C"){
                a.hayatta_mi=false;
                a.adi="X";
            }
            else if(b.adi=="S"){
                a.hayatta_mi=false;
                a.adi="X";
            }
            else if(b.adi=="P"){
                if(a.deger>b.deger){
                    b.hayatta_mi= false;
                    b.adi="X";
                }
                else if(a.deger<b.deger){
                    a.hayatta_mi= false;
                    a.adi="X";
                }
                else if(a.deger==b.deger){
                    int Auzaklık = (canlilar[canlilar.length].X_koordinat-a.X_koordinat)+(canlilar[canlilar.length].Y_koordinat-a.Y_koordinat);
                    int Buzaklık = (canlilar[canlilar.length].X_koordinat-b.X_koordinat)+(canlilar[canlilar.length].Y_koordinat-b.Y_koordinat);
                    if(Auzaklık<Buzaklık){
                        a.hayatta_mi = false;
                        a.adi = "X";
                    }
                    else{
                        b.hayatta_mi = false;
                        b.adi = "X";
                    }
                }
            }
        }
    }
}
