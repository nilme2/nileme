package me.nilme.exercise.java.concurrent;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface Clibrary extends Library {

    // [Native.synchronizedLibrary] 阻止多线程同时访问本地代码
    Clibrary INSTANTCE = (Clibrary) Native.synchronizedLibrary(
            (Clibrary) Native.loadLibrary(
                    Clibrary.class.getClassLoader().getResource("libsalt.so").getPath()
                    , Clibrary.class
            )
    );

    String getSignCode(byte[] bArr, byte[] bArr2, byte[] bArr3);

    String[] getSignRequest(String str, byte[] bArr, byte[] bArr2, byte[] bArr3);

}
