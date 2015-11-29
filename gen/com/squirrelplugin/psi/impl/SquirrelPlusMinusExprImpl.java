// This is a generated file. Not intended for manual editing.
package com.squirrelplugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.squirrelplugin.psi.SquirrelTypes.*;
import com.squirrelplugin.psi.*;

public class SquirrelPlusMinusExprImpl extends SquirrelExprImpl implements SquirrelPlusMinusExpr {

  public SquirrelPlusMinusExprImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SquirrelVisitor) ((SquirrelVisitor)visitor).visitPlusMinusExpr(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<SquirrelExpr> getExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SquirrelExpr.class);
  }

}
