package me.Neil.custom_mobs.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class UpdateBossHealthTag implements Listener
{
    @EventHandler
    public void onBossHit(EntityDamageEvent e)
    {
        if (e.getEntity().getScoreboardTags().contains("boss"))
        {
            LivingEntity boss = (LivingEntity)e.getEntity();
            if (boss.getHealth() - e.getFinalDamage() >= 0)
            {
                boss.setCustomName(ChatColor.RED + String.format("%.1f", boss.getHealth() - e.getFinalDamage()) + " ♥♥♥");
            }

        }
    }
}
