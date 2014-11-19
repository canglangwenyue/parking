package com.service.me;

public class ParserDataUtil {

	/**
	 * 处理接收到的信息
	 * 
	 * @param in
	 *            输入byte数组
	 * @return 返回去掉首尾tag的byte数组
	 */
	public static byte[] getMessage(byte[] in) {
		int msgLengh = in.length;
		if (in[0] != 58 || in[msgLengh - 1] != 58) {
			return null;
		} else {
			byte[] out = new byte[msgLengh - 2];
			System.arraycopy(in, 1, out, 0, msgLengh - 2);
			return out;
		}

	}

	/**
	 * 转义还原
	 * 
	 * @param in
	 * @return
	 */
	public static byte[] transForm(byte[] in) {
		int count = 0;
		for (int i = 0; i < in.length; i++)
			if (in[i] == 58)
				count++;

		byte[] out = new byte[in.length - count];
		for (int i = 0, j = 0; i < out.length; i++, j++) {
			if (in[i] == 58) {
				out[j] = 39;
				i++;
			} else {
				out[j] = in[i];
			}
		}
		return out;
	}

	/**
	 * 和校验
	 * 
	 * @param in
	 * @return
	 */
	public static boolean checkMessage(byte[] in) {
		int msgLength = in.length;
		int cheskSum = 0;
		for (int i = 0; i < in.length - 1; i++) {
			cheskSum += in[i];
		}
		if (cheskSum == in[msgLength - 1])
			return true;
		return false;
	}
}
