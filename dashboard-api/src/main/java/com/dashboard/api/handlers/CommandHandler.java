package com.dashboard.api.handlers;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Leboc Philippe.
 */
public class CommandHandler implements IHandler<ICommandHandler, String>
{
    private final Map<String, ICommandHandler> _handlers;

    protected CommandHandler() {
        _handlers = new HashMap<>();

        // Static handlers register: bad idea but it will be nice for school project
    }

    @Override
    public void registerHandler(ICommandHandler handler) {
        for (String id : handler.getCommandList()) {
            _handlers.put(id, handler);
        }
    }

    @Override
    public synchronized void removeHandler(ICommandHandler handler) {
        for (String id : handler.getCommandList()) {
            _handlers.remove(id);
        }
    }

    @Override
    public ICommandHandler getHandler(final String commandKey) {
        String command = commandKey;
        if (commandKey.contains(" ")) {
            command = commandKey.substring(0, commandKey.indexOf(" "));
        }
        return _handlers.get(command);
    }

    @Override
    public int size() {
        return _handlers.size();
    }

    public static CommandHandler getInstance() {
        return SingletonHolder._instance;
    }

    private static class SingletonHolder {
        protected static final CommandHandler _instance = new CommandHandler();
    }
}