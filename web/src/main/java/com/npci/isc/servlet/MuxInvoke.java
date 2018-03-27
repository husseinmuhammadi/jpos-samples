package com.npci.isc.servlet;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.MUX;
import org.jpos.util.NameRegistrar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MuxInvoke extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doGet(req, resp);

        try {
            MUX mux = (MUX) NameRegistrar.getIfExists("mux.jPOS-AUTORESPONDER");
            if (mux != null && mux.isConnected()) {
                System.out.println("mux is connected");
                ISOMsg response = mux.request(generateISOMsg(), 10000);
            } else {
                System.out.println("mux is not connected");
            }
        } catch (ISOException e) {
            e.printStackTrace();
        }
    }

    private ISOMsg generateISOMsg() throws ISOException {
        ISOMsg isoMsg = new ISOMsg();
        isoMsg.setMTI("0800");
        isoMsg.set(11, "000001");
        isoMsg.set(41, "00000001");
        isoMsg.set("70", "301");
        return isoMsg;
    }
}
