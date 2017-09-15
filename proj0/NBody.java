import java.util.Scanner;

class NBody{

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		double T = keyboard.nextDouble();
		double dt = keyboard.nextDouble();
		String filename = keyboard.next();

		double radius = readRadius(filename);
		Planet[] p = readPlanets(filename);

		StdAudio.play("./audio/2001.mid");
		StdDraw.setScale(-radius, radius);
		StdDraw.picture(0, 0, "./images/starfield.jpg");
		

		for (Planet item : p ) {
			item.draw();
		}

		double time = 0;

		while (time < T) {

			double[] xForces = new double[5];
			double[] yForces = new double[5];

			for (int i = 0; i < 5; i++ ) {
				xForces[i] = p[i].calcNetForceExertedByX(p);
				yForces[i] = p[i].calcNetForceExertedByY(p);
			}



			for (int i = 0; i < 5; i++ ) {
				p[i].update(dt, xForces[i], yForces[i]);
			}

			StdDraw.picture(0, 0, "./images/starfield.jpg");

			for (Planet item : p ) {
			item.draw();
			}		

			StdDraw.show(10);

			time += dt;
		}

		StdOut.printf("%d\n", p.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < p.length; i++) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
   			p[i].xxPos, p[i].yyPos, p[i].xxVel, p[i].yyVel, p[i].mass, p[i].imgFileName);	
		}	



	}
	
	public static double readRadius(String x) {
		In in = new In(x);
		in.readLine();
		double radius = in.readDouble();
		return radius;
	}

	public static Planet[] readPlanets(String x) {
		In in = new In(x);
		in.readLine();
		in.readLine();

		Planet p1 = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readString());
		Planet p2 = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readString());
		Planet p3 = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readString());
		Planet p4 = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readString());
		Planet p5 = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readString());

		Planet[] p = {p1, p2, p3, p4, p5};

		return p;

	}


}