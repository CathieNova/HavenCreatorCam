package net.cathienova.havencreatorcam.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.cathienova.havencreatorcam.HavenCreatorCam;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraft.client.KeyMapping;

public class ModKeybindings
{
    public static final ModKeybindings INSTANCE = new ModKeybindings();

    private ModKeybindings() {}

    private static final String CATEGORY = "key.categories." + HavenCreatorCam.MOD_ID;

    public final KeyMapping creatorcam = new KeyMapping(
            "key." + HavenCreatorCam.MOD_ID + ".havencreatorcam",
            KeyConflictContext.IN_GAME,
            InputConstants.getKey(InputConstants.KEY_Z, -1),
            CATEGORY
    );
}
