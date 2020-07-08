
package com.ace.networkmodeplugin;

import com.ace.temarecuperarelab.interfaces.IPluginsAppPlugin;
import com.ace.temarecuperarelab.interfaces.IModComunicare;

public class NetworkModePlugin implements IPluginsAppPlugin{

    @Override
    public String getUniqueNameText() {
        return "NetworkModePlugin";
    }

    @Override
    public String getDisplayText() {
        return "Network Mode";
    }

    @Override
    public IModComunicare getMode() {
        return new NetworkMode();
    }
}
