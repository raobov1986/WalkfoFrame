package com.raoul.walkfoframe.model;

import com.google.android.gms.maps.model.LatLng;
import com.raoul.walkfoframe.maputtiliy.clustering.ClusterItem;

public class MapAllSpecial implements ClusterItem {
  WOFCoupons coupons;

  public MapAllSpecial(WOFCoupons coupons) {
    super();
    this.coupons = coupons;
  }

  @Override
  public LatLng getPosition() {

    return new LatLng(coupons.getVenueLatitude(), coupons.getVenueLongitude());
  }

}
