package org.openactive.snippet.gitlab;

import com.intellij.ide.util.PropertiesComponent;
import org.openactive.snippet.SnippetHandler;
import org.openactive.snippet.SnippetProvider;
import org.openactive.snippet.swing.Bag;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class GitlabProvider implements SnippetProvider
{
    private JTextField urlField, tokenField;


    private String getToken()
    {
        PropertiesComponent props = PropertiesComponent.getInstance();
        String token = props.getValue( "org.openactive.gitlab.snippets.token" );
        if ( token == null ) token = "";
        return token;
    }

    private String getUrl()
    {
        PropertiesComponent props = PropertiesComponent.getInstance();
        String url = props.getValue( "org.openactive.gitlab.snippets.url" );
        if ( url == null ) url = "";
        return url;
    }

    @Override
    public JComponent getConfigPanel()
    {
        JPanel panel = new JPanel( new GridBagLayout() );
        panel.setBorder(new TitledBorder("GitLab"));
        Bag bag = new Bag();

        JLabel urlHint = new JLabel("This url should point at the root of your Gitlab install.\n i.e. https://gitlab.company.com" );
        JLabel urlLable = new JLabel( "Gitlab Install URL" );
        urlField = new JTextField( getUrl() );

        JLabel tokenLable = new JLabel( "Token" );
        tokenField = new JTextField( getToken() );

        panel.add( urlLable, bag );
        panel.add( urlField, bag.nextX().fillX() );
        panel.add( urlHint, bag.nextY().fillNone());

        JPanel spacer = new JPanel();
        spacer.setPreferredSize( new Dimension( 5, 30 ) );
        panel.add( spacer, bag.nextY().resetX() );

        panel.add( tokenLable, bag.nextY().resetX().fillNone().colspan( 1 ) );
        panel.add( tokenField, bag.nextX().fillX() );

        JLabel tokenHint = new JLabel( "To create a new token https://gitlab.company.com/profile/personal_access_tokens" );
        panel.add( tokenHint, bag.nextY().fillNone() );
        return panel;
    }

    @Override
    public SnippetHandler getSnippetHandler()
    {
        return null;
    }

    @Override
    public void save()
    {

    }
}
