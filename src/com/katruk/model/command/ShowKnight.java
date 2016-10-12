package com.katruk.model.command;

import com.katruk.model.logic.Base;
import com.katruk.veiw.Writer;

import java.util.Map;

public class ShowKnight implements Call {

  Writer writer = new Writer();

  @Override
  public void call(Base base) {

//    if (EmptyKnightMap()) {
//      return;
//    }

    for (Map.Entry entry : base.getKnightMap().entrySet()) {
      writer.printStrLN(entry.getValue().toString());
    }
  }
}
