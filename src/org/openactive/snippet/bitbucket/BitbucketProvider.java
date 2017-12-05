package org.openactive.snippet.bitbucket;

import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.ui.ComboBox;
import org.openactive.snippet.SnippetHandler;
import org.openactive.snippet.SnippetProvider;
import org.openactive.snippet.swing.Bag;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class BitbucketProvider implements SnippetProvider
{

    private JTextField urlField, usernameField;
    private JPasswordField passwordField;
    private ComboBox<Boolean> publicCombo;

    private enum Properties
    {
        URL("org.openactive.snippets.bitbucket.url"),
        USERNAME("org.openactive.snippets.bitbucket.username"),
        PASSWORD("org.openactive.snippets.bitbucket.password"),
        PRIVATE("org.openactive.snippets.bitbucket.private");

        private String value;

        Properties(String value )
        {
            this.value = value;
        }

        public String getValue()
        {
            return value;
        }
    }

    private String get( Properties property)
    {
        return PropertiesComponent.getInstance().getValue(property.getValue(), "");
    }

    @Override
    public void save()
    {
        PropertiesComponent props = PropertiesComponent.getInstance();
        props.setValue(Properties.URL.getValue(), urlField.getText().trim());
        props.setValue(Properties.USERNAME.getValue(), usernameField.getText().trim());
        props.setValue(Properties.PASSWORD.getValue(), new String(passwordField.getPassword()));
        props.setValue(Properties.PRIVATE.getValue(), publicCombo.getSelectedItem() == Boolean.TRUE);
    }

    @Override
    public JComponent getConfigPanel()
    {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new TitledBorder("BitBucket"));

        Bag bag = new Bag();

        JLabel urlHint = new JLabel("Full Snippet API URL.\n i.e. https://api.bitbucket.org/2.0/snippets/myTeam");
        JLabel urlLable = new JLabel("Snippet API URL");
        urlField = new JTextField();

        panel.add(urlLable, bag);
        panel.add(urlField, bag.nextX().fillX());
        panel.add(urlHint, bag.nextY());


        JPanel spacer = new JPanel();
        spacer.setPreferredSize(new Dimension(5, 30));
        panel.add(spacer, bag.nextY().resetX().colspan(2));

        JLabel usernameLabel = new JLabel("BitBucket Username");
        usernameField = new JTextField();

        JLabel passwordLabel = new JLabel("BitBucket Password");
        passwordField = new JPasswordField();

        panel.add(usernameLabel, bag.nextY().resetX().fillNone().colspan(1));
        panel.add(usernameField, bag.nextX().fillX());

        panel.add(passwordLabel, bag.nextY().resetX().fillNone());
        panel.add(passwordField, bag.nextX().fillX());

        spacer = new JPanel();
        spacer.setPreferredSize(new Dimension(5, 30));
        panel.add(spacer, bag.nextY().resetX().colspan(2));

        JLabel publicLabel = new JLabel("Snippet visibility");
        publicCombo = new ComboBox<>(new Boolean[]{Boolean.TRUE, Boolean.FALSE});


        panel.add(publicLabel, bag.nextY().resetX().fillNone().colspan(1));
        panel.add(publicCombo, bag.nextX().fillX());

        return panel;
    }


    @Override
    public SnippetHandler getSnippetHandler()
    {
        return null;
    }
}
