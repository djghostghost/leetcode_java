package org.practise.math;

//leetcode #223

public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

        int areaA=(C-A)*(D-B);
        int areaB=(G-E)*(H-F);

        int x0=Math.max(A,E);
        int y0=Math.max(B,F);

        int x1=Math.min(C,G);
        int y1=Math.min(D,H);

        int overlap=0;
        if(x0<x1 && y0<y1){
            overlap=(x1-x0)*(y1-y0);
        }

        return areaA+areaB-overlap;

    }
}
