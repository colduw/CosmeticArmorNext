package lain.mods.cos.impl.client;
import net.neoforged.neoforge.common.TranslatableEnum;
import net.minecraft.network.chat.Component;

public enum ToggleStyles implements TranslatableEnum {
    DEFAULT,
    CUSTOM_COLOR,
    GRADIENT;

    @Override
    public Component getTranslatedName() {
        return Component.translatable("cos.config.CosArmorToggleStyle." + name());
    }
}