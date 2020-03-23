package me.Neil.custom_mobs.custom_classes;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class DropLoot
{
    public static ItemStack generateLoot(DropRate[] loot)
    {
        ItemStack dropped_loot;

        ArrayList<ItemStack> drop_list = new ArrayList<ItemStack>() {
        };

        for (DropRate drop : loot)
        {
            for (int i = 0; i < drop.getRatio(); i++)
            {
                drop_list.add(drop.getItem());
            }
        }

        dropped_loot = drop_list.get((int)(Math.random() * drop_list.size()));

        return dropped_loot;
    }
}
