
hepsi: derle calis 

derle:
	gcc -I ./include/ -o ./lib/taktik.o -c ./src/taktik.c
	gcc -I ./include/ -o ./lib/ataktik.o -c ./src/ataktik.c
	gcc -I ./include/ -o ./lib/btaktik.o -c ./src/btaktik.c
	gcc -I ./include/ -o ./lib/uretim.o -c ./src/uretim.c
	gcc -I ./include/ -o ./lib/auretim.o -c ./src/auretim.c
	gcc -I ./include/ -o ./lib/buretim.o -c ./src/buretim.c
	gcc -I ./include/ -o ./lib/koloni.o -c ./src/koloni.c
	gcc -I ./include/ -o ./lib/oyun.o -c ./src/oyun.c
	gcc -I ./include/ -o ./bin/test ./lib/taktik.o ./lib/ataktik.o ./lib/btaktik.o ./lib/uretim.o ./lib/auretim.o ./lib/buretim.o ./lib/koloni.o ./lib/oyun.o ./src/test.c

calis:
	./bin/test