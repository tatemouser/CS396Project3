//src/main/MainApplication.java
package main;

import main.models.MedicalTeam;
import main.models.Patient;
public class MainApplication {
    public MainApplication() {
    }
 
    public static void main(String[] var0) {
        Patient var1 = new Patient("0", "Johann", "2024-01-01");
        MedicalTeam var2 = new MedicalTeam("0", "EMT1", "EMT");
        var2.setOnCall(true);
        System.out.println(var1);
        System.out.println(var2);
        System.out.println("Making a minor change to the code.");
    }
 }
