package com.gussoft.signdata.utils;

import javax.swing.*;

public class SelectCertificate {

    public static void main(String[] args) {
        String[] choices = { "A", "B", "C", "D", "E", "F" };
        String input = (String) JOptionPane.showInputDialog(null, "Choose now...",
                "The Choice of a Lifetime", JOptionPane.QUESTION_MESSAGE, null, // Use
                // default
                // icon
                choices, // Array of choices
                choices[1]); // Initial choice
        System.out.println(input);
    }
}
