package com.katruk.model.ammunition;

public interface Ammunition {

  /**
   * get id of ammunition
   *
   * @return id of ammunition
   */
  int getId();

  /**
   * get name of ammunition
   *
   * @return name of ammunition
   */
  String getName();

  /**
   * set name of ammunition
   *
   * @param name name of ammunition
   */
  void setName(String name);

  /**
   * get weight of ammunition
   *
   * @return weight of ammunition
   */
  int getWeight();

  /**
   * set weight of ammunition
   *
   * @param weight weight of ammunition
   */
  void setWeight(int weight);

  /**
   * get price of ammunition
   *
   * @return price of ammunition
   */
  int getPrice();

  /**
   * set	price of ammunition
   *
   * @param price price of ammunition
   */
  void setPrice(int price);
}
