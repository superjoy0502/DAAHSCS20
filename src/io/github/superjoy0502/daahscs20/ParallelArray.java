package io.github.superjoy0502.daahscs20;

import io.github.superjoy0502.daahscs20.custom.Rune;
import io.github.superjoy0502.daahscs20.custom.RunePage;

import java.util.Scanner;

public class ParallelArray {

    public void Initialize() {

        Scanner scanner = new Scanner(System.in);
        String champion = "";
        RunePage runePage = null;
        int cmd;
        int cmdChamp;

        String[] champions = {
                "Fiora",
                "Aatrox",
                "Camile",
                "Darius",
                "Poppy",
                "Graves",
                "Lee Sin",
                "Elise",
                "Talon"
        };

        RunePage[] runePages = {
            new RunePage(
                    Rune.Core.PRECISION,
                    Rune.Precision.Keystone.CONQUEROR,
                    Rune.Precision.Heroism.TRIUMPH,
                    Rune.Precision.Legend.ALACRITY,
                    Rune.Precision.Combat.COUP_DE_GRACE,
                    Rune.Core.RESOLVE,
                    Rune.Resolve.Strength.DEMOLISH,
                    Rune.Resolve.Resistance.BONE_PLATING
            ),
            new RunePage(
                    Rune.Core.PRECISION,
                    Rune.Precision.Keystone.CONQUEROR,
                    Rune.Precision.Heroism.TRIUMPH,
                    Rune.Precision.Legend.TENACITY,
                    Rune.Precision.Combat.LAST_STAND,
                    Rune.Core.RESOLVE,
                    Rune.Resolve.Resistance.BONE_PLATING,
                    Rune.Resolve.Vitality.REVITALIZE
            ),
            new RunePage(
                    Rune.Core.RESOLVE,
                    Rune.Resolve.Keystone.GRASP_OF_THE_UNDYING,
                    Rune.Resolve.Strength.SHIELD_BASH,
                    Rune.Resolve.Resistance.BONE_PLATING,
                    Rune.Resolve.Vitality.OVERGROWTH,
                    Rune.Core.INSPIRATION,
                    Rune.Inspiration.Contraption.MAGICAL_FOOTWEAR,
                    Rune.Inspiration.Tomorrow.BISCUIT_DELIVERY
            )
        };

        System.out.print("""
                Welcome to League of Legends Champion Rune Viewer!
                Please enter your lane:
                \t1. TOP
                \t2. JUNGLE
                \t3. MIDDLE
                \t4. BOTTOM
                \t5. SUPPORT
                >> 
                """);

        cmd = scanner.nextInt();

        if (0 >= cmd || 6 <= cmd ) {
            System.out.println("Please enter a proper option.");
            Initialize();
        }

        String championsString = switch (cmd) {

            case 1 -> """
                    \t1. Fiora
                    \t2. Aatrox
                    \t3. Camile
                    \t4. Darius
                    \t5. Poppy
                    """;

            case 2 -> """
                    \t6. Graves
                    \t7. Lee Sin
                    \t8. Elise
                    \t9. Talon
                    """;

            case 3 -> """
                    \t10. Talon
                    \t11. Vex
                    \t12. Akshan
                    \t13. Katarina
                    \t14. LeBlanc
                    """;

            case 4 -> """
                    \t15. Miss Fortune
                    \t16. Vayne
                    """;

            case 5 -> """
                    \t17. Amumu
                    \t18. Blitzcrank
                    \t19. Leona
                    \t20. Maokai
                    """;

            default -> throw new IllegalStateException("Unexpected value: " + cmd);
        };

        System.out.printf("Please choose a champion you'd like to see the Rune of: \n%s", championsString);
        cmdChamp = scanner.nextInt();
        cmdChamp -= 1;

        champion = champions[cmdChamp];
        runePage = runePages[cmdChamp];

        System.out.printf("Recommended Runes for %s is: \n==========================================================\n",
                champion);
        if (runePage != null) runePage.PrintRunePageAsString();

    }

}
