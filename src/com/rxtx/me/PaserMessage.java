package com.rxtx.me;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.entity.me.ParkData;
import com.service.me.MyLogger;
import com.service.me.ParserDataUtil;
import com.service.me.myPaser;

public class PaserMessage {

	static Logger mylog = LogManager.getLogger(MyLogger.class);

	/**
	 * for a test
	 * 
	 * @param in
	 * @return
	 */
	static byte[] test = { (byte) 0x3a, (byte) 0x02, (byte) 0x02, (byte) 0xaa,
			(byte) 0x03, (byte) 0x00, (byte) 0xad, (byte) 0x3a };

	public static boolean Paser(byte[] in) {
		List<String> addressList = new ArrayList<String>();
		List<String> statusList = new ArrayList<String>();
		ParkData data = new ParkData();
		myPaser paser = new myPaser();
		byte[] msg = ParserDataUtil.getMessage(in);
		if (msg == null) {
			return false;
		}
		msg = ParserDataUtil.transForm(msg);
		if (ParserDataUtil.checkMessage(msg) == false) {
			return false;
		}
		mylog.info("数据校验通过");
		byte[] temp = new byte[msg[0] * 2];
		System.arraycopy(msg, 1, temp, 0, msg[0] * 2);
		for (int i = 0; i < temp.length; i = i + 2) {
			System.out.println("address" + temp[i]);
			addressList.add(String.valueOf(temp[i]));
		}
		for (int i = 1; i < temp.length; i = i + 2) {
			System.out.println("status" + temp[i]);
			if (temp[i] == -86)
				temp[i] = 1;
			statusList.add(String.valueOf(temp[i]));
		}
		for (int i = 0; i < temp.length / 2; i++) {
			boolean exits = paser.checkUserExistsWithName(addressList.get(i));
			data.setAddress(addressList.get(i));
			data.setStatus(statusList.get(i));
			if (exits) {
				paser.update(data);
			} else {
				paser.add(data);
			}
		}
		// 所有操作结束后，关闭连接，若是采用dataDealDaoImpl中的方式用finally每次使用后来关闭会引发
		// No operations allowed after connection closed.异常
		// 因为使用了static
		paser.closeConnection();

		return true;

	}

	/**
	 * just for a test
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Paser(test);
	}

}
