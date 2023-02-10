package fr.imtld.ilog;

class HelloJava
{
        /* 
        void display() {
                System.out.println("Hello, World !");
        }*/

        static void display(String s) {
                System.out.printf("Hello " + s + " !\n");
        } 

        public static void main(String args[]) 
        { 
                HelloJava.display(args[0]);
        } 
}