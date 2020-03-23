package me.Neil.custom_mobs.custom_classes;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class DropRate
{
    private ItemStack item;
    private int ratio;

    public DropRate(ItemStack item, int ratio)
    {
        this.item = item;
        this.ratio = ratio;
    }

    public ItemStack getItem()
    {
        return this.item;
    }

    public int getRatio() {
        return ratio;
    }

    public static DropRate[] createDropRates(ItemStack[] items, int[] ratios)
    {
        ArrayList<DropRate> list = new ArrayList<DropRate>();

        for (int i = 0; i < items.length; i++)
        {
            list.add(new DropRate(items[i], ratios[i]));
        }

        DropRate[] array = new DropRate[list.size()];

        for (int i = 0; i < list.size(); i++)
        {
            array[i] = list.get(i);
        }

        return array;
    }
}
