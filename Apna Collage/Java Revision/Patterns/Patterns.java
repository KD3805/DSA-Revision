public class Patterns {
    public static void main(String[] args) {
        int n = 5;

        // numberPyramid(n);
        // palindromicPyramid(n);
        // diamondPattern(n);
        // solidRhombus(n);
        // butterflyPattern(n);
        interviewPattern(n);
    }

    public static void numberPyramid(int n) {

        //      1
        //     2 2
        //    3 3 3
        //   4 4 4 4
        //  5 5 5 5 5


        for(int i=1; i<=n; i++) {

            //1st part => spaces
            for(int j=1; j<=(n-i); j++) {
                System.out.print(" ");
            }

            //2nd part => numbers
            for(int j=1; j<=i; j++) {
                System.out.print(i+" ");
            }

            System.out.println();
        }
    }

    public static void palindromicPyramid(int n) {

        //         1
        //       2 1 2
        //     3 2 1 2 3
        //   4 3 2 1 2 3 4
        // 5 4 3 2 1 2 3 4 5


        for(int i=1; i<=n; i++) {

            //1st part => spaces
            for(int j=1; j<=(n-i); j++) {
                System.out.print("  ");
            }

            //2nd part => first half numbers
            for(int j=i; j>=1; j--) {
                System.out.print(j+" ");
            }

            //3rd part => second half numbers
            for(int j=2; j<=i; j++) {
                System.out.print(j+" ");
            }

            System.out.println();
        }
    }

    public static void diamondPattern(int n) {

        //     *
        //    ***
        //   *****
        //  *******
        // *********
        // *********
        //  *******
        //   *****
        //    ***
        //     *


        //Outer loop - upper half
        for(int i=1; i<=n; i++) {
            
            //1st part => spaces
            for(int j=1; j<=(n-i); j++) {
                System.out.print(" ");
            }

            //2nd part => stars
            for(int j=1; j<=(2*i - 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        //Outer loop - lower half
        for(int i=n; i>=1; i--) {
            
            //1st part => spaces
            for(int j=1; j<=(n-i); j++) {
                System.out.print(" ");
            }

            //2nd part => stars
            for(int j=1; j<=(2*i - 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void solidRhombus(int n) {

        //           * * * * *
        //         * * * * *
        //       * * * * *
        //     * * * * *
        //   * * * * *


        for(int i=1; i<=n; i++) {

            //1st part => spaces
            for(int j=1; j<=(n-i); j++) {
                System.out.print("  ");
            }

            //2nd part => stars
            for(int j=1; j<=n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void butterflyPattern(int n) {

        // *                 *
        // * *             * *
        // * * *         * * *
        // * * * *     * * * *
        // * * * * * * * * * *
        // * * * * * * * * * *
        // * * * *     * * * *
        // * * *         * * *
        // * *             * *
        // *                 *


        //Outer loop - upper half
        for(int i=1; i<=n; i++) {
            
            //1st part => Half Pyramid
            for(int j=1; j<=i; j++) {
                System.out.print("* ");
            }

            int spaces = 2 * (n - i);

            //2nd part => Spaces
            for(int j=1; j<=spaces; j++) {
                System.out.print("  ");
            }

            //3rd part => Inverted & Rotated Half Pyramid
            for(int j=1; j<=i; j++) {
                System.out.print("* ");
            }
            System.out.println();

        }


        //Outer loop - lowe half
        for(int i=n; i>=1; i--) {
            
            for(int j=1; j<=i; j++) {
                System.out.print("* ");
            }

            int spaces = 2 * (n - i);

            for(int j=1; j<=spaces; j++) {
                System.out.print("  ");
            }

            for(int j=1; j<=i; j++) {
                System.out.print("* ");
            }
            System.out.println();

        }
    }

    public static void interviewPattern(int n) {

        // 15
        // 7       14
        // 6       8       13
        // 2       5       9       12
        // 1       3       4       10      11

		int num = 0;

		for(int i=1; i<=n; i++){
			num += i;
		}
		int numInc = num;
		int numDec = 1;

		int arrPat[][] = new int[n][n];

		for(int def=0; def<n; def++){
			for(int i=0; i<arrPat.length; i++){
				for(int j=0; j<arrPat[i].length; j++){
					if(i>=j){
						if(i-j == def){
							if(def%2 == 0){
								arrPat[i][j] = numInc;
							}
							numInc--;	
						}
					}
				}
			}
		}

		for(int def=n-1; def>=0; def--){
			for(int i=0; i<arrPat.length; i++){
				for(int j=0; j<arrPat[i].length; j++){
					if(i>j){
						if(i-j == def){
							if(def%2 != 0){
								arrPat[i][j] = numDec;
							}
							numDec++;
						}
					}
				}
			}
		}

		for(int tempArr[] : arrPat){
			for(int tempVal : tempArr){
				if(tempVal == 0){
					continue;
				}else{
					System.out.print(tempVal+"\t");
				}
			}
			System.out.print("\n");
		}
    }
}
