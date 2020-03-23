package me.Neil.custom_mobs.custom_bosses;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class ZombieBoss
{
    public static void createBoss(Entity ent)
    {
        ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET, 1);
        helmet.addEnchantment(Enchantment.DURABILITY, 3);
        ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
        chestplate.addEnchantment(Enchantment.DURABILITY, 3);
        ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
        leggings.addEnchantment(Enchantment.DURABILITY, 3);
        ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS, 1);
        boots.addEnchantment(Enchantment.DURABILITY, 3);
        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD,1);
        sword.addEnchantment(Enchantment.DAMAGE_ALL, 5);


        Zombie boss = (Zombie)ent;
        boss.getEquipment().setHelmet(helmet);
        boss.getEquipment().setChestplate(chestplate);
        boss.getEquipment().setLeggings(leggings);
        boss.getEquipment().setBoots(boots);
        boss.getEquipment().setItemInMainHand(sword);
        boss.getEquipment().setHelmetDropChance(0);
        boss.getEquipment().setChestplateDropChance(0);
        boss.getEquipment().setLeggingsDropChance(0);
        boss.getEquipment().setBootsDropChance(0);
        boss.getEquipment().setItemInMainHandDropChance(0);
        boss.addScoreboardTag("boss");
        boss.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(150);
        boss.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.35);
        boss.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).setBaseValue(0.75);
        boss.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999, 17));
        boss.setHealth(150);
        boss.setCustomName(ChatColor.RED + String.format("%.1f", boss.getHealth()) + " ♥♥♥");

    }
}
