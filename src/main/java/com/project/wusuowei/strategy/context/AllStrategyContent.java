package com.project.wusuowei.strategy.context;

import com.project.wusuowei.config.KeyConfig;
import com.project.wusuowei.utils.LoadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

/**
 * @Author:无所为
 * @Description: T0D0
 * @DataTime: 2024-10-25 18:19
 **/
@Service
public class AllStrategyContent {
    @Autowired
    private KeyConfig keyConfig;
        public void all() throws Exception {
            PublicKey loadedPublicKey = LoadUtil.loadPublicKey(keyConfig.getUseAllPath());
            PrivateKey loadedPrivateKey = LoadUtil.loadPrivateKey(keyConfig.getUsrAllPath());
            String message = "This is a test message";
            Signature signer = Signature.getInstance("SHA256withRSA");
            signer.initSign(loadedPrivateKey);
            signer.update(message.getBytes());
            byte[] signature = signer.sign();
            Signature verifier = Signature.getInstance("SHA256withRSA");
            verifier.initVerify(loadedPublicKey);
            verifier.update(message.getBytes());
            boolean isValid = verifier.verify(signature);
            System.err.println(isValid);
            if (!isValid) {
                System.exit(0);
            }
        }
}
