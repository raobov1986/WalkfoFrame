package com.raoul.walkfoframe.model;

import com.google.android.gms.maps.model.LatLng;
import com.raoul.walkfoframe.maputtiliy.clustering.ClusterItem;

public class Person implements ClusterItem {
    public final String name;
    public final int profilePhoto;
    private final LatLng mPosition;

    public Person(LatLng position, String name, int pictureResource) {
        this.name = name;
        profilePhoto = pictureResource;
        mPosition = position;
    }

    @Override
    public LatLng getPosition() {
        return mPosition;
    }
}
