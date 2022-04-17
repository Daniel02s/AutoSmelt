package me.fanta.autosmelt.commands;

import me.fanta.autosmelt.AutoSmelt;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCommandAutoSmelt implements CommandExecutor {

    AutoSmelt main;

    public ReloadCommandAutoSmelt(AutoSmelt main){
        this.main = main;

    }




    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("auto.reload")){
                System.out.println("§7Configuration reloaded succesfully!");

                main.reloadConfig();
            }
        }


        return false;
    }
}
