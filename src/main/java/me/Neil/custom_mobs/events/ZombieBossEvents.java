package me.Neil.custom_mobs.events;

import me.Neil.custom_mobs.custom_bosses.ZombieBoss;
import me.Neil.custom_mobs.custom_classes.DropLoot;
import me.Neil.custom_mobs.custom_classes.DropRate;
import me.Neil.custom_mobs.custom_items.SpeedBoots;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class ZombieBossEvents implements Listener {

    @EventHandler
    public void onMobSpawn (CreatureSpawnEvent e)
    {

        if (e.getEntity().getType() == EntityType.ZOMBIE)
        {
            if ((int)(Math.random() * 5) == 0)
            {
//                System.out.println(e.getEntity().getLocation());
                ZombieBoss.createBoss(e.getEntity());
            }
        }
    }

    @EventHandler
    public void onBossDeath(EntityDeathEvent e)
    {

        if (e.getEntity().getScoreboardTags().contains("no_drops"))
        {
            e.getDrops().clear();
            e.setDroppedExp(0);
        }


        if (e.getEntity().getType() == EntityType.ZOMBIE && e.getEntity().getScoreboardTags().contains("boss"))
        {
            Zombie boss = (Zombie) e.getEntity();

            e.getDrops().clear();
            e.setDroppedExp(0);

            if (e.getEntity().getKiller() instanceof Player)
            {
                e.setDroppedExp(100);
                int rand = (int)(Math.random() * 100);
                String tier;

                int[] ratios = {13, 5, 2};
                DropRate[] rates = DropRate.createDropRates(SpeedBoots.getAllTiers(), ratios);
                boss.getWorld().dropItemNaturally(boss.getLocation(), DropLoot.generateLoot(rates));
            }
        }
    }
}
