
package com.ace.serialmodeplugin;

import com.ace.temarecuperarelab.interfaces.IModComunicare;
import com.ace.recuperare.Reteta;

public class SerialMode implements IModComunicare{

    @Override
    public String getModUniqueName() {
        return "Serial Mode";
    }

    @Override
    public String getModDisplayText() {
        return "Serial port communication.";
    }

    @Override
    public void send(Reteta r) {
        System.out.println(getModDisplayText() + " Recipe " + r.getReteta() + "sent to control software.");
    }
}
