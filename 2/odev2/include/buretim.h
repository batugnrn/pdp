#ifndef BURETIM_H
#define BURETIM_H

#include "uretim.h"


struct BURETIM
{
    uretim super;
    void (*buretimYoket)(struct BURETIM*);
};

typedef struct BURETIM* buretim;

buretim buretimOlustur();
int Buretim(const buretim);
void buretimYoket(const buretim);

#endif