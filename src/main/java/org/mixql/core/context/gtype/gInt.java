package org.mixql.core.context.gtype;

import java.util.ArrayList;
import java.util.Arrays;

public class gInt extends Type {
    int value;

    public int getValue(){
        return value;
    }

    public gInt(int value) {
        this.value = value;
    }

    public gInt(String value) {
        this.value = Integer.parseInt(value);
    }


    @Override
    public String toString() {
        return Integer.toString(value);
    }

    @Override
    public Type Add(Type other) {
        if (other instanceof gInt) {
            return new gInt(value + ((gInt) other).value);
        }

        if (other instanceof gDouble) {
            return new gDouble(value + ((gDouble) other).value);
        }

        if (other instanceof string) {
            string otherStr = (string) other;
            return new string(value + otherStr.value, otherStr.quote);
        }

        if (other instanceof array) {
            Type[] _t = ((array) other).getArr();
            ArrayList<Type> t = new ArrayList<>(Arrays.asList(_t));
            t.add(0, this);
            return (new array(t.toArray(_t)));
        }

        return super.Add(other);
    }

    @Override
    public Type Subtract(Type other) {
        if (other instanceof gInt) {
            return new gInt(value - ((gInt) other).value);
        }
        if (other instanceof gDouble) {
            return new gDouble(value - ((gDouble) other).value);
        }
        return super.Subtract(other);
    }

    @Override
    public Type Multiply(Type other) {
        if (other instanceof gInt) {
            return new gInt(value * ((gInt) other).value);
        }
        if (other instanceof gDouble) {
            return new gDouble(value * ((gDouble) other).value);
        }
        return super.Multiply(other);
    }

    @Override
    public Type Divide(Type other) {
        if (other instanceof gInt) {
            return new gInt(value / ((gInt) other).value);
        }
        if (other instanceof gDouble) {
            return new gDouble(value / ((gDouble) other).value);
        }
        return super.Divide(other);
    }

    @Override
    public Type MoreThen(Type other) {
        if (other instanceof gInt) {
            return new bool(value > ((gInt) other).value);
        }
        if (other instanceof gDouble) {
            return new bool(value > ((gDouble) other).value);
        }
        return super.MoreThen(other);
    }

    @Override
    public Type MoreEqualThen(Type other) {
        if (other instanceof gInt) {
            return new bool(value >= ((gInt) other).value);
        }
        if (other instanceof gDouble) {
            return new bool(value >= ((gDouble) other).value);
        }
        return super.MoreEqualThen(other);
    }

    @Override
    public Type LessThen(Type other) {
        if (other instanceof gInt) {
            return new bool(value < ((gInt) other).value);
        }
        if (other instanceof gDouble) {
            return new bool(value < ((gDouble) other).value);
        }
        return super.LessThen(other);
    }

    @Override
    public Type LessEqualThen(Type other) {
        if (other instanceof gInt) {
            return new bool(value <= ((gInt) other).value);
        }
        if (other instanceof gDouble) {
            return new bool(value <= ((gDouble) other).value);
        }
        return super.LessEqualThen(other);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof gInt) {
            return value == ((gInt) other).value;
        }
        if (other instanceof gDouble) {
            return value == ((gDouble) other).value;
        }
        if (other instanceof Null) {
            return false;
        }
        if (other instanceof none) {
            return false;
        }
        return super.equals(other);
    }

    @Override
    public Type Equal(Type other) {
        if (other instanceof gInt || other instanceof gDouble) {
            return new bool(this.equals(other));
        }
        if (other instanceof Null) {
            return new bool(false);
        }
        if (other instanceof none) {
            return new bool(false);
        }
        return super.Equal(other);
    }

    @Override
    public Type NotEqual(Type other) {
        if (other instanceof gInt) {
            return new bool(value != ((gInt) other).value);
        }
        if (other instanceof gDouble) {
            return new bool(value != ((gDouble) other).value);
        }
        if (other instanceof Null) {
            return new bool(true);
        }
        if (other instanceof none) {
            return new bool(true);
        }
        return super.NotEqual(other);
    }
}
