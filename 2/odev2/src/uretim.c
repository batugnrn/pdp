#include "uretim.h"


uretim uretimOlustur(){
    uretim this;
    this = (uretim)malloc(sizeof(struct URETIM));
    this->uretimYoket = &uretimYoket;
    return this;
}

void uretimYoket(const uretim this){
    if(this == NULL) return;
    free(this);
}
