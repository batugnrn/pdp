#ifndef ATAKTIK_H
#define ATAKTIK_H

#include "taktik.h"

struct ATAKTIK
{
    taktik super;
    void (*ataktikYoket)(struct ATAKTIK*);

};

typedef struct ATAKTIK* ataktik;




ataktik ataktikOlustur();
int Asavas(const ataktik);
void ataktikYoket(const ataktik);


#endif