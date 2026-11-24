package lain.mods.cos.impl.client.gui;
import lain.mods.cos.impl.ModConfigs;
import lain.mods.cos.impl.client.ToggleStyles;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.util.ARGB;

public class GuiCosArmorToggleButton extends Button implements IShiftingWidget {

    public int state;

    public GuiCosArmorToggleButton(int x, int y, int width, int height, Component message, int initialState, Button.OnPress onPress) {
        super(x, y, width, height, message, onPress, DEFAULT_NARRATION);
        state = initialState;
    }

    @Override
    public void extractContents(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTicks) {
        switch (ModConfigs.CosArmorToggleStyle.get()) {
            case CUSTOM_COLOR -> {
                graphics.blit(RenderPipelines.GUI_TEXTURED, GuiCosArmorInventory.COSARMOR_TOGGLE_BUTTON_BLANK, getX(), getY(), 5 * state, 0, 5, 5, 10, 5);

                if (state == 0) {
                    graphics.blit(RenderPipelines.GUI_TEXTURED, GuiCosArmorInventory.COSARMOR_TOGGLE_BUTTON_MASK, getX(), getY(), 5 * state, 0, 5, 5, 10, 5, ARGB.opaque(ModConfigs.CosArmorToggleStyle_Inactive.get()));
                } else {
                    graphics.blit(RenderPipelines.GUI_TEXTURED, GuiCosArmorInventory.COSARMOR_TOGGLE_BUTTON_MASK, getX(), getY(), 5 * state, 0, 5, 5, 10, 5, ARGB.opaque(ModConfigs.CosArmorToggleStyle_Active.get()));
                }
            }

            case GRADIENT -> {
                if (state == 0) {
                    graphics.fillGradient(getX() + 1, getY() + 1, getX() + 4, getY() + 4, ARGB.opaque(ModConfigs.CosArmorToggleInactiveGradientStart.get()), ARGB.opaque(ModConfigs.CosArmorToggleInactiveGradientEnd.get()));
                    graphics.blit(RenderPipelines.GUI_TEXTURED, GuiCosArmorInventory.COSARMOR_TOGGLE_BUTTON_BLANK, getX(), getY(), 5 * state, 0, 5, 5, 10, 5);
                } else {
                    graphics.fillGradient(getX() + 1, getY() + 1, getX() + 4, getY() + 4, ARGB.opaque(ModConfigs.CosArmorToggleActiveGradientStart.get()), ARGB.opaque(ModConfigs.CosArmorToggleActiveGradientEnd.get()));
                    graphics.blit(RenderPipelines.GUI_TEXTURED, GuiCosArmorInventory.COSARMOR_TOGGLE_BUTTON_BLANK, getX(), getY(), 5 * state, 0, 5, 5, 10, 5);
                }
            }

            default -> graphics.blit(RenderPipelines.GUI_TEXTURED, GuiCosArmorInventory.COSARMOR_TOGGLE_BUTTON, getX(), getY(), 5 * state, 0, 5, 5, 10, 5);
        }
    }

    @Override
    public void shiftLeft(int diffLeft) {
        setX(getX() + diffLeft);
    }

}
