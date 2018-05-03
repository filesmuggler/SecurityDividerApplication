/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package securitydividerapplication;

import java.util.Scanner;

/**
 *
 * @author krzst
 */
public class Divider {
    private String path_to_input;
    private String path_to_output_1;
    private String path_to_output_2;
    private String what_OS;
    
    public void chooseFile(){
        String chosenFile;
        
        System.out.println("Copy and paste the path to the file to be divided:");
        Scanner scan = new Scanner(System.in);
        chosenFile = scan.next();
        if(what_OS == "windows"){
            path_to_input = "";
            for(int i = 0; i<chosenFile.length();i++){
                path_to_input = path_to_input + chosenFile.charAt(i);
                if(chosenFile.charAt(i)=='\\'){
                    path_to_input = path_to_input + '\\';
                }
            }
        }
        else if(what_OS == "linux"){
            System.out.println("Linux not supported yet.");
        }
        else if(what_OS == "mac"){
            System.out.println("Mac not supported yet.");
        }
    }
    
    
}
