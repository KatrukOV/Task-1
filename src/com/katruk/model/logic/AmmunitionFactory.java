package com.katruk.model.logic;

import com.katruk.model.ammunition.Ammunition;
import com.katruk.model.ammunition.Armor;
import com.katruk.model.ammunition.Shield;
import com.katruk.model.ammunition.TypeAmmunition;

public class AmmunitionFactory {

  /**
   * this single factory
   */
  private static AmmunitionFactory ammunitionFactory = new AmmunitionFactory();

  /**
   * ID of ammunition
   */
  private int idAmmunition = 0;

  /**
   * hidden constructor
   */
  private AmmunitionFactory() {
  }

  /**
   * for get single AmmunitionFactory
   *
   * @return AmmunitionFactory
   */
  public static AmmunitionFactory getInstance() {
    return ammunitionFactory;
  }

  /**
   * create different type of ammunition with unique id
   *
   * @param type type of ammunition
   * @return one of ammunition
   */
  public Ammunition create(TypeAmmunition type) {
    Ammunition result = null;

    switch (type) {
      case Armor: {
        result = new Armor(idAmmunition++);
        break;
      }
      case Shield: {
        result = new Shield(idAmmunition++);
        break;
      }
    }
    return result;
  }
}
