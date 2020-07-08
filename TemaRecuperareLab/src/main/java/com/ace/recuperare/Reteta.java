
package com.ace.recuperare;

import java.util.InputMismatchException;
import java.lang.String;
import java.util.Scanner;

public class Reteta {
    private String reteta;
    
    public Reteta()
    {
        reteta = new String();
    }
    
    public Reteta(String reteta)
    {
        this.reteta = reteta; 
    }
    
    public boolean CreazaReteta()
    {
        String backReteta = new String();
        try
        {
            backReteta = this.reteta;
            this.reteta = "";
            Scanner scan = new Scanner(System.in);
            System.out.println("Write new recipe:");
            for (int i = 1; i <= 3; i++)
            {
                System.out.println("EP" + i +":");
                this.reteta += "EP" + i + "_" + scan.nextInt() + " ";
            }
            return true;
        }
        catch (InputMismatchException error)
        {
            this.reteta = backReteta;
            System.out.println("Input Mismatch.");
            return false;
        }
    }
    
    public String getReteta()
    {
        return reteta;
    }
}
