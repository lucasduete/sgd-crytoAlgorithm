package br.edu.ifpb.sgd.cryptoAlgorithm;

import java.security.Key;

public interface CryptoAlgorithm {

    public String crypt(String plainText, Key key) throws Exception;
    public String decrypt(String cifredText, Key key) throws Exception;

}
