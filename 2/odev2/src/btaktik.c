#include "btaktik.h"




btaktik btaktikOlustur(){
    btaktik this;
    this = (btaktik)malloc(sizeof(struct BTAKTIK));
    this->super = taktikOlustur();

    this->super->Savas = &Bsavas;
    this->btaktikYoket = &btaktikYoket;
    return this;
}

int Bsavas(const btaktik this){

    int Bsonuc = ((rand() % 1000+1) / 3) + 478;

    return Bsonuc;
}
void btaktikYoket(const btaktik this){
    if(this==NULL) return;
    this->super->taktikYoket(this->super);
    free(this);
}
