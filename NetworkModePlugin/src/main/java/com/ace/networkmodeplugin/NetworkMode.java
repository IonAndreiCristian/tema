
package com.ace.networkmodeplugin;

import com.ace.temarecuperarelab.interfaces.IModComunicare;
import com.ace.recuperare.Reteta;

public class NetworkMode implements IModComunicare{

    @Override
    public String getModUniqueName() {
        return "Network Mode";
    }

    @Override
    public String getModDisplayText() {
        return "Network communication.";
    }

    @Override
    public void send(Reteta r) {
        System.out.println(getModDisplayText() + " Recipe " + r.getReteta() + "sent to control software.");
    }
}
