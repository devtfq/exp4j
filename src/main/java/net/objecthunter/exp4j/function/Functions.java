/*
 * Copyright 2014 Frank Asseg
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.objecthunter.exp4j.function;

/**
 * Class representing the builtin functions available for use in expressions
 */
public class Functions {
    
    private static final int INDEX_SQRT = 0;
    private static final int INDEX_CBRT = 1;
    private static final int INDEX_ABS = 2;
    private static final int INDEX_CEIL = 3;
    private static final int INDEX_FLOOR = 4;
    private static final int INDEX_POW = 5;
    private static final int INDEX_EXP = 6;
    private static final int INDEX_EXPM1 =7;
    private static final int INDEX_LOG10 = 8;
    private static final int INDEX_LOG2 = 9;
    private static final int INDEX_LOG = 10;
    private static final int INDEX_LOG1P = 11;
    private static final int INDEX_LOGB = 12;
    private static final int INDEX_SGN = 13;
    private static final int INDEX_TO_RADIAN = 14;
    private static final int INDEX_TO_DEGREE = 15;

    private static final Function[] BUILT_IN_FUNCTIONS = new Function[16];

    static {
        
        BUILT_IN_FUNCTIONS[INDEX_LOG] = new Function("log") {
            @Override
            public double apply(double... args) {
                return Math.log(args[0]);
            }
        };
        BUILT_IN_FUNCTIONS[INDEX_LOG2] = new Function("log2") {
            @Override
            public double apply(double... args) {
                return Math.log(args[0]) / Math.log(2d);
            }
        };
        BUILT_IN_FUNCTIONS[INDEX_LOG10] = new Function("log10") {
            @Override
            public double apply(double... args) {
                return Math.log10(args[0]);
            }
        };
        BUILT_IN_FUNCTIONS[INDEX_LOG1P] = new Function("log1p") {
            @Override
            public double apply(double... args) {
                return Math.log1p(args[0]);
            }
        };
        BUILT_IN_FUNCTIONS[INDEX_ABS] = new Function("abs") {
            @Override
            public double apply(double... args) {
                return Math.abs(args[0]);
            }
        };
        BUILT_IN_FUNCTIONS[INDEX_CBRT] = new Function("cbrt") {
            @Override
            public double apply(double... args) {
                return Math.cbrt(args[0]);
            }
        };
        BUILT_IN_FUNCTIONS[INDEX_FLOOR] = new Function("floor") {
            @Override
            public double apply(double... args) {
                return Math.floor(args[0]);
            }
        };
        BUILT_IN_FUNCTIONS[INDEX_SQRT] = new Function("sqrt") {
            @Override
            public double apply(double... args) {
                return Math.sqrt(args[0]);
            }
        };
       BUILT_IN_FUNCTIONS[INDEX_CEIL] = new Function("ceil") {
            @Override
            public double apply(double... args) {
                return Math.ceil(args[0]);
            }
        };
        BUILT_IN_FUNCTIONS[INDEX_POW] = new Function("pow", 2) {
            @Override
            public double apply(double... args) {
                return Math.pow(args[0], args[1]);
            }
        };
        BUILT_IN_FUNCTIONS[INDEX_EXP] = new Function("exp", 1) {
            @Override
            public double apply(double... args) {
                return Math.exp(args[0]);
            }
        };
        BUILT_IN_FUNCTIONS[INDEX_EXPM1] = new Function("expm1", 1) {
            @Override
            public double apply(double... args) {
                return Math.expm1(args[0]);
            }
        };
        BUILT_IN_FUNCTIONS[INDEX_SGN] = new Function("signum", 1) {
            @Override
            public double apply(double... args) {
                if (args[0] > 0) {
                    return 1;
                } else if (args[0] < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };
        BUILT_IN_FUNCTIONS[INDEX_LOGB] = new Function("logb", 2) {
            @Override
            public double apply(double... args) {
                return Math.log(args[1]) / Math.log(args[0]);
            }
        };
        BUILT_IN_FUNCTIONS[INDEX_TO_RADIAN] = new Function("toradian") {
            @Override
            public double apply(double... args) {
                return Math.toRadians(args[0]);
            }
        };
        BUILT_IN_FUNCTIONS[INDEX_TO_DEGREE] = new Function("todegree") {
            @Override
            public double apply(double... args) {
                return Math.toDegrees(args[0]);
            }
        };

    }

    /**
     * Get the builtin function for a given name
     *
     * @param name te name of the function
     * @return a Function instance
     */
    public static Function getBuiltinFunction(final String name) {

        switch (name) {
            case "abs":
                return BUILT_IN_FUNCTIONS[INDEX_ABS];
            case "log":
                return BUILT_IN_FUNCTIONS[INDEX_LOG];
            case "log10":
                return BUILT_IN_FUNCTIONS[INDEX_LOG10];
            case "log2":
                return BUILT_IN_FUNCTIONS[INDEX_LOG2];
            case "log1p":
                return BUILT_IN_FUNCTIONS[INDEX_LOG1P];
            case "ceil":
                return BUILT_IN_FUNCTIONS[INDEX_CEIL];
            case "floor":
                return BUILT_IN_FUNCTIONS[INDEX_FLOOR];
            case "sqrt":
                return BUILT_IN_FUNCTIONS[INDEX_SQRT];
            case "cbrt":
                return BUILT_IN_FUNCTIONS[INDEX_CBRT];
            case "pow":
                return BUILT_IN_FUNCTIONS[INDEX_POW];
            case "exp":
                return BUILT_IN_FUNCTIONS[INDEX_EXP];
            case "expm1":
                return BUILT_IN_FUNCTIONS[INDEX_EXPM1];
            case "signum":
                return BUILT_IN_FUNCTIONS[INDEX_SGN];
            case "toradian":
                return BUILT_IN_FUNCTIONS[INDEX_TO_RADIAN];
            case "todegree":
                return BUILT_IN_FUNCTIONS[INDEX_TO_DEGREE];
            default:
                return null;
        }
    }

}
