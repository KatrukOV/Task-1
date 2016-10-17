package com.katruk.model.command;

import com.katruk.model.defaults.DefaultItems;
import com.katruk.model.logic.Memento;

public class DefaultKnights implements State {


  @Override
  public void handle(Memento memento) {
    memento.setKnightMap(new DefaultItems().addDefaultKnight());
//    showKnight();
  }
}
