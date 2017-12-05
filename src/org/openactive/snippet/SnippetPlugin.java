package org.openactive.snippet;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;
import org.openactive.snippet.bitbucket.BitbucketProvider;
import org.openactive.snippet.gitlab.GitlabProvider;
import org.openactive.snippet.swing.Bag;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SnippetPlugin extends AnAction implements Configurable
{
    private List<SnippetProvider> snippetProviders = new ArrayList<>();

    public SnippetPlugin()
    {
        snippetProviders.add(new GitlabProvider());
        snippetProviders.add(new BitbucketProvider());
    }


    @Override
    public void actionPerformed(AnActionEvent anActionEvent)
    {
        System.out.println("ACTION!");
        System.out.println(anActionEvent);
    }

    @Nls
    @Override
    public String getDisplayName()
    {
        return "Snippets";
    }

    @Nullable
    @Override
    public JComponent createComponent()
    {
        JPanel configPanel = new JPanel(new GridBagLayout());
        Bag bag = new Bag();
        for (SnippetProvider provider : snippetProviders)
        {
            configPanel.add(provider.getConfigPanel(), bag.fillX());
            bag.nextY();
        }
        configPanel.add(Bag.spacer(), bag.fillBoth());

        return configPanel;
    }

    @Override
    public boolean isModified()
    {
        return true;
    }

    @Override
    public void apply() throws ConfigurationException
    {
        for( SnippetProvider provider : snippetProviders )
        {
            provider.save();
        }
    }
}
