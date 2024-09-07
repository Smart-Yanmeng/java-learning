package com.celestia.testipfs;

import com.celestia.testipfs.utils.IpfsUtils;
import io.ipfs.api.MerkleNode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestIpfsApplication {

    public static void main(String[] args) {
//        SpringApplication.run(TestIpfsApplication.class, args);
//
//        MerkleNode merkleNode = IpfsUtils.addBytes("Hello, IPFS!".getBytes());
//        System.out.println(merkleNode);
//        System.out.println("Added file to IPFS with CID: " + merkleNode.hash.toBase58());

        byte[] bytes = IpfsUtils.getBytes("QmZaEQdUN9aj2UXzac2QHgDq5k2PHm6kMi17zJpRwwgKnm");
        System.out.println("Retrieved bytes from IPFS: " + new String(bytes));
    }
}
