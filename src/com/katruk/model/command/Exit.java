package com.katruk.model.command;

import com.katruk.model.logic.Base;

public class Exit implements Call {

  @Override
  public void call(Base base) {
    //todo exit
    throw new IllegalArgumentException();
  }
}
