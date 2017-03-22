class exercise1{
	public static void main(String[] args) {
		drawTriangle(20);
		}

	public static void drawTriangle(int x) {
		String  triangle = "*";
		for (int i = 0; i < x; i++ ) {
			System.out.println(triangle);
			triangle += "*";
		}	
	}
}