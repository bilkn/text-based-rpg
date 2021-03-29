package Places_Package;


import java.util.Scanner;

public abstract class Place {

    private final Scanner scanner = new Scanner(System.in);
    private String name;
    private int npcCount;


    public Place(String name, int npcCount) {
        this.name = name;
        this.npcCount = npcCount;

    }

    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNpcCount() {
        return npcCount;
    }

    public void setNpcCount(int npcCount) {
        this.npcCount = npcCount;
    }

    public Scanner getScanner() {
        return scanner;
    }
}
