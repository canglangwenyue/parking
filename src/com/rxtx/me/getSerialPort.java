package com.rxtx.me;

import gnu.io.CommPortIdentifier;

import java.util.Enumeration;

/**
 * @author canglangwenyue 测试方法列出宿主计算机的可用串口
 * 
 */
public class getSerialPort {
	static CommPortIdentifier portId;
	static Enumeration portList;
	static int bauds[] = { 9600, 19200, 57600, 115200 };

	public static void main(String[] args) {
		portList = CommPortIdentifier.getPortIdentifiers();
		while (portList.hasMoreElements()) {
			portId = (CommPortIdentifier) portList.nextElement();
			if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
				System.out.println("Find CommPort: " + portId.getName());
			}
		}
	}
}
