package me.SkyEden.LinksPlugin.blocks;

import me.SkyEden.LinksPlugin.utils.GUIUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;
import org.bukkit.profile.PlayerTextures;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

public class MiniChest {

    public static ItemStack skull;
    public static String texture;
    public static UUID hashAsID;
    public static SkullMeta skullMetaInfo;

    public static void initialize() {
        skull = new ItemStack(Material.PLAYER_HEAD);
        texture = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDVjNmRjMmJiZjUxYzM2Y2ZjNzcxNDU4NWE2YTU2ODNlZjJiMTRkNDdkOGZmNzE0NjU0YTg5M2Y1ZGE2MjIifX19";
        hashAsID = UUID.fromString("60715385-2b8c-4909-811f-507ed8ee737f");
        skullMetaInfo = (SkullMeta) skull.getItemMeta();
        PlayerProfile profile = Bukkit.createPlayerProfile(hashAsID);
        PlayerTextures textures = profile.getTextures();
        URL url;
        try {
            url = new URL("http://textures.minecraft.net/texture/d5c6dc2bbf51c36cfc7714585a6a5683ef2b14d47d8ff714654a893f5da622");
        } catch ( MalformedURLException e ) {
            throw new RuntimeException(e);
        }
        textures.setSkin(url);
        profile.setTextures(textures);
        skullMetaInfo.setDisplayName(GUIUtils.chat("&eMinichest"));
        skullMetaInfo.setOwnerProfile(profile);
        skull.setItemMeta(skullMetaInfo);

    }
}
