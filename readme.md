<h1 align="center">
  <img src="Assets/Students/Freshie.png" alt="logo" />
  <br>
  Professors vs. Students
  <br>
</h1>
<h4 align="center">A game adaptation of PopCap Game's <a href="http://www.popcap.com.ph/plants-vs-zombies-1">Plants vs. Zombies</a> written in Java</h4>

### Installation
* Clone the repository using `git clone https://github.com/rrsilaya/Drop-Cap-Games.git`.
* Create the build using any of the following options:
  * Manual Installation (Linux)
    * **`make compile`:** compile from source
    * **`make run`:** run the compiled build
    * **`make build`:** combined compile + run
  * Automated Installation (Windows)
    * Run the `build.bat` file to build from source and run it

### Package Directory
```
.
├── Assets                                          # GUI assets
│   ├── Drop-Cap-Games-Logo.png
│   ├── Font
│   │   ├── indiestarbb_bld.ttf
│   │   └── indiestarbb_reg.ttf
│   ├── Objects                                     # Miscellaneous Object Graphics
│   │   ├── Coffee.png
│   │   ├── Money.png
│   │   ├── Sound.png
│   │   └── Water.png
│   ├── Professors
│   │   ├── <Professor>.png                         # Original Professor Graphics
│   │   └── <Professor>_hurt.png                    # Overlayed Professor Graphics
│   ├── Students
│   │   ├── <Student>.png
│   │   └── <Student>_hurt.png
│   └── UI
│       ├── Buttons
│       │   ├── credits.png
│       │   └── play.png
│       ├── Credits.jpg
│       ├── Gameplay
│       │   ├── Background.jpg
│       │   ├── BackToGame.png
│       │   ├── Bar.png
│       │   ├── Cards
│       │   │   ├── <ProfessorCard>.png
│       │   │   └── <ProfessorCard>_disabled.png
│       │   ├── ExitToMenu.png
│       │   ├── Kwatro.png
│       │   ├── Loader.png
│       │   ├── Menu.png
│       │   ├── PauseMenu.png
│       │   ├── TimeBar.png
│       │   └── TimeID.png
│       ├── Lose.png
│       ├── MainMenu.jpg
│       └── Win.png
├── build.bat
├── Demo.java
├── makefile
├── Objects
│   ├── Button.java
│   ├── Colorable.java
│   ├── DragAndDrop.java
│   ├── GameElement.java
│   ├── Kwatro.java
│   ├── MainFrame.java
│   ├── Money.java
│   ├── ObjectRendered.java
│   ├── Sprite.java
│   ├── StudentGenerator.java
│   ├── Text.java
│   └── Timer.java
├── Professors
│   └── <Professor>.java
├── readme.md
├── Screens
│   ├── Background.java
│   └── Gameplay.java
├── Students
│   └── <Student>.java
└── University.java
```