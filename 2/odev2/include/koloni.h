#ifndef KOLONI_H
#define KOLONI_H

#include <stdio.h>

#include <time.h>
#include <stdbool.h>
#include "ataktik.h"
#include "btaktik.h"
#include "auretim.h"
#include "buretim.h"

struct KOLONI
{
    char sembol;
    int populasyonSay;
    int yemekSay;
    bool durum;
    int kazanmaSay;
    int kaybetmeSay;
    taktik t;
    uretim u;


    int (*kazanmaSayisi)(struct KOLONI*);
    void (*kazanmaSayisiArttir)(struct KOLONI*);
    int (*kaybetmeSayisi)(struct KOLONI*);
    void (*kaybetmeSayisiArttir)(struct KOLONI*);
    bool (*koloniDurumu)(struct KOLONI*);
    void (*setKoloniDurum)(struct KOLONI*,bool);
    char (*koloniSembol)(struct KOLONI*);
    int (*koloniSayisi)(struct KOLONI*);
    void (*setKoloniSayisi)(struct KOLONI*, int);
    int (*koloniYemek)(struct KOLONI*);
    void (*setKoloniYemek)(struct KOLONI*, int);
    int (*koloniSavas)(struct KOLONI*);
    void (*taktikSec)(struct KOLONI*);
    int (*uret)(struct KOLONI*);
    void (*uretimSec)(struct KOLONI*);
    void (*koloniYoket)(struct KOLONI*);
};

typedef struct KOLONI* koloni;

koloni koloniOlustur(int);
int kazanmaSayisi(const koloni);
void kazanmaSayisiArttir(const koloni);
int kaybetmeSayisi(const koloni);
void kaybetmeSayisiArttir(const koloni);
bool koloniDurumu(const koloni);
void setKoloniDurum(const koloni,bool);
char koloniSembol(const koloni);
int koloniSayisi(const koloni);
void setKoloniSayisi(const koloni, int);
int koloniYemek(const koloni);
void setKoloniYemek(const koloni, int);
int koloniSavas(const koloni);
void taktikSec(const koloni);
int uret(const koloni);
void uretimSec(const koloni);
void koloniYoket(const koloni);

#endif