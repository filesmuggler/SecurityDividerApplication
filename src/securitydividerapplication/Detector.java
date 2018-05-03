/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package securitydividerapplication;

/**
 *
 * @author krzst
 */
public class Detector {
    private static String what_OS = null;
    public static String getOsName(){
        if(what_OS == null) { 
            what_OS = System.getProperty("os.name"); 
        }
        return what_OS;
    }
    public static boolean isWindows(){
        return getOsName().startsWith("Windows");
    }
    
    public static boolean isUnix(){
        return getOsName().startsWith("Linux");
    }
    
    public static boolean isMacOS(){
        return getOsName().startsWith("mac");
    }

}
