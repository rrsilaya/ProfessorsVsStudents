compile:
	clear && javac -d . *.java Professors/*.java Students/*.java Objects/*.java

run:
	clear && java Main

clean:
	rm *.class && rm -rf pvs

build:
	clear && javac -d . *.java Professors/*.java Students/*.java Objects/*.java && java Demo
