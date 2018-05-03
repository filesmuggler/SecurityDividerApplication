/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package securitydividerapplication;

import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author krzst
 */
public class Divider {
    private String path_to_input;
    private String path_to_output_1;
    private String path_to_output_2;
    private String what_OS;
    
    //universal path setter 
    private String settingPath(String chosenFile){
        String path_out="";
        if(what_OS == "windows"){
            for(int i = 0; i<chosenFile.length();i++){
                path_out = path_out + chosenFile.charAt(i);
                if(chosenFile.charAt(i)=='\\'){
                    path_out = path_out + '\\';
                }
            }
        }
        else if(what_OS == "linux"){
            System.out.println("Linux not supported yet.");
        }
        else if(what_OS == "mac"){
            System.out.println("Mac not supported yet.");
        }
        return path_out;
    }
    
    //chooses file to be divided
    public void chooseFile(){
        String chosenFile;
        System.out.println("Copy and paste the path to the file to be divided:");
        Scanner scan = new Scanner(System.in);
        chosenFile = scan.next();
        path_to_input = settingPath(chosenFile);
    }
    
    //reads file byte-by-byte
    private byte[] readFileBytes(String pathToFile) throws IOException{
        Path path = Paths.get(pathToFile);
        return Files.readAllBytes(path);
    }
    
    //writes new file byte-by-byte
    private void writeFileBytes(byte[] contents, String pathToOutputFile) throws IOException{
        Path path = Paths.get(pathToOutputFile);
        Files.write(path, contents);
    }
    
    //divides given file into 2 separate parts 
    public void divideFile() throws IOException{
        byte[] myfile = readFileBytes(path_to_input);
        int len = myfile.length;
        byte[] output_1 = new byte[len/2+1];
        byte[] output_2 = new byte[len/2];
        int counter_1 = 0;
        int counter_2 = 0;
        for(int i=0;i<myfile.length;i++){
            //System.out.println(myfile[i]);
            if(i%2==0){
                output_1[counter_1]=myfile[i];
                counter_1++;
            }
            else{
                output_2[counter_2]=myfile[i]; 
                counter_2++;
            }
        }
        String chosenFile;
        System.out.println("Copy and paste the path for the first part of the file:");
        Scanner scan = new Scanner(System.in);
        chosenFile = scan.next();
        String path_1 = settingPath(chosenFile);
        
        System.out.println("Copy and paste the path for the second part of the file:");
        scan = new Scanner(System.in);
        chosenFile = scan.next();
        String path_2 = settingPath(chosenFile);
        
        writeFileBytes(output_1,path_1);
        writeFileBytes(output_2,path_2);
        
    }
    
    //constructor
    Divider(){
        Detector detector = new Detector();
        if(detector.isWindows()){
            System.out.println("MS Windows system detected");
            what_OS = "windows";
        }
        else if(detector.isUnix()){
            System.out.println("Linux system detected");
            what_OS = "linux";
        }
        else if(detector.isMacOS()){
            System.out.println("MacOS system detected");
            what_OS = "mac";
        }
        else{
            System.out.println("Detection error");
        }
    }
    
}
