package com.katruk.model.ammunition;

public abstract class AmmunitionImpl implements Ammunition {

	/**
	 * identifier of ammunition
	 */
	int id;

	/**
	 * name of ammunition
	 */
	String name;

	/**
	 * weight of ammunition
	 */
	int weight;

	/**
	 * price of ammunition
	 */
	int price;

	/**
	 * Constructor
	 * @param id	ID of ammunition
	 */
	public AmmunitionImpl(int id) {
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
