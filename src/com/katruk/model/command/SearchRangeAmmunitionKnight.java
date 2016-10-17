package com.katruk.model.command;

import com.katruk.model.ammunition.Ammunition;
import com.katruk.model.logic.Memento;
import com.katruk.veiw.Const;
import com.katruk.veiw.Message;
import com.katruk.veiw.Reader;
import com.katruk.veiw.Writer;

import java.util.Set;

public class SearchRangeAmmunitionKnight implements State, Message, Const {

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

    do {
      writer.printStr(ENTER_ID_KNIGHT);
      int id = reader.readInt(0, memento.getKnightMap().size() - 1);

      if (memento.getKnightMap().get(id).getAmmunition().size() == 0) {
        return;
      }

      writer.printStr(ENTER_MIN_PRICE_AMMUNITION_KNIGHT);
      int min = reader.readInt(MIN_PRICE_OF_AMMUNITION, MAX_PRICE_OF_AMMUNITION);
      writer.printStr(ENTER_MAX_PRICE_AMMUNITION_KNIGHT);
      int max = reader.readInt(MIN_PRICE_OF_AMMUNITION, MAX_PRICE_OF_AMMUNITION);

      Set<Ammunition> ammunitionSet = memento.getKnightMap().get(id).searchRangePrice(min, max);

      for (Ammunition item : ammunitionSet) {
        System.out.println(item);
      }

      writer.printStr(CONTINUE_SEARCH);
      flag = reader.readInt(one, two);
    } while (flag == one);
  }
}
