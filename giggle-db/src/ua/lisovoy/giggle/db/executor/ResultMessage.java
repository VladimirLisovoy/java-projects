package ua.lisovoy.giggle.db.executor;

import com.sun.istack.internal.Nullable;

/**
 * Created by vladimir on 13.12.16.
 */
public class ResultMessage {

    private final int errorCode;
    private final String errorMessage;
    private final boolean isSuccessful;

    public ResultMessage(int errorCode, String errorMessage, boolean isSuccessful) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.isSuccessful = isSuccessful;
    }

    public ResultMessage(boolean isSuccessful) {
        this.errorCode = 0;
        this.errorMessage = null;
        this.isSuccessful = isSuccessful;
    }

    public int getErrorCode() {
        return errorCode;
    }

    @Nullable
    public String getErrorMessage() {
        return errorMessage;
    }

    public boolean isSuccessful() {
        return isSuccessful;
    }
}
