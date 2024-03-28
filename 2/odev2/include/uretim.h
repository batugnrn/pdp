#ifndef URETIM_H
#define URETIM_H


#include <stdio.h>
#include <stdlib.h>
#include <time.h>

struct URETIM
{
    int yemek;

    int (*Uret)();
    void (*uretimYoket)(struct URETIM*);
};

typedef struct URETIM* uretim;


uretim uretimOlustur();
void uretimYoket(const uretim);




#endif