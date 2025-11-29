package game.States;

public interface State {
    void onEnter();
    void update();
    void onExit();
    void render();
}
