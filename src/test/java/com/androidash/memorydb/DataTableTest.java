package com.androidash.memorydb;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DataTableTest {

    @Test
    public void testInsertDataRow() {
        final DataTable dataTable = new DataTable();
        assertEquals(0, dataTable.getNumberOfRows());
        dataTable.insert(new Object[] { 1 });
        assertEquals(1, dataTable.getNumberOfRows());
    }
}
