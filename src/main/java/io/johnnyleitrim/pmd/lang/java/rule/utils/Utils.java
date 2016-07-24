package io.johnnyleitrim.pmd.lang.java.rule.utils;

import net.sourceforge.pmd.lang.java.ast.*;

public class Utils {

    public static final String getReturnedVariableName(ASTReturnStatement returnStatement) {
        if (hasTernaryCondition(returnStatement) && hasTernaryNullCheck(returnStatement)) {
            return returnStatement.getFirstDescendantOfType(ASTConditionalExpression.class).jjtGetChild(0).getFirstDescendantOfType(ASTName.class).getImage();
        }

        final ASTName name = returnStatement.getFirstDescendantOfType(ASTName.class);
        if (name != null) {
            return name.getImage();
        }
        final ASTPrimarySuffix primarySuffix = returnStatement.getFirstDescendantOfType(ASTPrimarySuffix.class);
        return (primarySuffix == null) ? null : primarySuffix.getImage();
    }

    private static boolean hasTernaryNullCheck(ASTReturnStatement ret) {
        ASTConditionalExpression condition = ret.getFirstDescendantOfType(ASTConditionalExpression.class);
        return condition.jjtGetChild(0) instanceof ASTEqualityExpression
                && condition.jjtGetChild(0).hasImageEqualTo("==")
                && condition.jjtGetChild(0).jjtGetChild(0).hasDescendantOfType(ASTName.class)
                && condition.jjtGetChild(0).jjtGetChild(1).hasDescendantOfType(ASTNullLiteral.class);
    }

    private static boolean hasTernaryCondition(ASTReturnStatement ret) {
        ASTConditionalExpression condition = ret.getFirstDescendantOfType(ASTConditionalExpression.class);
        return condition != null && condition.isTernary();
    }

}