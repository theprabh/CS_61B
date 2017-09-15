class exercise2 {

	public static void main(String[] args) {
		int[] numbers = {9, 2, 15, 2, 22, 10, 6};
		System.out.println(max(numbers));

	}

	public static int max(int[] x) {
		int largestNum = 0;
		for (int i = 0; i < x.length ;i++ ) {
			if (x[i] > largestNum) {
				largestNum = x[i];
			}
		}

		return largestNum;
	}

}