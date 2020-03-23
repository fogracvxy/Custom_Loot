package me.Neil.custom_mobs.custom_items;

import me.Neil.custom_mobs.Custom_Mobs;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.UUID;

public class SpeedBoots
{
    public static final String OLD = "Old";
    public static final String WORN = "Worn";
    public static final String NEW = "New";


    public static ItemStack createItem(String tier)
    {
        ItemStack boots;

        if (tier.equals(OLD))
        {
            boots = new ItemStack(Material.LEATHER_BOOTS,1);
            ItemMeta meta = boots.getItemMeta();
            meta.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(),"Armor", 1, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET));
            boots.setItemMeta(meta);
        }
        else if (tier.equals(WORN))
        {
            boots = new ItemStack(Material.IRON_BOOTS,1);
            ItemMeta meta = boots.getItemMeta();
            meta.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(),"Armor", 2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET));
            boots.setItemMeta(meta);
        }
        else
        {
            boots = new ItemStack(Material.DIAMOND_BOOTS,1);
            ItemMeta meta = boots.getItemMeta();
            meta.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(),"Armor", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET));
            meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(),"Armor_Toughness", 2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET));
            boots.setItemMeta(meta);
        }

        ItemMeta meta = boots.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + tier + " Sneakers");
        meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, new AttributeModifier(UUID.randomUUID(),"More Speed", 0.4, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.FEET));
        meta.getPersistentDataContainer().set(new NamespacedKey(Custom_Mobs.plugin, "custom_ability"), PersistentDataType.STRING, "speed");
        boots.setItemMeta(meta);

        return boots;
    }

    public static ItemStack[] getAllTiers()
    {
        ItemStack[] list =
                {
                        createItem(OLD),
                        createItem(WORN),
                        createItem(NEW)
                };

        return list;
    }
}
