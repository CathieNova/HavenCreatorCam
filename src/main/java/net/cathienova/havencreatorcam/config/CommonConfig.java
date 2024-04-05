package net.cathienova.havencreatorcam.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class CommonConfig
{
    public final ForgeConfigSpec.IntValue originalCamFOV;
    public final ForgeConfigSpec.IntValue creatorCamFOV;
    public final ForgeConfigSpec.BooleanValue hideGUI;


    public CommonConfig(ForgeConfigSpec.Builder builder)
    {
        creatorCamFOV = builder.comment("The FOV of the creator camera").defineInRange("creatorCamFOV", 30, 30, 110);
        originalCamFOV = builder.comment("The FOV you normally use. (defaulted to 70)").defineInRange("originalFOV", 70, 30, 110);
        hideGUI = builder.comment("Hide the GUI when using the creator camera?").define("hideGUI", true);
    }
}