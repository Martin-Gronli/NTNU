public class Fraction {
    private int num;
    private int den;


    public Fraction(int num, int den) { //constructor with numerator and denominator
        if (den == 0) {
            throw new IllegalArgumentException("Denominator cannot be 0");
        }
        this.num = num;
        this.den = den;
        simplify();

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
        simplify();
    }

    public void sub(Fraction b) { //substracs fractions
        this.num = this.num * b.den - b.num * this.den;
        this.den = this.den * b.den;
        simplify();
    }
    
    public void mul(Fraction b) { //multiplies fractions
        this.num = this.num * b.num;
        this.den = this.den * b.den;
        simplify();

    }

    public void div(Fraction b) { //divides fractions
        if (b.den == 0) {
            throw new IllegalArgumentException("Denominator cannot be 0");
        }
        this.num = this.num * b.den;
        this.den = this.den * b.num;
        simplify();
    }

     // Extra: simplify
    private void simplify() {
        int gcd = gcd(Math.abs(num), Math.abs(den));
        num /= gcd;
        den /= gcd;

        // denominator always positive
        if (den < 0) {
            num = -num;
            den = -den;
        }
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    @Override
    public String toString() {
        return num + "/" + den;
    }

}