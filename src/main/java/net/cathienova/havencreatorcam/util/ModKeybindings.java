package net.cathienova.havencreatorcam.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.neoforge.client.settings.KeyConflictContext;

public class ModKeybindings
{
    public static final ModKeybindings INSTANCE = new ModKeybindings();

    private ModKeybindings() {}

    private static final String CATEGORY = "key.categories.havencreatorcam";

    public final KeyMapping creatorcam = new KeyMapping(
            "key.havencreatorcam.havencreatorcam",
            KeyConflictContext.IN_GAME,
            InputConstants.getKey(InputConstants.KEY_Z, -1),
            CATEGORY
    );
}
