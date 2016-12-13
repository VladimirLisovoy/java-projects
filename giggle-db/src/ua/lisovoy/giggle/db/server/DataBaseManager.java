package ua.lisovoy.giggle.db.server;

import ua.lisovoy.giggle.db.executor.ExcutorFactory;
import ua.lisovoy.giggle.db.executor.Executor;
import ua.lisovoy.giggle.db.query.Query;
import ua.lisovoy.giggle.db.query.QueryType;
import ua.lisovoy.giggle.db.query.parser.Parser;
import ua.lisovoy.giggle.db.query.parser.ParserFactory;

import java.util.List;

/**
 * Created by vladimir on 12.12.16.
 */
public class DataBaseManager {

    private Query query;

    public void pull(String queryContent) {
        String[] splitQuery = queryContent.split(" ");
        QueryType queryType = QueryType.valueOf(splitQuery[0]);
        Parser parser = ParserFactory.getParser(queryType);
        query = parser.parse(splitQuery);
    }

    public List<String> push() {
        Executor executor = ExcutorFactory.getExecutor();
        executor.execute(query);
        return null;
    }

}
