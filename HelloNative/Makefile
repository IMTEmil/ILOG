JDK = /usr/lib/jvm/java-8-openjdk-amd64

INCLUDES = -I"C:\Users\emilp\Documents\eclipse-jee-2022-09-R-win32-x86_64\eclipse\plugins\org.eclipse.justj.openjdk.hotspot.jre.full.win32.x86_64_17.0.4.v20220903-1038\jre\include\win32" \
-I"C:\Users\emilp\Documents\eclipse-jee-2022-09-R-win32-x86_64\eclipse\plugins\org.eclipse.justj.openjdk.hotspot.jre.full.win32.x86_64_17.0.4.v20220903-1038\jre\include" 

CFLAGS += $(INCLUDES)

OBJS = Display.o

TARGET = ../HelloJNI/HelloNative.dll

Display.o: Display.c fr_imtld_ilog_Display.h

$(TARGET): $(OBJS)
	$(CXX) $(OBJS) -o $(TARGET)

all: $(TARGET)

clean:
	$(RM) $(OBJS) $(TARGET)