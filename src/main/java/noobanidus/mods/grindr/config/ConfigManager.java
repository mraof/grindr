package noobanidus.mods.grindr.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import net.minecraft.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import noobanidus.mods.grindr.Grindr;
import noobanidus.mods.grindr.blocks.GrindstoneType;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigManager {
  private static ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();

  public static ForgeConfigSpec COMMON_CONFIG;
  private static Map<String, ForgeConfigSpec.BooleanValue> CONFIG_MAP = new HashMap<>();
  public static Map<String, ForgeConfigSpec.BooleanValue> GRINDSTONE_MAP = new HashMap<>();
  public static Map<String, ForgeConfigSpec.DoubleValue> RESULT_MODIFIER = new HashMap<>();
  public static Map<String, ForgeConfigSpec.DoubleValue> SPEED_MODIFIER = new HashMap<>();

  private static List<String> types = Arrays.asList("gold", "iron", "silver", "copper", "tin", "nickel", "lead", "aluminum", "uranium", "zinc", "platinum", "mercury", "bismuth", "neptunium");

  static {
    COMMON_BUILDER.comment("invidiaully configure which dusts are visible").push("dust_settings");
    for (String d : types) {
      String dust = d.toLowerCase() + "_dust";
      CONFIG_MAP.put(dust, COMMON_BUILDER.define("hide_" + dust, true));
    }
    COMMON_BUILDER.pop();

    COMMON_BUILDER.comment("individually configure which grindstones are visible").push("grindstone_settings");
    for (String g : types) {
      String grindstone = g.toLowerCase();
      GRINDSTONE_MAP.put(g, COMMON_BUILDER.define("hide_" + grindstone, true));
    }
    COMMON_BUILDER.pop();

    COMMON_BUILDER.push("grindstone_types");
    COMMON_BUILDER.push("stone");
    RESULT_MODIFIER.put("stone", COMMON_BUILDER.defineInRange("stone_result_modifier", 1.1, 0, 10));
    SPEED_MODIFIER.put("stone", COMMON_BUILDER.defineInRange("stone_speed_modifier", 1.3, 0, 10));
    COMMON_BUILDER.pop();
    COMMON_BUILDER.push("granite");
    RESULT_MODIFIER.put("granite", COMMON_BUILDER.defineInRange("granite_result_modifier", 1.1, 0, 10));
    SPEED_MODIFIER.put("granite", COMMON_BUILDER.defineInRange("granite_speed_modifier", 1.3, 0, 10));
    COMMON_BUILDER.pop();
    COMMON_BUILDER.push("diorite");
    RESULT_MODIFIER.put("diorite", COMMON_BUILDER.defineInRange("diorite_result_modifier", 1.1, 0, 10));
    SPEED_MODIFIER.put("diorite", COMMON_BUILDER.defineInRange("diorite_speed_modifier", 1.3, 0, 10));
    COMMON_BUILDER.pop();
    COMMON_BUILDER.push("andesite");
    RESULT_MODIFIER.put("andesite", COMMON_BUILDER.defineInRange("andesite_result_modifier", 1.1, 0, 10));
    SPEED_MODIFIER.put("andesite", COMMON_BUILDER.defineInRange("andesite_speed_modifier", 1.3, 0, 10));
    COMMON_BUILDER.pop();

    COMMON_BUILDER.push("tin");
    RESULT_MODIFIER.put("tin", COMMON_BUILDER.defineInRange("tin_result_modifier", 1.3, 0, 10));
    SPEED_MODIFIER.put("tin", COMMON_BUILDER.defineInRange("tin_speed_modifier", 0.75, 0, 10));
    COMMON_BUILDER.pop();

    COMMON_BUILDER.push("aluminum");
    RESULT_MODIFIER.put("aluminum", COMMON_BUILDER.defineInRange("aluminum_result_modifier", 1.6, 0, 10));
    SPEED_MODIFIER.put("aluminum", COMMON_BUILDER.defineInRange("aluminum_speed_modifier", 0.9, 0, 10));
    COMMON_BUILDER.pop();

    COMMON_BUILDER.push("copper");
    RESULT_MODIFIER.put("copper", COMMON_BUILDER.defineInRange("copper_result_modifier", 1.4, 0, 10));
    SPEED_MODIFIER.put("copper", COMMON_BUILDER.defineInRange("copper_speed_modifier", 0.6, 0, 10));
    COMMON_BUILDER.pop();

    COMMON_BUILDER.push("iron");
    RESULT_MODIFIER.put("iron", COMMON_BUILDER.defineInRange("iron_result_modifier", 1.7, 0, 10));
    SPEED_MODIFIER.put("iron", COMMON_BUILDER.defineInRange("iron_speed_modifier", 1.0, 0, 10));
    COMMON_BUILDER.pop();

    COMMON_BUILDER.push("nickel");
    RESULT_MODIFIER.put("nickel", COMMON_BUILDER.defineInRange("nickel_result_modifier", 1.6, 0, 10));
    SPEED_MODIFIER.put("nickel", COMMON_BUILDER.defineInRange("nickel_speed_modifier", 0.95, 0, 10));
    COMMON_BUILDER.pop();

    COMMON_BUILDER.push("gold");
    RESULT_MODIFIER.put("gold", COMMON_BUILDER.defineInRange("gold_result_modifier", 1.4, 0, 10));
    SPEED_MODIFIER.put("gold", COMMON_BUILDER.defineInRange("gold_speed_modifier", 0.5, 0, 10));
    COMMON_BUILDER.pop();

    COMMON_BUILDER.push("silver");
    RESULT_MODIFIER.put("silver", COMMON_BUILDER.defineInRange("silver_result_modifier", 1.5, 0, 10));
    SPEED_MODIFIER.put("silver", COMMON_BUILDER.defineInRange("silver_speed_modifier", 0.75, 0, 10));
    COMMON_BUILDER.pop();

    COMMON_BUILDER.push("lead");
    RESULT_MODIFIER.put("lead", COMMON_BUILDER.defineInRange("lead_result_modifier", 2.0, 0, 10));
    SPEED_MODIFIER.put("lead", COMMON_BUILDER.defineInRange("lead_speed_modifier", 1.6, 0, 10));
    COMMON_BUILDER.pop();

    COMMON_BUILDER.push("zinc");
    RESULT_MODIFIER.put("zinc", COMMON_BUILDER.defineInRange("zinc_result_modifier", 1.45, 0, 10));
    SPEED_MODIFIER.put("zinc", COMMON_BUILDER.defineInRange("zinc_speed_modifier", 0.8, 0, 10));
    COMMON_BUILDER.pop();

    COMMON_BUILDER.push("uranium");
    RESULT_MODIFIER.put("uranium", COMMON_BUILDER.defineInRange("uranium_result_modifier", 0.75, 0, 10));
    SPEED_MODIFIER.put("uranium", COMMON_BUILDER.defineInRange("uranium_speed_modifier", 0.2, 0, 10));
    COMMON_BUILDER.pop();

    COMMON_BUILDER.push("mercury");
    RESULT_MODIFIER.put("mercury", COMMON_BUILDER.defineInRange("mercury_result_modifier", 1.3, 0, 10));
    SPEED_MODIFIER.put("mercury", COMMON_BUILDER.defineInRange("mercury_speed_modifier", 0.3, 0, 10));
    COMMON_BUILDER.pop();

    COMMON_BUILDER.push("diamond");
    RESULT_MODIFIER.put("diamond", COMMON_BUILDER.defineInRange("diamond_result_modifier", 2.0, 0, 10));
    SPEED_MODIFIER.put("diamond", COMMON_BUILDER.defineInRange("diamond_speed_modifier", 0.7, 0, 10));
    COMMON_BUILDER.pop();

    COMMON_BUILDER.push("obsidian");
    RESULT_MODIFIER.put("obsidian", COMMON_BUILDER.defineInRange("obsidian_result_modifier", 2.5, 0, 10));
    SPEED_MODIFIER.put("obsidian", COMMON_BUILDER.defineInRange("obsidian_speed_modifier", 1.1, 0, 10));
    COMMON_BUILDER.pop();

    COMMON_BUILDER.push("platinum");
    RESULT_MODIFIER.put("platinum", COMMON_BUILDER.defineInRange("platinum_result_modifier", 2.2, 0, 10));
    SPEED_MODIFIER.put("platinum", COMMON_BUILDER.defineInRange("platinum_speed_modifier", 0.7, 0, 10));
    COMMON_BUILDER.pop();

    COMMON_BUILDER.push("bismuth");
    RESULT_MODIFIER.put("bismuth", COMMON_BUILDER.defineInRange("bismuth_result_modifier", 3.2, 0, 10));
    SPEED_MODIFIER.put("bismuth", COMMON_BUILDER.defineInRange("bismuth_speed_modifier", 3.5, 0, 10));
    COMMON_BUILDER.pop();

    COMMON_BUILDER.push("emerald");
    RESULT_MODIFIER.put("emerald", COMMON_BUILDER.defineInRange("emerald_result_modifier", 2.5, 0, 10));
    SPEED_MODIFIER.put("emerald", COMMON_BUILDER.defineInRange("emerald_speed_modifier", 1.0, 0, 10));
    COMMON_BUILDER.pop();

    COMMON_BUILDER.push("neptunium");
    RESULT_MODIFIER.put("neptunium", COMMON_BUILDER.defineInRange("neptunium_result_modifier", 2.0, 0, 10));
    SPEED_MODIFIER.put("neptunium", COMMON_BUILDER.defineInRange("neptunium_speed_modifier", 0.8, 0, 10));
    COMMON_BUILDER.pop();

    COMMON_BUILDER.pop();

    COMMON_CONFIG = COMMON_BUILDER.build();
  }

  public static boolean isDustHidden (String dust) {
    ForgeConfigSpec.ConfigValue<Boolean> val = CONFIG_MAP.get(dust);
    return val == null || !val.get();
  }

  public static boolean isGrindstoneHidden (String grindstone) {
     ForgeConfigSpec.ConfigValue<Boolean> val = GRINDSTONE_MAP.get(grindstone);
    return val == null || !val.get();
  }

  @SuppressWarnings("ConstantConditions")
  public static NonNullUnaryOperator<Item.Properties> getDustProperty(String dust) {
    ForgeConfigSpec.ConfigValue<Boolean> val = CONFIG_MAP.get(dust);
    if (val == null || !val.get()) {
      return (o) -> o.group(null);
    } else {
      return (o) -> o.group(Grindr.ITEM_GROUP);
    }
  }

  public static void loadConfig(ForgeConfigSpec spec, Path path) {
    CommentedFileConfig configData = CommentedFileConfig.builder(path).sync().autosave().writingMode(WritingMode.REPLACE).build();
    configData.load();
    spec.setConfig(configData);
  }
}
