package com.anupam.razorpay.common.util;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.UUID;

public class RandomizerUtil {

    private static final SecureRandom SECURE_RANDOM = new SecureRandom(); // SecureRandom is thread safe.

    public static String randomBase64(int length) {
        byte[] buf = new byte[length];
        SECURE_RANDOM.nextBytes(buf);

        return Base64.getUrlEncoder().withoutPadding().encodeToString(buf);
    }
}
