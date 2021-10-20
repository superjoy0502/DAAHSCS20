package io.github.superjoy0502.daahscs20.custom;

public class RunePage {

    public String core;
    public String keystone;
    public String coreRune1;
    public String coreRune2;
    public String coreRune3;

    public String subCore;
    public String subRune1;
    public String subRune2;

    public RunePage(String core, String keystone, String coreRune1, String coreRune2, String coreRune3, String subCore, String subRune1, String subRune2) {

        this.core = core;
        this.keystone = keystone;
        this.coreRune1 = coreRune1;
        this.coreRune2 = coreRune2;
        this.coreRune3 = coreRune3;
        this.subCore = subCore;
        this.subRune1 = subRune1;
        this.subRune2 = subRune2;

    }

    public void PrintRunePageAsString() {
        System.out.printf(
                """
                Core Rune - %s
                Keystone Rune - %s
                Rune 1 - %s
                Rune 2 - %s
                Rune 3 - %s
                Sub Rune - %s
                Sub 1 - %s
                Sub 2 - %s
                """,
                core,
                keystone,
                coreRune1,
                coreRune2,
                coreRune3,
                subCore,
                subRune1,
                subRune2
        );
    }

}
