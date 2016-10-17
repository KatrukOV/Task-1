package com.katruk.model.command;

import com.katruk.model.ammunition.Ammunition;
import com.katruk.model.logic.Memento;
import com.katruk.veiw.Const;
import com.katruk.veiw.Message;
import com.katruk.veiw.Reader;
import com.katruk.veiw.Writer;

import java.util.List;

public class SearchRangeAllAmmunition implements State, Message, Const {

  Writer writer = new Writer();
  Reader reader = new Reader();

  // todo dell
  int flag;
  int one;
  int two;

  @Override
  public void handle(Memento memento) {
//    if (EmptyAmmunitionMap()) {
//      return;
//    }

    do {
      writer.printStr(ENTER_MIN_PRICE_AMMUNITION);
      int min = reader.readInt(MIN_PRICE_OF_AMMUNITION, MAX_PRICE_OF_AMMUNITION);
      writer.printStr(ENTER_MAX_PRICE_AMMUNITION);
      int max = reader.readInt(MIN_PRICE_OF_AMMUNITION, MAX_PRICE_OF_AMMUNITION);

      List<Ammunition> ammunitionList = memento.searchRangePriceAllAmmunition(min, max);

      for (Ammunition item : ammunitionList) {
        writer.printStrLN(item.toString());
      }
      writer.printStr(CONTINUE_SEARCH);
      flag = reader.readInt(one, two);
    } while (flag == one);
  }
}
