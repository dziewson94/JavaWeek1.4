package com.sii.academy.data.car.carparams;

import java.util.Objects;

public class Dimensions implements CarParam {
    private int height;
    private int width;
    private int length;
    private int trunkCapacity;

    public Dimensions(int height, int width, int length, int trunkCapacity) {
        this.height = height;
        this.width = width;
        this.length = length;
        this.trunkCapacity = trunkCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dimensions that = (Dimensions) o;
        return height == that.height && width == that.width && length == that.length && trunkCapacity == that.trunkCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, width, length, trunkCapacity);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getTrunkCapacity() {
        return trunkCapacity;
    }

    public void setTrunkCapacity(int trunkCapacity) {
        this.trunkCapacity = trunkCapacity;
    }

    @Override
    public String toString() {
        return "Dimensions{" +
                "height=" + height +
                ", width=" + width +
                ", length=" + length +
                ", trunkCapacity=" + trunkCapacity +
                '}';
    }

    public boolean compareEqual(Dimensions dimensions) {
        boolean result = true;
        if (dimensions.height != 0) {
            result = result && height == dimensions.height;
        }
        if (dimensions.length != 0) {
            result = result && length == dimensions.length;
        }
        if (dimensions.width != 0) {
            result = result && width == dimensions.width;
        }
        if (dimensions.trunkCapacity != 0) {
            result = result && trunkCapacity == dimensions.trunkCapacity;
        }
        return result;
    }

    public boolean compareMoreThan(Dimensions dimensions) {
        boolean result = true;
        if (dimensions.height != 0) {
            result = result && height > dimensions.height;
        }
        if (dimensions.length != 0) {
            result = result && length > dimensions.length;
        }
        if (dimensions.width != 0) {
            result = result && width > dimensions.width;
        }
        if (dimensions.trunkCapacity != 0) {
            result = result && trunkCapacity > dimensions.trunkCapacity;
        }
        return result;
    }

    public boolean compareLessThan(Dimensions dimensions) {
        boolean result = true;
        if (dimensions.height != 0) {
            result = result && height < dimensions.height;
        }
        if (dimensions.length != 0) {
            result = result && length < dimensions.length;
        }
        if (dimensions.width != 0) {
            result = result && width < dimensions.width;
        }
        if (dimensions.trunkCapacity != 0) {
            result = result && trunkCapacity < dimensions.trunkCapacity;
        }
        return result;
    }


}
