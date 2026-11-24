package lain.mods.cos.impl;

import lain.mods.cos.impl.client.ButtonStyles;
import lain.mods.cos.impl.client.ToggleStyles;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.*;
import net.minecraft.client.gui.layouts.LinearLayout;
import net.minecraft.client.gui.layouts.SpacerElement;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;
import net.minecraftforge.common.ForgeConfigSpec.EnumValue;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

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

    public static void registerConfigs(FMLJavaModLoadingContext context) {
        context.registerConfig(ModConfig.Type.CLIENT, new ForgeConfigSpec.Builder() {
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
        context.registerConfig(ModConfig.Type.COMMON, new ForgeConfigSpec.Builder() {
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
                pop();
            }
        }.build());
    }

    public static void registerConfigScreen(FMLJavaModLoadingContext modLoadingContext) {
        modLoadingContext.registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class, () -> new ConfigScreenHandler.ConfigScreenFactory(ConfigMenu::new));
    }

    // my hope is that whoever sees this config menu will immediately want to switch to the fabric
    // or neoforge build
    public static class ConfigMenu extends Screen {
        public final Screen parent;
        public ConfigMenu(Screen parent) {
            super(Component.translatable("key.category.cosmeticarmorreworked.cos.key.category"));
            this.parent = parent;
        }

        @Override
        protected void init() {
            LinearLayout clientLayout = LinearLayout.vertical();

            int maxWidth = (this.width / 2) - 20;

            // CosArmorGuiButton_Hidden
            Checkbox CosArmorGuiButtonHidden = Checkbox.builder(Component.translatable("cos.config.CosArmorGuiButton_Hidden"), this.font)
                    .selected(CosArmorGuiButton_Hidden.get())
                    .onValueChange((btn, value) -> CosArmorGuiButton_Hidden.set(value))
                    .tooltip(Tooltip.create(Component.translatable("cos.config.CosArmorGuiButton_Hidden.tooltip")))
                    .maxWidth(maxWidth - 40)
                    .build();
            clientLayout.addChild(SpacerElement.height(15));
            clientLayout.addChild(CosArmorGuiButtonHidden);

            // CosArmorGuiButton_Left
            EditBox CosArmorGuiButtonLeft = new EditBox(this.font, 100, 20, Component.translatable("cos.config.CosArmorGuiButton_Left"));
            CosArmorGuiButtonLeft.setValue(CosArmorGuiButton_Left.get().toString());
            CosArmorGuiButtonLeft.setTooltip(Tooltip.create(Component.translatable("cos.config.CosArmorGuiButton_Left.tooltip")));
            CosArmorGuiButtonLeft.setResponder(s -> {
                try {
                    CosArmorGuiButton_Left.set(Integer.parseInt(s));
                } catch (Exception e) {
                    ModObjects.logger.warn("CosArmorGuiButton_Left could not be parsed as number: {}", e.getMessage());
                }
            });
            clientLayout.addChild(SpacerElement.height(15));
            clientLayout.addChild(new MultiLineTextWidget(CosArmorGuiButtonLeft.getMessage(), this.font).setMaxWidth(maxWidth));
            clientLayout.addChild(CosArmorGuiButtonLeft);

            // CosArmorGuiButton_Top
            EditBox CosArmorGuiButtonTop = new EditBox(this.font, 100, 20, Component.translatable("cos.config.CosArmorGuiButton_Top"));
            CosArmorGuiButtonTop.setValue(CosArmorGuiButton_Top.get().toString());
            CosArmorGuiButtonTop.setTooltip(Tooltip.create(Component.translatable("cos.config.CosArmorGuiButton_Top.tooltip")));
            CosArmorGuiButtonTop.setResponder(s -> {
                try {
                    CosArmorGuiButton_Top.set(Integer.parseInt(s));
                } catch (Exception e) {
                    ModObjects.logger.warn("CosArmorGuiButton_Top could not be parsed as number: {}", e.getMessage());
                }
            });
            clientLayout.addChild(SpacerElement.height(15));
            clientLayout.addChild(new MultiLineTextWidget(CosArmorGuiButtonTop.getMessage(), this.font).setMaxWidth(maxWidth));
            clientLayout.addChild(CosArmorGuiButtonTop);

            // CosArmorToggleButton_Hidden
            Checkbox CosArmorToggleButtonHidden = Checkbox.builder(Component.translatable("cos.config.CosArmorToggleButton_Hidden"), this.font)
                    .selected(CosArmorToggleButton_Hidden.get())
                    .onValueChange((btn, value) -> CosArmorToggleButton_Hidden.set(value))
                    .tooltip(Tooltip.create(Component.translatable("cos.config.CosArmorToggleButton_Hidden.tooltip")))
                    .maxWidth(maxWidth - 40)
                    .build();
            clientLayout.addChild(SpacerElement.height(15));
            clientLayout.addChild(CosArmorToggleButtonHidden);

            // CosArmorToggleButton_Left
            EditBox CosArmorToggleButtonLeft = new EditBox(this.font, 100, 20, Component.translatable("cos.config.CosArmorToggleButton_Left"));
            CosArmorToggleButtonLeft.setValue(CosArmorToggleButton_Left.get().toString());
            CosArmorToggleButtonLeft.setTooltip(Tooltip.create(Component.translatable("cos.config.CosArmorToggleButton_Left.tooltip")));
            CosArmorToggleButtonLeft.setResponder(s -> {
                try {
                    CosArmorToggleButton_Left.set(Integer.parseInt(s));
                } catch (Exception e) {
                    ModObjects.logger.warn("CosArmorToggleButton_Left could not be parsed as number: {}", e.getMessage());
                }
            });
            clientLayout.addChild(SpacerElement.height(15));
            clientLayout.addChild(new MultiLineTextWidget(CosArmorToggleButtonLeft.getMessage(), this.font).setMaxWidth(maxWidth));
            clientLayout.addChild(CosArmorToggleButtonLeft);

            // CosArmorToggleButton_Top
            EditBox CosArmorToggleButtonTop = new EditBox(this.font, 100, 20, Component.translatable("cos.config.CosArmorToggleButton_Top"));
            CosArmorToggleButtonTop.setValue(CosArmorToggleButton_Top.get().toString());
            CosArmorToggleButtonTop.setTooltip(Tooltip.create(Component.translatable("cos.config.CosArmorToggleButton_Top.tooltip")));
            CosArmorToggleButtonTop.setResponder(s -> {
                try {
                    CosArmorToggleButton_Top.set(Integer.parseInt(s));
                } catch (Exception e) {
                    ModObjects.logger.warn("CosArmorToggleButton_Top could not be parsed as number: {}", e.getMessage());
                }
            });
            clientLayout.addChild(SpacerElement.height(15));
            clientLayout.addChild(new MultiLineTextWidget(CosArmorToggleButtonTop.getMessage(), this.font).setMaxWidth(maxWidth));
            clientLayout.addChild(CosArmorToggleButtonTop);

            // CosArmorCreativeGuiButton_Hidden
            Checkbox CosArmorCreativeGuiButtonHidden = Checkbox.builder(Component.translatable("cos.config.CosArmorCreativeGuiButton_Hidden"), this.font)
                    .selected(CosArmorCreativeGuiButton_Hidden.get())
                    .onValueChange((btn, value) -> CosArmorCreativeGuiButton_Hidden.set(value))
                    .tooltip(Tooltip.create(Component.translatable("cos.config.CosArmorCreativeGuiButton_Hidden.tooltip")))
                    .maxWidth(maxWidth - 40)
                    .build();
            clientLayout.addChild(SpacerElement.height(15));
            clientLayout.addChild(CosArmorCreativeGuiButtonHidden);

            // CosArmorCreativeGuiButton_Left
            EditBox CosArmorCreativeGuiButtonLeft = new EditBox(this.font, 100, 20, Component.translatable("cos.config.CosArmorCreativeGuiButton_Left"));
            CosArmorCreativeGuiButtonLeft.setValue(CosArmorCreativeGuiButton_Left.get().toString());
            CosArmorCreativeGuiButtonLeft.setTooltip(Tooltip.create(Component.translatable("cos.config.CosArmorCreativeGuiButton_Left.tooltip")));
            CosArmorCreativeGuiButtonLeft.setResponder(s -> {
                try {
                    CosArmorCreativeGuiButton_Left.set(Integer.parseInt(s));
                } catch (Exception e) {
                    ModObjects.logger.warn("CosArmorCreativeGuiButton_Left could not be parsed as number: {}", e.getMessage());
                }
            });
            clientLayout.addChild(SpacerElement.height(15));
            clientLayout.addChild(new MultiLineTextWidget(CosArmorCreativeGuiButtonLeft.getMessage(), this.font).setMaxWidth(maxWidth));
            clientLayout.addChild(CosArmorCreativeGuiButtonLeft);

            // CosArmorCreativeGuiButton_Top
            EditBox CosArmorCreativeGuiButtonTop = new EditBox(this.font, 100, 20, Component.translatable("cos.config.CosArmorCreativeGuiButton_Top"));
            CosArmorCreativeGuiButtonTop.setValue(CosArmorCreativeGuiButton_Top.get().toString());
            CosArmorCreativeGuiButtonTop.setTooltip(Tooltip.create(Component.translatable("cos.config.CosArmorCreativeGuiButton_Top.tooltip")));
            CosArmorCreativeGuiButtonTop.setResponder(s -> {
                try {
                    CosArmorCreativeGuiButton_Top.set(Integer.parseInt(s));
                } catch (Exception e) {
                    ModObjects.logger.warn("CosArmorCreativeGuiButton_Top could not be parsed as number: {}", e.getMessage());
                }
            });
            clientLayout.addChild(SpacerElement.height(15));
            clientLayout.addChild(new MultiLineTextWidget(CosArmorCreativeGuiButtonTop.getMessage(), this.font).setMaxWidth(maxWidth));
            clientLayout.addChild(CosArmorCreativeGuiButtonTop);

            // CosArmorTextColor
            EditBox CosArmorTextColorButton = new EditBox(this.font, 100, 20, Component.translatable("cos.config.CosArmorTextColor"));
            CosArmorTextColorButton.setValue(CosArmorTextColor.get().toString());
            CosArmorTextColorButton.setTooltip(Tooltip.create(Component.translatable("cos.config.CosArmorTextColor.tooltip")));
            CosArmorTextColorButton.setResponder(s -> {
                try {
                    CosArmorTextColor.set(Integer.decode(s));
                } catch (Exception e) {
                    ModObjects.logger.warn("CosArmorTextColor could not be parsed as number: {}", e.getMessage());
                }
            });
            clientLayout.addChild(SpacerElement.height(15));
            clientLayout.addChild(new MultiLineTextWidget(CosArmorTextColorButton.getMessage(), this.font).setMaxWidth(maxWidth));
            clientLayout.addChild(CosArmorTextColorButton);

            // CosArmorCraftingTextColor
            EditBox CosArmorCraftingTextColorButton = new EditBox(this.font, 100, 20, Component.translatable("cos.config.CosArmorCraftingTextColor"));
            CosArmorCraftingTextColorButton.setValue(CosArmorCraftingTextColor.get().toString());
            CosArmorCraftingTextColorButton.setTooltip(Tooltip.create(Component.translatable("cos.config.CosArmorCraftingTextColor.tooltip")));
            CosArmorCraftingTextColorButton.setResponder(s -> {
                try {
                    CosArmorCraftingTextColor.set(Integer.decode(s));
                } catch (Exception e) {
                    ModObjects.logger.warn("CosArmorCraftingTextColor could not be parsed as number: {}", e.getMessage());
                }
            });
            clientLayout.addChild(SpacerElement.height(15));
            clientLayout.addChild(new MultiLineTextWidget(CosArmorCraftingTextColorButton.getMessage(), this.font).setMaxWidth(maxWidth));
            clientLayout.addChild(CosArmorCraftingTextColorButton);

            // ButtonStyling
            Button goToButtonStylingMenu = Button.builder(Component.translatable("cosmeticarmorreworked.configuration.ButtonStyling"), button -> this.minecraft.setScreen(new ButtonStylingMenu(this)))
                    .width(100)
                    .build();
            clientLayout.addChild(SpacerElement.height(15));
            clientLayout.addChild(goToButtonStylingMenu);

            /// COMMON
            LinearLayout commonLayout = LinearLayout.vertical();

            // CosArmorKeepThroughDeath
            Checkbox CosArmorKeepThroughDeathButton = Checkbox.builder(Component.translatable("cos.config.CosArmorKeepThroughDeath"), this.font)
                    .selected(CosArmorKeepThroughDeath.get())
                    .onValueChange((btn, value) -> CosArmorKeepThroughDeath.set(value))
                    .tooltip(Tooltip.create(Component.translatable("cos.config.CosArmorKeepThroughDeath.tooltip")))
                    .maxWidth(maxWidth - 40)
                    .build();
            commonLayout.addChild(SpacerElement.height(15));
            commonLayout.addChild(CosArmorKeepThroughDeathButton);

            // CosArmorDisableRecipeBook
            Checkbox CosArmorDisableRecipeBookButton = Checkbox.builder(Component.translatable("cos.config.CosArmorDisableRecipeBook"), this.font)
                    .selected(CosArmorDisableRecipeBook.get())
                    .onValueChange((btn, value) -> CosArmorDisableRecipeBook.set(value))
                    .tooltip(Tooltip.create(Component.translatable("cos.config.CosArmorDisableRecipeBook.tooltip")))
                    .maxWidth(maxWidth - 40)
                    .build();
            commonLayout.addChild(SpacerElement.height(15));
            commonLayout.addChild(CosArmorDisableRecipeBookButton);

            // CosArmorDisableCosHatCommand
            Checkbox CosArmorDisableCosHatCommandButton = Checkbox.builder(Component.translatable("cos.config.CosArmorDisableCosHatCommand"), this.font)
                    .selected(CosArmorDisableCosHatCommand.get())
                    .onValueChange((btn, value) -> CosArmorDisableCosHatCommand.set(value))
                    .tooltip(Tooltip.create(Component.translatable("cos.config.CosArmorDisableCosHatCommand.tooltip")))
                    .maxWidth(maxWidth - 40)
                    .build();
            commonLayout.addChild(SpacerElement.height(15));
            commonLayout.addChild(CosArmorDisableCosHatCommandButton);

            /// CLIENT
            ScrollableLayout clientScroll = new ScrollableLayout(this.minecraft, clientLayout, 100);
            clientScroll.setMaxHeight(this.height - 50);
            clientScroll.setPosition(20, 20);
            clientScroll.arrangeElements();
            clientScroll.visitWidgets(this::addRenderableWidget);

            /// COMMON
            ScrollableLayout commonScroll = new ScrollableLayout(this.minecraft, commonLayout, 100);
            commonScroll.setMinWidth((this.width / 2) - 100);
            commonScroll.setMaxHeight(this.height - 50);
            commonScroll.setPosition((this.width / 2) + 20, 20);
            commonScroll.arrangeElements();
            commonScroll.visitWidgets(this::addRenderableWidget);

            Button backButton = Button.builder(Component.translatable("gui.back"), button -> onClose())
                    .pos(0, this.height - 20)
                    .build();

            this.addRenderableWidget(backButton);
        }

        @Override
        public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
            super.render(graphics, mouseX, mouseY, partialTicks);

            graphics.drawString(this.font, Component.translatable("cosmeticarmorreworked.configuration.Client"), 80, 30 - this.font.lineHeight - 10, 0xFFFFFFFF, true);
            graphics.drawString(this.font, Component.translatable("cosmeticarmorreworked.configuration.Common"), (this.width / 2) + 35, 30 - this.font.lineHeight - 10, 0xFFFFFFFF, true);
        }

        @Override
        public void onClose() {
            CosArmorGuiButton_Hidden.save();
            CosArmorKeepThroughDeath.save();
            this.minecraft.setScreen(this.parent);
        }
    }

    public static class ButtonStylingMenu extends Screen {
        public final Screen parent;
        public ButtonStylingMenu(Screen parent) {
            super(Component.translatable("key.category.cosmeticarmorreworked.cos.key.category"));
            this.parent = parent;
        }

        @Override
        public void init() {
            LinearLayout clientLayout = LinearLayout.vertical();

            int maxWidth = this.width / 2;

            // CosArmorToggleStyle
            CycleButton<ToggleStyles> CosArmorToggleStyleButton = CycleButton.<ToggleStyles>builder(b -> Component.translatable("cos.config.CosArmorToggleStyle."+b.name()))
                    .withValues(ToggleStyles.values())
                    .withInitialValue(CosArmorToggleStyle.get())
                    .withTooltip(t -> Tooltip.create(Component.translatable("cos.config.CosArmorToggleStyle.tooltip")))
                    .create(0, 0, 200, 20, Component.translatable("cos.config.CosArmorToggleStyle"),
                            (btn, value) -> CosArmorToggleStyle.set(value));
            clientLayout.addChild(SpacerElement.height(15));
            clientLayout.addChild(CosArmorToggleStyleButton);

            // CosArmorToggleStyle_Inactive
            EditBox CosArmorToggleStyleInactiveButton = new EditBox(this.font, 100, 20, Component.translatable("cos.config.CosArmorToggleStyle_Inactive"));
            CosArmorToggleStyleInactiveButton.setValue(CosArmorToggleStyle_Inactive.get().toString());
            CosArmorToggleStyleInactiveButton.setTooltip(Tooltip.create(Component.translatable("cos.config.CosArmorToggleStyle_Inactive.tooltip")));
            CosArmorToggleStyleInactiveButton.setResponder(s -> {
                try {
                    CosArmorToggleStyle_Inactive.set(Integer.decode(s));
                } catch (Exception e) {
                    ModObjects.logger.warn("CosArmorToggleStyle_Inactive could not be parsed as number: {}", e.getMessage());
                }
            });
            clientLayout.addChild(SpacerElement.height(15));
            clientLayout.addChild(new MultiLineTextWidget(CosArmorToggleStyleInactiveButton.getMessage(), this.font).setMaxWidth(maxWidth));
            clientLayout.addChild(CosArmorToggleStyleInactiveButton);

            // CosArmorToggleStyle_Active
            EditBox CosArmorToggleStyleActiveButton = new EditBox(this.font, 100, 20, Component.translatable("cos.config.CosArmorToggleStyle_Active"));
            CosArmorToggleStyleActiveButton.setValue(CosArmorToggleStyle_Active.get().toString());
            CosArmorToggleStyleActiveButton.setTooltip(Tooltip.create(Component.translatable("cos.config.CosArmorToggleStyle_Active.tooltip")));
            CosArmorToggleStyleActiveButton.setResponder(s -> {
                try {
                    CosArmorToggleStyle_Active.set(Integer.decode(s));
                } catch (Exception e) {
                    ModObjects.logger.warn("CosArmorToggleStyle_Active could not be parsed as number: {}", e.getMessage());
                }
            });
            clientLayout.addChild(SpacerElement.height(15));
            clientLayout.addChild(new MultiLineTextWidget(CosArmorToggleStyleActiveButton.getMessage(), this.font).setMaxWidth(maxWidth));
            clientLayout.addChild(CosArmorToggleStyleActiveButton);

            // CosArmorButtonStyle
            CycleButton<ButtonStyles> CosArmorButtonStyleButton = CycleButton.<ButtonStyles>builder(b -> Component.translatable("cos.config.CosArmorButtonStyle."+b.name()))
                    .withValues(ButtonStyles.values())
                    .withInitialValue(CosArmorButtonStyle.get())
                    .withTooltip(t -> Tooltip.create(Component.translatable("cos.config.CosArmorButtonStyle.tooltip")))
                    .create(0, 0, 200, 20, Component.translatable("cos.config.CosArmorButtonStyle"),
                            (btn, value) -> CosArmorButtonStyle.set(value));
            clientLayout.addChild(SpacerElement.height(15));
            clientLayout.addChild(CosArmorButtonStyleButton);

            // CosArmorButtonStyle_Inactive
            EditBox CosArmorButtonStyleInactiveButton = new EditBox(this.font, 100, 20, Component.translatable("cos.config.CosArmorButtonStyle_Inactive"));
            CosArmorButtonStyleInactiveButton.setValue(CosArmorButtonStyle_Inactive.get().toString());
            CosArmorButtonStyleInactiveButton.setTooltip(Tooltip.create(Component.translatable("cos.config.CosArmorButtonStyle_Inactive.tooltip")));
            CosArmorButtonStyleInactiveButton.setResponder(s -> {
                try {
                    CosArmorButtonStyle_Inactive.set(Integer.decode(s));
                } catch (Exception e) {
                    ModObjects.logger.warn("CosArmorButtonStyle_Inactive could not be parsed as number: {}", e.getMessage());
                }
            });
            clientLayout.addChild(SpacerElement.height(15));
            clientLayout.addChild(new MultiLineTextWidget(CosArmorButtonStyleInactiveButton.getMessage(), this.font).setMaxWidth(maxWidth));
            clientLayout.addChild(CosArmorButtonStyleInactiveButton);

            // CosArmorButtonStyle_Active
            EditBox CosArmorButtonStyleActiveButton = new EditBox(this.font, 100, 20, Component.translatable("cos.config.CosArmorButtonStyle_Active"));
            CosArmorButtonStyleActiveButton.setValue(CosArmorButtonStyle_Active.get().toString());
            CosArmorButtonStyleActiveButton.setTooltip(Tooltip.create(Component.translatable("cos.config.CosArmorButtonStyle_Active.tooltip")));
            CosArmorButtonStyleActiveButton.setResponder(s -> {
                try {
                    CosArmorButtonStyle_Active.set(Integer.decode(s));
                } catch (Exception e) {
                    ModObjects.logger.warn("CosArmorButtonStyle_Active could not be parsed as number: {}", e.getMessage());
                }
            });
            clientLayout.addChild(SpacerElement.height(15));
            clientLayout.addChild(new MultiLineTextWidget(CosArmorButtonStyleActiveButton.getMessage(), this.font).setMaxWidth(maxWidth));
            clientLayout.addChild(CosArmorButtonStyleActiveButton);

            // GradientButtonStyling
            Button goToButtonStylingMenu = Button.builder(Component.translatable("cosmeticarmorreworked.configuration.GradientButtonStyling"), button -> this.minecraft.setScreen(new GradientButtonStylingMenu(this)))
                    .width(200)
                    .build();
            clientLayout.addChild(SpacerElement.height(15));
            clientLayout.addChild(goToButtonStylingMenu);

            /// CLIENT
            ScrollableLayout clientScroll = new ScrollableLayout(this.minecraft, clientLayout, 100);
            clientScroll.setMinWidth(maxWidth);
            clientScroll.setMaxHeight(this.height - 50);
            clientScroll.setPosition(this.width / 4, 20);
            clientScroll.arrangeElements();
            clientScroll.visitWidgets(this::addRenderableWidget);

            Button backButton = Button.builder(Component.translatable("gui.back"), button -> onClose())
                    .pos(0, this.height - 20)
                    .build();

            this.addRenderableWidget(backButton);
        }

        @Override
        public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
            super.render(graphics, mouseX, mouseY, partialTicks);

            graphics.drawString(this.font, Component.translatable("cosmeticarmorreworked.configuration.ButtonStyling"), (this.width / 2) - 30, 30 - this.font.lineHeight - 10, 0xFFFFFFFF, true);
        }

        @Override
        public void onClose() {
            this.minecraft.setScreen(this.parent);
        }
    }

    public static class GradientButtonStylingMenu extends Screen {
        public final Screen parent;
        public GradientButtonStylingMenu(Screen parent) {
            super(Component.translatable("key.category.cosmeticarmorreworked.cos.key.category"));
            this.parent = parent;
        }

        @Override
        public void init() {
            LinearLayout clientLayout = LinearLayout.vertical();

            int maxWidth = this.width / 2;

            // CosArmorButtonActiveGradientStart
            EditBox CosArmorButtonActiveGradientStartButton = new EditBox(this.font, 100, 20, Component.translatable("cos.config.CosArmorButtonActiveGradientStart"));
            CosArmorButtonActiveGradientStartButton.setValue(CosArmorButtonActiveGradientStart.get().toString());
            CosArmorButtonActiveGradientStartButton.setTooltip(Tooltip.create(Component.translatable("cos.config.CosArmorButtonActiveGradientStart.tooltip")));
            CosArmorButtonActiveGradientStartButton.setResponder(s -> {
                try {
                    CosArmorButtonActiveGradientStart.set(Integer.decode(s));
                } catch (Exception e) {
                    ModObjects.logger.warn("CosArmorButtonActiveGradientStart could not be parsed as number: {}", e.getMessage());
                }
            });
            clientLayout.addChild(SpacerElement.height(15));
            clientLayout.addChild(new MultiLineTextWidget(CosArmorButtonActiveGradientStartButton.getMessage(), this.font).setMaxWidth(maxWidth));
            clientLayout.addChild(CosArmorButtonActiveGradientStartButton);

            // CosArmorButtonActiveGradientEnd
            EditBox CosArmorButtonActiveGradientEndButton = new EditBox(this.font, 100, 20, Component.translatable("cos.config.CosArmorButtonActiveGradientEnd"));
            CosArmorButtonActiveGradientEndButton.setValue(CosArmorButtonActiveGradientEnd.get().toString());
            CosArmorButtonActiveGradientEndButton.setTooltip(Tooltip.create(Component.translatable("cos.config.CosArmorButtonActiveGradientEnd.tooltip")));
            CosArmorButtonActiveGradientEndButton.setResponder(s -> {
                try {
                    CosArmorButtonActiveGradientEnd.set(Integer.decode(s));
                } catch (Exception e) {
                    ModObjects.logger.warn("CosArmorButtonActiveGradientEnd could not be parsed as number: {}", e.getMessage());
                }
            });
            clientLayout.addChild(SpacerElement.height(15));
            clientLayout.addChild(new MultiLineTextWidget(CosArmorButtonActiveGradientEndButton.getMessage(), this.font).setMaxWidth(maxWidth));
            clientLayout.addChild(CosArmorButtonActiveGradientEndButton);

            // CosArmorButtonInactiveGradientStart
            EditBox CosArmorButtonInactiveGradientStartButton = new EditBox(this.font, 100, 20, Component.translatable("cos.config.CosArmorButtonInactiveGradientStart"));
            CosArmorButtonInactiveGradientStartButton.setValue(CosArmorButtonInactiveGradientStart.get().toString());
            CosArmorButtonInactiveGradientStartButton.setTooltip(Tooltip.create(Component.translatable("cos.config.CosArmorButtonInactiveGradientStart.tooltip")));
            CosArmorButtonInactiveGradientStartButton.setResponder(s -> {
                try {
                    CosArmorButtonInactiveGradientStart.set(Integer.decode(s));
                } catch (Exception e) {
                    ModObjects.logger.warn("CosArmorButtonInactiveGradientStart could not be parsed as number: {}", e.getMessage());
                }
            });
            clientLayout.addChild(SpacerElement.height(15));
            clientLayout.addChild(new MultiLineTextWidget(CosArmorButtonInactiveGradientStartButton.getMessage(), this.font).setMaxWidth(maxWidth));
            clientLayout.addChild(CosArmorButtonInactiveGradientStartButton);

            // CosArmorButtonInactiveGradientEnd
            EditBox CosArmorButtonInactiveGradientEndButton = new EditBox(this.font, 100, 20, Component.translatable("cos.config.CosArmorButtonInactiveGradientEnd"));
            CosArmorButtonInactiveGradientEndButton.setValue(CosArmorButtonInactiveGradientEnd.get().toString());
            CosArmorButtonInactiveGradientEndButton.setTooltip(Tooltip.create(Component.translatable("cos.config.CosArmorButtonInactiveGradientEnd.tooltip")));
            CosArmorButtonInactiveGradientEndButton.setResponder(s -> {
                try {
                    CosArmorButtonInactiveGradientEnd.set(Integer.decode(s));
                } catch (Exception e) {
                    ModObjects.logger.warn("CosArmorButtonInactiveGradientEnd could not be parsed as number: {}", e.getMessage());
                }
            });
            clientLayout.addChild(SpacerElement.height(15));
            clientLayout.addChild(new MultiLineTextWidget(CosArmorButtonInactiveGradientEndButton.getMessage(), this.font).setMaxWidth(maxWidth));
            clientLayout.addChild(CosArmorButtonInactiveGradientEndButton);

            // CosArmorToggleActiveGradientStart
            EditBox CosArmorToggleActiveGradientStartButton = new EditBox(this.font, 100, 20, Component.translatable("cos.config.CosArmorToggleActiveGradientStart"));
            CosArmorToggleActiveGradientStartButton.setValue(CosArmorToggleActiveGradientStart.get().toString());
            CosArmorToggleActiveGradientStartButton.setTooltip(Tooltip.create(Component.translatable("cos.config.CosArmorToggleActiveGradientStart.tooltip")));
            CosArmorToggleActiveGradientStartButton.setResponder(s -> {
                try {
                    CosArmorToggleActiveGradientStart.set(Integer.decode(s));
                } catch (Exception e) {
                    ModObjects.logger.warn("CosArmorToggleActiveGradientStart could not be parsed as number: {}", e.getMessage());
                }
            });
            clientLayout.addChild(SpacerElement.height(15));
            clientLayout.addChild(new MultiLineTextWidget(CosArmorToggleActiveGradientStartButton.getMessage(), this.font).setMaxWidth(maxWidth));
            clientLayout.addChild(CosArmorToggleActiveGradientStartButton);

            // CosArmorToggleActiveGradientEnd
            EditBox CosArmorToggleActiveGradientEndButton = new EditBox(this.font, 100, 20, Component.translatable("cos.config.CosArmorToggleActiveGradientEnd"));
            CosArmorToggleActiveGradientEndButton.setValue(CosArmorToggleActiveGradientEnd.get().toString());
            CosArmorToggleActiveGradientEndButton.setTooltip(Tooltip.create(Component.translatable("cos.config.CosArmorToggleActiveGradientEnd.tooltip")));
            CosArmorToggleActiveGradientEndButton.setResponder(s -> {
                try {
                    CosArmorToggleActiveGradientEnd.set(Integer.decode(s));
                } catch (Exception e) {
                    ModObjects.logger.warn("CosArmorToggleActiveGradientEnd could not be parsed as number: {}", e.getMessage());
                }
            });
            clientLayout.addChild(SpacerElement.height(15));
            clientLayout.addChild(new MultiLineTextWidget(CosArmorToggleActiveGradientEndButton.getMessage(), this.font).setMaxWidth(maxWidth));
            clientLayout.addChild(CosArmorToggleActiveGradientEndButton);

            // CosArmorToggleInactiveGradientStart
            EditBox CosArmorToggleInactiveGradientStartButton = new EditBox(this.font, 100, 20, Component.translatable("cos.config.CosArmorToggleInactiveGradientStart"));
            CosArmorToggleInactiveGradientStartButton.setValue(CosArmorToggleInactiveGradientStart.get().toString());
            CosArmorToggleInactiveGradientStartButton.setTooltip(Tooltip.create(Component.translatable("cos.config.CosArmorToggleInactiveGradientStart.tooltip")));
            CosArmorToggleInactiveGradientStartButton.setResponder(s -> {
                try {
                    CosArmorToggleInactiveGradientStart.set(Integer.decode(s));
                } catch (Exception e) {
                    ModObjects.logger.warn("CosArmorToggleInactiveGradientStart could not be parsed as number: {}", e.getMessage());
                }
            });
            clientLayout.addChild(SpacerElement.height(15));
            clientLayout.addChild(new MultiLineTextWidget(CosArmorToggleInactiveGradientStartButton.getMessage(), this.font).setMaxWidth(maxWidth));
            clientLayout.addChild(CosArmorToggleInactiveGradientStartButton);

            // CosArmorToggleInactiveGradientEnd
            EditBox CosArmorToggleInactiveGradientEndButton = new EditBox(this.font, 100, 20, Component.translatable("cos.config.CosArmorToggleInactiveGradientEnd"));
            CosArmorToggleInactiveGradientEndButton.setValue(CosArmorToggleInactiveGradientEnd.get().toString());
            CosArmorToggleInactiveGradientEndButton.setTooltip(Tooltip.create(Component.translatable("cos.config.CosArmorToggleInactiveGradientEnd.tooltip")));
            CosArmorToggleInactiveGradientEndButton.setResponder(s -> {
                try {
                    CosArmorToggleInactiveGradientEnd.set(Integer.decode(s));
                } catch (Exception e) {
                    ModObjects.logger.warn("CosArmorToggleInactiveGradientEnd could not be parsed as number: {}", e.getMessage());
                }
            });
            clientLayout.addChild(SpacerElement.height(15));
            clientLayout.addChild(new MultiLineTextWidget(CosArmorToggleInactiveGradientEndButton.getMessage(), this.font).setMaxWidth(maxWidth));
            clientLayout.addChild(CosArmorToggleInactiveGradientEndButton);

            /// CLIENT
            ScrollableLayout clientScroll = new ScrollableLayout(this.minecraft, clientLayout, 100);
            clientScroll.setMinWidth(maxWidth);
            clientScroll.setMaxHeight(this.height - 50);
            clientScroll.setPosition(this.width / 4, 20);
            clientScroll.arrangeElements();
            clientScroll.visitWidgets(this::addRenderableWidget);

            Button backButton = Button.builder(Component.translatable("gui.back"), button -> onClose())
                    .pos(0, this.height - 20)
                    .build();

            this.addRenderableWidget(backButton);
        }

        @Override
        public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
            super.render(graphics, mouseX, mouseY, partialTicks);

            graphics.drawString(this.font, Component.translatable("cosmeticarmorreworked.configuration.GradientButtonStyling"), (this.width / 2) - 30, 30 - this.font.lineHeight - 10, 0xFFFFFFFF, true);
        }

        @Override
        public void onClose() {
            this.minecraft.setScreen(this.parent);
        }
    }
}
