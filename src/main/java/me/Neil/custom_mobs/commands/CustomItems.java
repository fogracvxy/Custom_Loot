package me.Neil.custom_mobs.commands;

import me.Neil.custom_mobs.custom_items.GroundPoundBoots;
import me.Neil.custom_mobs.custom_items.SpeedBoots;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class CustomItems implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player)
        {
            Player player = (Player) sender;

            Inventory inv = Bukkit.createInventory(player, 9, ChatColor.DARK_PURPLE + "Custom Items");
            inv.addItem(SpeedBoots.createItem(SpeedBoots.OLD));
            inv.addItem(SpeedBoots.createItem(SpeedBoots.WORN));
            inv.addItem(SpeedBoots.createItem(SpeedBoots.NEW));
            inv.addItem(GroundPoundBoots.createItem(GroundPoundBoots.OLD));
            inv.addItem(GroundPoundBoots.createItem(GroundPoundBoots.WORN));
            inv.addItem(GroundPoundBoots.createItem(GroundPoundBoots.NEW));

            player.openInventory(inv);
        }
        else
        {
            System.out.println("You need to be a player to run this command!");
        }

        return true;
    }
}
