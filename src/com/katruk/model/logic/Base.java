package com.katruk.model.logic;

import com.katruk.model.ammunition.Ammunition;
import com.katruk.model.ammunition.TypeAmmunition;
import com.katruk.model.knight.Knight;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Base {

	/**
	 * map for all knights
	 */
	private Map<Integer, Knight> knightMap = new HashMap<Integer, Knight>();

	/**
	 * map for all ammunition
	 */
	private Map<Integer, Ammunition> ammunitionMap = new HashMap<Integer, Ammunition>();

	/**
	 * add to map new knight
	 * @param knight	knight
	 */
	public void addKnight(Knight knight){
		checkArg(knight);

		for (Map.Entry entry : knightMap.entrySet()){

			//todo  equals
			if ( ((Knight) entry.getValue()).getName().equals(knight.getName()) ){
				//or other logic
				System.out.println("update banned");
				return;
			}
		}

		knightMap.put(knight.getId(), knight);
	}

	/**
	 * add to map ammunition
	 * @param ammunition	ammunition
	 * @param <T>			type of ammunition
	 */
	public <T extends Ammunition> void  addAmmunition(T ammunition){
		checkArg(ammunition);

		ammunitionMap.put(ammunition.getId(), ammunition);
	}

	/**
	 * create new ammunition
	 * @param type		type of ammunition
	 * @return			new ammunition
	 */
	public Ammunition createAmmunition(TypeAmmunition type){
			return AmmunitionFactory.getInstance().create(type);
	}

	/**
	 * search by price range ammunition
	 * @param loPrice	lowest price
	 * @param hiPrice	highest price
	 * @return			list of ammunition
	 */
	public List<Ammunition> searchRangePriceAllAmmunition(double loPrice, double hiPrice){
		final List<Ammunition> result = new ArrayList<Ammunition>();

		for (Map.Entry entry : ammunitionMap.entrySet() ){
			Ammunition item = (Ammunition) entry.getValue();
			if ((item.getPrice() > loPrice) && (item.getPrice() < hiPrice)){
				result.add(item);
			}
		}
		return result;
	}

	/**
	 * get all Knight
 	 * @return	map of knight
	 */
	public Map<Integer, Knight> getKnightMap() {
		return knightMap;
	}

	/**
	 * get all ammunition
	 * @return map of ammunition
	 */
	public Map<Integer, Ammunition> getAmmunitionMap() {
		return ammunitionMap;
	}

	/**
	 * set new all knight
	 * @param knightMap	map of all knights
	 */
	public void setKnightMap(Map<Integer, Knight> knightMap) {
		this.knightMap = knightMap;
	}

	/**
	 * set new all ammunition
	 * @param ammunitionMap map of all ammunition
	 */
	public void setAmmunitionMap(Map<Integer, Ammunition> ammunitionMap) {
		this.ammunitionMap = ammunitionMap;
	}

	/**
	 * check arguments for NULL
	 * @param arg	input arguments
	 */
	private void checkArg(Object...arg){
		for(Object item: arg){
			if (item == null){
				throw new IllegalArgumentException("Bed input argument");
			}
		}
	}

}
