package ua.lisovoy.giggle.db.metadata;

/**
 * Created by vladimir on 13.12.16.
 */
public class ColumnModel {

    private final String columnName;
    private final DataType dataType;
    private final int length;

    public ColumnModel(String columnName, DataType dataType, int length) {
        this.columnName = columnName;
        this.dataType = dataType;
        this.length = length;
    }

    public DataType getDataType() {
        return dataType;
    }

    public String getColumnName() {
        return columnName;
    }

    public int getLength() {
        return length;
    }
}
