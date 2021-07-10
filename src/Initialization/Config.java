/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Initialization;

import forsakenplayer.Main;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Properties;

/**
 *
 * @author forsakenmystery
 */
public class Config {

    private static Config c = null;
    private String name = "config.xml";
    private static Properties preferences = new Properties();
    
    public Properties getPreferences() {
        return preferences;
    }
    
    private Config() {
        try {
            File configFile = new File("config.xml");

            InputStream inputStream = new FileInputStream(configFile);
            preferences.loadFromXML(inputStream);
            System.out.println("props = " + preferences);
            inputStream.close();
        } catch (FileNotFoundException ex) {
            // file does not exist
            makeFile();
        } catch (IOException ex) {
            // I/O error
        }
    }

    public static Config getConfig() {
        if (c == null) {
            c = new Config();
        }
        return c;
    }

    private void makeFile() {
        try {
            File configFile = new File("config.xml");
            OutputStream outputStream = new FileOutputStream(configFile);

            Properties props = new Properties();
            props.setProperty("AlwaysOnTop", "False");
            props.storeToXML(outputStream, "config");
            outputStream.close();
        } catch (IOException ex) {
            // I/O error
        }
    }
}
