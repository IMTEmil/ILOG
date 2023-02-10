#include "fr_imtld_ilog_Display.h"

#include <stdio.h>

void Java_fr_imtld_ilog_Display_display(JNIEnv *env, jobject this, jstring jstrMessage) {

        printf("Hello World !");        
}

int main(void) {

        return 0;
}