package com.sii.academy.data.car.finder;

import com.sii.academy.data.car.carparams.Dimensions;

import java.util.Comparator;

public class DimensionBiggerComparator implements Comparator<Dimensions> {
    @Override
    public int compare(Dimensions o1, Dimensions o2) {
        return o1.compareMoreThan(o2) ? 1 : 0;
    }
}
