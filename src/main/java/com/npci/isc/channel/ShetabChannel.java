package com.npci.isc.channel;

import org.jpos.iso.FilteredChannel;
import org.jpos.iso.ISOFilter;
import org.jpos.iso.channel.ASCIIChannel;

public class ShetabChannel extends ASCIIChannel implements FilteredChannel {
    @Override
    public void addIncomingFilter(ISOFilter filter) {
        super.addIncomingFilter(filter);
    }
}
