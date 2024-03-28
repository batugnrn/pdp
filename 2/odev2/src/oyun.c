#include "oyun.h"





oyun oyunOlustur(){
    oyun this;
    this = (oyun)malloc(sizeof(struct OYUN));
    this->savasaBasla = &savasaBasla;
    this->oyunaBasla = &oyunaBasla;
    this->oyunYoket = &oyunYoket;
    return this;
}

void savasaBasla(const oyun this, koloni a, koloni b){
    a->taktikSec(a);
    b->taktikSec(b);

    int aSavasSonucu = a->koloniSavas(a);
    int bSavasSonucu = b->koloniSavas(b);


    if(aSavasSonucu>bSavasSonucu){      // a kolonisin kazanması
        int YeniOran =(((aSavasSonucu-bSavasSonucu)/10));
        int q = b->koloniSayisi(b)-YeniOran;
        b->setKoloniSayisi(b,q);
        int ganimet = b->koloniYemek(b) / 10;
        a->setKoloniYemek(a,a->koloniYemek(a)+ganimet);
        b->setKoloniYemek(b,b->koloniYemek(b)-ganimet);
        a->kazanmaSayisiArttir(a);
        b->kaybetmeSayisiArttir(b);
        if(b->koloniYemek(b)<=0||b->koloniSayisi(b)<=0){
            b->setKoloniDurum(b,false);
        }
    }
    else if(aSavasSonucu<bSavasSonucu){     // b kolonisinin kazanması 
        int yeniOran =(((bSavasSonucu-aSavasSonucu)/10));
        int q = a->koloniSayisi(a)-yeniOran;
        a->setKoloniSayisi(a,q);
        int ganimet = a->koloniYemek(a)/10;
        b->setKoloniYemek(b,a->koloniYemek(a)+ganimet);
        a->setKoloniYemek(a,a->koloniYemek(a)-ganimet);
        b->kazanmaSayisiArttir(b);
        a->kaybetmeSayisiArttir(a);
        if(a->koloniYemek(a)<=0||a->koloniSayisi(a)<=0){
            a->setKoloniDurum(a,false);
        }
    }
    else if(aSavasSonucu==bSavasSonucu){        // berabere olma durumu
        if(a->koloniSayisi(a)>b->koloniSayisi(b)){     //a kolonisinin sayisi fazla ise
            int ganimet = b->koloniYemek(b) / 10;
            a->setKoloniYemek(a,a->koloniYemek(a)+ganimet);
            b->setKoloniYemek(b,b->koloniYemek(b)-ganimet);
            a->kazanmaSayisiArttir(a);
            b->kaybetmeSayisiArttir(b);
            if(b->koloniYemek(b)<=0||b->koloniSayisi(b)<=0){
                b->setKoloniDurum(b,false);
            }
        }
        else if(a->koloniSayisi(a)<b->koloniSayisi(b)){        //b kolonisinin sayisi fazla ise
            int ganimet = a->koloniYemek(a) / 10;
            b->setKoloniYemek(b,b->koloniYemek(b)+ganimet);
            a->setKoloniYemek(a,a->koloniYemek(a)-ganimet);
            b->kazanmaSayisiArttir(b);
            a->kaybetmeSayisiArttir(a);
            if(a->koloniYemek(a)<=0||a->koloniSayisi(a)<=0){
                a->setKoloniDurum(a,false);
            }
        }
        else if(a->koloniSayisi(a) == b->koloniSayisi(b)) {    // populasyonlarında eşit olma durumu
          
            int random = rand() % 2;
            if(random == 0){
                int ganimet = b->koloniYemek(b)/10;
                a->setKoloniYemek(a,a->koloniYemek(a)+ganimet);
                b->setKoloniYemek(b,b->koloniYemek(b)-ganimet);
                a->kazanmaSayisiArttir(a);
                b->kaybetmeSayisiArttir(b);
                if(b->koloniYemek(b)<=0||b->koloniSayisi(b)<=0){
                    b->setKoloniDurum(b,false);
                }
            }
            else{
                int ganimet = a->koloniYemek(a)/10;
                b->setKoloniYemek(b,b->koloniYemek(b)+ganimet);
                a->setKoloniYemek(a,a->koloniYemek(a)-ganimet);
                b->kazanmaSayisiArttir(b);
                a->kaybetmeSayisiArttir(a);
                if(a->koloniYemek(a)<=0||a->koloniSayisi(a)<=0){
                    a->setKoloniDurum(a,false);
                }
            }
        }
    }

}
void oyunaBasla(const oyun this, koloni* koloniler,int diziSayisi){
    int tur=0;
    int aktifKoloni=0;

    do
    {
        aktifKoloni=0;
        tur++;
        for (int p = 0; p < diziSayisi ; p++)
        {
            if(koloniler[p]->koloniDurumu(koloniler[p])==true){
                for (int l = p+1 ; l < diziSayisi; l++)
                {
                    if(koloniler[p]->koloniDurumu(koloniler[p])==false){
                        break;
                    }
                    if(koloniler[l]->koloniDurumu(koloniler[l])==true){
                        savasaBasla(this,koloniler[p],koloniler[l]);
                    }
                    continue;
                }
                continue;
            }
        }
        

        
        

        for (int u = 0; u < diziSayisi; u++)          // her turda %20 koloni sayısını arttırma
        {
            if(koloniler[u]->koloniDurumu(koloniler[u])==true){
                koloniler[u]->setKoloniSayisi(koloniler[u],koloniler[u]->koloniSayisi(koloniler[u])+(koloniler[u]->koloniSayisi(koloniler[u])/5));
            }
        }
        

        for (int w = 0; w < diziSayisi; w++)            // her turda yemek sayısını uret fonksiyonuyla arttırma
        {
            if(koloniler[w]->koloniDurumu(koloniler[w])==true){
                koloniler[w]->uretimSec(koloniler[w]);
                koloniler[w]->setKoloniYemek(koloniler[w],koloniler[w]->koloniYemek(koloniler[w])+koloniler[w]->uret(koloniler[w]));
            }
        }
        
        for(int h=0; h<diziSayisi; h++){                    //Yemek stoğu (GüncelPopülasyon x 2) oranında azalır.
        	if(koloniler[h]->koloniDurumu(koloniler[h])==true){
        		koloniler[h]->setKoloniYemek(koloniler[h],(koloniler[h]->koloniYemek(koloniler[h])-koloniler[h]->koloniSayisi(koloniler[h])*2));
        		if(koloniler[h]->koloniYemek(koloniler[h])<=0){
					koloniler[h]->setKoloniDurum(koloniler[h],false);
				}
			}
		}
		
        for (int t = 0; t < diziSayisi; t++)
        {
            if(koloniler[t]->koloniDurumu(koloniler[t])==true){
                aktifKoloni++;                                   // hayatta olan koloni sayısını bulma
            }
        }
        
        if(aktifKoloni==0){
            puts(" ");
        	printf("--Yeni turda her koloninin yemek stoklari tukendigi icin oyun beraber sonuclanmistir.--"); 
        	break;
		}
      
        puts(" ");
		printf("Tur Sayisi: %d",tur);
		puts(" ");
        printf("KOLONI   POPULASYON    YEMEK     KAZANMA     KAYBETME");
        puts(" ");
        for (int y = 0; y < diziSayisi; y++)
        {
            if(koloniler[y]->koloniDurumu(koloniler[y])==true){
                printf("%-7c",koloniler[y]->koloniSembol(koloniler[y]));
                printf("  ");
                printf("%-12d",koloniler[y]->koloniSayisi(koloniler[y]));
                printf("  ");
                printf("%-8d",koloniler[y]->koloniYemek(koloniler[y]));
                printf("  ");
                printf("%-10d",koloniler[y]->kazanmaSayisi(koloniler[y]));
                printf("  ");
                printf("%-15d",koloniler[y]->kaybetmeSayisi(koloniler[y]));
                puts(" ");
            }
            else{
                printf("%-7c",koloniler[y]->koloniSembol(koloniler[y]));
                printf("  ");
                printf("%-12s","----");
                printf("  ");
                printf("%-8s","----");
                printf("  ");
                printf("%-10s","----");
                printf("  ");
                printf("%-15s","----");
                puts(" ");
            }
        } 
		       
        puts(" ");
        printf("*******************************************************");      
    } while (aktifKoloni!=1);
    
}
void oyunYoket(const oyun this){
    if(this == NULL) return;
    free(this);
}