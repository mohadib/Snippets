package org.openactive.snippet.gitlab;

import org.openactive.snippet.Configurable;
import org.openactive.snippet.swing.Bag;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class GitlabConfig implements Configurable {

    @Override
    public JComponent getConfigPanel() {
        JLabel urlHint = new JLabel("This url should point at the root of your Gitlab install.\n i.e. https://gitlab.company.com");
        JLabel urlLable = new JLabel("Gitlab Install URL");
        JTextField urlField = new JTextField();

        JLabel tokenLable = new JLabel("Token");
        JTextField tokenField = new JTextField();

        JPanel panel = new JPanel(new GridBagLayout());
        Bag bag = new Bag();

        panel.setBorder(new TitledBorder("Gitlab"));

        panel.add(urlLable, bag);
        panel.add(urlField, bag.nextX().fillX());
        panel.add(urlHint, bag.nextY().fillNone());

        JPanel spacer = new JPanel();
        spacer.setPreferredSize(new Dimension(5, 30));
        panel.add(spacer, bag.nextY().resetX());

        panel.add(tokenLable, bag.nextY().resetX().fillNone().colspan(1));
        panel.add(tokenField, bag.nextX().fillX());

        JLabel tokenHint = new JLabel("To create a new token https://gitlab.company.com/profile/personal_access_tokens");
        panel.add(tokenHint, bag.nextY().fillNone());

        panel.add(Bag.spacer(), bag.nextY().resetX().colspan(2).fillBoth());

        return panel;
    }
}

