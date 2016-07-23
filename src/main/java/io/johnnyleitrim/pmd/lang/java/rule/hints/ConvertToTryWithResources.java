package io.johnnyleitrim.pmd.lang.java.rule.hints;

import net.sourceforge.pmd.lang.java.ast.ASTLocalVariableDeclaration;
import net.sourceforge.pmd.lang.java.rule.AbstractJavaRule;

public class ConvertToTryWithResources extends AbstractJavaRule {

    @Override
    public Object visit(ASTLocalVariableDeclaration node, Object data) {
        if (node.getTypeNode().getType() != null && AutoCloseable.class.isAssignableFrom(node.getTypeNode().getType())) {
            addViolation(data, node);
            return data;
        }
        return data;
    }

}
