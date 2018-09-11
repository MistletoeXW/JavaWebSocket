package Socket;

import java.net.*;
import java.util.Enumeration;

/*
 * @program: WebScoket
 * @description: InetAddres类测试
 * @author: xw
 * @create: 2018-09-05 18:46
 **/
public class Address {

    public static void main(String[] args){
        System.out.print(getInet4Address());
    }

    public static String getInet4Address() {
        Enumeration<NetworkInterface> nis;
        String ip = null;
        try {
            nis = NetworkInterface.getNetworkInterfaces();
            for (; nis.hasMoreElements();) {
                NetworkInterface ni = nis.nextElement();
                Enumeration<InetAddress> ias = ni.getInetAddresses();
                for (; ias.hasMoreElements();) {
                    InetAddress ia = ias.nextElement();
                    //ia instanceof Inet6Address && !ia.equals("")
                    if (ia instanceof Inet4Address && !ia.getHostAddress().equals("127.0.0.1")) {
                        ip = ia.getHostAddress();
                    }
                }
            }
        } catch (SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ip;
    }
}
