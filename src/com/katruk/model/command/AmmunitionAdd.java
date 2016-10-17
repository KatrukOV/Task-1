package com.katruk.model.command;

import com.katruk.model.ammunition.Armor;
import com.katruk.model.ammunition.Shield;
import com.katruk.model.ammunition.TypeAmmunition;
import com.katruk.model.logic.Memento;
import com.katruk.veiw.Const;
import com.katruk.veiw.Message;
import com.katruk.veiw.Reader;
import com.katruk.veiw.Writer;

public class AmmunitionAdd implements State, Message, Const {

  Writer writer = new Writer();
  Reader reader = new Reader();

  // todo dell
  int flag;
  int one;
  int two;

  @Override
  public void handle(Memento memento) {

    do {
      writer.printStr(ENTER_TYPE_AMMUNITION);

      TypeAmmunition[] typeAmmunition = TypeAmmunition.values();
      for (TypeAmmunition type : typeAmmunition) {
        writer.printStr(String.format(" %s    %s \n", type.ordinal() + 1, type));
      }

      int numberCode = reader.readInt(one, two) - 1;

      TypeAmmunition choiceType = null;
      for (TypeAmmunition type : typeAmmunition) {
        if (type.ordinal() == numberCode) {
          choiceType = type;
        }
      }

      writer.printStr(ENTER_NAME_AMMUNITION);
      String name = reader.readString();
      writer.printStr(ENTER_WEIGHT_AMMUNITION);
      int weight = reader.readInt(MIN_WEIGHT_OF_AMMUNITION, MAX_WEIGHT_OF_AMMUNITION);
      writer.printStr(ENTER_PRICE_AMMUNITION);
      int price = reader.readInt(MIN_PRICE_OF_AMMUNITION, MAX_PRICE_OF_AMMUNITION);

      assert choiceType != null;
      switch (choiceType) {
        case SHIELD: {
          Shield shield = (Shield) memento.createAmmunition(TypeAmmunition.SHIELD);
          shield.setName(name);
          shield.setWeight(weight);
          shield.setPrice(price);
          writer.printStr(ENTER_SHIELD_SKILL);
          int skill = reader.readInt(MIN_SKILL_OF_SHIELD, MAX_SKILL_OF_SHIELD);
          shield.setShieldSkill(skill);
          memento.addAmmunition(shield);
          break;
        }
        case ARMOR: {
          Armor armor = (Armor) memento.createAmmunition(TypeAmmunition.ARMOR);
          armor.setName(name);
          armor.setWeight(weight);
          armor.setPrice(price);
          writer.printStr(ENTER_ARMOR_SKILL);
          int skill = reader.readInt(MIN_SKILL_OF_ARMOR, MAX_SKILL_OF_ARMOR);
          armor.setArmorSkill(skill);
          memento.addAmmunition(armor);
          break;
        }
      }
      writer.printStr(CONTINUE_ADD);
      flag = reader.readInt(one, two);
    } while (flag == one);
  }
}
