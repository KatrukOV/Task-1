package com.katruk.model.command;

import com.katruk.model.logic.Base;
import com.katruk.veiw.Message;
import com.katruk.veiw.Reader;
import com.katruk.veiw.Writer;

public class CalcCostAmmunition implements Call, Message {

  Writer writer = new Writer();
  Reader reader = new Reader();

  // todo dell
  int flag;
  int one;
  int two;

  @Override
  public void call(Base base) {
//    if (EmptyKnightMap()) {
//      return;
//    }

    do {
      writer.printStr(ENTER_ID_KNIGHT);

      int id = reader.readInt(0, base.getKnightMap().size() - 1);
      double cost = base.getKnightMap().get(id).calculateCostAmmunition();

      writer.printStrLN(String.format(COST_AMMUNITION_KNIGHT,
                                      base.getKnightMap().get(id).getName(), cost));

      writer.printStr(CONTINUE_CALCULATE);
      flag = reader.readInt(one, two);
    } while (flag == one);
  }
}
