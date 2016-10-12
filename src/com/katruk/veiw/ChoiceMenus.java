package com.katruk.veiw;

public enum ChoiceMenus {
  DEFAULT_KNIGHTS(" 1 - use default knights"),
  DEFAULT_AMMUNITION(" 2 - use default ammunition"),
  KIGHT_ADD(" 3 - add new knight"),
  AMMUNITION_ADD(" 4 - add ammunition"),
  APPOINT_AMMUNITION_KNIGHT(" 5 - appoint ammunition knight"),
  CALC_COST_AMMUNITION(" 6 - calculate cost of ammunition on knight"),
  SORT_AMMUNITION_ON_KNIGHT(" 7 - sort ammunition on knight"),
  SEARCH_RANGE_AMMUNITION_KNIGHT(" 8 - search in price range ammunition knight"),
  SEARCH_RANGE_ALL_AMMUNITION(" 9 - search in price range in all ammunition"),
  SHOW_KNIGHT(" 10 - show all knight"),
  SHOW_AMMUNITION(" 11 - show all ammunition"),
  EXIT(" 12 - exit");

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
