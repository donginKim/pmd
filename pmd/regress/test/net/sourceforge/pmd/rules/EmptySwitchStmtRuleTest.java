package test.net.sourceforge.pmd.rules;

import net.sourceforge.pmd.Rule;
import net.sourceforge.pmd.cpd.CPD;
import net.sourceforge.pmd.rules.XPathRule;

public class EmptySwitchStmtRuleTest extends SimpleAggregatorTst {

    private Rule rule;

    public void setUp() {
        rule = new XPathRule();
        rule.addProperty("xpath", "//SwitchStatement[count(*) = 1]");
    }

    public void testAll() {
       runTests(new TestDescriptor[] {
           new TestDescriptor(TEST1, "bad", 1, rule),
           new TestDescriptor(TEST2, "ok", 0, rule),
       });
    }

    private static final String TEST1 =
    "public class EmptySwitchStmt1 {" + CPD.EOL +
    " public void bar() {" + CPD.EOL +
    "  int x = 2;" + CPD.EOL +
    "  switch (x) {}" + CPD.EOL +
    " }" + CPD.EOL +
    "}";

    private static final String TEST2 =
    "public class EmptySwitchStmt2 {" + CPD.EOL +
    " public void bar() {" + CPD.EOL +
    "  int x = 2;" + CPD.EOL +
    "  switch (x) {" + CPD.EOL +
    "   case 2: int y=4;" + CPD.EOL +
    "  }" + CPD.EOL +
    " }" + CPD.EOL +
    "}";


}
