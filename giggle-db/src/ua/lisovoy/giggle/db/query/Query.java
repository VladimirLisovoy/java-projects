package ua.lisovoy.giggle.db.query;

import ua.lisovoy.giggle.db.metadata.ColumnModel;
import ua.lisovoy.giggle.db.metadata.BaseObjectType;

import java.util.List;

/**
 * Created by vladimir on 12.12.16.
 */
public class Query {

    private final String query;
    private final QueryType queryType;
    private final String tableName;
    private final BaseObjectType objectType;
    private List<ColumnModel> columns;
    private List<ColumnModel> values;

    public Query(String query, QueryType queryType, BaseObjectType objectType, String tableName, List<ColumnModel> columns) {
        this.query = query;
        this.queryType = queryType;
        this.tableName = tableName;
        this.objectType = objectType;
        this.columns = columns;
    }

    public QueryType getQueryType(){
        return queryType;
    }

    public String getTableName(){
        return tableName;
    }

    public String getQuery() {
        return query;
    }

    public boolean isDDL(){
        return queryType.getLanguage().equals(DataLanguage.DDL);
    }

    public boolean isDML(){
        return queryType.getLanguage().equals(DataLanguage.DML);
    }

    public List<ColumnModel> getColumns(){
        return columns;
    }

    public BaseObjectType getObjectType() {
        return objectType;
    }
}
