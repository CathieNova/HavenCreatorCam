package net.cathienova.havencreatorcam.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.cathienova.havencreatorcam.HavenCreatorCam;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraft.client.KeyMapping;

public class ModKeybindings
{
    public static final ModKeybindings INSTANCE = new ModKeybindings();

    private ModKeybindings() {}

    private static final String CATEGORY = "key.categories." + HavenCreatorCam.MOD_ID;

    public static final KeyMapping creatorCamKey = new KeyMapping(
            "key." + HavenCreatorCam.MOD_ID + ".creatorCam",
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            InputConstants.KEY_Z,
            CATEGORY
    );

    public static void registerKeybindings() {
        ClientRegistry.registerKeyBinding(creatorCamKey);
    }
}
