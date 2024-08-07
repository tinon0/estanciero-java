package ar.edu.utn.frc.tup.lciii.model;

import ar.edu.utn.frc.tup.lciii.Printer;
import ar.edu.utn.frc.tup.lciii.entities.Profile;
import ar.edu.utn.frc.tup.lciii.entities.ProfileList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

@Data
public class ProfileManager {
    private ProfileList profileList;
    private Scanner scanner;
    private Gson gson;

    public ProfileManager() {
        profileList = this.loadProfiles();
    }



    private int display(){
        Printer.println("welcome, please choose a profile to play, or create a new one");
        Printer.println("1. new profile");
        Printer.println("2. load a profile");
        scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();

        return choice;
    }

    public Profile selectProfileMenu(){

        Integer choice =  display();


        if(choice.equals(1)){
            Printer.println("please tell us the name you want to use");
            String name = scanner.nextLine();
            //scanner.close();
            Profile newProfile = new Profile(name);
            Printer.println("okay, "+ newProfile.getNombre()+", Let's play!");
            profileList.getProfiles().add(newProfile);
            this.saveProfiles();
            return newProfile;
        } else {
            Printer.println("please select the profile you want to play as:");

            Profile profileSelected = new Profile("dummy");
            for (int i = 0; i < profileList.getProfiles().size(); i++) {
                Printer.println((i+1)+". "+profileList.getProfiles().get(i).getNombre());
            }
            int selectedPerfil = scanner.nextInt()-1;
            profileSelected = profileList.getProfiles().get(selectedPerfil);

            Printer.println("okay, "+ profileSelected.getNombre()+", Let's play!");
            return profileSelected;
        }

    }

    private void saveProfiles() {
        gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("Profiles.json")) {
            gson.toJson(profileList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ProfileList loadProfiles() {
        gson = new GsonBuilder().setPrettyPrinting().create();
        ProfileList profileList1 = new ProfileList();
        try (FileReader reader = new FileReader("Profiles.json")) {
            profileList1 = gson.fromJson(reader, ProfileList.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return profileList1;
    }

    public void saveGame(HandlerPartida handlerDetails, Profile profile) {
        gson = new Gson();
        String path = "saves/" + profile.getNombre();

        File directory = new File(path);
        if (!directory.exists()) {
            if (directory.mkdirs()) {
                System.out.println("Carpeta creada: " + directory);
            }
        }

        try (FileWriter writer = new FileWriter(path + "/" + handlerDetails.getName() + ".json")) {
            gson.toJson(handlerDetails, writer);
            System.out.println("Archivo guardado en: " + path + "/" + handlerDetails.getName() + ".json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
