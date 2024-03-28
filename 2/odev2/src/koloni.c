#include "koloni.h"


koloni koloniOlustur(int sayi){
    koloni this;
    this = (koloni)malloc(sizeof(struct KOLONI));
  
    
    this->sembol = 224 + rand() % 30+1;
    this->populasyonSay = sayi;
    this->yemekSay = sayi*sayi;
    this->durum = true;
    this->kazanmaSay = 0;
    this->kaybetmeSay =0;
	this->t = taktikOlustur();
	this->u = uretimOlustur();
    this->kazanmaSayisi = &kazanmaSayisi;
    this->kazanmaSayisiArttir = &kazanmaSayisiArttir;
    this->kaybetmeSayisi = &kaybetmeSayisi;
    this->kaybetmeSayisiArttir = &kaybetmeSayisiArttir;
    this->koloniDurumu = &koloniDurumu;
    this->setKoloniDurum = &setKoloniDurum;
    this->koloniSembol = &koloniSembol;
    this->koloniSayisi = &koloniSayisi;
    this->setKoloniSayisi = &setKoloniSayisi;
    this->koloniYemek = &koloniYemek;
    this->setKoloniYemek = &setKoloniYemek;
    this->koloniSavas = &koloniSavas;
    this->taktikSec = &taktikSec;
    this->uret = &uret;
    this->uretimSec = &uretimSec;
    this->koloniYoket = &koloniYoket;
    return this;
}
int kazanmaSayisi(const koloni this){
    return this->kazanmaSay;
}
void kazanmaSayisiArttir(const koloni this){
    this->kazanmaSay = this->kazanmaSay + 1;
}
int kaybetmeSayisi(const koloni this){
    return this->kaybetmeSay;
}
void kaybetmeSayisiArttir(const koloni this){
    this->kaybetmeSay = this->kaybetmeSay + 1;
}
bool koloniDurumu(const koloni this){
    return this->durum;
}
void setKoloniDurum(const koloni this, bool deger){
    this->durum = deger;
}
char koloniSembol(const koloni this){
    return this->sembol;
}
int koloniSayisi(const koloni this){
    return this->populasyonSay;
}
void setKoloniSayisi(const koloni this, int say){
    this->populasyonSay = say;
}
int koloniYemek(const koloni this){
    return this->yemekSay;
}
void setKoloniYemek(const koloni this, int say){
    this->yemekSay = say;
}
int koloniSavas(const koloni this){
	
    return this->t->sonuc;
}
void taktikSec(const koloni this){
 
  	
    int random = rand() % 2;
    if(random == 1){
    	ataktik a = ataktikOlustur();
        this->t->sonuc = a->super->Savas();
        a->ataktikYoket(a);
    }
    else{
    	btaktik b = btaktikOlustur();
        this->t->sonuc = b->super->Savas();
        b->btaktikYoket(b);
    }
}
int uret(const koloni this){
    return this->u->yemek;
}
void uretimSec(const koloni this){
   
    int random = rand() % 2;
    if(random == 1){
        auretim a = auretimOlustur();
        this->u->yemek = a->super->Uret();
        a->auretimYoket(a);
    }
    else{
        buretim b = buretimOlustur();
        this->u->yemek = b->super->Uret();
        b->buretimYoket(b);
    }
}
void koloniYoket(const koloni this){
    if (this == NULL) return;
    this->t->taktikYoket(this->t);
    this->u->uretimYoket(this->u);
    free(this);
}