package net.cathienova.havencreatorcam.config;

import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public class CommonConfig
{
    public static final Pair<CommonConfig, ModConfigSpec> SPEC_PAIR = new ModConfigSpec.Builder().configure(CommonConfig::new);
    public static final CommonConfig CONFIG = SPEC_PAIR.getLeft();
    public static final ModConfigSpec SPEC = SPEC_PAIR.getRight();
    public final ModConfigSpec.ConfigValue<Integer> originalCamFOV;
    public final ModConfigSpec.ConfigValue<Integer> creatorCamFOV;
    public final ModConfigSpec.ConfigValue<Boolean> hideGUI;


    public CommonConfig(ModConfigSpec.Builder builder)
    {
        creatorCamFOV = builder.comment("The FOV of the creator camera").defineInRange("creatorCamFOV", 30, 30, 110);
        originalCamFOV = builder.comment("The FOV you normally use. (defaulted to 70)").defineInRange("originalFOV", 70, 30, 110);
        hideGUI = builder.comment("Hide the GUI when using the creator camera?").define("hideGUI", true);
    }
}