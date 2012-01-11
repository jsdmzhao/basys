package com.aisino2.common;

public class ImageUtil {
	public static String picConTemp = "R0lGODlhegCYAKIAAAAAAP///8zMzGZmZl5eXv///wAAAAAAACH5BAEAAAUALAAAAAB6AJgAAAP/OLrc/jDKSau9S+jNu/9gKI5kaZ7Kqa5s66LDK8903aV2ru8hzv/Ami9ILMKMyGQvpmw2h85oECqt6qjW7Ayr7bK43nAJLC6DyOb0Bq1Os9vlNzwsn3fr9iw+X93zo35/T0yCaoGFSIeIRYqLU4SOdJCRd5OUepaXfZmagJydg6BajaI0pKUyp6guqqtfn1kEHAS0tIawUrW1ArJzrTqyvbx2vza6tsfCYsXAG73KcbhRycPVbtJVz85tzMbJtrdq0BrjkuLf5V7dNeXpleff3NjTH+6j865X+Pk26/xL/5T4k4Fu1zU79szNSahuX648A41BdGikoK6DcIIRo6hE/5svjkk8wolIcNvHNsKUMfQkbpZLMyRZgJtlECbIgK9wJrqp80hPIjFXWJwZzUxKDytZlkl50VrRpeREJnUSVIVGqeGgOlOZVcyzr+S6hjHIdGoorVtN2jSa9uVatFHVPvUqwqxAnj+G2k1SNWDff3/5BW6xlypeIFxPpkk88nBet/LgxcPIVtDgEoWtXCaBrnHLDpl3fob8tjLpuXSReoZ7epnjnwBhA9mMinYp26Jwg9Ldibcm35eAUxIeibgj44uQI1JeiLnl17I9OP8znU/1idF/XN+Yncd2xd1zfF8dvh/08uMjlze/nn17U+fDpxf7nlX87vMp17e/P9X97CH5ldZfTgO2ECBqBfqUoAoHurbgCg1KgsGEFFZo4YUSJAAAOw==";
	
	public static byte[] getImageByte(String str) throws Exception{
		byte[] bkdxzp=null;
		if(!"".equals(str)){
			sun.misc.BASE64Decoder base64Decoder = new sun.misc.BASE64Decoder();
			bkdxzp = base64Decoder.decodeBuffer(str);
		}
		return bkdxzp;
	}
}
