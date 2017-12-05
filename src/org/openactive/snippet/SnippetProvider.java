package org.openactive.snippet;

import javax.swing.JComponent;

public interface SnippetProvider
{
    JComponent getConfigPanel();
    SnippetHandler getSnippetHandler();
    void save();
}
