package com.util;

import javax.swing.*;

public class BeautifyUI {
    public static void beautify() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
