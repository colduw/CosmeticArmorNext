# [v4] - 2026.11.08

### Kinda breaking change

- Added compatibility to resource packs that modify the inventory / slot appearance

tldr:

Delete `config/cosmeticarmorreworked-client.toml`, or, (assuming default config)

- change `CosArmorGuiButton_Left` to `66` (add 1)
- change `CosArmorGuiButton_Top` to `69` (add 2)
- change `CosArmorCreativeGuiButton_Left` to `96` (add 1)
- change `CosArmorCreativeGuiButton_Top` to `40` (add 2)

---

actual explanation:
the old GUI used a slightly modified version of `textures/gui/container/inventory.png`, by adding 4 slots next to the
offhand item, and having the gui button / toggle buttons

this version separated them to individual images `cosarmor_button.png` and `cosarmor_toggle_button.png` respectively,
and now uses the base `minecraft` namespace's textures
(one being the aforementioned inventory.png, other being `textures/gui/sprites/container/slot.png`)
