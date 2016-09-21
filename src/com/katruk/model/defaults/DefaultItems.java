package com.katruk.model.defaults;

import com.katruk.model.ammunition.Ammunition;
import com.katruk.model.ammunition.Armor;
import com.katruk.model.ammunition.Shield;
import com.katruk.model.ammunition.TypeAmmunition;
import com.katruk.model.knight.Knight;
import com.katruk.model.logic.AmmunitionFactory;
import com.katruk.model.logic.KnightFactory;

import java.util.HashMap;
import java.util.Map;

public class DefaultItems {

    /**
     * Create default ammunition
     *
     * @return map of default ammunition
     */
    public Map<Integer, Ammunition> addDefaultAmmunition() {
        Map<Integer, Ammunition> ammunitionMap = new HashMap<Integer, Ammunition>();
        Ammunition ammunition;
        ammunition = AmmunitionFactory.getInstance().create(TypeAmmunition.Armor);
        ammunition.setName("a1");
        ammunition.setWeight(10);
        ammunition.setPrice(255);
        ((Armor) ammunition).setArmorSkill(57);
        ammunitionMap.put(ammunition.getId(), ammunition);

        ammunition = AmmunitionFactory.getInstance().create(TypeAmmunition.Armor);
        ammunition.setName("a2");
        ammunition.setWeight(15);
        ammunition.setPrice(270);
        ((Armor) ammunition).setArmorSkill(82);
        ammunitionMap.put(ammunition.getId(), ammunition);

        ammunition = AmmunitionFactory.getInstance().create(TypeAmmunition.Shield);
        ammunition.setName("s1");
        ammunition.setWeight(50);
        ammunition.setPrice(400);
        ((Shield) ammunition).setShieldSkill(150);
        ammunitionMap.put(ammunition.getId(), ammunition);

        ammunition = AmmunitionFactory.getInstance().create(TypeAmmunition.Shield);
        ammunition.setName("s2");
        ammunition.setWeight(60);
        ammunition.setPrice(700);
        ((Shield) ammunition).setShieldSkill(185);
        ammunitionMap.put(ammunition.getId(), ammunition);

        ammunition = AmmunitionFactory.getInstance().create(TypeAmmunition.Shield);
        ammunition.setName("s3");
        ammunition.setWeight(40);
        ammunition.setPrice(500);
        ((Shield) ammunition).setShieldSkill(128);
        ammunitionMap.put(ammunition.getId(), ammunition);
        return ammunitionMap;
    }

    /**
     * Create default knight
     *
     * @return map of default knight
     */
    public Map<Integer, Knight> addDefaultKnight() {
        Map<Integer, Knight> knightMapMap = new HashMap<Integer, Knight>();
        Knight knight = KnightFactory.getInstance().create();
        knight.setName("Vova");
        knightMapMap.put(knight.getId(), knight);
        knight = KnightFactory.getInstance().create();
        knight.setName("Ivan");
        knightMapMap.put(knight.getId(), knight);
        knight = KnightFactory.getInstance().create();
        knight.setName("Artur");
        knightMapMap.put(knight.getId(), knight);
        knight = KnightFactory.getInstance().create();
        knight.setName("Senya");
        knightMapMap.put(knight.getId(), knight);
        knight = KnightFactory.getInstance().create();
        knight.setName("Jeka");
        knightMapMap.put(knight.getId(), knight);
        return knightMapMap;
    }

}
