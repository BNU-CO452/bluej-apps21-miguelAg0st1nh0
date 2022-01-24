import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Player
{

    public ArrayList<Item> inventory;
    public HashMap<String, Item> inventoryMap;
    private int playerHP;
    private int playerThirst;
    private int playerHunger;
    private int huntChance;
    private int huntWaterChance;
    private int playerEnergy;
    private int matingChance;
    private int totalCubs;

    public Player()
    {
        inventory = new ArrayList<>();
        inventoryMap = new HashMap<>();
        playerHP = 100;
        playerHunger = 0;
        playerThirst = 0;
        huntChance = 50;
        playerEnergy = 100;
        huntWaterChance = 40;
        matingChance = 40;
        totalCubs = 0;
    }


    public void printInventory()
    {
        if(!inventory.isEmpty())
        {
            String output = "";

            for(int i = 0; i < inventory.size(); i++)
            {
                output += inventory.get(i).getItem() + "\n";

            }
            System.out.println("You are carrying: ");
            System.out.println(output);
        }
        else
        {
            System.out.println("Your inventory is currently empty!");
        }


    }

    public Boolean hasSpearInInventory(String name)
    {
        if(inventory != null)
        {
            for(int i = 0; i < inventory.size(); i++)
            {
                if(inventory.get(i).getItem().equalsIgnoreCase(name))
                {
                    return true;
                }
            }
        }

        return false;
    }

    public Boolean hasAmuletInInventory(String name)
    {
        if(inventory != null)
        {
            for(int i = 0; i < inventory.size(); i++)
            {
                if(inventory.get(i).getItem().equalsIgnoreCase(name))
                {
                    return true;
                }
            }
        }

        return false;
    }

    public Boolean hasHerbInInventory(String name)
    {
        if(inventory != null)
        {
            for(int i = 0; i < inventory.size(); i++)
            {
                if(inventory.get(i).getItem().equalsIgnoreCase(name))
                {
                    return true;
                }
            }
        }

        return false;
    }

    public Boolean hasMapInInventory(String name)
    {
        if(inventory != null)
        {
            for(int i = 0; i < inventory.size(); i++)
            {
                if(inventory.get(i).getItem().equalsIgnoreCase(name))
                {
                    return true;
                }
            }
        }

        return false;
    }

    public Boolean hasFlaskInInventory(String name)
    {
        if(inventory != null)
        {
            for(int i = 0; i < inventory.size(); i++)
            {
                if(inventory.get(i).getItem().equalsIgnoreCase(name))
                {
                    return true;
                }
            }
        }

        return false;
    }

    public String getItemInventory(String item)
    {
        return item;
    }

    public void addItemToInventory(Item newItem)
    {
        inventory.add(newItem);

    }


    public void removeItemFromInventory(Item newItem)
    {
        inventory.remove(newItem);
    }

    public void decreasePlayerHP(int amount)
    {
        playerHP -= amount;
    }

    public void increasePlayerHP(int amount)
    {
        playerHP += amount;
    }

    public int getPlayerHP()
    {
        return playerHP;
    }

    public int setPlayerHP(int newHP)
    {
        return playerHP = newHP;
    }

    public void decreasePlayerThirst(int amount)
    {
        playerThirst -= amount;
    }

    public void increasePlayerThirst(int amount)
    {
        playerThirst += amount;
    }

    public int getPlayerThirst()
    {
        return playerThirst;
    }
    public int setPlayerThirst(int amount)
    {
        return playerThirst = amount;
    }

    public void decreasePlayerHunger(int amount)
    {
        playerHunger -= amount;
    }

    public void increasePlayerHunger(int amount)
    {
        playerHunger += amount;
    }


    public int getPlayerHunger()
    {
        return playerHunger;
    }

    public int setPlayerHunger(int amount)
    {
        return playerHunger = amount;
    }

    public int getPlayerHuntChance()
    {
        return huntChance;
    }

    public int setPlayerHuntChance(int newChance)
    {
        return huntChance = newChance;
    }

    public int getPlayerHuntWaterChance()
    {
        return huntWaterChance;
    }

    public int setPlayerHuntWaterChance(int newChance)
    {
        return huntWaterChance = newChance;
    }

    public int setPlayerEnergy(int newEnergy)
    {
        return playerEnergy = newEnergy;
    }

    public int getPlayerEnergy()
    {
        return playerEnergy;
    }

    public int getPlayerMatingChance()
    {
        return matingChance;
    }

    public int setPlayerMatingChance(int newChance)
    {
        return matingChance = newChance;
    }

    public int getTotalCubs()
    {
        return totalCubs;
    }
    public int setTotalCubs(int newCubs)
    {
        return totalCubs = newCubs;
    }




}
