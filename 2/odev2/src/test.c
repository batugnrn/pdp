/*****************************************************************************************************
** SAKARYA ÜNİVERSİTESİ
** BİLGİSAYAR VE BİLİŞİM BİLİMLERİ FAKÜLTESİ
** BİLGİSAYAR MÜHENDİSLİĞİ BÖLÜMÜ
** PROGRAMLAMA DİLLERİNİN PRENSİPLERİ DERSİ
** 2022-2023 BAHAR DÖNEMİ
**
**
** ÖDEV ..................: 2. ÖDEV
** ÖĞRENCİ ADI............: BAHRİ BATUHAN GÜNEREN
** ÖĞRENCİ NUMARASI.......: G201210059
** DERSİN ALINDIĞI GRUP...: 2.ÖĞRETİM A GRUBU
****************************************************************************************************/
#include <stdio.h>
#include <stdlib.h>
#include "koloni.h"
#include "oyun.h"
#include <string.h>


int main(){
    char str[100];
    int *num = NULL, i = 0, size = 10; // num pointer'ı boyutu 10 olan int bir diziye işaret eder.
    srand(time(NULL));
    printf("Aralarinda bosluk birakarak sayi dizisini girin: ");
    fgets(str, sizeof(str), stdin);
    
    num = (int *) malloc(size * sizeof(int)); // num pointer'ı 10 elemanlı int dizisi için bellek ayırma işlemi
    
    char *ptr = strtok(str, " ");
    while (ptr != NULL) {
        num[i++] = atoi(ptr);
        if (i >= size) {
            size += 10;                                     // eğer 10 elemandan daha fazla ise
            num = (int *) realloc(num, size * sizeof(int)); // num dizisine 10 daha fazla eleman ekler.
        }
        ptr = strtok(NULL, " ");
    }
    

   koloni* koloniler = malloc(i * sizeof(koloni));


   
    for (int j = 0; j < i; j++) {

    koloni k = koloniOlustur(num[j]);
    koloniler[j] = k;
    
    }
    

        
    oyun o = oyunOlustur();

    o->oyunaBasla(o,koloniler,i);



    for (int j = 0; j < i; j++) {    // koloniler dizisinin elemanları yok ediliyor.
        koloni k2 = koloniler[j];
        k2->koloniYoket(k2);
    }

    free(koloniler);     // koloniler dizisinin kendisi yok ediliyor.
    free(num); // num dizisinin kullandığı bellek alanını serbest bırakır.
    o->oyunYoket(o);  // oyunu serbest bırakır.
    return 0;

}


