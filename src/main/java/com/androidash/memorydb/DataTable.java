package com.androidash.memorydb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Represents a table of data in a memory data system, which stores object arrays as rows and tables.
 */
public class DataTable implements Iterable<DataRow> {

    private List<DataRow> table;

    /**
     * Creates an empty data table.
     */
    public DataTable() {
        table = new ArrayList<DataRow>();
    }

    /**
     * Creates an data table filled with the given data.
     * 
     * @param rawDataTable
     *            The data to fill the table with.
     */
    public DataTable(final Object[][] rawDataTable) {
        table = new ArrayList<DataRow>();
        for (final Object[] rawDataRow : rawDataTable) {
            table.add(new DataRow(rawDataRow));
        }
    }

    /**
     * Inserts the data as a data row to the table.
     * 
     * @param data
     *            The data to insert.
     */
    public void insert(final Object[] data) {
        insert(new DataRow(data));
    }

    /**
     * Inserts the data row to the table.
     * 
     * @param dataRow
     *            The data row to insert.
     */
    public void insert(final DataRow dataRow) {
        table.add(dataRow);
    }

    /**
     * Returns an iterator over all table rows.
     * 
     * @see java.lang.Iterable#iterator()
     */
    @Override
    public Iterator<DataRow> iterator() {
        return table.iterator();
    }

    /**
     * Returns the number of table rows.
     * 
     * @return The number of table rows.
     */
    public int getNumberOfRows() {
        return table.size();
    }

    /**
     * Returns new unique id of the table.
     * 
     * @return New unique id of the table.
     */
    public int getNewId() {
        int maxId = 0;
        int newId = 0;
        synchronized (table) {
            for (final DataRow dataRow : table) {
                if (maxId < dataRow.getId()) {
                    maxId = dataRow.getId();
                }
            }
            newId = maxId + 1;
        }
        return newId;
    }

    /**
     * Deletes all data rows with the given id.
     * 
     * @param id
     *            The id of the data rows.
     */
    public void delete(final int id) {
        final List<DataRow> newDataTable = new ArrayList<DataRow>();
        for (final DataRow dataRow : table) {
            if (id != dataRow.getId()) {
                newDataTable.add(dataRow);
            }
        }
        table = newDataTable;
    }

    /**
     * Deletes the all data rows with the given value at the given column id. This similar to a where clause in a SQL
     * delete statement.
     * 
     * @param columnId
     *            The id of the column to compare the value to.
     * @param value
     *            The value to match to delete the row.
     */
    public void delete(final int columnId, final Object value) {
        final List<DataRow> newDataTable = new ArrayList<DataRow>();
        for (final DataRow dataRow : table) {
            if (!dataRow.get(columnId).equals(value)) {
                newDataTable.add(dataRow);
            }
        }
        table = newDataTable;
    }

    public List<DataRow> select(final int columntId, final Object value) {
        final List<DataRow> resultSet = new ArrayList<DataRow>();
        for (final DataRow dataRow : table) {
            if (dataRow.get(columntId).equals(value)) {
                resultSet.add(dataRow);
            }
        }
        return resultSet;
    }

}
