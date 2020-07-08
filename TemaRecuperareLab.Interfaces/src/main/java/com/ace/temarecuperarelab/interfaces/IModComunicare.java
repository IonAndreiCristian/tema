
package com.ace.temarecuperarelab.interfaces;

import com.ace.recuperare.Reteta;

public interface IModComunicare {
    String getModUniqueName();
    String getModDisplayText();
    void send(Reteta r);
}
