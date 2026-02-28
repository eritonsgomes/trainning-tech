package tech.trainning.trainningspringvalidation.exceptions;


public class EnumJsonParserException extends RuntimeException {

    public EnumJsonParserException() {
        super();
    }

    public EnumJsonParserException(String message) {
        super(message);
    }

    public EnumJsonParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public EnumJsonParserException(Throwable cause) {
        super(cause);
    }

    protected EnumJsonParserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}