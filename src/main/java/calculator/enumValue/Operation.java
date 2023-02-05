package calculator.enumValue;

public enum Operation {
    ADDING {
        @Override
        public int action(int x, int y) {
            return x + y;
        }
    },
    DIVIDE {
        @Override
        public int action(int x, int y) {
            return x / y;
        }
    },
    MULTI {
        @Override
        public int action(int x, int y) {
            return x * y;
        }
    },
    SUBTRACT {
        @Override
        public int action(int x, int y) {
            return x - y;
        }
    };

    public abstract int action(int x, int y);

}