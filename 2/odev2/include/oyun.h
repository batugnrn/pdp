#ifndef OYUN_H
#define OYUN_H

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "koloni.h"


struct OYUN
{
    void (*savasaBasla)(struct OYUN*,koloni,koloni);
    void (*oyunaBasla)(struct OYUN*,koloni*,int);
    void (*oyunYoket)(struct OYUN*);
};

typedef struct OYUN* oyun;

oyun oyunOlustur();
void savasaBasla(const oyun,koloni,koloni);
void oyunaBasla(const oyun,koloni*,int);
void oyunYoket(const oyun);



#endif