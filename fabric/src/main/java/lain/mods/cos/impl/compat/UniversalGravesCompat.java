package lain.mods.cos.impl.compat;

import eu.pb4.graves.GravesApi;
import eu.pb4.graves.grave.GraveInventoryMask;
import lain.mods.cos.impl.ModObjects;
import lain.mods.cos.impl.inventory.InventoryCosArmor;
import lain.mods.cos.init.ModConstants;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public record UniversalGravesCompat() implements GraveInventoryMask {
    public static final GraveInventoryMask INSTANCE = new UniversalGravesCompat();

    public static void register() {
        GravesApi.registerInventoryMask(Identifier.fromNamespaceAndPath("universal_graves", ModConstants.MODID), INSTANCE);
    }

    @Override
    public void addToGrave(ServerPlayer serverPlayer, ItemConsumer itemConsumer) {
        InventoryCosArmor inventoryCosArmor = ModObjects.invMan.getCosArmorInventory(serverPlayer.getUUID());

        for (int i = 0; i < inventoryCosArmor.getContainerSize(); i++) {
            ItemStack itemStack = inventoryCosArmor.getItem(i);
            if (GravesApi.canAddItem(serverPlayer, itemStack)) {
                itemConsumer.addItem(itemStack.copyAndClear(), i);
                inventoryCosArmor.setItem(i, ItemStack.EMPTY);
            }
        }
    }

    @Override
    public boolean moveToPlayerExactly(ServerPlayer serverPlayer, ItemStack itemStack, int i, @Nullable Tag tag) {
        InventoryCosArmor inventoryCosArmor = ModObjects.invMan.getCosArmorInventory(serverPlayer.getUUID());
        if (inventoryCosArmor.getItem(i).isEmpty()) {
            inventoryCosArmor.setItem(i, itemStack.copyAndClear());
            return true;
        }

        return false;
    }

    @Override
    public boolean moveToPlayerClosest(ServerPlayer serverPlayer, ItemStack itemStack, int i, @Nullable Tag tag) {
        Inventory inventory = serverPlayer.getInventory();
        for (int j = 0; j < inventory.getContainerSize(); j++) {
            if (inventory.getItem(j).isEmpty()) {
                inventory.setItem(j, itemStack.copyAndClear());
                return true;
            }
        }

        return false;
    }
}
