package com.npci.isc;

import com.npci.isc.packager.ShetabISO87APackager;
import org.jpos.iso.*;
import org.jpos.util.*;
import org.jpos.iso.channel.*;
import org.jpos.iso.packager.*;

public class Client  {
    public static void main (String[] args) throws Exception {
        Logger logger = new Logger();
        logger.addListener (new SimpleLogListener (System.out));
        ISOChannel channel = new ASCIIChannel (
                "172.22.113.21", 8000, new ShetabISO87APackager()
        );
        ((LogSource)channel).setLogger (logger, "test-channel");
        channel.connect ();
        ISOMsg m = new ISOMsg ();
        m.setMTI ("0800");
        m.set (3, "000000");
        m.set (41, "00000001");
        m.set (70, "301");
        channel.send (m);
        ISOMsg r = channel.receive ();
        channel.disconnect ();
    }
}