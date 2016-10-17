package com.katruk.model.command;

import com.katruk.model.logic.Memento;

public interface State {

  public void handle(Memento memento);
}
