package test;

import org.junit.Test;

import com.service.me.ParserDataUtil;

public class ParserDataUtilTest {

	@Test
	public void testGetMessage() {
		byte[] in = { (byte) 0x3a, (byte) 0x02, (byte) 0x00, (byte) 0xaa,
				(byte) 0x01, (byte) 0x00, (byte) 0xad, (byte) 0x3a };
		byte[] result = ParserDataUtil.getMessage(in);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

	@Test
	public void testTransForm() {
		byte[] in = { (byte) 0x02, (byte) 0x00, (byte) 0xaa, (byte) 0x01,
				(byte) 0x00, (byte) 0xad };
		byte[] out = ParserDataUtil.transForm(in);
		for (int i = 0; i < out.length; i++) {
			System.out.println(out[i]);
		}
	}

	@Test
	public void testCheckMessage() {
		byte[] in = { (byte) 0x02, (byte) 0x00, (byte) 0xaa, (byte) 0x01,
				(byte) 0x00, (byte) 0xad };
		boolean result = ParserDataUtil.checkMessage(in);
		if (result) {
			System.out.println("OKKO");
		}
	}

}
