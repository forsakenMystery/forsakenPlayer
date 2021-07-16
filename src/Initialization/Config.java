/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Initialization;

import Utility.Preference;
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

    static {
        File configFile = new File("config.xml");
        if (!configFile.exists()) {
            makeFile();
        }
    }

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
            // file does not exist! can't happen
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

    private static void makeFile() {
        try {
            File configFile = new File("config.xml");
            OutputStream outputStream = new FileOutputStream(configFile);

            Properties props = new Properties();
            props.setProperty(Preference.X+"", "100");
            props.setProperty(Preference.Y+"", "100");
            props.setProperty(Preference.FullScreen+"", "false");
            props.setProperty(Preference.ForceTop+"", "false");
            props.setProperty(Preference.Width+"", "640");
            props.setProperty(Preference.Height+"", "480");
            props.storeToXML(outputStream, "config");
            outputStream.close();
        } catch (IOException ex) {
            // I/O error
        }
    }

}
