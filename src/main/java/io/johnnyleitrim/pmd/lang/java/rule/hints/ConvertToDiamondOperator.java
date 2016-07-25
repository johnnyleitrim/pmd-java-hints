package io.johnnyleitrim.pmd.lang.java.rule.hints;

import net.sourceforge.pmd.lang.java.ast.ASTAllocationExpression;
import net.sourceforge.pmd.lang.java.ast.ASTTypeArgument;
import net.sourceforge.pmd.lang.java.ast.ASTTypeArguments;
import net.sourceforge.pmd.lang.java.rule.AbstractJavaRule;

public class ConvertToDiamondOperator extends AbstractJavaRule {

    @Override
    public Object visit(ASTAllocationExpression node, Object data) {
        ASTTypeArguments typeArguments = node.getFirstDescendantOfType(ASTTypeArguments.class);
        if (typeArguments != null && typeArguments.hasDecendantOfAnyType(ASTTypeArgument.class)) {
            addViolation(data, node);
        }
        return data;
    }

}
