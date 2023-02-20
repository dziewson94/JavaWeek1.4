package com.sii.academy.data.car.carparams;


public enum GearType implements CarParam {


    MANUAL("Manual"),
    FULL_AUTOMATIC("Auto"),
    SEMI_AUTOMATIC("Semi-Auto");

    private final String type;

    /**
     * @param text
     */


    GearType(String type) {
        this.type = type;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return type;
    }


}



