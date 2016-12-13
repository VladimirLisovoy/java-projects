package ua.lisovoy.giggle.db.metadata;

import ua.lisovoy.giggle.db.executor.ResultMessage;
import ua.lisovoy.giggle.db.query.Query;

import java.io.*;

/**
 * Created by vladimir on 13.12.16.
 */
public class Table implements BaseObject {

    @Override
    public ResultMessage create(Query query) {
        if (query.getObjectType() == BaseObjectType.TABLE) {
            String tablePath = "data/" + query.getTableName() + ".db";
            try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(tablePath)))) {
                for (ColumnModel column : query.getColumns()) {
                    dos.writeInt(column.getColumnName().length());
                    dos.writeChars(column.getColumnName());
                    dos.writeInt(column.getDataType().toString().length());
                    dos.writeChars(column.getDataType().toString());
                    dos.writeInt(column.getLength());
                }
                return new ResultMessage(true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    @Override
    public ResultMessage drop(Query query) {
        if (query.getObjectType() == BaseObjectType.TABLE) {
            File tablePath = new File("data/" + query.getTableName() + ".db");
            tablePath.delete();
            return new ResultMessage(true);
        }
        return null;
    }

    @Override
    public ResultMessage alter(Query query) {
        return null;
    }
}
