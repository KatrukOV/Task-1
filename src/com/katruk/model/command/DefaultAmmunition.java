package com.katruk.model.command;

import com.katruk.model.defaults.DefaultItems;
import com.katruk.model.logic.Base;

public class DefaultAmmunition implements Call {

  @Override
  public void call(Base base) {
    base.setAmmunitionMap(new DefaultItems().addDefaultAmmunition());
    //showAmmunition();
  }
}
