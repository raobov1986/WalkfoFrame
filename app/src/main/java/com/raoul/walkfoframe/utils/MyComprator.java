package com.raoul.walkfoframe.utils;

import com.raoul.walkfoframe.model.HonoreesandStar;

import java.util.Comparator;

public class MyComprator implements Comparator<HonoreesandStar> {
  private String sortOrderType;
  private String keySortedBy;
  
 

  public MyComprator(String sortOrder, String SortedKey) {
    this.sortOrderType = sortOrder;
    this.keySortedBy = SortedKey;
  }

  @SuppressWarnings("deprecation")
  @Override
  public int compare(HonoreesandStar lhs, HonoreesandStar rhs) {
    int result = 0;
    String FirstValue = null;
    String SecondValue = null;
    if (keySortedBy.equals(Constant.FNAME)) {
      FirstValue = lhs.getNameFullFirst();
      SecondValue = rhs.getNameFullFirst();
    } else if (keySortedBy.equals(Constant.LNAME)) {
      FirstValue = lhs.getNameFullLast();
      SecondValue = rhs.getNameFullLast();
    }

    else if (keySortedBy.equals(Constant.EDUCATION)) {
      FirstValue = lhs.getEducation();
      SecondValue = rhs.getEducation();
    }


    if (keySortedBy.equals(Constant.EDUCATION)) {
      if (sortOrderType.equals(Constant.ASC)) {
        result = FirstValue.compareTo(SecondValue);
      } else {
        result = SecondValue.compareTo(FirstValue);
      }
    }


    else if (keySortedBy.equals(Constant.CATEGORIES)) {
      if (sortOrderType.equals(Constant.ASC)) {
        result = FirstValue.compareTo(SecondValue);
      } else {
        result = SecondValue.compareTo(FirstValue);
      }
    } else if (keySortedBy.equals(Constant.FNAME)) {
      if (sortOrderType.equals(Constant.ASC)) {
        result = FirstValue.compareTo(SecondValue);
      } else {
        result = SecondValue.compareTo(FirstValue);
      }
    } else if (keySortedBy.equals(Constant.LNAME)) {
      if (sortOrderType.equals(Constant.ASC)) {
        result = FirstValue.compareTo(SecondValue);
      } else {
        result = SecondValue.compareTo(FirstValue);
      }
    }
    return result;
  }
}
