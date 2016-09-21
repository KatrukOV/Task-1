package com.katruk.model.logic;

import com.katruk.model.knight.Knight;
import com.katruk.model.knight.KnightImpl;

public class KnightFactory {
	/**
	 * this single knightFactory
	 */
	private static KnightFactory knightFactory = new KnightFactory();

	/**
	 * ID of Knight
	 */
	private int idKnight = -1;

	/**
	 * hidden constructor
	 */
	private KnightFactory() {
	}

	/**
	 * for get single KnightFactory
	 * @return	KnightFactory
	 */
	public static KnightFactory getInstance(){
		return knightFactory;
	}

	/**
	 * create different Knight;
	 * @return		one of Knight
	 */
	public Knight create() {
		return new KnightImpl(++idKnight);
	}

}
