package com.javarush.task.task32.task3209;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MenuHelper {
    public static JMenuItem addMenuItem(JMenu parent, String text, ActionListener actionListener) {
        JMenuItem jMenuItem = new JMenuItem(text);
        jMenuItem.addActionListener(actionListener);
        parent.add(jMenuItem);
        return jMenuItem;
    }

    public static JMenuItem addMenuItem(JMenu parent, Action action) {
        return addMenuItem(parent, null, action);
    }

    public void initHelpMenu(View view, JMenuBar menuBar) {

    }

    public void initFontMenu(View view, JMenuBar menuBar) {

    }

    public void initColorMenu(View view, JMenuBar menuBar) {

    }

    public void initAlignMenu(View view, JMenuBar menuBar) {

    }

    public void initStyleMenu(View view, JMenuBar menuBar) {

    }

    public void initEditMenu(View view, JMenuBar menuBar) {

    }

    public void initFileMenu(View view, JMenuBar menuBar) {

    }
}
