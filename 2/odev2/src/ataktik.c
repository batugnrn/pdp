#include "ataktik.h"



ataktik ataktikOlustur(){
    ataktik this;
    this = (ataktik)malloc(sizeof(struct ATAKTIK));
    
    this->super = taktikOlustur();

    this->super->Savas = &Asavas;
    this->ataktikYoket = &ataktikYoket;
    return this;
}


int Asavas(const ataktik this){
   

    int Asonuc = ((rand() % 1000+1)/2)+311;

    return Asonuc;

}
void ataktikYoket(const ataktik this){
    if(this == NULL) return;
    this->super->taktikYoket(this->super);
    free(this);
}