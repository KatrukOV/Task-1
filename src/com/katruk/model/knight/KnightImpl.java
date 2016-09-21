package com.katruk.model.knight;

import com.katruk.model.ammunition.Ammunition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class KnightImpl implements Knight {

	/**
	 * identifier of knight
	 */
	private int id;

	/**
	 * name of knight
	 */
	private String name;

	/**
	 *  ammunition of knight
	 */
	private List<Ammunition> ammunition = new ArrayList<Ammunition>();

	/**
	 * Constructor
	 * @param id		identifier of knight
	 */
	public KnightImpl(int id) {
		this.id = id;
	}

	/**
	 * Equip knight
	 * @param itemAmmunition	ammunition which equip on knight
	 */
	@Override
	public void equip(Ammunition itemAmmunition){
		if (ammunition == null) new ArrayList<Ammunition>();
		ammunition.add(itemAmmunition);
	}

	/**
	 * Calculate the cost of ammunition
	 * @return price of all ammunition
	 */
	@Override
	public double calculateCost(){
		double result = 0;
		for (Ammunition item : ammunition){
			result+=item.getPrice();
		}
		return result;
	}

	/**
	 * sorting based on the weight of ammunition
	 * @return new List of ammunition
	 */
	@Override
	public List<Ammunition> sortAmmunitionWeight(){
		final List<Ammunition> result = new ArrayList<Ammunition>(ammunition);
		Collections.sort(result, new Comparator<Ammunition>() {
			@Override
			public int compare(Ammunition o1, Ammunition o2) {
				return o1.getWeight() - o2.getWeight();
			}
		});
		return result;
	}

	/**
	 * search for ammunition elements that match a given price range
	 * @param loPrice		the lower limit of the price
	 * @param hiPrice		the upper limit of price
	 * @return 				new List of ammunition
	 */
	@Override
	public List<Ammunition> searchRangePrice(double loPrice, double hiPrice){
		final List<Ammunition> result = new ArrayList<Ammunition>();
		for (Ammunition item : ammunition){
			if ((item.getPrice() > loPrice) && (item.getPrice() < hiPrice)){
				result.add(item);
			}
		}
		return result;
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
	public List<Ammunition> getAmmunition() {
		return ammunition;
	}

	@Override
	public String toString() {
		return "id "+id+" name: "+name+" ammunition: " + ammunition;
	}
}
