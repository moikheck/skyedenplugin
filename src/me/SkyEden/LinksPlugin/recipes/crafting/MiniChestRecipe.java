package me.SkyEden.LinksPlugin.recipes.crafting;

import me.SkyEden.LinksPlugin.Main;
import me.SkyEden.LinksPlugin.blocks.MiniChest;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;

public class MiniChestRecipe {

    public Main plugin;
    public static ShapedRecipe minichestRecipe;

    public MiniChestRecipe (Main main) {
        this.plugin = main;
        minichestRecipe = new ShapedRecipe(new NamespacedKey(plugin,"minichest"), MiniChest.skull);
        minichestRecipe.shape("XXX", "X X", "XXX");
        minichestRecipe.setIngredient('X', Material.STICK);

        Bukkit.addRecipe(minichestRecipe);
    }
}
