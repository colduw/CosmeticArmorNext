package lain.mods.cos.impl.client.gui;

import lain.mods.cos.impl.ModConfigs;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.util.ARGB;

import java.util.function.BiConsumer;

public class GuiCosArmorButton extends Button implements IShiftingWidget, ICreativeInvWidget {

    private final BiConsumer<GuiCosArmorButton, Boolean> onCreativeTabChanged;

    public GuiCosArmorButton(int x, int y, int width, int height, Component message, Button.OnPress onPress, BiConsumer<GuiCosArmorButton, Boolean> onCreativeTabChanged) {
        super(x, y, width, height, message, onPress, DEFAULT_NARRATION);
        this.onCreativeTabChanged = onCreativeTabChanged;
    }

    @Override
    public void extractContents(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTicks) {
        boolean state = isHoveredOrFocused();
        if (state) {
            graphics.centeredText(Minecraft.getInstance().font, getMessage(), getX() + 4, getY() + height, ARGB.opaque(ModConfigs.CosArmorTextColor.get()));
        }

        switch (ModConfigs.CosArmorButtonStyle.get()) {
            case CUSTOM_COLOR -> {
                graphics.blit(RenderPipelines.GUI_TEXTURED, GuiCosArmorInventory.COSARMOR_BUTTON_BLANK, getX(), getY(), state ? 10 : 0, 0, 8, 7, 18, 7);

                if (state) {
                    graphics.blit(RenderPipelines.GUI_TEXTURED, GuiCosArmorInventory.COSARMOR_BUTTON_MASK, getX(), getY(), state ? 10 : 0, 0, 8, 7, 18, 7, ARGB.opaque(ModConfigs.CosArmorButtonStyle_Active.get()));
                } else {
                    graphics.blit(RenderPipelines.GUI_TEXTURED, GuiCosArmorInventory.COSARMOR_BUTTON_MASK, getX(), getY(), state ? 10 : 0, 0, 8, 7, 18, 7, ARGB.opaque(ModConfigs.CosArmorButtonStyle_Inactive.get()));
                }
            }

            case GRADIENT -> {
                if (state) {
                    graphics.fillGradient(getX() + 1, getY() + 1, getX() + 7, getY() + 6, ARGB.opaque(ModConfigs.CosArmorButtonActiveGradientStart.get()), ARGB.opaque(ModConfigs.CosArmorButtonActiveGradientEnd.get()));
                    graphics.blit(RenderPipelines.GUI_TEXTURED, GuiCosArmorInventory.COSARMOR_BUTTON_BLANK, getX(), getY(), state ? 10 : 0, 0, 8, 7, 18, 7);
                } else {
                    graphics.fillGradient(getX() + 1, getY() + 1, getX() + 7, getY() + 6, ARGB.opaque(ModConfigs.CosArmorButtonInactiveGradientStart.get()), ARGB.opaque(ModConfigs.CosArmorButtonInactiveGradientEnd.get()));
                    graphics.blit(RenderPipelines.GUI_TEXTURED, GuiCosArmorInventory.COSARMOR_BUTTON_BLANK, getX(), getY(), state ? 10 : 0, 0, 8, 7, 18, 7);
                }
            }

            default -> graphics.blit(RenderPipelines.GUI_TEXTURED, GuiCosArmorInventory.COSARMOR_BUTTON, getX(), getY(), state ? 10 : 0, 0, 8, 7, 18, 7);
        }
    }

    @Override
    public void shiftLeft(int diffLeft) {
        setX(getX() + diffLeft);
    }

    @Override
    public void onSelectedTabChanged(boolean isInventoryOpen) {
        if (onCreativeTabChanged != null)
            onCreativeTabChanged.accept(this, isInventoryOpen);
    }
}
