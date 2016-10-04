package com.katruk.model.knight;

import com.katruk.model.ammunition.Ammunition;

import java.util.Comparator;
import java.util.List;
import java.util.Set;


public interface Knight{

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
	public Set<Ammunition> getAmmunition();

	/**
	 * equip Knight
	 * @param itemAmmunition one of ammunition
	 */
	public void equip(Ammunition itemAmmunition);

	/**
	 * Calculate the price of ammunition
	 * @return cost of all ammunition
	 */
	public int calculateCostAmmunition();

	/**
	 * search for ammunition elements that match a given price range
	 * @param lowerPrice	the lower limit of the price
	 * @param higherPrice	the higher limit of price
	 * @return 				new List of ammunition
	 */
	public Set<Ammunition> searchRangePrice(int lowerPrice, int higherPrice);

	/**
	 * sorting ammunition based by comparator //Ammunition based sorting comparator
	 * @param comparator	comparator of Ammunition
	 * @return	list of Ammunition
	 */
	public List<Ammunition> sortAmmunition(Comparator<Ammunition> comparator);
}
