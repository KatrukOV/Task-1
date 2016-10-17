package com.katruk.model.command;

import com.katruk.model.logic.Memento;
import com.katruk.veiw.Message;
import com.katruk.veiw.Reader;
import com.katruk.veiw.Writer;

public class AppointAmmunitionKnight implements State, Message {

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
//
//    if (EmptyAmmunitionMap()) {
//      return;
//    }

    int idKnight;
    int idAmmunition;

    do {
      writer.printStr(ENTER_ID_KNIGHT);
      idKnight = reader.readInt(0, memento.getKnightMap().size() - 1);

      writer.printStr(ENTER_ID_AMMUNITION);
      idAmmunition = reader.readInt(0, memento.getAmmunitionMap().size() - 1);

      memento.getKnightMap().get(idKnight).equip(memento.getAmmunitionMap().get(idAmmunition));

      writer.printStr(CONTINUE_APPOINT);
      flag = reader.readInt(one, two);
    } while (flag == one);
  }
}
