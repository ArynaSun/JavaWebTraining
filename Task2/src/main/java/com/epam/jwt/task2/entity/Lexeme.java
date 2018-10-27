package com.epam.jwt.task2.entity;

public class Lexeme implements PartOfText {

    private String lexeme;

    public Lexeme() {
    }

    public Lexeme(String lexeme) {
        setLexeme(lexeme);
    }

    public String getLexeme() {
        return lexeme;
    }

    public void setLexeme(String lexeme) {
        this.lexeme = lexeme;
    }

    @Override
    public String convertPartOfTextToString() {
        return lexeme;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Lexeme lex = (Lexeme) obj;

        if (lex == null) {
            return (lexeme == lex.lexeme);
        } else {
            if (!lexeme.equals(lex.lexeme)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return  ((lexeme == null)? 0 : lexeme.hashCode()*31);
    }

    @Override
    public String toString(){
        return getClass().getName() + "lexeme: " + lexeme;
    }
}


