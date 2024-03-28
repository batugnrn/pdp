#ifndef TAKTIK_H
#define TAKTIK_H

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

struct TAKTIK
{
    int sonuc;

    int (*Savas)();
    void (*taktikYoket)(struct TAKTIK*);
};

typedef struct TAKTIK* taktik;




taktik taktikOlustur();
void taktikYoket(const taktik);




#endif