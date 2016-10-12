package com.katruk.model.ammunition;

abstract class AmmunitionImpl implements Ammunition {

  /**
   * identifier of ammunition
   */
  private int id;

  /**
   * name of ammunition
   */
  private String name;

  /**
   * weight of ammunition
   */
  private int weight;

  /**
   * price of ammunition
   */
  private int price;

  /**
   * Constructor
   *
   * @param id ID of ammunition
   */
  AmmunitionImpl(int id) {
    this.id = id;
  }

  @Override
  public int getId() {
    return id;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public int getWeight() {
    return weight;
  }

  @Override
  public void setWeight(int weight) {
    this.weight = weight;
  }

  @Override
  public int getPrice() {
    return price;
  }

  @Override
  public void setPrice(int price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return String.format("ID: %3d name: %s weight %5d price %10d  ", id, name, weight, price);
  }
}
