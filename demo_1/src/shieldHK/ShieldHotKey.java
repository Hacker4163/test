package shieldHK;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ShieldHotKey {
        static{
            System.load("D:/shieldHK.dll");
        }
        public static native void Attach();//启动屏蔽
        public static native void Detach();//关闭屏蔽
}
