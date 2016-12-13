package ua.lisovoy.giggle.db.query.parser;

import ua.lisovoy.giggle.db.query.Query;

/**
 * Created by vladimir on 13.12.16.
 */
public abstract class BaseParser implements Parser{

    public abstract Query parse(String[] query);
}
