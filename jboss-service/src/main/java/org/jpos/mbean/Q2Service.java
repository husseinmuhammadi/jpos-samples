package org.jpos.mbean;

import org.jpos.q2.Q2;

public class Q2Service implements Q2ServiceMBean, Runnable {

    private Q2 q2;

    @Override
    public void run() {
        q2.start();
    }

    public void start() throws Exception {
        System.out.println("\n\ntStarting start() MyServerMonitor invoked");
        String deployPath[] = {
                "-d", "q2/deploy"
        };
        q2 = new Q2(deployPath);
        (new Thread(this)).start();
        System.out.println("Q2Service started.");
    }

    public void stop() throws Exception {
        System.out.println("\n\ntStopping stop() MyServerMonitor  invoked");
        q2.shutdown();
        System.out.println("Q2Service stopped.");
    }
}
