package br.edu.ifpb.sgd.cryptoAlgorithm;

import br.edu.ifpb.sgd.cryptoAlgorithm.implementantions.AesCryptoAlgorithm;
import br.edu.ifpb.sgd.cryptoAlgorithm.implementantions.RsaCryptoAlgorithm;
import br.edu.ifpb.sgd.cryptoAlgorithm.keystore.AesKeyStore;
import br.edu.ifpb.sgd.cryptoAlgorithm.keystore.RsaKeyStore;

import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class Main {

    public static void main(String[] args) throws Exception {
//        AesKeyStore aesKeyStore = new AesKeyStore();
//        RsaKeyStore rsaKeyStore = new RsaKeyStore();

//        aesKeyStore.generateKeyStore();
//        rsaKeyStore.generateKeyStore();


        testAes();
        System.out.printf("\n\n");
        testRsa();
    }

    private static void testAes() throws Exception {
        CryptoAlgorithm cryptoAlgorithm = new AesCryptoAlgorithm();

        String cifrado = cryptoAlgorithm.crypt("Hello World", new AesKeyStore().getKey());

        System.out.println(cifrado);

        System.out.println(cryptoAlgorithm.decrypt(cifrado, new AesKeyStore().getKey()));
    }

    private static void testRsa() throws Exception {
        CryptoAlgorithm cryptoAlgorithm = new RsaCryptoAlgorithm();

        String cifrado = cryptoAlgorithm.crypt("Hello World", new RsaKeyStore().getPublicKey());
        System.out.println(cifrado);

        System.out.println(cryptoAlgorithm.decrypt(cifrado, new RsaKeyStore().getPrivateKey()));
    }
}
