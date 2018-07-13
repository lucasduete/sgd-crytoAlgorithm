package br.edu.ifpb.sgd.cryptoAlgorithm;

import br.edu.ifpb.sgd.cryptoAlgorithm.implementantions.AesCryptoAlgorithm;
import br.edu.ifpb.sgd.cryptoAlgorithm.implementantions.DesCryptoAlgorithm;
import br.edu.ifpb.sgd.cryptoAlgorithm.implementantions.RsaCryptoAlgorithm;

import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class Main {

    public static void main(String[] args) throws Exception {

        testDes();

        System.out.printf("\n\n");

        testAes();

        System.out.printf("\n\n");

        testRsa();
    }

    private static void testDes() throws Exception {

        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");

        byte[] key = keyGenerator.generateKey().getEncoded();
        SecretKeySpec keySpec = new SecretKeySpec(key, "DES");

        CryptoAlgorithm cryptoAlgorithm = new DesCryptoAlgorithm();

        String cifrado = cryptoAlgorithm.crypt("Hello World", keySpec);

        System.out.println(cifrado);

        System.out.println(cryptoAlgorithm.decrypt(cifrado, keySpec));
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
