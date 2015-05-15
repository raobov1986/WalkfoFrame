package com.raoul.walkfoframe.model;

import com.google.android.gms.maps.model.LatLng;
import com.raoul.walkfoframe.maputtiliy.clustering.ClusterItem;

public class CouponsEvent implements ClusterItem {
  private WOFCoupons coupons;
  public WOFCoupons getCoupons() {
    return coupons;
  }
  public void setCoupons(WOFCoupons coupons) {
    this.coupons = coupons;
  }
  @Override
  public LatLng getPosition() {
    // TODO Auto-generated method stub
    try {
      return new LatLng(coupons.getVenueLatitude(), coupons.getVenueLongitude());
    } catch (Exception e) {
      e.printStackTrace();
      return new LatLng(51.50360, -0.14980);
    }

  }  
}
