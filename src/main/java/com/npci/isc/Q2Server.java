package com.npci.isc;

import org.jpos.q2.Q2;

/**
 * Created by h.mohammadi on 3/19/2018.
 */
public class Q2Server implements Runnable {
    private Q2 q2Server;

    public static void main(String[] args) {
        Q2Server server = new Q2Server();
        server.start();
    }

    private void start() {
        q2Server = new Q2("C:\\jpos\\deploy");
        (new Thread(this)).start();
    }

    public void run() {
        q2Server.run();
    }
}
