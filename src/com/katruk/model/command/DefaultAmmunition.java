package com.katruk.model.command;

import com.katruk.model.defaults.DefaultItems;
import com.katruk.model.logic.Memento;

public class DefaultAmmunition implements State {

  @Override
  public void handle(Memento memento) {
    memento.setAmmunitionMap(new DefaultItems().addDefaultAmmunition());
    //showAmmunition();
  }
}
