package ast;

import java.util.ArrayList;

public class Prog{
    public Main main;
    public ArrayList<Fun> fun;
    public Prog(Main main, ArrayList<Fun> fun)
    {
        this.main = main;
        this.fun = fun;
    }

    public String toString() {
        var out = main.toString();
        for (Fun function : fun) {
            out = out + function.toString();
        }
        return out;
    }
}

