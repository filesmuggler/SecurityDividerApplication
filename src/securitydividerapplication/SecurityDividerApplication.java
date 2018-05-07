/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package securitydividerapplication;

import java.util.Scanner;
import java.io.IOException;
import static javafx.application.Platform.exit;

/**
 *
 * @author krzst
 */
public class SecurityDividerApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        char answer='x';
        
        do{
            System.out.println("Divide(d), merge(m) or exit(e)?");
            answer = (char) System.in.read();
        }while(answer != 'd' & answer !='m' & answer!='e');
        
        if(answer == 'd'){
            Divider divider = new Divider();
            divider.chooseFile();
            try {
                divider.divideFile();
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
        else if(answer == 'm'){
            //merge
        }
        else if(answer == 'e'){
            exit();
        }
        else{
            System.out.println("error");
        }
        
        
        
        
    }
    
}
