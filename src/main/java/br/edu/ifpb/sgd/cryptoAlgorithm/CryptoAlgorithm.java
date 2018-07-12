package br.edu.ifpb.sgd.cryptoAlgorithm;

public interface CryptoAlgorithm {

    public String crypt(String plainText);
    public String decrypt(String cifredText);

}
