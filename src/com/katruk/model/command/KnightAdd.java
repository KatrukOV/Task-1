package com.katruk.model.command;

import com.katruk.model.knight.Knight;
import com.katruk.model.logic.Base;
import com.katruk.model.logic.KnightFactory;
import com.katruk.veiw.Message;
import com.katruk.veiw.Reader;
import com.katruk.veiw.Writer;

public class KnightAdd implements Call, Message {

  Writer writer = new Writer();
  Reader reader = new Reader();

  // todo dell
  int flag;
  int one;
  int two;

  @Override
  public void call(Base base) {
    do {
      writer.printStr(ENTER_NAME_KNIGHT);
      String name = reader.readString();
      Knight knight = KnightFactory.getInstance().create();
      knight.setName(name);
      base.addKnight(knight);
      writer.printStr(CONTINUE_ADD);
      flag = reader.readInt(one, two);
    } while (flag == one);
  }
}
