package com.npci.isc.listener;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISORequestListener;
import org.jpos.iso.ISOSource;

import java.io.IOException;

/**
 * Created by h.mohammadi on 3/19/2018.
 */
public class RequestListener implements ISORequestListener {
    public boolean process(ISOSource isoSource, ISOMsg isoMsg) {
        try {
            isoSource.send(isoMsg);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ISOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
