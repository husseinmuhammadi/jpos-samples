package com.npci.isc;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.MUX;
import org.jpos.q2.Q2;
import org.jpos.util.Logger;
import org.jpos.util.NameRegistrar;

public class Q2Service implements Runnable {
    private Q2 q2;
    private static MUX mux;

    public Q2Service() {

    }

    public static void main(String[] args) {
        try {
            Q2Service server = new Q2Service();
            server.start();

            Logger logger = new Logger();
            System.out.println("**************************************");
            mux = (MUX) NameRegistrar.getIfExists("mux.jPOS-AUTORESPONDER");
            System.out.println("mux: " + mux);

            Thread.sleep(3000);
            System.out.println("**************************************");
            mux = (MUX) NameRegistrar.getIfExists("mux.jPOS-AUTORESPONDER");
            if (mux != null && mux.isConnected()) {
                System.out.println("mux is connected");
                ISOMsg response = mux.request(generateISOMsg(), 10000);
            } else {
                System.out.println("mux is not connected");
            }
            System.out.println("**************************************");


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ISOException e) {
            e.printStackTrace();
        }
    }

    private static ISOMsg generateISOMsg() throws ISOException {
        ISOMsg isoMsg = new ISOMsg();
        isoMsg.setMTI("0800");
        isoMsg.set(11, "000001");
        isoMsg.set(41, "00000001");
        isoMsg.set("70", "301");
        return isoMsg;
    }

    private void start() {
        q2 = new Q2("deploy");
        (new Thread(this)).start();
    }

    public void run() {
        q2.run();
    }
}
