package mystitechadventures;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

public class MyPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // При запуску плагіну виводимо повідомлення в консоль
        getLogger().info("MyPlugin завантажено успішно!");
        
        // Реєструємо обробку подій (наприклад, коли гравець заходить на сервер)
        getServer().getPluginManager().registerEvents(this, this);

        // Запускаємо повторюване завдання:
        // Кожні 60 секунд (1200 тік при 20 тиках/сек) в консоль виводиться повідомлення про роботу плагіну
        Bukkit.getScheduler().runTaskTimer(this, () -> {
            getLogger().info("Плагін працює... Час: " + System.currentTimeMillis());
        }, 0L, 1200L);
    }

    @Override
    public void onDisable() {
        // При вимкненні плагіну виводимо повідомлення в консоль
        getLogger().info("MyPlugin вимкнено!");
    }

    // Обробка події входу гравця
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        // Надсилаємо привітальне повідомлення гравцю при вході
        player.sendMessage(ChatColor.GREEN + "Привіт, " + player.getName() + "! Ласкаво просимо на сервер!");
    }

    // Реалізація команди "greet"
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("greet")) {
            sender.sendMessage(ChatColor.AQUA + "Привіт! Це повідомлення від MyPlugin!");
            return true;
        }
        return false;
    }
}