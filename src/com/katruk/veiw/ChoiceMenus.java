package com.katruk.veiw;

public enum ChoiceMenus {
	menu1("		1 - use default knights"),
	menu2("		2 - use default ammunition"),
	menu3("		3 - add new knight"),
	menu4("		4 - add ammunition"),
	menu5("		5 - appoint ammunition knight"),
	menu6("		6 - calculate cost of ammunition on knight"),
	menu7("		7 - sort ammunition on knight"),
	menu8("		8 - search in price range ammunition knight"),
	menu9("		9 - search in price range in all ammunition"),
	menu10("		10 - show all knight"),
	menu11("		11 - show all ammunition");

	private String nameMenu;

	ChoiceMenus(String name) {
	nameMenu = name;
	}

	public String getNameMenu() {
		return nameMenu;
	}

	@Override
	public String toString() {
		return getNameMenu();
	}
}
