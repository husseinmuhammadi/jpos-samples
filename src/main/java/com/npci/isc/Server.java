package com.npci.isc;

import com.npci.isc.packager.ShetabISO87APackager;
import org.jpos.iso.ISOServer;
import org.jpos.iso.ServerChannel;
import org.jpos.iso.channel.XMLChannel;
import org.jpos.util.LogSource;
import org.jpos.util.Logger;
import org.jpos.util.SimpleLogListener;

import java.io.IOException;

public class Server {
    public static void main(String[] args) {
        try {
            Logger logger = new Logger();
            logger.addListener(new SimpleLogListener(System.out));
            ServerChannel channel = new XMLChannel(new ShetabISO87APackager());
            ((LogSource) channel).setLogger(logger, "channel");
            ISOServer server = new ISOServer(8000, channel, null);
            server.setLogger(logger, "server");
            new Thread(server).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
