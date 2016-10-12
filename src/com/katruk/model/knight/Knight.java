package com.katruk.model.knight;

import com.katruk.model.ammunition.Ammunition;

import java.util.Comparator;
import java.util.List;
import java.util.Set;


public interface Knight {

  /**
   * get ID of Knight
   *
   * @return ID of Knight
   */
  int getId();

  /**
   * get name of Knight
   *
   * @return name of Knight
   */
  String getName();

  /**
   * set name of knight
   *
   * @param name name of knight
   */
  void setName(String name);

  /**
   * get all ammunition of Knight
   *
   * @return list ammunition of Knight
   */
  Set<Ammunition> getAmmunition();

  /**
   * equip Knight
   *
   * @param itemAmmunition one of ammunition
   */
  void equip(Ammunition itemAmmunition);

  /**
   * Calculate the price of ammunition
   *
   * @return cost of all ammunition
   */
  int calculateCostAmmunition();

  /**
   * search for ammunition elements that match a given price range
   *
   * @param lowerPrice  the lower limit of the price
   * @param higherPrice the higher limit of price
   * @return new List of ammunition
   */
  Set<Ammunition> searchRangePrice(int lowerPrice, int higherPrice);

  /**
   * sorting ammunition based by comparator //Ammunition based sorting comparator
   *
   * @param comparator comparator of Ammunition
   * @return list of Ammunition
   */
  List<Ammunition> sortAmmunition(Comparator<Ammunition> comparator);
}
