package game.Managers;

import game.Data.GameData;
import game.States.MenuState;
import game.States.State;

public class StateManager {
    private final GameData data;
    private State currentState;
    private boolean running = true;

    public StateManager(GameData data) { // Constructor
        this.data = data;
        this.currentState = new MenuState(this, data); // Start the game in the MenuState
        this.currentState.onEnter();
    }

    public void run() throws InterruptedException { // Main -> run() -> update()/render() whatever the currentState is MenuState,GameState etc.
        while (running) {
            currentState.update();
            currentState.render();
            data.messageLog.displayMessages();

            //Thread.sleep(300); // 'sleep' or such, make a tick rate
        }
    }

    public void stopRunning(){
        running = false;
    }

    public void setState(State newState) {
        currentState.onExit();
        currentState = newState;
        currentState.onEnter();
    }
}
