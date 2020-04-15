package com.remoteseome.quotesserver.exceptions;

/**
 * @author Vasiliy Dronov
 */
public class ErrorDto {

    /**
     * Short message
     */
    private String shortMessage;

    /**
     * Full stacktrace
     */
    private String stackTrace;


    /**
     * Gets Short message.
     *
     * @return Value of Short message.
     */
    public String getShortMessage() {
        return shortMessage;
    }

    /**
     * Sets new Short message.
     *
     * @param shortMessage New value of Short message.
     */
    public void setShortMessage(String shortMessage) {
        this.shortMessage = shortMessage;
    }

    /**
     * Gets Full stacktrace.
     *
     * @return Value of Full stacktrace.
     */
    public String getStackTrace() {
        return stackTrace;
    }

    /**
     * Sets new Full stacktrace.
     *
     * @param stackTrace New value of Full stacktrace.
     */
    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }
}
