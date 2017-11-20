package org.openactive.snippet;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;
import org.openactive.snippet.bitbucket.BitBucketConfig;
import org.openactive.snippet.gitlab.GitlabConfig;

import javax.swing.*;
import java.util.List;

public class SnippetPlugin extends AnAction implements Configurable
{
    private List<SnippetProvider> snippetProviders;

    public SnippetPlugin()
    {
        snippetProviders.add( new SnippetProvider(new GitlabConfig(), new SnippetHandler() {
            @Override
            public void create() {

            }
        }));


        snippetProviders.add( new SnippetProvider(new BitBucketConfig(), new SnippetHandler() {
            @Override
            public void create() {

            }
        }));
    }


    @Override
    public void actionPerformed(AnActionEvent anActionEvent)
    {

    }

    @Nls
    @Override
    public String getDisplayName()
    {
        return "Snippets";
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        return null;
    }

    @Override
    public boolean isModified() {
        return false;
    }

    @Override
    public void apply() throws ConfigurationException {

    }
}
