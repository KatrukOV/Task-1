package com.katruk.model.knight;

import com.katruk.model.ammunition.Ammunition;

import java.util.List;


public interface Knight{

	public void equip(Ammunition itemAmmunition);

	/**
	 * Calculate the cost of ammunition
	 * @return price of all ammunition
	 */
	public double calculateCost();

	/**
	 * sorting based on the weight of ammunition
	 * @return new List of ammunition
	 */
	public List<Ammunition> sortAmmunitionWeight();

	/**
	 * search for ammunition elements that match a given price range
	 * @param loPrice		the lower limit of the price
	 * @param hiPrice		the upper limit of price
	 * @return 				new List of ammunition
	 */
	public List<Ammunition> searchRangePrice(double loPrice, double hiPrice);

	/**
	 * get ID of Knight
	 * @return	ID of Knight
	 */
	public int getId();


	/**
	 * get name of Knight
	 * @return name of Knight
	 */
	public String getName();

	/**
	 * set name of knight
	 * @param name	name of knight
	 */
	public void setName(String name);


	/**
	 * get all ammunition of Knight
	 * @return list ammunition of Knight
	 */
	public List<Ammunition> getAmmunition();
}
