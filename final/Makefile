all:
	cd src &&\
	javacc -OUTPUT_DIRECTORY=../bin Lugosi.jj &&\
	cp -r ./ast ../bin &&\
	cd ../bin &&\
	javac -d ./class *.java

clean:
	rm -rf ./bin/*