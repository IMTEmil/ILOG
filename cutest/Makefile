CC = gcc

all : lib

-include rules.mk

lib : AllTests.o CuTest.o CuTestTest.o	
	ar -r libs/libcutest.a *.o
	ranlib libs/libcutest.a

tests: lib
	gcc -o tests libs/libcutest.a
	tests

clean :
	rm -f *.o
	rm -f *.exe	
	rm -f *.a

mm: rules.mk
	gcc -MM *.c>rules.mk


