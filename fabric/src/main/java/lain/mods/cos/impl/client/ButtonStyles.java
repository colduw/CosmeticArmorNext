package lain.mods.cos.impl.client;

import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.common.TranslatableEnum;

public enum ButtonStyles implements TranslatableEnum {
    DEFAULT,
    CUSTOM_COLOR,
    GRADIENT;

    @Override
    public Component getTranslatedName() {
        return Component.translatable("cos.config.CosArmorButtonStyle." + name());
    }
}