package ua.lisovoy.giggle.db.query.parser;

import ua.lisovoy.giggle.db.query.QueryType;

/**
 * Created by vladimir on 13.12.16.
 */
public class ParserFactory {

    public static Parser getParser(QueryType queryType) {
        try {
            return queryType.getParser().newInstance();
        } catch (InstantiationException | IllegalAccessException e){
            throw new IllegalArgumentException();
        }

    }
}
