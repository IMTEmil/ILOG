CC = gcc

all : lib

-include rules.mk

lib : AllTests.o CuTest.o CuTestTest.o	
	ar -r libcutest.a *.o
	ranlib libcutest.a

tests:
	gcc -o tests libcutest.a

clean :
	rm -f *.o
	rm -f *.exe	
	rm -f *.a

mm: rules.mk
	gcc -MM *.c>rules.mk


