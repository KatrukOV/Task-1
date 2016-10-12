package com.katruk.model.command;

import com.katruk.model.defaults.DefaultItems;
import com.katruk.model.logic.Base;

public class DefaultKnights implements Call {


  @Override
  public void call(Base base) {
    base.setKnightMap(new DefaultItems().addDefaultKnight());
//    showKnight();
  }
}
