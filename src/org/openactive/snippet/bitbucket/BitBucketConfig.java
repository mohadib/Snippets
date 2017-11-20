package org.openactive.snippet.bitbucket;

import org.openactive.snippet.Configurable;
import org.openactive.snippet.swing.Bag;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class BitBucketConfig implements Configurable
{
    @Override
    public JComponent getConfigPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new TitledBorder("BitBucket"));

        Bag bag = new Bag();

        JLabel urlHint = new JLabel("Full Snippet API URL.\n i.e. https://api.bitbucket.org/2.0/snippets/myTeam");
        JLabel urlLable = new JLabel("Snippet API URL");
        JTextField urlField = new JTextField();

        panel.add(urlLable, bag);
        panel.add(urlField, bag.nextX().fillX());
        panel.add(urlHint, bag.nextY());


        JPanel spacer = new JPanel();
        spacer.setPreferredSize(new Dimension(5, 30));
        panel.add(spacer, bag.nextY().resetX().colspan(2));

        JLabel usernameLable = new JLabel("BitBucket Username");
        JTextField usernameField = new JTextField();

        JLabel passwordLable = new JLabel("BitBucket Password");
        JPasswordField passwordField = new JPasswordField();

        panel.add(usernameLable, bag.nextY().resetX().fillNone().colspan(1));
        panel.add(usernameField, bag.nextX().fillX());

        panel.add(passwordLable, bag.nextY().resetX().fillNone());
        panel.add(passwordField, bag.nextX().fillX());

        spacer = new JPanel();
        spacer.setPreferredSize(new Dimension(5, 30));
        panel.add(spacer, bag.nextY().resetX().colspan(2));

        JLabel publicLabel = new JLabel("Snippet visibility");
        JComboBox<Boolean> publicCombo = new JComboBox<>(new Boolean[]{Boolean.TRUE, Boolean.FALSE});

        panel.add(publicLabel, bag.nextY().resetX().fillNone().colspan(1));
        panel.add(publicCombo, bag.nextX().fillX());

        return panel;
    }
}
