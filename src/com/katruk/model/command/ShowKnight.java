package com.katruk.model.command;

import com.katruk.model.logic.Memento;
import com.katruk.veiw.Writer;

import java.util.Map;

public class ShowKnight implements State {

  Writer writer = new Writer();

  @Override
  public void handle(Memento memento) {

//    if (EmptyKnightMap()) {
//      return;
//    }

    for (Map.Entry entry : memento.getKnightMap().entrySet()) {
      writer.printStrLN(entry.getValue().toString());
    }
  }
}
