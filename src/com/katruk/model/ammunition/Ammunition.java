package com.katruk.model.ammunition;

public interface Ammunition {

	/**
	 * get id of ammunition
	 * @return 		id of ammunition
	 */
	public int getId();

	/**
	 * set id of ammunition
	 * @param id 	id of ammunition
	 */
	public void setId(int id);

	/**
	 * get name of ammunition
	 * @return	name of ammunition
	 */
	public String getName();

	/**
	 * set name of ammunition
	 * @param name	name of ammunition
	 */
	public void setName(String name);

	/**
	 * get weight of ammunition
	 * @return	weight of ammunition
	 */
	public int getWeight();

	/**
	 * set weight of ammunition
	 * @param weight	weight of ammunition
	 */
	public void setWeight(int weight);

	/**
	 * get price of ammunition
	 * @return	price of ammunition
	 */
	public double getPrice();

	/**
	 * set	price of ammunition
	 * @param price	price of ammunition
	 */
	public void setPrice(double price);

}
