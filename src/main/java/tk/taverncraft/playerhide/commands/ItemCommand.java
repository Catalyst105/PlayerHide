package tk.taverncraft.playerhide.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import tk.taverncraft.playerhide.Main;
import tk.taverncraft.playerhide.player.PlayerManager;
import tk.taverncraft.playerhide.utils.MessageManager;
import tk.taverncraft.playerhide.utils.ValidationManager;

/**
 * ItemCommand contains the execute method for when a user inputs the command to get the hide/show item.
 */
public class ItemCommand {

    private final String helpPerm = "phide.item";
    private ValidationManager validationManager;

    /**
     * Constructor for ItemCommand.
     */
    public ItemCommand(Main main) {
        this.validationManager = new ValidationManager(main);
    }

    /**
     * Give the hide/show item to the player.
     *
     * @param sender user who sent the command
     *
     * @return true at end of execution
     */
    public boolean execute(CommandSender sender, Main main) {
        if (!validationManager.hasPermission(helpPerm, sender)) {
            return true;
        }

        if(!validationManager.isPlayer(sender)){
            MessageManager.sendMessage(sender, "player-not-exist");
            return true;
        }

        Player player = ((Player)sender);
        new PlayerManager(main).givePlayerItem(player, false);

        return true;
    }
}

