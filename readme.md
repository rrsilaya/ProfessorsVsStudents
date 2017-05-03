# Drop Cap Games
Drop Cap Games is a collective developer team name for CMSC 22 project.

### Cloning and Development
* Clone the repository using `git clone https://github.com/rrsilaya/Drop-Cap-Games.git`.
* **ALWAYS** do `git pull origin backend` first before anything else.
* **NEVER** push to the `master` branch without consensus to the team.
* `git branch backend` to your development branch.
* Instead of running/compiling the codes manually, use the `makefile` included in the project.
	* `make` to compile the files
	* `make run` to run the `Main` class
	* `make clean` to delete compiled classes (retaining the source codes)
	* `make build` to compile and run at the same time
* **ALWAYS** do a `make clean` first before pushing files to git.
* Always check the ***Projects*** tab to know what tasks are left to do, in progress, and done.

### Coding Rules and Guidelines
> These coding rules should be HIGHLY implemented for ease of collaboration and code readability.
1. **NEVER** use soft tabs (spaces as tabs) in your codes. Use *hard tabs*.
2. **DO NOT** push to the repository with *.class* files. Do `rm *.class` first
	before adding to the repository.
3. Declare import statements by group depending on its class. Do this also in your codes.
```java
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Color;

import java.util.Scanner;
import java.util.Arrays;
```
4. Use proper spaces in your code.
**Wrong:**
```java
for(i=0;i<5;i++){
  System.out.println("Hello world!");
}
```
**Correct:**
```java
for(i = 0; i < 5; i++) {
  System.out.println("Hello world!");
}
```
5. Observe proper indention.
```java
int i = 1,
    a = 2,
    c = 3;
```
6. Group the variable declarations by *native types* and *class types*.
```java
int i;
String j;
float k;

Student b;
Professor a;
```

> Happy coding!
