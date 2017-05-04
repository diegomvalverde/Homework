package com.company;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import static java.awt.Frame.MAXIMIZED_BOTH;

public class Interface implements Observer
{
    private JPanel PrincipalWindow;
    private JTextField TextToFind;
    private JButton FindButton;
    private JPanel HtmlViewer;
    private JScrollBar scrollBar1;
    private String StringFromInterface;
    private int PosHtmlViewer = 0;
    private int ScreenX = 1366;
    private Dimension size = new Dimension(100,100);

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
        PrincipalFrame.setExtendedState(MAXIMIZED_BOTH);
        PrincipalFrame.setVisible(true);

    }

    @Override
    public void update(Observable observable, Object o)
    {
        if (observable instanceof CacheMemory)
        {
            addHtml((MyHtml)(o));
        }
    }

    private void addHtml(MyHtml pHtml)
    {
        Browser browser = new Browser();
        BrowserView browserView = new BrowserView(browser);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        frame.add(browserView, BorderLayout.CENTER);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        browser.loadHTML(pHtml.getHtml());
        JLabel tmp = new JLabel();
        tmp.setText("Palabra buscada: " + pHtml.getName() + "   Tiempo de espera: " + pHtml.getTiempo() + " Milisegundos" + "     Se ha creado una ventana con la busqueda");
        HtmlViewer.add(tmp);
        tmp.setSize(1366, 30);
        tmp.setLocation(0,PosHtmlViewer);
        HtmlViewer.repaint();
        PosHtmlViewer += 20;
    }

}
