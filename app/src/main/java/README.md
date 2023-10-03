# Tap-It part 2!

## Requirements:

    Home Screen
        1.1 The home screen should display the current high score.
        1.2 The home screen should display a button that takes them to the game screen
    Game Screen
        1.1 The game should still be playable just like before.
        1.2 When the player loses, the high score is updated if it needs to be.
        1.3 When the player loses, the Play Again button should be changed to "Return to Main Menu"
            Take the player back to the previous page when the button is pressed.
    Your app should follow the MVVM design pattern.
        No business logic (saving high score, loading high score, etc. should be found in the composables)
        You should move the presentation logic (the state) to state holders and manage the state through the view model or state holder

    Must user MVVM design!

## Pseudocode:

### Home screen:
When the app launches the user is presented with a screen that has the title of the game,
the current high score (loaded from shared preferences), and a button that says "Play Game".

### Game screen:
When the play game button is pressed they transition to a new screen where the game is played 
(this is where everything you did in your previous assignment should be). 
This should be a separate screen in the navigation structure.

### End screen:
When the player loses the game it should do the same thing as it did in assignment 2 but with 2 changes: 
First, it should save the high score to the shared preferences. 
Second, instead of a button that says play again, you should change the button to say "Back to Main Menu" 
which when pressed takes you back to the first screen. 
From there the player can start another game.