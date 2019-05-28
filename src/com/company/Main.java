package com.company;
import java.util.Scanner;
import java.math.BigDecimal;
import java.math.BigInteger;

public class Main {

    public static void main(String args[])
    {
        Scanner scanner=new Scanner(System.in);

        int p,q,n,z,d=0,e;
        double c;


        System.out.println("RSA Encrypted");


        System.out.println("Enter the your message number:");
        int msg=scanner.nextInt();

        System.out.println("-----------p and q must be prime number!!!!-----------");

        System.out.println("Enter number p");
        p=scanner.nextInt();

        System.out.println("Enter number q");
        q=scanner.nextInt();

        n=p*q;
        System.out.println("the value of n = "+n);

        z=(p-1)*(q-1);
        System.out.println("the value of z = "+z);


        for(e=2 ; e<z ; e++)
        {
            if(mod_al(e,z)==1)
            {
                break;
            }
        }
        System.out.println("the value of e = "+e);


        for(int i=0; i<=9; i++)
        {
            int x=1+(i*z);

            if(x%e==0)
            {
                d=x/e;
                break;
            }
        }
        System.out.println("the value of d = " +d);


        //Public Key {e,n} Private Key {d,n}

        System.out.println("Public Key:"+ "("+ e +","+n+")");
        System.out.println("Private Key:" + "("+ d +","+n+")");

        c=(Math.pow(msg,e))%n;
        System.out.println("Encrypted message is :" + c);

      BigInteger N = BigInteger.valueOf(n);
        BigInteger C = BigDecimal.valueOf(c).toBigInteger();
        BigInteger msback;

        msback = (C.pow(d)).mod(N);
        System.out.println("Derypted message is :"+msback);



    }

    static int mod_al(int e, int z)
    {
        if(e==0)
            return z;
        else
            return mod_al(z%e,e);
    }
}

