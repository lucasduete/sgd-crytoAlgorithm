package br.edu.ifpb.sgd.cryptoAlgorithm;

import br.edu.ifpb.sgd.cryptoAlgorithm.implementantions.AesCryptoAlgorithm;
import br.edu.ifpb.sgd.cryptoAlgorithm.implementantions.RsaCryptoAlgorithm;

import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class Main {

    public static void main(String[] args) throws Exception {



    }

    private static void testAes() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);

        byte[] key = keyGenerator.generateKey().getEncoded();
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");

        CryptoAlgorithm cryptoAlgorithm = new AesCryptoAlgorithm();

        String cifrado = cryptoAlgorithm.crypt("Hello World", keySpec);

        System.out.println(cifrado);

        System.out.println(cryptoAlgorithm.decrypt(cifrado, keySpec));
    }

    private static void testRsa() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(4096);

        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        CryptoAlgorithm cryptoAlgorithm = new RsaCryptoAlgorithm();

        String cifrado = cryptoAlgorithm.crypt("Hello World", keyPair.getPublic());
        System.out.println(cifrado);

        System.out.println(cryptoAlgorithm.decrypt(cifrado, keyPair.getPrivate()));
    }
}
