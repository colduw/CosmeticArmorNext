package lain.mods.cos.impl;

import lain.mods.cos.impl.client.ButtonStyles;
import lain.mods.cos.impl.client.ToggleStyles;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec.BooleanValue;
import net.neoforged.neoforge.common.ModConfigSpec.IntValue;
import net.neoforged.neoforge.common.ModConfigSpec.EnumValue;

public class ModConfigs {
    public static BooleanValue CosArmorGuiButton_Hidden;
    public static IntValue CosArmorGuiButton_Left;
    public static IntValue CosArmorGuiButton_Top;

    public static BooleanValue CosArmorToggleButton_Hidden;
    public static IntValue CosArmorToggleButton_Left;
    public static IntValue CosArmorToggleButton_Top;

    public static BooleanValue CosArmorCreativeGuiButton_Hidden;
    public static IntValue CosArmorCreativeGuiButton_Left;
    public static IntValue CosArmorCreativeGuiButton_Top;

    public static EnumValue<ToggleStyles> CosArmorToggleStyle;
    public static IntValue CosArmorToggleStyle_Inactive;
    public static IntValue CosArmorToggleStyle_Active;

    public static EnumValue<ButtonStyles> CosArmorButtonStyle;
    public static IntValue CosArmorButtonStyle_Inactive;
    public static IntValue CosArmorButtonStyle_Active;

    public static IntValue CosArmorButtonActiveGradientStart;
    public static IntValue CosArmorButtonActiveGradientEnd;
    public static IntValue CosArmorButtonInactiveGradientStart;
    public static IntValue CosArmorButtonInactiveGradientEnd;
    public static IntValue CosArmorToggleActiveGradientStart;
    public static IntValue CosArmorToggleActiveGradientEnd;
    public static IntValue CosArmorToggleInactiveGradientStart;
    public static IntValue CosArmorToggleInactiveGradientEnd;

    public static IntValue CosArmorTextColor;
    public static IntValue CosArmorCraftingTextColor;

    public static BooleanValue CosArmorKeepThroughDeath;
    public static BooleanValue CosArmorDisableRecipeBook;
    public static BooleanValue CosArmorDisableCosHatCommand;
    public static BooleanValue CosArmorDisableGraveStoneCorpseCompat;
    public static BooleanValue CosArmorDisableUpdateChecks;

    public static void registerConfigs() {
        ModLoadingContext.get().getActiveContainer().registerConfig(ModConfig.Type.CLIENT, new ModConfigSpec.Builder() {
            {
                comment("These settings only affects client").push("Client");
                CosArmorGuiButton_Hidden = comment("Whether or not to hide the button for opening Cosmetic Armor Inventory")
                        .translation("cos.config.CosArmorGuiButton_Hidden")
                        .define("CosArmorGuiButton_Hidden", false);
                CosArmorGuiButton_Left = comment("The horizontal pixel distance from the origin point of player inventory gui")
                        .translation("cos.config.CosArmorGuiButton_Left")
                        .defineInRange("CosArmorGuiButton_Left", 66, Integer.MIN_VALUE, Integer.MAX_VALUE);
                CosArmorGuiButton_Top = comment("The vertical pixel distance from the origin point of player inventory gui")
                        .translation("cos.config.CosArmorGuiButton_Top")
                        .defineInRange("CosArmorGuiButton_Top", 69, Integer.MIN_VALUE, Integer.MAX_VALUE);
                CosArmorToggleButton_Hidden = comment("Whether or not to hide the button for toggling the mod temporarily on client side")
                        .translation("cos.config.CosArmorToggleButton_Hidden")
                        .define("CosArmorToggleButton_Hidden", false);
                CosArmorToggleButton_Left = comment("The horizontal pixel distance from the origin point of player inventory gui")
                        .translation("cos.config.CosArmorToggleButton_Left")
                        .defineInRange("CosArmorToggleButton_Left", 59, Integer.MIN_VALUE, Integer.MAX_VALUE);
                CosArmorToggleButton_Top = comment("The vertical pixel distance from the origin point of player inventory gui")
                        .translation("cos.config.CosArmorToggleButton_Top")
                        .defineInRange("CosArmorToggleButton_Top", 72, Integer.MIN_VALUE, Integer.MAX_VALUE);
                CosArmorCreativeGuiButton_Hidden = comment("Whether or not to hide the button for opening Cosmetic Armor Inventory in Creative Inventory")
                        .translation("cos.config.CosArmorCreativeGuiButton_Hidden")
                        .define("CosArmorCreativeGuiButton_Hidden", false);
                CosArmorCreativeGuiButton_Left = comment("The horizontal pixel distance from the origin point of creative inventory gui")
                        .translation("cos.config.CosArmorCreativeGuiButton_Left")
                        .defineInRange("CosArmorCreativeGuiButton_Left", 96, Integer.MIN_VALUE, Integer.MAX_VALUE);
                CosArmorCreativeGuiButton_Top = comment("The vertical pixel distance from the origin point of creative inventory gui")
                        .translation("cos.config.CosArmorCreativeGuiButton_Top")
                        .defineInRange("CosArmorCreativeGuiButton_Top", 40, Integer.MIN_VALUE, Integer.MAX_VALUE);
                CosArmorTextColor = comment("Color of the Cosmetic Armor Button Text when Hovered")
                        .translation("cos.config.CosArmorTextColor")
                        .defineInRange("CosArmorTextColor", 0xFFFFFF, 0, 0xFFFFFF);
                CosArmorCraftingTextColor = comment("Color of the drawn Crafting Text")
                        .translation("cos.config.CosArmorCraftingTextColor")
                        .defineInRange("CosArmorCraftingTextColor", 0x404040, 0, 0xFFFFFF);
                CosArmorDisableUpdateChecks = comment("Whether or not to disable the update check messages whenever a world is joined")
                        .translation("cos.config.CosArmorDisableUpdateChecks")
                        .define("CosArmorDisableUpdateChecks", false);

                    comment("Button Styling").push("ButtonStyling");
                    CosArmorToggleStyle = comment("Style of the Toggle Buttons")
                            .translation("cos.config.CosArmorToggleStyle")
                            .defineEnum("CosArmorToggleStyle", ToggleStyles.DEFAULT);
                    CosArmorToggleStyle_Inactive = comment("Style of the Toggle Button when it's not active, only applied if CUSTOM_COLOR is used")
                            .translation("cos.config.CosArmorToggleStyle_Inactive")
                            .defineInRange("CosArmorToggleStyle_Inactive", 0x2C2C2C, 0, 0xFFFFFF);
                    CosArmorToggleStyle_Active = comment("Style of the Toggle Button when it's active, only applied if CUSTOM_COLOR is used")
                            .translation("cos.config.CosArmorToggleStyle_Active")
                            .defineInRange("CosArmorToggleStyle_Active", 0xF0F0F0, 0, 0xFFFFFF);
                    CosArmorButtonStyle = comment("Style of the Cosmetic Armor Button")
                            .translation("cos.config.CosArmorButtonStyle")
                            .defineEnum("CosArmorButtonStyle", ButtonStyles.DEFAULT);
                    CosArmorButtonStyle_Inactive = comment("Style of the Cosmetic Armor Button when it's not active, only applied if CUSTOM_COLOR is used")
                            .translation("cos.config.CosArmorButtonStyle_Inactive")
                            .defineInRange("CosArmorButtonStyle_Inactive", 0x2C2C2C, 0, 0xFFFFFF);
                    CosArmorButtonStyle_Active = comment("Style of the Cosmetic Armor Button when it's active, only applied if CUSTOM_COLOR is used")
                            .translation("cos.config.CosArmorButtonStyle_Active")
                            .defineInRange("CosArmorButtonStyle_Active", 0xF0F0F0, 0, 0xFFFFFF);

                    comment("Gradient Button Styling").push("GradientButtonStyling");
                    CosArmorButtonActiveGradientStart = comment("The starting color for the gradient on the Cosmetic Armor Button, while it is active")
                            .translation("cos.config.CosArmorButtonActiveGradientStart")
                            .defineInRange("CosArmorButtonActiveGradientStart", 0xE9E9E9, 0, 0xFFFFFF);
                    CosArmorButtonActiveGradientEnd = comment("The ending color for the gradient on the Cosmetic Armor Button, while it is active")
                            .translation("cos.config.CosArmorButtonActiveGradientEnd")
                            .defineInRange("CosArmorButtonActiveGradientEnd", 0x9A9A9A, 0, 0xFFFFFF);
                    CosArmorButtonInactiveGradientStart = comment("The starting color for the gradient on the Cosmetic Armor Button, while it is inactive")
                            .translation("cos.config.CosArmorButtonInactiveGradientStart")
                            .defineInRange("CosArmorButtonInactiveGradientStart", 0x707070, 0, 0xFFFFFF);
                    CosArmorButtonInactiveGradientEnd = comment("The ending color for the gradient on the Cosmetic Armor Button, while it is inactive")
                            .translation("cos.config.CosArmorButtonInactiveGradientEnd")
                            .defineInRange("CosArmorButtonInactiveGradientEnd", 0x454545, 0, 0xFFFFFF);
                    CosArmorToggleActiveGradientStart = comment("The starting color for the gradient on the Cosmetic Armor Toggle Button, while it is active")
                            .translation("cos.config.CosArmorToggleActiveGradientStart")
                            .defineInRange("CosArmorToggleActiveGradientStart", 0xE9E9E9, 0, 0xFFFFFF);
                    CosArmorToggleActiveGradientEnd = comment("The ending color for the gradient on the Cosmetic Armor Toggle Button, while it is active")
                            .translation("cos.config.CosArmorToggleActiveGradientEnd")
                            .defineInRange("CosArmorToggleActiveGradientEnd", 0x9A9A9A, 0, 0xFFFFFF);
                    CosArmorToggleInactiveGradientStart = comment("The starting color for the gradient on the Cosmetic Armor Toggle Button, while it is inactive")
                            .translation("cos.config.CosArmorToggleInactiveGradientStart")
                            .defineInRange("CosArmorToggleInactiveGradientStart", 0x707070, 0, 0xFFFFFF);
                    CosArmorToggleInactiveGradientEnd = comment("The ending color for the gradient on the Cosmetic Armor Toggle Button, while it is inactive")
                            .translation("cos.config.CosArmorToggleInactiveGradientEnd")
                            .defineInRange("CosArmorToggleInactiveGradientEnd", 0x454545, 0, 0xFFFFFF);
                    pop(2);
                pop();
            }
        }.build());
        ModLoadingContext.get().getActiveContainer().registerConfig(ModConfig.Type.LOCAL, new ModConfigSpec.Builder() {
            {
                comment("These settings affects both server and client").push("Common");
                CosArmorKeepThroughDeath = comment("Whether or not to keep items in cosmetic armor slots in the event of player death")
                        .translation("cos.config.CosArmorKeepThroughDeath")
                        .define("CosArmorKeepThroughDeath", false);
                CosArmorDisableRecipeBook = comment("Whether or not to disable the Recipe Book in the Cosmetic Armor Inventory")
                        .translation("cos.config.CosArmorDisableRecipeBook")
                        .define("CosArmorDisableRecipeBook", false);
                CosArmorDisableCosHatCommand = comment("Whether or not to disable the /coshat command")
                        .translation("cos.config.CosArmorDisableCosHatCommand")
                        .define("CosArmorDisableCosHatCommand", false);
                CosArmorDisableGraveStoneCorpseCompat = comment("Whether or not to disable GraveStones / Corpse compatibility")
                        .translation("cos.config.CosArmorDisableGraveStoneCorpseCompat")
                        .define("CosArmorDisableGraveStoneCorpseCompat", false);
                pop();
            }
        }.build());
    }

}
