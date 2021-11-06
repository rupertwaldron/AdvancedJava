package com.ruppyrup.memento;

public class EditorState {
    private final String content;
    private final int size;

    public EditorState(String content, int size) {
        this.content = content;
        this.size = size;
    }

    public String getContent() {
        return content;
    }

    public int getSize() {
        return size;
    }

}
