package ua.lisovoy.giggle.db.executor;

import ua.lisovoy.giggle.db.query.Query;

/**
 * Created by vladimir on 13.12.16.
 */
public interface Executor {

    void execute(Query query);
}
