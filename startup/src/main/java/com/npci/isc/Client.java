package com.npci.isc;

import com.npci.isc.packager.ShetabISO87APackager;
import org.jpos.iso.ISOChannel;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.channel.ASCIIChannel;
import org.jpos.util.LogSource;
import org.jpos.util.Logger;
import org.jpos.util.SimpleLogListener;

import java.io.IOException;

public class Client {
    public static void main(String[] args) {
        try {
            Logger logger = new Logger();
            logger.addListener(new SimpleLogListener(System.out));
            ISOChannel channel = new ASCIIChannel("localhost", 8000, new ShetabISO87APackager());
            ((LogSource) channel).setLogger(logger, "test-channel");
            channel.connect();
            ISOMsg m = new ISOMsg();
            m.setMTI("0800");
            m.set(3, "000000");
            m.set(41, "00000001");
            m.set(70, "301");
            channel.send(m);
            ISOMsg r = channel.receive();
            channel.disconnect();
        } catch (ISOException | IOException e) {
            e.printStackTrace();
        }
    }
}


