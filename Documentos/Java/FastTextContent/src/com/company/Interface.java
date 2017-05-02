package com.company;

import javax.swing.*;

public class Interface extends JFrame
{
    private JPanel PrincipalWindow;
    private JTextField TextToFind;
    private JButton FindButton;
    private JPanel HtmlViewer;
    private JScrollBar HtmlViewerScroll;

    void showPanel()
    {
        JFrame PrincipalFrame = new JFrame();
        PrincipalFrame.add(PrincipalWindow);
        PrincipalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PrincipalFrame.pack();
        PrincipalFrame.setVisible(true);
    }
}
