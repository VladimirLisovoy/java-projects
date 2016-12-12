package ua.lisovoy.giggle.db.server;

import ua.lisovoy.giggle.db.query.Query;
import ua.lisovoy.giggle.db.query.Validation;

import java.util.HashMap;
import java.util.List;

/**
 * Created by vladimir on 12.12.16.
 */
public class DataBaseManager {


    public List<String> getResult() {
        return null;
    }

    public void pull(Query query) {
        new Validation(query);


    }
}
