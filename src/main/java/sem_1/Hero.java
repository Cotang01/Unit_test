package sem_1;

import java.util.List;

public class Hero {

    public Hero(String name, int armor, String weapon, List<String> inventory, boolean isHuman) {
        super();
        this.name = name;
        this.armor = armor;
        this.weapon = weapon;
        this.inventory = inventory;
        this.isHuman = isHuman;
    }

    private String name;
    private int armor;
    private String weapon;
    private List<String> inventory;
    private boolean isHuman;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public List<String> getInventory() {
        return inventory;
    }

    public void setInventory(List<String> inventory) {
        this.inventory = inventory;
    }

    public boolean isHuman() {
        return isHuman;
    }

    public void setHuman(boolean isHuman) {
        this.isHuman = isHuman;
    }

}
