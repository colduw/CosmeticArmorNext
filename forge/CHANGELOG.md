# [v5] - tbd

- Changed keybind category from inventory to an own category.
- Update checker notifications now show up in game chat as well.
- Changed some formatting on text (CosmeticArmor -> Cosmetic Armor)
- Builds are now named cosmeticarmornext-[modloader]-[minecraft version]-[version].jar
  - Internally, it will remain called "cosmeticarmorreworked", to keep compatibility with any and all mods that may use the old id.
- Now uses access transformers instead of reflection
- Fixed "Ignoring click in mismatching container"
- Fixed CosArmorDisableRecipeBook, will now properly remove the Recipe Book
- Fixed some typos in config comments (inventoy -> inventory)
- Added config screen
- Added missing localization keys to all new/existing languages
- Added new localizations (dk, fi, hu, it, nl, no, pl, ro, se)
  - If there are any issues with them (there is a 99% guarantee that some are off, as google translate is not 100% accurate), if there is an issue, a [PR](https://github.com/colduw/CosmeticArmorNext/pulls) or [Issue](https://github.com/colduw/CosmeticArmorNext/issues) can be opened