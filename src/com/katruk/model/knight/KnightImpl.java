package com.katruk.model.knight;

import com.katruk.model.ammunition.Ammunition;
import java.util.*;

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
	private Set<Ammunition> ammunition;

	/**
	 * Constructor
	 * @param id		identifier of knight
	 */
	public KnightImpl(int id) {
		this.id = id;
		ammunition = new HashSet<>();
	}

	/**
	 * Equip knight
	 * @param itemAmmunition	ammunition which equip on knight
	 */
	@Override
	public void equip(Ammunition itemAmmunition){
		ammunition.add(itemAmmunition);
	}

	/**
	 * Calculate the cost of ammunition
	 * @return price of all ammunition
	 */
	@Override
	public int calculateCostAmmunition(){
		int result = 0;
		for (Ammunition item : ammunition){
			result += item.getPrice();
		}
		return result;
	}

	/**
	 * sorting ammunition based by comparator //Ammunition based sorting comparator
	 * @param comparator	comparator of Ammunition
	 * @return		List of Ammunition
	 */
	@Override
	public List<Ammunition> sortAmmunition(Comparator<Ammunition> comparator){
		List<Ammunition> result = new ArrayList<>();
		result.addAll(ammunition);
		Collections.sort(result, comparator);
		return result;
	}

	/**
	 * search for ammunition elements that match a given price range
	 * @param lowerPrice	the lower limit of the price
	 * @param higherPrice	the higher limit of price
	 * @return 				new List of ammunition
	 */
	@Override
	public Set<Ammunition> searchRangePrice(int lowerPrice, int higherPrice){
		final Set<Ammunition> result = new HashSet<>();
		for (Ammunition item : ammunition){
			if ((item.getPrice() > lowerPrice) && (item.getPrice() < higherPrice)){
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
	public Set<Ammunition> getAmmunition() {
		return ammunition;
	}

	@Override
	public String toString() {
		return "id "+id+" name: "+name+" ammunition: " + ammunition;
	}
}



//	Collections.sort(result, new Comparator<Ammunition>() {
//			@Override
//			public int compare(Ammunition o1, Ammunition o2) {
//				return o1.getWeight() - o2.getWeight();
//			}
//		});
//		return result;
//		final Set<Ammunition> result = new TreeSet<>();
//		Collections.sort(result, new Comparator<Ammunition>() {
//			@Override
//			public int compare(Ammunition o1, Ammunition o2) {
//				return o1.getWeight() - o2.getWeight();
//			}
//		});
//		return result;