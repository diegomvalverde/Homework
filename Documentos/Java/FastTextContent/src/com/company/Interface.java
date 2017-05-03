package com.company;

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
//        JLabel lab1 = new JLabel();
//        HtmlViewer.add(lab1);
//
//        lab1.setText(pHtml.getHtml());
//        lab1.setBackground(Color.black);
//        lab1.setBounds(new Rectangle(40,40,ScreenX,50)); // Le asignamos las dimensiones al label
//        lab1.setLocation(PosHtmlViewer,0);// le asignamos la posicion al label
//        lab1.setOpaque(true);

//        JEditorPane pane = new JEditorPane();
//        pane.setEditable(false);
//        HTMLEditorKit editorKit;
//        editorKit = new HTMLEditorKit();
//        pane.setEditorKit (editorKit) ;
//        pane.setSize(size);
//        pane.setMinimumSize(size);
//        pane.setMaximumSize(size);
//        pane.setOpaque(true);
//        System.out.println(pHtml.getHtml());
//        pane.setText(pHtml.getHtml());
//        HtmlViewer.add(pane, BorderLayout.CENTER);
//
//        HtmlViewer.repaint();

//        JFrame tmp = new JFrame();
        JEditorPane jep = new JEditorPane();
//        tmp.add(jep);
        jep.setEditable(false);

        jep.setText(pHtml.getHtml());

        JScrollPane scrollPane = new JScrollPane(jep);
        JFrame f = new JFrame("Test HTML");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(scrollPane);
        f.setPreferredSize(new Dimension(800,600));
        f.setVisible(true);
//        tmp.setExtendedState(MAXIMIZED_BOTH);
//        tmp.setVisible(true);
    }
}
