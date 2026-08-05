package jlox;

abstract class Expr {

  interface Visitor<R> {
      R visitBinaryExpr(Binary expr);
      R visitGroupingExpr(Grouping expr);
      R visitLiteralExpr(Literal expr);
      R visitUnaryExpr(Unary expr);
  }


  class ReversePolish implements Visitor {

    @Override
    public String visitBinaryExpr(Binary expr) {
      return expr.left.toString() + expr.right.toString() + expr.operator.toString();
    }

    @Override
    public String visitGroupingExpr(Grouping expr) {
     return expr.toString();
    }

    @Override
    public String visitLiteralExpr(Literal expr) {
     return expr.toString();
    }

    @Override
    public String visitUnaryExpr(Unary expr) {
      return expr.right.toString() + expr.operator.toString();
    }
  }

 static class Binary extends Expr {
    Binary(Expr left, Token operator, Expr right) {
      this.left = left;
      this.operator = operator;
      this.right = right;
    }
    @Override
    <R> R accept(Visitor<R> visitor) {
      return visitor.visitBinaryExpr(this);
    }
    final Expr left;
    final Token operator;
    final Expr right;
  }

 static class Grouping extends Expr {
    Grouping(Expr expression) {
      this.expression = expression;
    }
    @Override
    <R> R accept(Visitor<R> visitor) {
      return visitor.visitGroupingExpr(this);
    }
    final Expr expression;
  }

 static class Literal extends Expr {
    Literal(Object value) {
      this.value = value;
    }
    @Override
    <R> R accept(Visitor<R> visitor) {
      return visitor.visitLiteralExpr(this);
    }
    final Object value;
  }

 static class Unary extends Expr {
    Unary(Token operator, Expr right) {
      this.operator = operator;
      this.right = right;
    }
    @Override
    <R> R accept(Visitor<R> visitor) {
      return visitor.visitUnaryExpr(this);
    }
    final Token operator;
    final Expr right;
  }

  abstract <R> R accept(Visitor<R> visitor);
}
