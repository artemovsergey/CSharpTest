package model;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private String name;
    private boolean isHuge;
    private List<Aeromobile> aeromobileList;

    public Room(String name, boolean isHuge, List<Aeromobile> aeromobileList) {
        this.name = name;
        this.isHuge = isHuge;

        if (aeromobileList != null) {
            this.aeromobileList = aeromobileList;
        } else {
            this.aeromobileList = new ArrayList<>();
        }
    }

    public boolean isHuge() {
        return isHuge;
    }

    public String getName() {
        return name;
    }

    public List<Aeromobile> getAeromobileList() {
        return aeromobileList;
    }

    public void addAeromobile(Aeromobile aeromobile) {
        this.aeromobileList.add(aeromobile);
    }

    public void removeAeromobile(Aeromobile aeromobile) {
        this.aeromobileList.remove(aeromobile);
    }

}
