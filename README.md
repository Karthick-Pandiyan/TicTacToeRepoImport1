# Tic Tac Toe

## Rules

The rules are described below :

- X always goes first.
- Players cannot play on a played position.
- Players alternate placing X’s and O’s on the board until either:
	- One player has three in a row, horizontally, vertically or diagonally
	- All nine squares are filled.
- If a player is able to draw three X’s or three O’s in a row, that player wins.
- If all nine squares are filled and neither player has three in a row, the game is a draw.

# Prerequisites
- 4 GB RAM minimum, 8 GB RAM recommended

- 2 GB of available disk space minimum, 4 GB Recommended (500 MB for IDE + 1.5 GB for Android SDK and emulator system image)
1280 x 800 minimum screen resolution

- Mac OS X 10.10 or higher

- Microsoft Windows 7/8/10 (32- or 64-bit). The Android Emulator supports 64-bit Windows only

- Android Studio

- Android SDK

- GIT Bash

- Android Emulator / Physical Device to test

# Run Application
Step-1: Open "Android studio" then choose "Check out project from Version control"

Step-2: From the options choose "Git", then provide the following url "https://github.com/2020-DEV-058/TicTacToe.git" and tap on "Clone"

Step-3: Once the checkout completes it should open up the project.

Step - 4: Click "Run App" from the toolbar to run the application on the Physical device or Emulator.

step - 5: Use touch to place "X"'s and "O"'s into the game board, Player 1 always goes "X" as first and Player 2 will have "O" to play the game. Result will be announced based on the above game rules.

# Run Test Cases
Step-1: Click on "Run" option in toolbar and edit the run configure to point testcases within the application

Step-2: Please find the test class files and its path in below table:

| File Name  | File Path|
| ------------- | ------------- |
| CellTest  | "app/src/test/java/com.dev.tictactoe.model.CellTest"  |
| GameTest  | "app/src/test/java/com.dev.tictactoe.model.GameTest"  |
| PlayerTest  | "app/src/test/java/com.dev.tictactoe.model.PlayerTest"  |
| GameViewModelTest  | "app/src/test/java/com.dev.tictactoe.viewmodel.GameViewModelTest"  |
| StringUtilityTest  | "app/src/test/java/com.dev.tictactoe.StringUtilityTest"  |

Step-3: You can choose to test all the cases by running the whole file or choose any particular test cases by opening it
