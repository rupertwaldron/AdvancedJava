package com.ruppyrup.memento;

import java.util.ArrayDeque;
import java.util.Deque;

public class History {
    private Deque<EditorState> states = new ArrayDeque<>();

    public void saveState(EditorState editorState) {
        states.push(editorState);
    }

    public EditorState getPreviousState() {
        return states.pop();
    }
}
