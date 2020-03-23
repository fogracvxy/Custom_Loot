package me.Neil.custom_mobs.events;

import me.Neil.custom_mobs.Custom_Mobs;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.util.Vector;

import java.util.List;

public class CustomItemEvents implements Listener
{
    @EventHandler
    public void onGroundHit(EntityDamageEvent e)
    {
        if (e.getEntity().getType() == EntityType.PLAYER && e.getCause() == EntityDamageEvent.DamageCause.FALL)
        {
            Player player = (Player) e.getEntity();

            try
            {
                if (player.isSneaking() && player.getEquipment().getBoots().getItemMeta().getPersistentDataContainer().has(new NamespacedKey(Custom_Mobs.plugin, "custom_ability"), PersistentDataType.STRING))
                {
                    if (player.getEquipment().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(Custom_Mobs.plugin, "custom_ability"), PersistentDataType.STRING).equals("ground_pound"))
                    {
                        double diameter = e.getDamage();
                        if (diameter > 10)
                        {
                            diameter = 10;
                        }

                        double radius = diameter/2;
                        double[] radiusDegrees = {0, 30, 60, 90, 120, 150, 180, 210, 240, 270, 300, 330};

                        for (double degree : radiusDegrees)
                        {
                            player.spawnParticle(Particle.SNOWBALL, new Location(player.getWorld(), player.getLocation().getX() + Math.cos(Math.toRadians(degree)) * radius, player.getLocation().getY(),player.getLocation().getZ() + Math.sin(Math.toRadians(degree)) * radius), 30);
                        }

                        List<Entity> nearEntities = player.getNearbyEntities(radius, radius, radius);

                        for (Entity ent : nearEntities)
                        {
                            if (ent instanceof LivingEntity)
                            {
                                ((LivingEntity) ent).damage(e.getDamage() * 1.3, player);
                                System.out.println(((LivingEntity) ent).getHealth());

                                //this part doesn't work too well
                                /*double dx = ent.getLocation().getX() - player.getLocation().getX();
                                double dy = ent.getLocation().getY() - player.getLocation().getY();
                                double dz = ent.getLocation().getZ() - player.getLocation().getZ();

                                if (dx <= radius && dy <= radius && dz <= radius)
                                {
                                    double vx, vy, vz;

                                    vx = gpVelFormula(dx);
                                    vy = gpVelFormula(dy);
                                    vz = gpVelFormula(dz);

                                    ent.setVelocity(new Vector(vx, vy, vz));
                                }*/
                            }
                        }

                        e.setCancelled(true);
                        player.damage(e.getDamage() * 0.90);
                        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_PLACE, (float) 0.7, (float) (Math.pow(1.04,e.getFinalDamage())-0.35));
                    }
                    else
                    {
                        System.out.println("player is not wearing gp boots");
                    }
                }
            }
            catch(NullPointerException exception)
            {
                System.out.println("Player is not wearing any boots");
            }
        }
    }

    public static double gpVelFormula(double dist)
    {
        double vel;

        vel = (0.75/(dist + 1.5)) + 0.25;
        if (vel < 0)
        {
            vel  = 0;
        }

        return vel;
    }
}
