package com.kodilla.rps;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;


public class HallOfFame {

    private void save(List<Player> listHallOfFame) {
        String currentCatalog = System.getProperty("user.dir");
        Path fileName = Paths.get(currentCatalog, "halof.txt");
        try(BufferedWriter bw =
                    Files.newBufferedWriter(fileName, StandardOpenOption.CREATE)){
            for( Player player : listHallOfFame) {
                bw.write(player.getName() + " ");
                bw.write(player.getNumberOfPoints() + "\n");
            }
            bw.close();
        }catch(IOException ex) {
            System.out.println("Error:" + ex);
        }
    }

    private  List<Player> load(){
        List<Player>  listHallOfFame = new ArrayList<>();
        String currentCatalog = System.getProperty("user.dir");
        Path fileName = Paths.get(currentCatalog, "halof.txt");

        try(BufferedReader br =
                    Files.newBufferedReader(fileName)){
            String line;
            while( (line = br.readLine()) != null) {
                String [] split = line.split(" ");
                if(split.length == 2) {
                    Player player = new Player( split[0],Integer.parseInt(split[1]));
                    listHallOfFame.add(player);
                }
            }
            br.close();
        }catch(IOException ex) {
            System.out.println("Error:" + ex);
        }

        return listHallOfFame;
    }

    public void reloadHallOfFame(Player player){
        if( isFileExists() ) { // to do
            if(!switchPlayer(player)) {
                List<Player> listHallOfFame = load();
                if (listHallOfFame.size() < 10) {
                    listHallOfFame.add(player);
                } else {
                    listHallOfFame.add(player);
                    Player playerMinScore = listHallOfFame.stream().min((Player p1, Player p2) -> p1.getNumberOfPoints() - p2.getNumberOfPoints()).get();
                    listHallOfFame.remove(playerMinScore);
                }
                listHallOfFame.sort((Player p1, Player p2) -> p2.getNumberOfPoints() - p1.getNumberOfPoints());
                save(listHallOfFame);
            }
        }
        else{
            List<Player>  listHallOfFame = new ArrayList<>();
            listHallOfFame.add(player);
            save(listHallOfFame);
        }

    }

    private boolean switchPlayer(Player newPlayer){
            List<Player> listHallOfFame = load();
            for(int i = 0; i < listHallOfFame.size();i++){
                boolean isNewPlayerAlreadyExists = listHallOfFame.get(i).getName().equals(newPlayer.getName());
                if(isNewPlayerAlreadyExists){
                    Player oldPlayer = listHallOfFame.get(i);
                    if(oldPlayer.getNumberOfPoints() < newPlayer.getNumberOfPoints()){
                        listHallOfFame.remove(oldPlayer);
                        listHallOfFame.add(newPlayer);
                        listHallOfFame.sort( (Player p1, Player p2) -> p2.getNumberOfPoints()-p1.getNumberOfPoints() );
                        save(listHallOfFame);
                    }
                    return true;

                }
            }
            return false;
    }

    public void show(){
        System.out.println("***Hall of Fame***");
        List<Player> listHallOfFame = load();
            for (int i = 0; i < listHallOfFame.size(); i++) {
                System.out.println(i + 1 + ". " + listHallOfFame.get(i).toString());
            }
            System.out.println();
        }

    private boolean isFileExists() {
        String currentCatalog = System.getProperty("user.dir");
        Path fileName = Paths.get(currentCatalog, "halof.txt");
        File file = new File(fileName.toString());
        return  file.exists();
    }
}
