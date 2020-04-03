package JFrameQuadraction;

import java.util.Scanner;

public class Quadratic extends LinearEquation
{
	private double c;
	public double getC() {
		return this.c;
	}
	public void setC(double c) {
		this.c = c;
	}
	public 		Quadratic() {
		super();// gọi hàm khai báo không đối số của lớp cha
	}
	public  	Quadratic(double a, double b, double c) {
		super(b,a);// gọi hàm khia báo có đối số của lớp cha
		setC(c);
	}
	public void input() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter c");
		this.setA(in.nextDouble());
		super.input();// gọi hàm input của lớp cha
	}
	public String solve()
	{
		String s ="";
		if ( a == 0 )
		{

			s = super.solve();// gọi hàm solve của lớp cha
		}
		else
		{	
            double del=(b*b)-(4*a*c);
            if(del>0)
            {
            	s = "  x2 = "+(float) ((-b + Math.sqrt(del)) / (2*a))+
            			"  x1 = " +(float) ((-b - Math.sqrt(del)) / (2*a));
            }
            else
            	if(del==0)
            	{
            		s ="x = "+(float)-b/(2*a);
            	}
            	else
            		s ="Phuong trinh vo nghiem";
		}
		return s;
	}
	public static void main(String[] args) {
		System.out.println("Quadratic_Equation ax^2 + bx + c = 0");
		Quadratic q1 = new Quadratic();
		q1.a =1;
		q1.b =-4;
		q1.c =4;
		q1.solve();
		Quadratic q2 = new Quadratic();
		q2.a =2;
		q2.b =7;
		q2.c =3;
		q2.solve();
		Quadratic q3 = new Quadratic();
		q3.a =2;
		q3.b =6;
		q3.c =5;
		q3.solve();
	}

}
