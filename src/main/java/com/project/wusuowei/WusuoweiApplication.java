package com.project.wusuowei;

import jakarta.annotation.PostConstruct;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;


@SpringBootApplication
@MapperScan("com.project.wusuowei.mapper")
public class WusuoweiApplication {
	public static void main(String[] args) throws Exception {
		System.out.println("wusuowei");
		SpringApplication.run(WusuoweiApplication.class, args);

	}

}
