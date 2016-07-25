package io.johnnyleitrim.pmd.lang.java.rule.hints;

import net.sourceforge.pmd.lang.java.ast.ASTLiteral;
import net.sourceforge.pmd.lang.java.rule.AbstractJavaRule;

public class ConvertToNumericsWithUnderscores extends AbstractJavaRule {

    @Override
    public Object visit(ASTLiteral node, Object data) {
        if (node.isDoubleLiteral() || node.isFloatLiteral() || node.isIntLiteral() || node.isLongLiteral()) {
            String literal = node.getImage();
            if (!literal.contains("_") && literal.matches(".*\\d{4,}.*")) {
                addViolation(data, node);
            }
        }
        return data;
    }
}
