package org.xstefank;

public class Main {
    public static void main(String[] args) {
        GoodDummy goodDummy = new GoodDummy();

        printDummy(goodDummy);
                    
        DummyOverride dummyOverride = new DummyOverride();

        printDummy(dummyOverride);
    }

    private static void printDummy(Dummy dummy) {
        System.out.println(dummy.getFoo());
        System.out.println(dummy.getBar());
    }
}
