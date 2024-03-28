#ifndef AURETIM_H
#define AURETIM_H

#include "uretim.h"


struct AURETIM
{
    uretim super;
    void (*auretimYoket)(struct AURETIM*);
};

typedef struct AURETIM* auretim;


auretim auretimOlustur();
int Auretim(const auretim);
void auretimYoket(const auretim);

#endif