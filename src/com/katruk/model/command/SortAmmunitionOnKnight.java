package com.katruk.model.command;

import com.katruk.model.ammunition.Ammunition;
import com.katruk.model.logic.Memento;
import com.katruk.veiw.Message;
import com.katruk.veiw.Reader;
import com.katruk.veiw.Writer;

import java.util.List;

public class SortAmmunitionOnKnight implements State, Message {

  Writer writer = new Writer();
  Reader reader = new Reader();

  // todo dell
  int flag;
  int one;
  int two;

  @Override
  public void handle(Memento memento) {
//    if (EmptyKnightMap()) {
//      return;
//    }
//    if (EmptyAmmunitionMap()) {
//      return;
//    }

    do {
      writer.printStr(ENTER_ID_KNIGHT);
      int id = reader.readInt(0, memento.getKnightMap().size() - 1);

      if (memento.getKnightMap().get(id).getAmmunition().size() == 0) {
        return;
      }

      List<Ammunition> ammunitionList;
      ammunitionList =
          memento.getKnightMap().get(id).sortAmmunition((o1, o2) -> o1.getWeight() - o2.getWeight());

      for (Ammunition item : ammunitionList) {
        System.out.println(item);
      }

      writer.printStr(CONTINUE_SORT);
      flag = reader.readInt(one, two);
    } while (flag == one);
  }
}
