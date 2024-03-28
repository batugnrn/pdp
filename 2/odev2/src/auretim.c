#include "auretim.h"



auretim auretimOlustur(){
    auretim this;
    this = (auretim)malloc(sizeof(struct AURETIM));
    this->super = uretimOlustur();

    this->super->Uret = &Auretim;
    this->auretimYoket = &auretimYoket;
    return this;
}
int Auretim(const auretim this){

    int asonuc = rand() % 10;
    return asonuc;
}
void auretimYoket(const auretim this){
    if(this==NULL) return;
    this->super->uretimYoket(this->super);
    free(this);
}