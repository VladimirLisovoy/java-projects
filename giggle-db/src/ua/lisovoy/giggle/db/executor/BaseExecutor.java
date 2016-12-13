package ua.lisovoy.giggle.db.executor;

import ua.lisovoy.giggle.db.query.Query;

/**
 * Created by vladimir on 13.12.16.
 */
public abstract class BaseExecutor implements Executor {

    @Override
    public abstract void execute(Query query);
}
