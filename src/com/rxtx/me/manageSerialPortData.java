package com.rxtx.me;

public class manageSerialPortData {

	public static void main(String[] args) {
		getDataObserver observer = new getDataObserver();
		observer.openSerialPort("start service");
	}

}
