package fuckleetcode;

public class ArrayPartion_II {
	 public static int[] sortArrayByParityII(int[] A) {
	        int j = 1;
	        for (int i = 0; i < A.length; i += 2) {
				if (A[i] % 2 == 1) {
					while (A[j] % 2 == 1){
						j += 2;
					}

					// Swap A[i] and A[j]
					int tmp = A[i];
					A[i] = A[j];
					A[j] = tmp;
				}
			}

	        return A;
	    }
	 
	 public static void main(String[] args) {
		int A[] = {4,2,5,7};
		sortArrayByParityII(A);
		for(int i=0;i<4;i++) {
			System.out.println(A[i]);
		}
		
		
	}
}
