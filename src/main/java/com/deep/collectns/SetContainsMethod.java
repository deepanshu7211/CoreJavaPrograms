package com.deep.collectns;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by deepanshu.saxena on 09/06/16.
 */
public class SetContainsMethod {

    private String first, last;

    public SetContainsMethod(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public static void main(String[] args) {
        Set<SetContainsMethod> s = new HashSet();
        s.add(new SetContainsMethod("deep", "abcd"));
        System.out.println(s.contains(new SetContainsMethod("deep", "abcd")));
    }

    public boolean equals(Object o) {
        System.out.println("in equals method.... \n");
        if (this == o) return true;

        if (!(o instanceof SetContainsMethod))
            return false;
        SetContainsMethod n = (SetContainsMethod) o;
        return n.first.equals(first) && n.last.equals(last);
    }

    public int hashCode() {
        System.out.println("in hashcode method... \n");
        return first.hashCode() + last.hashCode();
    }
}
