package ua.lisovoy.giggle.db.query.parser;

import ua.lisovoy.giggle.db.query.Query;

/**
 * Created by vladimir on 13.12.16.
 */
public interface Parser {

    Query parse(String[] query);
}
