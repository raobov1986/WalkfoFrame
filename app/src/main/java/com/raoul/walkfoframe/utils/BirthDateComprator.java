package com.raoul.walkfoframe.utils;

import com.raoul.walkfoframe.model.HonoreesandStar;

import java.util.Comparator;

public class BirthDateComprator implements Comparator<HonoreesandStar> {
  /* use for date formate or parse date 
   * DateFormat df = DateFormat.getDateInstance(); Date date1, date2;
   */
  @Override
  public int compare(HonoreesandStar arg0, HonoreesandStar arg1) {
    // TODO Auto-generated method stub
    return arg0.getInductionDate().compareTo(arg1.getInductionDate());
  }

}
