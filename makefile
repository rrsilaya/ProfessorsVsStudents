compile:
	clear && javac -d . *.java Objects/*.java Professors/*.java Students/*.java Screens/*.java

run:
	clear && java Main

clean:
	rm *.class && rm -rf pvs

build:
	clear && javac -d . *.java Objects/*.java Professors/*.java Students/*.java Screens/*.java && java Demo
