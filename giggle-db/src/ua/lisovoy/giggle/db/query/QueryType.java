package ua.lisovoy.giggle.db.query;

import ua.lisovoy.giggle.db.executor.BaseExecutor;
import ua.lisovoy.giggle.db.executor.impl.CreateExecutor;
import ua.lisovoy.giggle.db.query.parser.*;
import ua.lisovoy.giggle.db.query.parser.impl.*;

/**
 * Created by vladimir on 13.12.16.
 */
public enum QueryType {

    SELECT(DataLanguage.DML, SelectParser.class, CreateExecutor.class),
    UPDATE(DataLanguage.DML, UpdateParser.class, CreateExecutor.class),
    INSERT(DataLanguage.DML, InsertParser.class, CreateExecutor.class),
    CREATE(DataLanguage.DDL, CreateParser.class, CreateExecutor.class),
    DROP(DataLanguage.DDL, DropParser.class, CreateExecutor.class),
    ALTER(DataLanguage.DDL, AlterParser.class, CreateExecutor.class);

    private final DataLanguage language;
    private Class<? extends BaseParser> parser;
    private Class<? extends BaseExecutor> executor;

    QueryType(DataLanguage language, Class<? extends BaseParser> parser, Class<? extends BaseExecutor> executor) {
        this.language = language;
        this.parser = parser;
        this.executor = executor;
    }

    public DataLanguage getLanguage() {
        return language;
    }

    public Class<? extends BaseParser> getParser() {
        return parser;
    }

    public Class<? extends BaseExecutor> getExecutor() {
        return executor;
    }
}
