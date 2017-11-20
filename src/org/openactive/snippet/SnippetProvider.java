package org.openactive.snippet;


public class SnippetProvider
{
    private Configurable configurable;
    private SnippetHandler handler;

    public SnippetProvider(Configurable configurable, SnippetHandler handler) {
        this.configurable = configurable;
        this.handler = handler;
    }

    public Configurable getConfigurable() {
        return configurable;
    }

    public void setConfigurable(Configurable configurable) {
        this.configurable = configurable;
    }

    public SnippetHandler getHandler() {
        return handler;
    }

    public void setHandler(SnippetHandler handler) {
        this.handler = handler;
    }
}
