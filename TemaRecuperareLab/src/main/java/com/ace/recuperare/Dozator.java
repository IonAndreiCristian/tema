
package com.ace.recuperare;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import com.ace.temarecuperarelab.interfaces.*;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.Writer;

public class Dozator {
    
    private ArrayList<Reteta> retete = new ArrayList<Reteta>();
    File fisierRetete;
    IModComunicare modComunicare;
    
    public Dozator()
    {
        CreeazaFisier();
        CitesteFisier();
    }
    
    public void setModComunicare(IModComunicare modComunicare)
    {
        this.modComunicare = modComunicare;
        System.out.println("Communication mode set to: " + this.modComunicare.getModUniqueName());
    }
    
    private void CreeazaFisier()
    {
        System.out.println("Trying to create recipes file.");
        try 
        {
            fisierRetete = new File("retete.txt");
            if (fisierRetete.createNewFile()) {
              System.out.println("File created: " + fisierRetete.getName());
            } else {
              System.out.println("Recipe file already exists.");
            }
        } 
        catch (IOException e) 
        {
            System.out.println("An error occurred while creating the file.");
        }
    }
    
    private void CitesteFisier()
    {
        try 
        {
            Scanner myReader = new Scanner(fisierRetete);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Reteta newReteta = new Reteta(data);
                retete.add(newReteta);
            }
            myReader.close();
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("An error occurred while loading recipes in array.");
        }
    }
    
    public void AdaugaReteta(Reteta reteta)
    {
        try
        {
            retete.add(reteta);
            try 
            {
                PrintWriter myWriter = new PrintWriter(new FileWriter("retete.txt", true));
                myWriter.println(reteta.getReteta());
                myWriter.close();
                System.out.println("Successfully wrote recipe to the file.");
            } 
            catch (IOException e) 
            {
                System.out.println("An error occurred while adding recipe.");
            }
        }
        catch(InputMismatchException error)
        {
            System.out.println("Input Mismatch.");
        }
    }
    
    public boolean AfiseazaRetete()
    {  
        if (retete.size() > 0)
        {
            System.out.println("Index : Recipe Type");
            int i = 0;
            for (Reteta r : retete)
            {
                System.out.println(i++ + " " + r.getReteta());
            }
            return true;
        }
        else 
        {
            System.out.println("Recipt list is empty");
            return false;
        }
    }
    
    public void StergeReteta()
    {
        if (AfiseazaRetete())
        {
            try
            {
                Scanner scan = new Scanner(System.in);
                System.out.println("Insert index: ");
                int index = scan.nextInt();

                retete.remove(index);
                
                System.out.println("Recipe deleted.");
                
                OverrideFisier();
            }
            catch (InputMismatchException error)
            {
                    System.out.println("Input Mismatch.");
            }
            catch (IndexOutOfBoundsException error)
            {
                    System.out.println("Index out of bounds.");
            }
        }
    }
    
    public void ModificaReteta()
    {
        if (AfiseazaRetete())
        {
            try
            {
                Scanner scan = new Scanner(System.in);
                System.out.println("Insert index: ");
                int index = scan.nextInt();

                if (retete.get(index).CreazaReteta())
                {
                    System.out.println("Recipe modified.");
                
                    OverrideFisier();
                }
            }
            catch (InputMismatchException error)
            {
                System.out.println("Input Mismatch.");
            }
            catch (IndexOutOfBoundsException error)
            {
                System.out.println("Index out of bounds.");
            }
        }
    }
    
    public void TrimiteReteta()
    {
        Reteta r = new Reteta();
        if (AfiseazaRetete())
        {
            try
            {
                Scanner scan = new Scanner(System.in);
                System.out.println("Insert index: ");
                int index = scan.nextInt();
                
                System.out.println(retete.get(index).getReteta());
                
                r = retete.get(index);
            }
            catch (InputMismatchException error)
            {
                System.out.println("Input Mismatch.");
            }
            catch (IndexOutOfBoundsException error)
            {
                System.out.println("Index out of bounds.");
            }
        }
        try
        {
            if (modComunicare != null)
            {
                modComunicare.send(r);
            }
            else
            {
                System.out.println("No communication mode selected or available. Check configuration settings.");
            }
        }
        catch (NullPointerException error)
        {
            System.out.println("No ");
        }
    }
    
    private void OverrideFisier()
    {
        if (fisierRetete.delete()) 
        { 
            try 
            {
                fisierRetete = new File("retete.txt");
                fisierRetete.createNewFile();
            } 
            catch (IOException e) 
            {
                System.out.println("An error occurred while refactoring the file.");
            }
            try 
            {
                PrintWriter myWriter = new PrintWriter(new FileWriter("retete.txt", true));
                for (Reteta r : retete)
                {
                    myWriter.println(r.getReteta());
                }
                myWriter.close();
            } 
            catch (IOException e) 
            {
                System.out.println("An error occurred while refactoring the file.");
            }
        }
    }
}
