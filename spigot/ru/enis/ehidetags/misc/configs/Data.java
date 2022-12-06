package ru.enis.ehidetags.misc.configs;

public class Data {
    public static class ACTIONBAR {
        public static Boolean ENABLE;
        public static Boolean USE_TAME;
        public static String MESSAGE;
    }
    public static class TITLE{
        public static Boolean ENABLE;
        public static Boolean USE_TAME;
        public static String MESSAGE;
    }
    public static class MESSAGE {
        public static String PREFIX;
        public static class HELP {
            public static String RELOAD;
        }
        public static class ERROR {
            public static String PERMISSION, USAGE;
        }
        public static class SUCCESS {
            public static String RELOAD;
        }
    }
}
