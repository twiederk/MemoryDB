package com.androidash.memorydb;

public class DaoUtil {

    public boolean getBoolean(final int booleanId) {
        if (booleanId == 0) {
            return false;
        }
        return true;
    }

    public int setBoolean(final boolean value) {
        if (value) {
            return 1;
        }
        return 0;
    }

    public Enum<?> getEnum(final int id, final Enum<?>[] values) {
        for (final Enum<?> enumElement : values) {
            if (enumElement.ordinal() == id) {
                return enumElement;
            }
        }
        throw new IllegalArgumentException("Can't determine " + values.getClass().getSimpleName() + " of id: " + id);
    }

}
