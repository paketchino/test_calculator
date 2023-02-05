package calculator.enumValue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum Roman {

        I(1), IV(4), V(5), IX(9), X(10), XL(40),
        L(50), XC(90), C( 100), D( 500), M( 1000);
        final int val;

        Roman(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        @Override
        public String toString() {
            return "Roman{" +
                    "val=" + val +
                    '}';
        }

        public static List<Roman> sorted() {
            Roman[] values = Roman.values();
            return Arrays.stream(values)
                    .sorted(Comparator.comparing((Roman e) -> e.val).reversed())
                    .collect(Collectors.toList());
        }
}

