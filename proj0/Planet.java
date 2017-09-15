class Planet {
	double xxPos;
	double yyPos;
	double xxVel;
	double yyVel;
	double mass;
	String imgFileName;
	double G = 6.67e-11;

	public Planet(double xP, double yP, double xV, double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p) {
		double r = 0;
		double dx = p.xxPos - xxPos;
		double dy = p.yyPos - yyPos;
		r = Math.sqrt((dx * dx) + (dy * dy));
		return r;
	}

	public double calcForceExertedBy(Planet p) {
		double r = calcDistance(p);
		double force = G * mass * p.mass / (r * r);
		return force;
	}

	public double calcForceExertedByX(Planet p){
		double dx = p.xxPos - xxPos;
		double r = calcDistance(p);
		double f = calcForceExertedBy(p);
		double fx = f * dx / r;
		return fx;
	}

	public double calcForceExertedByY(Planet p){
		double dy = p.yyPos - yyPos;
		double r = calcDistance(p);
		double f = calcForceExertedBy(p);
		double fy = f * dy / r;
		return fy;
	}

	public double calcNetForceExertedByX(Planet[] p) {
		double netFx = 0;
		for (int i = 0; i < p.length; i++) {
			if (this.equals(p[i])) {

			}
			else {
				netFx += calcForceExertedByX(p[i]);
			}
		}
		return netFx;
	}

	public double calcNetForceExertedByY(Planet[] p) {
		double netFy = 0;
		for (int i = 0; i < p.length; i++) {
			if (this.equals(p[i])) {
				
			}
			else {
				netFy += calcForceExertedByY(p[i]);
			}
		}
		return netFy;
	}

	public void update(double dt, double fX, double fY) {
		double aX = fX / mass;
		double aY = fY / mass;
		xxVel= xxVel + dt * aX;
		yyVel = yyVel + dt * aY;
		xxPos = xxPos + dt * xxVel;
		yyPos = yyPos + dt * yyVel;

	}

	public void draw() {
		StdDraw.picture(xxPos, yyPos, "./images/"+imgFileName);
	}

}