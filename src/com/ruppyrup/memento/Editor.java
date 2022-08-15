package com.ruppyrup.memento;

import java.util.Objects;

public class Editor {

  private EditorState state;

  public String getContent() {
    return state.content;
  }

  public void setSize(int size) {
    state.size = size;
  }

  public void setContent(String content) {
    state.content = content;
  }

  public Editor() {
    this.state = new EditorState();
  }

  public EditorMemento getMemento() {
    return new EditorMementoImpl(state);
  }

  public void restore(EditorMemento memento) {
    state = memento.state();
  }

  @Override
  public String toString() {
    return "Editor{" +
        "state=" + state +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Editor editor = (Editor) o;

    return Objects.equals(state, editor.state);
  }

  @Override
  public int hashCode() {
    return state != null ? state.hashCode() : 0;
  }

  private static final class EditorMementoImpl implements EditorMemento {

    private final EditorState state;

    private EditorMementoImpl(final EditorState state) {
      this.state = new EditorState(state);
    }

    @Override
    public EditorState state() {
      return state;
    }
  }

  public static class EditorState {

    private String content;
    private int size;

    public EditorState(final EditorState state) {
      content = state.content;
      size = state.size;
    }

    public EditorState() {
    }

    @Override
    public String toString() {
      return "EditorState{" +
          "content='" + content + '\'' +
          ", size=" + size +
          '}';
    }

  }
}

