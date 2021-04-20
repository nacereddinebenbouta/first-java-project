/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.chainemarkov;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author benbouta nacereddine
 */
public class Methodes {

    //this methode reads the matrice
    public double[][] readMatrice(int rows, int columns) {
        Scanner clavier = new Scanner(System.in);
        System.out.println();
        System.out.println("You have entred: ");
        System.out.println("Matrice Rows= " + rows);
        System.out.println("Matrice Columns= " + rows);
        System.out.println();
        //declaration of a matrice [lines][colones]
        double Matrice[][] = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.println("Enter element for Matrice = [" + (i + 1) + "][" + (j + 1) + "] :");
                Matrice[i][j] = clavier.nextDouble();
            }
        }
        return Matrice;
    }

    //this methode will show (ouput) the matrice
    public void showMatrice(double matrice[][]) {
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                System.out.format("%.2f  ", matrice[i][j]);
            }
            System.out.println();
        }
    }

    //this methode checks if the matrice is stochastic or not
    public boolean checkStochastic(double matrice[][]) {
        //i<nbr of rows
        for (int i = 0; i < matrice.length; i++) {
            double sumVector = 0;
            //j< nbr of columns
            for (int j = 0; j < matrice[i].length; j++) {
                sumVector = sumVector + matrice[i][j];
            }
            if (sumVector != 1) {
                return false;
            }
        }
        return true;
    }

    //Genrate a random value between 0-1
    public float randValue() {
        Random random = new Random();
        double randNumbr = random.nextFloat();
        System.out.println();
        System.out.println("randNumbr= " + randNumbr);
        randNumbr = randNumbr * 10;
        System.out.println("randNumbr*10 = " + randNumbr);
        int intCasted = (int) randNumbr;
        System.out.println("intCasted= " + intCasted);
        float R = (float) intCasted / 10;
        System.out.println("R = intCasted/10= " + R);
        System.out.println();
        return R;
    }

    //calculates sum of matrice[i]+matrice[i+1] of row [i] and compare it with R
    //if R<Sum return the index of the row
    public int retRowIndice(double A[], float r, double Matrice[][]) {
        double SUM = 0;
        for (int i = 0; i < Matrice[0].length; i++) {
            System.out.println();
            System.out.format("SUM = %.3f", SUM);
            System.out.format(" + %.3f", A[i]);
            SUM = SUM + A[i];
            System.out.format(" = %.3f", SUM);
            System.out.println();
            System.out.format("SUM = " + "SUM" + " + " + "Vector" + "[" + i + "]" + " = " + "%.3f", +SUM);
            System.out.println();
            if (SUM < r && i == Matrice.length - 1) {
                //code will go here
            } else if (SUM > r) {
                System.out.println();
                System.out.println("SUM > R <===> " + SUM + ">" + r);
                if ((SUM == 1.0) | (SUM == 0.99)) {
                    System.out.println("Echeck du calcule chaine de markove descret");
                }
                return i;
            }
        }
        return Matrice.length-1;
    }

    //return the row number that willmultiplied with the matrice
    public int eteration(double A[], double Matrice[][]) {
        Methodes meth = new Methodes();
        float randNumber = meth.randValue();
        System.out.println("R= " + randNumber);
        System.out.println();
        System.out.println("Vector[R]= " + Arrays.toString(A));
        System.out.println();
        int rowNumber = meth.retRowIndice(A, randNumber, Matrice);
        System.out.println();
        System.out.println("Index of Vector[row] is= " + rowNumber);
        System.out.println("Vector[" + rowNumber + "]= " + Arrays.toString(Matrice[rowNumber]));
        System.out.println();
        return rowNumber;
    }

    //return the Vector[i]
    public void getVictor(double matrice[], double vec[]) {
        for (int i = 0; i < matrice.length; i++) {
            vec[i] = matrice[i];
        }
    }

    //multiplication Vector[i]*Matrice[i][j]
    public void multiple(double vec[], double A[][], int rowIndice, double c[]) {
        for (int test = 0; test < rowIndice; test++) {
            double sum = 0;
            int z = 0;
            for (int j = 0; j < A.length; j++) {
                for (int i = 0; i < A.length; i++) {
                    sum = vec[z] * A[i][j] + sum;
                    z++;
                }
                z = 0;
                c[j] = sum;
                sum = 0;
            }
        }
    }
}
