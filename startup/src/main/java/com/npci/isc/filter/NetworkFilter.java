package com.npci.isc.filter;

import org.jpos.iso.ISOChannel;
import org.jpos.iso.ISOFilter;
import org.jpos.iso.ISOMsg;
import org.jpos.util.LogEvent;

public class NetworkFilter implements ISOFilter {
    public ISOMsg filter(ISOChannel isoChannel, ISOMsg isoMsg, LogEvent logEvent) throws VetoException {
        return null;
    }
}
