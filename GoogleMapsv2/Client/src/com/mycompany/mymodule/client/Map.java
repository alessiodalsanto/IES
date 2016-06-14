package com.mycompany.mymodule.client;

/**
 * Created by IES on 13/06/2016.
 */



import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import com.google.maps.test.SimpleSwingBrowser;
import com.inductiveautomation.vision.api.client.components.model.AbstractVisionPanel;

import javax.swing.*;

public class Map extends AbstractVisionPanel {

    public Map(){
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                SimpleSwingBrowser browser = new SimpleSwingBrowser();
                browser.setVisible(true);
                browser.loadURL("http://www.google.it");
            }
        });
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.add(new Map());

        f.setBounds(100, 100, 300, 300);
        f.setVisible(true);
    }
}
