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
/**
 *
 * @author krzst
 */
public class Merger {
    private String path_to_input_1;
    private String path_to_input_2;
    private String path_to_output;
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
    public void chooseFiles(){
        String chosenFile;
        
        System.out.println("Copy and paste the path to the first file to be merged:");
        Scanner scan = new Scanner(System.in);
        chosenFile = scan.next();
        path_to_input_1 = settingPath(chosenFile);
        
        System.out.println("Copy and paste the path to the second file to be merged:");
        scan = new Scanner(System.in);
        chosenFile = scan.next();
        path_to_input_2 = settingPath(chosenFile);
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
    
    public void mergeFiles() throws IOException {
        //read first file
        byte[] myfile_1 = readFileBytes(path_to_input_1);
        int len_1 = myfile_1.length;
        
        //read second file
        byte[] myfile_2 = readFileBytes(path_to_input_2);
        int len_2 = myfile_2.length;
        
        if(len_1>=len_2){
            System.out.println("1");
        }
        else{
            System.out.println("2");
            
        }
        
        
    }
     //constructor
    Merger(){
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
