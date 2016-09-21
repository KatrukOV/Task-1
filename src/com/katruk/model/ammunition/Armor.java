package com.katruk.model.ammunition;

public class Armor extends AmmunitionImpl {

	/**
	 *  armor skill
	 */
	int armorSkill;

	/**
	 * Constructor
	 * @param id		ID of Ammunition
	 */
	public Armor(int id) {
		super(id);
	}

	/**
	 * get armor skill
	 * @return armor skill
	 */
	public int getArmorSkill() {
		return armorSkill;
	}

	/**
	 * set armor skill
	 * @param armorSkill armor skill
	 */
	public void setArmorSkill(int armorSkill) {
		this.armorSkill = armorSkill;
	}

	@Override
	public String toString() {
		return String.format("%s skill %5d", super.toString(), armorSkill);
	}
}
