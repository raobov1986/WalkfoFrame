package com.raoul.walkfoframe.model;

import com.google.android.gms.maps.model.LatLng;
import com.raoul.walkfoframe.maputtiliy.clustering.ClusterItem;

public class MapHwofAllStar implements ClusterItem {
  WOFStars stars;

  public MapHwofAllStar(WOFStars star) {
    stars = star;
  }

  @Override
  public LatLng getPosition() {

    return new LatLng(Double.parseDouble(stars.getLatitude()), Double.parseDouble(stars
        .getLongitude()));
  }


}
