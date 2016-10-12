package com.katruk.model.command;

import com.katruk.model.logic.Base;
import com.katruk.veiw.Writer;

import java.util.Map;

public class ShowAmmunition implements Call {

  Writer writer = new Writer();

  @Override
  public void call(Base base) {

//    if (EmptyAmmunitionMap()) {
//      return;
//    }

    for (Map.Entry entry : base.getAmmunitionMap().entrySet()) {
      writer.printStrLN(entry.getValue().toString());
    }
  }
}
