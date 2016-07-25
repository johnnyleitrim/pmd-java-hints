package io.johnnyleitrim.pmd.lang.java.rule.hints;

import net.sourceforge.pmd.testframework.SimpleAggregatorTst;

public class HintsTest extends SimpleAggregatorTst {

    private static final String RULESET = "java-hints";

    @Override
    public void setUp() {
        addRule(RULESET, "ConvertToTryWithResources");
        addRule(RULESET, "ConvertToNumericsWithUnderscores");
    }
}
