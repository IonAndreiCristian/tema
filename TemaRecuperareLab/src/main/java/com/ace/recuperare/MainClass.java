package com.ace.recuperare;

import com.ace.menu.*;
import com.ace.pluginman.*;

public class MainClass {
    public static void main(String[] args)
    {
        PluginManager pluginMan = new PluginManager();
        Dozator configurare = new Dozator();
        
        ApplicationMenu appMenu = new ApplicationMenu(pluginMan, configurare);
        
        appMenu.load();
    }
}
