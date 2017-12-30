package com.dashboard.api.handlers;

/**
 * @author Leboc Philippe.
 */
public interface ICommandHandler {

    boolean useCommand(String event, String data);

    /**
     * @return  All the command list affected to the current Handler
     */
    String[] getCommandList();
}