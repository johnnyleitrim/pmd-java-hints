package io.johnnyleitrim.pmd.lang.java.rule.hints;

import io.johnnyleitrim.pmd.lang.java.rule.utils.Utils;
import java.util.List;
import net.sourceforge.pmd.lang.java.ast.ASTBlock;
import net.sourceforge.pmd.lang.java.ast.ASTLocalVariableDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTReturnStatement;
import net.sourceforge.pmd.lang.java.rule.AbstractJavaRule;

public class ConvertToTryWithResources extends AbstractJavaRule {

    @Override
    public Object visit(ASTLocalVariableDeclaration node, Object data) {
        if (node.getTypeNode().getType() != null && AutoCloseable.class.isAssignableFrom(node.getTypeNode().getType())) {
            if (!isReturnedFromBlock(node)) {
                addViolation(data, node);
            }
        }
        return data;
    }

    private static boolean isReturnedFromBlock(ASTLocalVariableDeclaration node) {
        ASTBlock containingBlock = node.getFirstParentOfType(ASTBlock.class);
        List<ASTReturnStatement> returnStatements = containingBlock.findDescendantsOfType(ASTReturnStatement.class);
        for (ASTReturnStatement returnStatement : returnStatements) {
            String returnedVariable = Utils.getReturnedVariableName(returnStatement);
            if (node.getVariableName().equals(returnedVariable)) {
                return true;
            }
        }
        return false;
    }

}
