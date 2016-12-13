package ua.lisovoy.giggle.db.metadata;

import ua.lisovoy.giggle.db.executor.ResultMessage;
import ua.lisovoy.giggle.db.query.Query;

/**
 * Created by vladimir on 13.12.16.
 */
public interface BaseObject {

    ResultMessage create(Query query);

    ResultMessage drop(Query query);

    ResultMessage alter(Query query);
}
