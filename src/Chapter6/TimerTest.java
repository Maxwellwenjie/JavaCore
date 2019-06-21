package Chapter6;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class TimerTest {
    public static void main(String[] args) {
        ActionListener listener = new TimePrinter();
        Timer t = new Timer(10000, listener);
        t.start();

        //construct a timer that calls the listener
        //once every 10 seconds
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

class TimePrinter implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        Date now = new Date();
        System.out.println("At the tone, the time is "+now);
        Toolkit.getDefaultToolkit().beep();
    }
}
