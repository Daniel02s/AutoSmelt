package me.fanta.autosmelt.events;

import me.fanta.autosmelt.AutoSmelt;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class AutoPickUp implements Listener {

    AutoSmelt main;

    public AutoPickUp(AutoSmelt main){
        this.main = main;
    }


    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){
        Player p = e.getPlayer();

        if(main.getConfig().getStringList("autoworlds").contains(p.getWorld().getName())){

            if(main.getConfig().getConfigurationSection("autosmelting").contains(e.getBlock().getType().toString())){

                        String materialcotto = main.getConfig().getConfigurationSection("autosmelting").getString(e.getBlock().getType().toString());
                        Block b = e.getBlock();
                        e.setDropItems(false);
                        materialcotto.toUpperCase();
                        if(p.getInventory().firstEmpty() != -1){
                            ItemStack is = new ItemStack(Material.valueOf(materialcotto));

                            if(p.getInventory().getItemInMainHand().containsEnchantment(Enchantment.LOOT_BONUS_BLOCKS)){
                                double d = p.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) * main.getConfig().getDouble("fortunemultiplier");

                                is.setAmount((int) Math.round(d));


                            }
                            p.getInventory().addItem(is);


                        }












            } else {
                ItemStack is = new ItemStack(e.getBlock().getType());
                e.setDropItems(false);
                if(p.getInventory().getItemInMainHand().containsEnchantment(Enchantment.LOOT_BONUS_BLOCKS)){
                    double d = p.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) * main.getConfig().getDouble("fortunemultiplier");

                    is.setAmount((int) Math.round(d));


                }
                if(p.getInventory().firstEmpty() != -1){
                    p.getInventory().addItem(is);
                } else {
                    p.sendMessage("§cYour inventory is full!");
                    e.setCancelled(true);
                }







            }




        }



    }



}
