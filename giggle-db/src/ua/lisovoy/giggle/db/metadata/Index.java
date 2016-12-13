package ua.lisovoy.giggle.db.metadata;

import ua.lisovoy.giggle.db.executor.ResultMessage;
import ua.lisovoy.giggle.db.query.Query;

/**
 * Created by vladimir on 13.12.16.
 */
public class Index implements BaseObject {
    @Override
    public ResultMessage create(Query query) {
        if (query.getObjectType() == BaseObjectType.INDEX) {

        }
        return null;
    }

    @Override
    public ResultMessage drop(Query query) {
        if (query.getObjectType() == BaseObjectType.INDEX) {

        }
        return null;
    }

    @Override
    public ResultMessage alter(Query query) {
        if (query.getObjectType() == BaseObjectType.INDEX) {

        }
        return null;
    }
}
