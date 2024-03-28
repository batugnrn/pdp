#include "buretim.h"


buretim buretimOlustur(){
    buretim this;
    this = (buretim)malloc(sizeof(struct BURETIM));
    this->super = uretimOlustur();

    this->super->Uret = &Buretim;
    this->buretimYoket = &buretimYoket;
    return this;
}
int Buretim(const buretim this){
    srand(time(NULL)); 

    int bsonuc = (rand() %10+1) / 2 +5;
    return bsonuc;
}
void buretimYoket(const buretim this){
    if(this==NULL) return;
    this->super->uretimYoket(this->super);
    free(this);
}