package Darts;

import consoleUi.TextUi;

public class Main {
    public static void main(String[] args) throws Exception {
        DartsGame game = new DartsGame(501, 2);
        TextUi ui = new TextUi(game);
        ui.playGame();
    }
}
