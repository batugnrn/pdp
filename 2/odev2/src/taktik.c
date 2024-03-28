#include "taktik.h"




taktik taktikOlustur(){
    taktik this;
    this = (taktik)malloc(sizeof(struct TAKTIK));
    this->taktikYoket = &taktikYoket;
    
    return this;
}
void taktikYoket(const taktik this){
    if(this == NULL) return;
    free(this);
}