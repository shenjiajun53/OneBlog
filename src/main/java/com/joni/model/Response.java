package com.joni.model;

/**
 * Created by shenjj on 2017/4/11.
 */
public class Response<T extends Object> {

    private T result;
    private Error error;

    public Response(T result, Error error) {
        this.result = result;
        this.error = error;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    class Error {
        String errorMsg;
        String errorId;

        public String getErrorMsg() {
            return errorMsg;
        }

        public void setErrorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
        }

        public String getErrorId() {
            return errorId;
        }

        public void setErrorId(String errorId) {
            this.errorId = errorId;
        }

        @Override
        public String toString() {
            return "Error{" +
                    "errorMsg='" + errorMsg + '\'' +
                    ", errorId='" + errorId + '\'' +
                    '}';
        }
    }
}
