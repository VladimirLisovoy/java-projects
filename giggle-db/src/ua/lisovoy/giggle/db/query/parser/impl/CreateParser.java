package ua.lisovoy.giggle.db.query.parser.impl;

import ua.lisovoy.giggle.db.metadata.ColumnModel;
import ua.lisovoy.giggle.db.metadata.DataType;
import ua.lisovoy.giggle.db.metadata.BaseObjectType;
import ua.lisovoy.giggle.db.query.Query;
import ua.lisovoy.giggle.db.query.QueryType;
import ua.lisovoy.giggle.db.query.parser.BaseParser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by vladimir on 13.12.16.
 */
public class CreateParser extends BaseParser {

    @Override
    public Query parse(String[] splitQuery) {
        String query = splitQuery.toString();
        QueryType queryType = QueryType.valueOf(splitQuery[0]);
        BaseObjectType objectType = BaseObjectType.valueOf(splitQuery[1]);
        String tableName = splitQuery[2];

        return new Query(query, queryType, objectType, tableName, parseColumns(query));
    }

    private List<ColumnModel> parseColumns(String query) {
        String[] columnLines = null;
        String regexColumns = "(?<=\\().*?(?=\\))";
        Matcher matcherColumns = Pattern.compile(regexColumns).matcher(query);
        while (matcherColumns.find()) {
            columnLines = matcherColumns.group().split(",");
        }

        List<ColumnModel> columnList = new ArrayList<>();
        for (String columnLine : columnLines) {
            String[] splitColumnLine = columnLine.split(" ");
            DataType dataType = DataType.valueOf(splitColumnLine[0].split("[^a-zA-Z]+").toString());
            int length = Integer.parseInt(splitColumnLine[1]);
            columnList.add(new ColumnModel(splitColumnLine[0], dataType, length));
        }
        return columnList;
    }

}
