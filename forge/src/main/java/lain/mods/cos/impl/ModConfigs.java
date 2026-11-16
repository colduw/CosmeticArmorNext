package lain.mods.cos.impl;

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
        public Screen parent;
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
}
