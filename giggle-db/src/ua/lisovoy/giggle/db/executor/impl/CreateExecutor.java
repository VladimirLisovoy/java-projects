package ua.lisovoy.giggle.db.executor.impl;

import ua.lisovoy.giggle.db.executor.BaseExecutor;
import ua.lisovoy.giggle.db.executor.ResultMessage;
import ua.lisovoy.giggle.db.metadata.BaseObject;
import ua.lisovoy.giggle.db.metadata.Index;
import ua.lisovoy.giggle.db.metadata.Table;
import ua.lisovoy.giggle.db.query.Query;

/**
 * Created by vladimir on 13.12.16.
 */
public class CreateExecutor extends BaseExecutor {

    @Override
    public void execute(Query query) {
        BaseObject[] baseObjects = {new Table(), new Index()};
        for (BaseObject baseObject: baseObjects){
            ResultMessage resultMessage =  baseObject.create(query);
            if (resultMessage != null){
                break;
            }
        }
    }
}
