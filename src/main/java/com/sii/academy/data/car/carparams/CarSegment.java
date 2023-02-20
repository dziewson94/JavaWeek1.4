package com.sii.academy.data.car.carparams;

public enum CarSegment implements CarParam {
    CLASS_A("Mini"),
    CLASS_B("Small"),
    CLASS_C("Medium"),
    CLASS_D("Large"),
    CLASS_E("Executive"),
    CLASS_F("Luxury"),
    CLASS_J("Sport utility"),
    CLASS_M("Multi-purpose"),
    CLASS_S("Sport");

    private final String segment;

    /**
     * @param text
     */


    CarSegment(String segment) {
        this.segment = segment;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return segment;
    }


}
