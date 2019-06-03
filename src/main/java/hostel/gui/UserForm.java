package main.java.hostel.gui;

import javax.swing.*;
import java.awt.event.*;

public class UserForm extends JDialog {
    private JPanel contentPanel;
    private JButton cancelButton;
    private JButton okButton;

    public UserForm() {
        setContentPane(contentPanel);
        setModal(true);
        getRootPane().setDefaultButton(okButton);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        contentPanel.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    public static void main(String[] args) {
        UserForm dialog = new UserForm();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void onOK() {
        System.out.println("on OK button was pressed");
        this.setVisible(false);
//        dispose();
    }

    private void onCancel() {
        System.out.println("on Cancel button was pressed");

        dispose();
    }
}
