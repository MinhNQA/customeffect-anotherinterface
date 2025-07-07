package com.customeffect;

import net.advancedplugins.ae.api.EffectActivationEvent;
import net.advancedplugins.ae.api.CustomEffect;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.*;

public class VoidDomain implements CustomEffect {

    @Override
    public boolean onEffectActivation(EffectActivationEvent event) {
        LivingEntity user = event.getMainEntity();
        if (!(user instanceof Player)) return false;

        Location loc = user.getLocation();
        World world = loc.getWorld();
        double r = 2.5;

        // Visual particle border
        for (double x = -r; x <= r; x += 0.5) {
            for (double y = -r; y <= r; y += 0.5) {
                for (double z = -r; z <= r; z += 0.5) {
                    if (Math.abs(x) == r || Math.abs(y) == r || Math.abs(z) == r) {
                        world.spawnParticle(Particle.DRAGON_BREATH, loc.clone().add(x, y, z), 1, 0, 0, 0, 0);
                    }
                }
            }
        }

        // Apply true damage
        for (Entity e : world.getNearbyEntities(loc, r, r, r)) {
            if (e instanceof LivingEntity && !e.equals(user)) {
                LivingEntity le = (LivingEntity) e;
                le.damage(4.0, user);
                le.setNoDamageTicks(0);
            }
        }
        return true;
    }
}
