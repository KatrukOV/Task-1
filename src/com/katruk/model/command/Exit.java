package com.katruk.model.command;

import com.katruk.model.logic.Memento;

public class Exit implements State {

  @Override
  public void handle(Memento memento) {
    //todo exit
    throw new IllegalArgumentException();
  }
}
