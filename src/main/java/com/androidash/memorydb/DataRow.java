package com.androidash.memorydb;

/**
 * Represents a row of data in a memory data system, which stores object arrays as rows and tables. The datarow expects
 * a unique id in the first element of the object array.
 */
public class DataRow {

    private final Object[] row;

    /**
     * Creates data row of the given object array.
     * 
     * @param row
     *            The object array to create the data row of.
     */
    public DataRow(final Object[] row) {
        this.row = row;
    }

    /**
     * Returns the id of the data row, which is stored in the first element of the object array.
     * 
     * @return The id of the data row.
     */
    public int getId() {
        return (Integer) row[0];
    }

    /**
     * Returns the data of the given index.
     * 
     * @param index
     *            The index of the element to get the data of.
     * @return The data stored at the given index.
     */
    public Object get(final int index) {
        return row[index];
    }

    public int getInt(final int index) {
        return (Integer) row[index];
    }

    public String getString(final int index) {
        return (String) row[index];
    }

    public void set(final int index, final Object value) {
        row[index] = value;
    }

}
