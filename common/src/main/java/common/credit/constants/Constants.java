package common.credit.constants;


public class Constants {

    public static final String nick_name = "nick name";

    // 系统版本
    public static final String SYSTEM_VERSION = "1.0.0";

    // 白名单设置
    public static final String WHITE_LIST = "72.160.3.204, 127.0.0.1";

    // 线程数
    public final static int THREAD_COUNT = 5;

    // 处理间隔时间
    public final static int INTERVAL_MILS = 0;

    // consumer失败后等待时间(mils)
    public static final int ONE_SECOND = 1 * 1000;

    // 异常sleep时间(mils)
    public static final int ONE_MINUTE = 1 * 60 * 1000;

    // MQ消息retry时间
    public static final int RETRY_TIME_INTERVAL = ONE_MINUTE;

    // MQ消息有效时间
    public static final int VALID_TIME = ONE_MINUTE;

    // app id
    public static final String APP_ID = "123456";

    // private key
    public static final String PRIVATE_KEY = "123456";

    public static final String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDl5eloqFM/QEp5kVXTNwmpTlAMpFXqi8V"
            + "+B43YkUCGANwlpzQKJKY49fHzPRHRQlMX3XtKkXAKYnx7PSOt0sONyMu7HIkD1FOqfeKCcAxuyzCdpwfl4UVZh+HjgWbGCv+AZS43W4rC"
            + "/KCWlAjuX1rXbwcA9wUap2Yoen75pj0reThoiCbzt6tw9Fboqhfk0EAoTZGpkZ0E3Qpy/eLW"
            + "+G0fssqVUkOFR5VfYZhUXDceHNxBjXUxrpOZIJ0Vf0Kk280e0bxnOvumyD1syAQ3hsjhfBWxA0B8pxyLuMM462Di1Z0tPF2ul9yD5BG"
            + "++o3PbeXLARJIbrQFWNkx6AsgZMSlAgMBAAECggEAA2RkEEZDjDBfqPGLCaXLP7NHHRijp+VOEbD819A02oVSuj+AVhH6XebLHiKti5/l5"
            + "/k9o3kH5S9U1OCvERaGCiaHUwh1wRe18FMRL4mFtXDME9duF2c+hbaqj5fOM2fgIz3a87gnEP93QyGGDDZd+cXKnaoHakBEEp7UFszsJCMLl6v4LbS"
            + "+ZKV5SFhYMqWHbpxMzwtrHY3Wk/uZr6MpL7LJHJbGpUj1SpPsIBLSS8UTQOJoeO8oxPj"
            + "/+Noec6cWy6e00TZFgOgtoXLgdgRP2c3njN3DHxKaeebwpVjO"
            +
            "+C0s4I3NGhQEm7zORfsGMLTDsURf3gy5NKkux3pR61vBIQKBgQD45lSpmnNizcJVk1WUHfw6VkU2co1ihGnKQKLbKxqS8K8BQA30H7lRf1ERZZPUR4jsFXPkDLBZ8ZUNYUn3+Ce92fKixmZ5ILPhwTZ0q44/DdTsVfIShb99e711WlAoYFx7ZGYeGavGnRTCuojH/7ducNrDxA8JjZBbe6c8gtOuvQKBgQDsdNDIWuAv6epHzRbzwzG383XYm9Imp2Dy8OsiWMepPqREVhc+LDZ8H0eru3AhjniqByBbDDSTGbUjuxE1BtXTxWaFIf948i0Z2X+VIma0J1/ahmaxUUCxMgW/oVT7XAxPp9R8gMVAlr/zeaTSU0x3WAOXNQ+l3ZqTPtSwhUwgCQKBgQCZlsBdnFJhgOjPl8gyS0KO2ReCnrOCPIVvae1U40dVrzG+ysERiNX5ZWAoJQ9Q6gei7yYBbpcQGZRJmmRjoP0dGTWxnk4zpqt5vpmU6xwu6qEeaXakWWYtz8K8fMuD7tqCxhSBtIOcXugltaecCr8tZnSIYx6IXZPb7/Tl0TFA3QKBgCVSKsH01f26BehfToga/vXxz1/o+DpxoLO3ouVA7gKgiHzgubpucAsXRNCuPPyO6CyuA0Vbn9C39gc1t3mPIqDSP2Q0AYatcsDpu2FmlJ9Kt65eGEdUc8mEA7RDWo5x8N+BteAQ0xFmudVMFd+8lg0gLzDmhxm+6G7lM9zIrUNBAoGBAOBCmTjhCMZ1lGNN2LUhLvpRYcDivB3SE9OOC9wi8En4iHg9w0CtXVfJOKTTjPcajLLMtfIPHsRYDTNnSX/ysJGY39W8YKW3S8mCWgBMprAX2wMq1wKA7o+hB+aiKRtPYujjZ3vS/IBdUAl+Vg1Czjw5JLc0fz8nO9zmlnKVlMGr";
    ;

    public static final String alipayPublicKey
            =
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA5eXpaKhTP0BKeZFV0zcJqU5QDKRV6ovFfgeN2JFAhgDcJac0CiSmOPXx8z0R0UJTF917SpFwCmJ8ez0jrdLDjcjLuxyJA9RTqn3ignAMbsswnacH5eFFWYfh44Fmxgr/gGUuN1uKwvyglpQI7l9a128HAPcFGqdmKHp++aY9K3k4aIgm87ercPRW6KoX5NBAKE2RqZGdBN0Kcv3i1vhtH7LKlVJDhUeVX2GYVFw3HhzcQY11Ma6TmSCdFX9CpNvNHtG8Zzr7psg9bMgEN4bI4XwVsQNAfKcci7jDOOtg4tWdLTxdrpfcg+QRvvqNz23lywESSG60BVjZMegLIGTEpQIDAQAB";
    ;


    // maybe change in product env.
    public static final String REQUEST_URL = "http://supergwext-1-64.test.dl.alipaydev.com/HNXT85/HNXT8579142.htm";

    // debug开关开启
    public static final int IS_DEBUG = 0;

}
