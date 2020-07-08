
package com.ace.menu;

import com.ace.temarecuperarelab.interfaces.IModComunicare;
import com.ace.temarecuperarelab.interfaces.IPluginsAppPlugin;
import com.ace.pluginman.*;
import com.ace.recuperare.*;
import com.ace.temarecuperarelab.interfaces.IModComunicare;
import java.util.ArrayList;

public class ApplicationMenu{
    
    private PluginManager pluginMan;
    private Dozator configurare;
    
    public ApplicationMenu(PluginManager pluginMan, Dozator configurare)
    {
        this.pluginMan = pluginMan;
        this.configurare = configurare;
    }
    
    public void load()
    {
        try 
        {
            pluginMan.loadPlugins("/plugins");
        }
        catch (NullPointerException error)
        {
            System.out.println("Null Pointer Exception - Did you forgot the plugins folder?");
            System.exit(0);
        }
        
        int shortCut = 1;
        var plugins = pluginMan.getPlugins();
     
        Menu mainMenu = new Menu("Main Menu");
        Menu configurareSubMenu = new Menu("Configuration");
        Menu comunicareSubMenu = new Menu("Communication");
        Menu amestecareSubMenu = new Menu("Mixture");
        mainMenu.AddSubMenu(1, "Configuration", configurareSubMenu);
        configurareSubMenu.AddMenuItem(1, "Add Recipe", (parameters) -> {
            ConsoleController.Clear();
            Reteta newReteta = new Reteta();
            if (newReteta.CreazaReteta())
            {
                configurare.AdaugaReteta(newReteta);
            }
	});
        configurareSubMenu.AddMenuItem(2, "Modify Recipe", (parameters) -> {
            ConsoleController.Clear();
            configurare.ModificaReteta();
	});
        configurareSubMenu.AddMenuItem(3, "Delete Recipe", (parameters) -> {
            ConsoleController.Clear();
            configurare.StergeReteta();
	});
        configurareSubMenu.AddSubMenu(4, "Communication Mode", comunicareSubMenu);
        mainMenu.AddSubMenu(2, "Mixture", amestecareSubMenu);
        amestecareSubMenu.AddMenuItem(1, "Send Recipe", (parameters) -> {
            configurare.TrimiteReteta();
        });
        mainMenu.AddMenuItem(3, "View Recipes", (parameters) -> {
            configurare.AfiseazaRetete();
        });
        
        for (int i = 0 ; i < plugins.size(); i++)
        {      
           var currentPlugin = plugins.get(i); 
           MenuItem currentItem = new MenuItem(shortCut++, plugins.get(i).getDisplayText(), (parameters)->{
               IModComunicare modComunicare = currentPlugin.getMode();
               configurare.setModComunicare(modComunicare);
           });
           
           comunicareSubMenu.AddMenuItem(currentItem);
        }
        mainMenu.InitMenu();
    }
}
