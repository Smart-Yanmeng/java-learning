package com.celestia.testipfs.utils;

import io.ipfs.api.IPFS;
import io.ipfs.api.MerkleNode;
import io.ipfs.api.NamedStreamable;
import io.ipfs.multihash.Multihash;

import java.io.File;
import java.io.IOException;

public class IpfsUtils {

    private static final IPFS ipfs = new IPFS("/ip4/127.0.0.1/tcp/5001");

    public static MerkleNode addFile(File file) {

        try {
            NamedStreamable.FileWrapper fileWrapper = new NamedStreamable.FileWrapper(file);

            return ipfs.add(fileWrapper).getFirst();
        } catch (Exception e) {

            throw new RuntimeException("Error adding file to IPFS", e);
        }
    }

    public static MerkleNode addBytes(byte[] bytes) {

        try {
            NamedStreamable.ByteArrayWrapper byteArrayWrapper = new NamedStreamable.ByteArrayWrapper(bytes);

            return ipfs.add(byteArrayWrapper).getFirst();
        } catch (Exception e) {

            throw new RuntimeException("Error adding bytes to IPFS", e);
        }
    }

    public static byte[] getBytes(String cid) {

        try {
            return ipfs.cat(Multihash.fromBase58(cid));
        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }
}
