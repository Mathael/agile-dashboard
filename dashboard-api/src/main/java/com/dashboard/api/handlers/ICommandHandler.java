package com.dashboard.api.handlers;

import com.google.gson.JsonElement;

/**
 * @author Leboc Philippe.
 */
public interface ICommandHandler {

    boolean useCommand(String event, JsonElement data);

    /**
     * @return  All the command list affected to the current Handler
     */
    String[] getCommandList();
}