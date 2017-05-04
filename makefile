compile:
	clear && javac -d . *.java

run:
	clear && java Main

clean:
	rm *.class && rm -rf pvs

build:
	clear && javac -d . *.java && java Demo