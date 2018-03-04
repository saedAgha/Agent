package agent.hardwareDetails;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class HardwareDetails {
	public static String GetMacAddress() {

		String macAddressStr = "";

		try {
			InetAddress ip = GetIP();
			byte[] mac;
			NetworkInterface network = NetworkInterface.getByInetAddress(ip);
			mac = network.getHardwareAddress();

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < mac.length; i++) {
				sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
			}
			macAddressStr = sb.toString();

		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return macAddressStr;

	}

	public static InetAddress GetIP() {
		InetAddress ip = null;
		try {
			ip = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ip;

	}
	


	public HardwareDetails() {
		// TODO Auto-generated constructor stub
	}

}
