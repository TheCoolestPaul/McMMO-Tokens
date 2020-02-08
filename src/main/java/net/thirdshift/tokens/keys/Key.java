package net.thirdshift.tokens.keys;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Key {

    public String keyString;
    public boolean enabled;
    public boolean oneTime;
    public int tokens;
    public long cooldown; // in minutes
    public Map<UUID, Long> cooldowns;

    public Key(String keyString){
        this.keyString=keyString;
        this.cooldowns=new HashMap<>();
    }

    public Key(String keyString, boolean enabled, boolean oneTime, int tokens, long cooldown){
        this.keyString=keyString;
        this.enabled=enabled;
        this.oneTime=oneTime;
        this.tokens=tokens;
        this.cooldown=cooldown;
        this.cooldowns=new HashMap<>();
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setOneTime(boolean oneTime) {
        this.oneTime = oneTime;
    }

    public void setTokens(int tokens) {
        this.tokens = tokens;
    }

    public int getTokens() {
        return tokens;
    }

    public void setCooldown(long cooldown) {
        this.cooldown = cooldown;
    }

    public long getCooldown() {
        return cooldown;
    }

    public void setPlayerCooldown(Player player, long time){
        if(!this.oneTime) {
            if (time < 1) {
                cooldowns.remove(player.getUniqueId());
            } else {
                cooldowns.put(player.getUniqueId(), time);
            }
        }else{
            cooldowns.put(player.getUniqueId(), time);
        }
    }

    public long getPlayerCooldown(Player player){
        return cooldowns.getOrDefault(player.getUniqueId(), (long) 0);
    }

    @Override
    public String toString() {
        return "Key{" +
                "keyString='" + keyString + '\'' +
                ", enabled=" + enabled +
                ", oneTime=" + oneTime +
                ", tokens=" + tokens +
                ", cooldown=" + cooldown +
                '}';
    }
}
