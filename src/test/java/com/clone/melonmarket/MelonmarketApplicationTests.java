package com.clone.melonmarket;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MelonmarketApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void jasypt() {
		String url = "cloneproject4";
		String username = "AKIAX5IVUWAHM35NZL4B";
		String password = "ZlZISnq0gmnVmsnXHc7e6p8m0b5qsVwDcOaimw31";

		System.out.println("안뇽");
		System.out.println(jasyptEncoding(url));
		System.out.println(jasyptEncoding(username));
		System.out.println(jasyptEncoding(password));
	}

	public String jasyptEncoding(String value) {

		String key = "my_jasypt_key";
		StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
		pbeEnc.setAlgorithm("PBEWithMD5AndDES");
		pbeEnc.setPassword(key);
		return pbeEnc.encrypt(value);
	}


}
