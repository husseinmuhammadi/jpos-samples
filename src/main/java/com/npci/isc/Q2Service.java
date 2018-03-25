package com.npci.isc;

import org.jpos.q2.Q2;

public class Q2Service implements Runnable {
    private Q2 q2;

    public Q2Service() {

    }

    public static void main(String[] args) {
        Q2Service server = new Q2Service();
        server.start();
    }

    private void start() {
        q2 = new Q2("deploy");
        (new Thread(this)).start();
    }

    public void run() {
        q2.run();
    }
}
