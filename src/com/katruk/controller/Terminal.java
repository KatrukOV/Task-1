package com.katruk.controller;

import com.katruk.model.command.AmmunitionAdd;
import com.katruk.model.command.AppointAmmunitionKnight;
import com.katruk.model.command.CalcCostAmmunition;
import com.katruk.model.command.Call;
import com.katruk.model.command.DefaultAmmunition;
import com.katruk.model.command.DefaultKnights;
import com.katruk.model.command.Exit;
import com.katruk.model.command.KnightAdd;
import com.katruk.model.command.SearchRangeAllAmmunition;
import com.katruk.model.command.SearchRangeAmmunitionKnight;
import com.katruk.model.command.ShowAmmunition;
import com.katruk.model.command.ShowKnight;
import com.katruk.model.command.SortAmmunitionOnKnight;
import com.katruk.model.logic.Base;
import com.katruk.veiw.ChoiceMenus;
import com.katruk.veiw.Const;
import com.katruk.veiw.Message;
import com.katruk.veiw.Reader;
import com.katruk.veiw.Writer;

public class Terminal implements Const, Message {

  private Base base = new Base();
  private Reader reader = new Reader();
  private Writer writer = new Writer();

  /**
   * method for start
   */
  public void start() {

    int flag;

    int one = 1;

    do {
      writer.printStrLN(BEGIN);

      ChoiceMenus[] choices = ChoiceMenus.values();
      for (ChoiceMenus menus : choices) {
        writer.printStrLN(menus.toString());
      }
      writer.printStr(SELECT);

      // number begin from 0, therefore mast -1
      int numberChoiceMenus = reader.readInt(one, choices.length) - 1;

      //todo ChoiceMenus
      ChoiceMenus choiceMenus = null;
      for (ChoiceMenus menus : choices) {
        if (menus.ordinal() == numberChoiceMenus) {
          choiceMenus = menus;
        }
      }

      Call call;

      assert choiceMenus != null;

      switch (choiceMenus) {
        case DEFAULT_KNIGHTS: {
          call = new DefaultKnights();
          break;
        }
        case DEFAULT_AMMUNITION: {
          call = new DefaultAmmunition();
          break;
        }
        case KIGHT_ADD: {
          call = new KnightAdd();
          break;
        }
        case AMMUNITION_ADD: {
          call = new AmmunitionAdd();
          break;
        }
        case APPOINT_AMMUNITION_KNIGHT: {
          call = new AppointAmmunitionKnight();
          break;
        }
        case CALC_COST_AMMUNITION: {
          call = new CalcCostAmmunition();
          break;
        }
        case SORT_AMMUNITION_ON_KNIGHT: {
          call = new SortAmmunitionOnKnight();
          break;
        }
        case SEARCH_RANGE_AMMUNITION_KNIGHT: {
          call = new SearchRangeAmmunitionKnight();
          break;
        }
        case SEARCH_RANGE_ALL_AMMUNITION: {
          call = new SearchRangeAllAmmunition();
          break;
        }
        case SHOW_KNIGHT: {
          call = new ShowKnight();
          break;
        }
        case SHOW_AMMUNITION: {
          call = new ShowAmmunition();
          break;
        }
        case EXIT: {
          call = new Exit();
          break;
        }
        default:
          throw new IllegalArgumentException();
      }

      call.call(base);

      writer.printStr(CONTINUE);

      int two = 2;

      flag = reader.readInt(one, two);
    } while (flag == one);
  }


  private boolean EmptyKnightMap() {
    if (base.getKnightMap().size() == 0) {
      writer.printStrLN(NO_KNIGHTS);
      return true;
    }
    return false;
  }

  private boolean EmptyAmmunitionMap() {
    if (base.getAmmunitionMap().size() == 0) {
      writer.printStrLN(NO_AMMUNITION);
      return true;
    }
    return false;
  }
}