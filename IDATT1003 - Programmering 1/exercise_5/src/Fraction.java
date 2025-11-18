public class Fraction {
    private int num;
    private int den;


    public Fraction(int num, int den) { //constructor with numerator and denominator
        if (den == 0) {
            throw new IllegalArgumentException("Denominator cannot be 0");
        }
        this.num = num;
        this.den = den;
    }

    public Fraction(int num) { //constructor with numerator, and denominator = 1
        this.num = num;
        this.den = 1;
    }

    //get methods
    public int getNum() {
        return num;
    }

    public int getDen() {
        return den;
    }

    public void add(Fraction b) { //adds fractions
        this.num = this.num * b.den + b.num * this.den;
        this.den = this.den * b.den;

    }

    public void sub(Fraction b) { //substracs fractions
        this.num = this.num * b.den - b.num * this.den;
        this.den = this.den * b.den;
    }
    
    public void mul(Fraction b) { //multiplies fractions
        this.num = this.num * b.num;
        this.den = this.den * b.den;
    }

    public void div(Fraction b) { //divides fractions
        if (b.den == 0) {
            throw new IllegalArgumentException("Denominator cannot be 0");
        }
        this.num = this.num * b.den;
        this.den = this.den * b.num;
    }

    @Override
    public String toString() {
        return num + "/" + den;
    }

}