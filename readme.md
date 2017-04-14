# Drop Cap Games
Drop Cap Games is a collective developer team name for CMSC 22 project.

### Cloning and Development
* Clone the repository using `git clone https://github.com/rrsilaya/Drop-Cap-Games.git`.
* **ALWAYS** do `git pull origin backend` first before anything else.
* **NEVER** push to the `master` branch.
* `git branch backend` to your development branch.

### Coding Rules and Guidelines
> These coding rules should be HIGHLY implemented for ease of collaboration and code readability.
1. **NEVER** use soft tabs (spaces as tabs) in your codes. Use *hard tabs*.
2. Declare import statements by group depending on its class. Do this also in your codes.
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
3. Use proper spaces in your code.
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
4. Observe proper indention.
```java
int i = 1,
    a = 2,
    c = 3;
```
5. Group the variable declarations by *native types* and *class types*.
```java
int i;
String j;
float k;

Student b;
Professor a;
```

> Happy coding!
