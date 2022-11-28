package com.States;

import java.util.Stack;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameState {
    //best to use a DSArraylist because it will act as a better stack than graph.
    //Also, I didn't want to rewrite DSgraph to make it compaitble.
    private static DSArraylist<State> states;

    public GameState() {
        states = new DSArraylist<State>();
    }

    public void push(State state) {
        states.add(state);
    }

    public void pop(State state) {
        states.remove(state);
    }

    public void set(State state1, State state2) {
        states.remove(state1);
        states.add(state2);
    }

    public void update(float dt) {
        states.get(0).update(dt);
    }

    public void render(SpriteBatch ab) {
        states.get(0).render(ab);
    }
    public static State get(int i) {
        //if ( i < length ) {       
            return states.get(i);
    }

}
//normally I would use a stack, but I need to use something from the three data structures, so why not a DSarraylist?