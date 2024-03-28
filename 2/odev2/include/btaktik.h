#ifndef BTAKTIK_H
#define BTAKTIK_H

#include "taktik.h"

struct BTAKTIK
{
    taktik super;

    void (*btaktikYoket)(struct BTAKTIK*);
};

typedef struct BTAKTIK* btaktik;




btaktik btaktikOlustur();
int Bsavas(const btaktik);
void btaktikYoket(const btaktik);







#endif