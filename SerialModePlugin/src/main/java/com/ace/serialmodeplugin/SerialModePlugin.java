
package com.ace.serialmodeplugin;

import com.ace.temarecuperarelab.interfaces.IPluginsAppPlugin;
import com.ace.temarecuperarelab.interfaces.IModComunicare;

public class SerialModePlugin implements IPluginsAppPlugin{

    @Override
    public String getUniqueNameText() {
        return "SerialModePlugin";
    }

    @Override
    public String getDisplayText() {
        return "Serial Mode";
    }

    @Override
    public IModComunicare getMode() {
        return new SerialMode();
    }
}
