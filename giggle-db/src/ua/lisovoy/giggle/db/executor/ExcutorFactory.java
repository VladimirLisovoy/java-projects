package ua.lisovoy.giggle.db.executor;

import ua.lisovoy.giggle.db.query.QueryType;

/**
 * Created by vladimir on 13.12.16.
 */
public class ExcutorFactory {

    public static Executor getExecutor(QueryType queryType){
        try {
            return queryType.getExecutor().newInstance();
        } catch (InstantiationException | IllegalAccessException e){
            throw new IllegalArgumentException();
        }
    }
}
