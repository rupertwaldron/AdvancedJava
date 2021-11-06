package com.ruppyrup.memento;

public class Editor {
    private String content;
    private int size;

    public String getContent() {
        return content;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public EditorState createState() {
       return new EditorState(content, size);
    }

    public void restore(EditorState editorState) {
        content = editorState.getContent();
        size = editorState.getSize();
    }

    @Override
    public String toString() {
        return "Editor{" +
                "content='" + content + '\'' +
                ", size=" + size +
                '}';
    }
}

