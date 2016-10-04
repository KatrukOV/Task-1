package com.katruk.controller;

import com.katruk.model.ammunition.Armor;
import com.katruk.model.ammunition.Shield;
import com.katruk.model.knight.Knight;
import com.katruk.model.logic.Base;
import com.katruk.model.ammunition.Ammunition;
import com.katruk.model.ammunition.TypeAmmunition;
import com.katruk.model.defaults.DefaultItems;
import com.katruk.model.logic.KnightFactory;
import com.katruk.veiw.*;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Terminal implements Const, Message {

	/**
	 * flag to continue
	 */
	int flag;

	/**
	 * number "1"
	 */
	final int one = 1;

	/**
	 * number "2"
	 */
	final int two = 2;


	Base base = new Base();
	Reader reader = new Reader();
	Writer writer = new Writer();

	/**
	 * method for start
	 */
	public void menu(){
		do {
			writer.printStrLN(BEGIN);

			ChoiceMenus[] choices = ChoiceMenus.values();
			for(ChoiceMenus menus : choices) {
				writer.printStrLN(menus.toString());
			}
			writer.printStr(SELECT);

			// number begin from 0, therefore mast -1
			int numberChoiceMenus = reader.readInt(one, choices.length ) - 1;

			ChoiceMenus choiceMenus = null;
			for(ChoiceMenus menus : choices){
				if (menus.ordinal()==numberChoiceMenus) choiceMenus = menus;
			}

			assert choiceMenus != null;

			switch (choiceMenus) {
				case menu1: { useDefaultKnights(); 					break;}
				case menu2: { useDefaultAmmunition(); 				break;}
				case menu3: { addKnightMenu(); 						break;}
				case menu4: { addAmmunitionMenu();					break;}
				case menu5: { appointAmmunitionKnightMenu();		break;}
				case menu6: { calcCostAmmunitionMenu();				break;}
				case menu7: { sortAmmunitionWeightKnightMenu();		break;}
				case menu8: { searchRangeAmmunitionKnightMenu();	break;}
				case menu9: { searchRangeAllAmmunitionMenu();		break;}
				case menu10: { showKnight();						break;}
				case menu11: { showAmmunition();					break;}
			}
			writer.printStr(CONTINUE);
			flag = reader.readInt(one, two);
		} while (flag == one);
	}

	/**
	 * load default knights
	 */
	private void useDefaultKnights() {
		base.setKnightMap(new DefaultItems().addDefaultKnight());
		showKnight();
	}

	/**
	 * load default ammunition
	 */
	private void useDefaultAmmunition() {
		base.setAmmunitionMap(new DefaultItems().addDefaultAmmunition());
		showAmmunition();
	}

	/**
	 * add new knight
	 */
	private void addKnightMenu() {
		do {
			writer.printStr(ENTER_NAME_KNIGHT);
			String name = reader.readString();
			Knight knight = KnightFactory.getInstance().create();
			knight.setName(name);
			base.addKnight(knight);
			writer.printStr(CONTINUE_ADD);
			flag = reader.readInt(one, two);
		} while (flag == one);
	}

	/**
	 * add new ammunition
	 */
	private void addAmmunitionMenu() {

        do {
			writer.printStr(ENTER_TYPE_AMMUNITION);

			TypeAmmunition[] typeAmmunition = TypeAmmunition.values();
			for(TypeAmmunition type : typeAmmunition) {
				writer.printStr(String.format(" %s    %s \n", type.ordinal() + 1, type));
			}

			int numberCode = reader.readInt(one, two) - 1;

			TypeAmmunition choiceType = null;
			for(TypeAmmunition type : typeAmmunition){
				if (type.ordinal() == numberCode) choiceType = type;
			}

			writer.printStr(ENTER_NAME_AMMUNITION);
			String name = reader.readString();
			writer.printStr(ENTER_WEIGHT_AMMUNITION);
			int weight = reader.readInt(MIN_WEIGHT_OF_AMMUNITION, MAX_WEIGHT_OF_AMMUNITION);
			writer.printStr(ENTER_PRICE_AMMUNITION);
			int price = reader.readInt(MIN_PRICE_OF_AMMUNITION, MAX_PRICE_OF_AMMUNITION);

			assert choiceType != null;
			switch (choiceType) {
				case Shield:{
					Shield shield = (Shield) base.createAmmunition(TypeAmmunition.Shield);
					shield.setName(name);
					shield.setWeight(weight);
					shield.setPrice(price);
					writer.printStr(ENTER_SHIELD_SKILL);
					int skill = reader.readInt(MIN_SKILL_OF_SHIELD, MAX_SKILL_OF_SHIELD);
					shield.setShieldSkill(skill);
					base.addAmmunition(shield);
					break;
				}
				case Armor:{
					Armor armor = (Armor) base.createAmmunition(TypeAmmunition.Armor);
					armor.setName(name);
					armor.setWeight(weight);
					armor.setPrice(price);
					writer.printStr(ENTER_ARMOR_SKILL);
					int skill = reader.readInt(MIN_SKILL_OF_ARMOR, MAX_SKILL_OF_ARMOR);
					armor.setArmorSkill(skill);
					base.addAmmunition(armor);
					break;
				}
			}
			writer.printStr(CONTINUE_ADD);
			flag = reader.readInt(one, two);
		} while (flag == one);
	}

	/**
	 *  appoint the ammunition on the knight
	 */
	private void appointAmmunitionKnightMenu() {
        if (EmptyKnightMap()) return;

        if (EmptyAmmunitionMap()) return;

		int idKnight;
		int idAmmunition;
		do {
			writer.printStr(ENTER_ID_KNIGHT);
			idKnight = reader.readInt(0, base.getKnightMap().size() - 1);

			writer.printStr(ENTER_ID_AMMUNITION);
			idAmmunition = reader.readInt(0, base.getAmmunitionMap().size() - 1);

			base.getKnightMap().get(idKnight).equip(base.getAmmunitionMap().get(idAmmunition));

			writer.printStr(CONTINUE_APPOINT);
			flag = reader.readInt(one, two);
		} while (flag == one);
	}

	/**
	 * calculate cost of ammunition on the knight
	 */
	private void calcCostAmmunitionMenu() {

        if (EmptyKnightMap()) return;

        do {
			writer.printStr(ENTER_ID_KNIGHT);

			int id = reader.readInt(0, base.getKnightMap().size() - 1);
			double cost = base.getKnightMap().get(id).calculateCostAmmunition();

			writer.printStrLN(String.format(COST_AMMUNITION_KNIGHT,
					base.getKnightMap().get(id).getName(), cost));

			writer.printStr(CONTINUE_CALCULATE);
			flag = reader.readInt(one, two);
		} while (flag == one);
	}

	/**
	 * sort ammunition on the knight by the weight
	 */
	private void sortAmmunitionWeightKnightMenu() {

        if (EmptyKnightMap()) return;
        if (EmptyAmmunitionMap()) return;

        do {
			writer.printStr(ENTER_ID_KNIGHT);
			int id = reader.readInt(0, base.getKnightMap().size() - 1);

			if (base.getKnightMap().get(id).getAmmunition().size() == 0) return;

			List<Ammunition> ammunitionList;
            ammunitionList = base.getKnightMap().get(id).sortAmmunition((o1, o2) -> o1.getWeight() - o2.getWeight());

            for (Ammunition item: ammunitionList){
				System.out.println(item);
			}

			writer.printStr(CONTINUE_SORT);
			flag = reader.readInt(one, two);
		} while (flag == one);
	}

	/**
	 * search ammunition knights in the price range
	 */
	private void searchRangeAmmunitionKnightMenu() {

        if (EmptyKnightMap()) return;

		do {
			writer.printStr(ENTER_ID_KNIGHT);
			int id = reader.readInt(0, base.getKnightMap().size() - 1);

			if (base.getKnightMap().get(id).getAmmunition().size() == 0) return;

			writer.printStr(ENTER_MIN_PRICE_AMMUNITION_KNIGHT);
				int min = reader.readInt(MIN_PRICE_OF_AMMUNITION, MAX_PRICE_OF_AMMUNITION);
			writer.printStr(ENTER_MAX_PRICE_AMMUNITION_KNIGHT);
				int max = reader.readInt(MIN_PRICE_OF_AMMUNITION, MAX_PRICE_OF_AMMUNITION);

			Set<Ammunition> ammunitionSet = base.getKnightMap().get(id).searchRangePrice(min, max);

			for (Ammunition item: ammunitionSet){
				System.out.println(item);
			}

			writer.printStr(CONTINUE_SEARCH);
			flag = reader.readInt(one, two);
		} while (flag == one);
	}
	/**
	 * search ammunition in the price range
	 */
	private void searchRangeAllAmmunitionMenu() {

        if (EmptyAmmunitionMap()) return;

        do {
			writer.printStr(ENTER_MIN_PRICE_AMMUNITION);
				int min = reader.readInt(MIN_PRICE_OF_AMMUNITION, MAX_PRICE_OF_AMMUNITION);
			writer.printStr(ENTER_MAX_PRICE_AMMUNITION);
				int max = reader.readInt(MIN_PRICE_OF_AMMUNITION, MAX_PRICE_OF_AMMUNITION);

			List<Ammunition> ammunitionList = base.searchRangePriceAllAmmunition(min, max);

			for (Ammunition item: ammunitionList){
				writer.printStrLN(item.toString());
			}
			writer.printStr(CONTINUE_SEARCH);
			flag = reader.readInt(one, two);
		} while (flag == one);
	}

	/**
	 * show all knight
	 */
	private void showKnight() {

        if (EmptyKnightMap()) return;

        for (Map.Entry entry : base.getKnightMap().entrySet()) {
			writer.printStrLN(entry.getValue().toString());

		}
	}

	/**
	 * show all ammunition
	 */
	private void showAmmunition() {

        if (EmptyAmmunitionMap()) return;

		for (Map.Entry entry : base.getAmmunitionMap().entrySet()){
			writer.printStrLN(entry.getValue().toString());
		}
	}

	private boolean EmptyKnightMap(){
        if (base.getKnightMap().size() == 0) {
            writer.printStrLN(NO_KNIGHTS);
            return true;
        }
        return false;
    }

    private boolean EmptyAmmunitionMap(){
        if (base.getAmmunitionMap().size() == 0) {
            writer.printStrLN(NO_AMMUNITION);
            return true;
        }
        return false;
    }
}


//	private void checkEmpty(Class clazz){
//		switch (clazz) {
//			case Knight.class: { if (base.getKnightMap().size() == 0) {
//										writer.printStrLN(NO_KNIGHTS);
//										return;
//								   }
//			    break;}
//			case Ammunition.class: { if (base.getKnightMap().size() == 0) {
//										writer.printStrLN(NO_AMMUNITION);
//										return;
//									}
//                break;}
//			default: writer.printStrLN(NO_TYPE);
//		}
