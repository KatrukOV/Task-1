package com.katruk.model.ammunition;

public class Shield extends AmmunitionImpl {

	/**
	 * protective skill
	 */
	int shieldSkill;

	/**
	 * Constructor
	 * @param id		ID of ammunition
	 */
	public Shield(int id) {
		super(id);
	}

	/**
	 * get shield skill
	 * @return	shield skill
	 */
	public int getShieldSkill() {
		return shieldSkill;
	}

	/**
	 * set shield skill
	 * @param shieldSkill	shield skill
	 */
	public void setShieldSkill(int shieldSkill) {
		this.shieldSkill = shieldSkill;
	}

	@Override
	public String toString() {
		return String.format("%s skill %5d", super.toString(), shieldSkill);
	}
}
