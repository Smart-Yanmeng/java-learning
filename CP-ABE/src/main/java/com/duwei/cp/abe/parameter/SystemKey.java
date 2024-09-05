package com.duwei.cp.abe.parameter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SystemKey {

    private PublicKey publicKey;
    private MasterPrivateKey masterPrivateKey;

    public static SystemKey build() {
        SystemKey systemKey = new SystemKey();
        PairingParameter pairingParameter = PairingParameter.getInstance();
        MasterPrivateKey masterPrivateKey = MasterPrivateKey.build(pairingParameter);
        PublicKey publicKey = PublicKey.build(pairingParameter, masterPrivateKey);
        systemKey.setPublicKey(publicKey);
        systemKey.setMasterPrivateKey(masterPrivateKey);

        return systemKey;
    }
}
