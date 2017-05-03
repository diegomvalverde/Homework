package com.company;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class Interface implements Observer
{
    private JPanel PrincipalWindow;
    private JTextField TextToFind;
    private JButton FindButton;
    private JPanel HtmlViewer;
    private JScrollBar HtmlViewerScroll;
    private String StringFromInterface;

    Interface() {
        FindButton.addActionListener(actionEvent -> {
            HttpGetRequest http = new HttpGetRequest();
            StringFromInterface = TextToFind.getText();

            String [] ListaTmp = StringFromInterface.split("\\s+");

            for(int t = ListaTmp.length; t > 0; t--)
            {
                System.out.println("Request: " + ListaTmp[t-1]);
                try {
                    http.getRequest(ListaTmp[t-1]);
                    http.run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });
    }

    void showPanel()
    {
        JFrame PrincipalFrame = new JFrame();
        PrincipalFrame.add(PrincipalWindow);
        PrincipalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PrincipalFrame.pack();
        PrincipalFrame.setVisible(true);
    }

    @Override
    public void update(Observable observable, Object o)
    {
        if (observable instanceof CacheMemory)
        {

        }
    }

    private void addHtml()
    {

    }
}
