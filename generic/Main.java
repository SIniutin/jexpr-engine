package expression.generic;

public class Main {
    public static void main(String[] args) throws Exception {
        if(args.length < 2) {
            throw new IllegalArgumentException("Must be 2 arguments not: " + args.length);
        }
        Tabulator tabulator = new GenericTabulator();
        Object[][][] result = tabulator.tabulate(args[0], args[1], -2, 2, -2, 2, -2, 2);
        for(int i = 0; i < 5; i++) {
            System.out.println("i = "+ i);
            for (int j =0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    System.out.print(result[i][j][k]+" ");
                }
                System.out.println();
            }
        }
    }
}
