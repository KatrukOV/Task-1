package com.katruk.model.command;

import com.katruk.model.logic.Base;
import com.katruk.veiw.Message;
import com.katruk.veiw.Reader;
import com.katruk.veiw.Writer;

public class AppointAmmunitionKnight implements Call, Message {

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
//
//    if (EmptyAmmunitionMap()) {
//      return;
//    }

    int idKnight;
    int idAmmunition;

    do {
      writer.printStr(ENTER_ID_KNIGHT);
      idKnight = reader.readInt(0, base.getKnightMap().size() - 1);

      writer.printStr(ENTER_ID_AMMUNITION);
      idAmmunition = reader.readInt(0, base.getAmmunitionMap().size() - 1);

      base.getKnightMap().get(idKnight).equip(base.getAmmunitionMap().get(idAmmunition));

      writer.printStr(CONTINUE_APPOINT);
      flag = reader.readInt(one, two);
    } while (flag == one);
  }
}
