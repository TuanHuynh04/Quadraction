package JFrameQuadraction;

import java.util.Scanner;

public class LinearEquation
{
	protected double a,b;
	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}
	public double getA() {
		return a;
	}
	public void setA(double a) {
		this.a = a;
	}
	public    LinearEquation() {
		
	}
	public    LinearEquation(double a, double b) {
		setA(a);
		setB(b);
	}
	public void input() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a:");
		this.setA(in.nextDouble());
		System.out.print("Enter b:");
		this.setB(in.nextDouble());
	}
	public String solve()
	{
		String s ="";
		if(a==0) 
			if(b==0)
				s= "Phuong trinh vo so nghiem";
			else
				s= "Phuong trinh vo nghiem";
		else
			s=" x ="+(double)(-b/a);
		return s;
	}
	public static void main(String[] args) {
		System.out.print("LinearEquation bx + c = 0\n");
		LinearEquation x1 = new LinearEquation();
		x1.b = -3;
		x1.a = 3;
		x1.solve();
		LinearEquation x2 = new LinearEquation();
		x2.setA(3);
		x2.setB(6);
		x2.solve();
		LinearEquation x3 = new LinearEquation(0,3);
		x3.solve();
		
	}

}
