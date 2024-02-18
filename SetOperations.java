import java.util.Set;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;

public class SetOperations {
    public Set<String> union(Set<String> A, Set<String> B, Set<String> C) {
        Set<String> union = new HashSet<>();
        union.addAll(A);
        union.addAll(B);
        union.addAll(C);
        return union;
    }

    public Set<String> intersection(Set<String> A, Set<String> B, Set<String> C) {
        Set<String> intersection = new HashSet<>();
        intersection.addAll(A);
        intersection.retainAll(B);
        intersection.retainAll(C);
        return intersection;
    }

    public Set<String> unionOfIntersection(Set<String> A, Set<String> B, Set<String> C) {
        Set<String> unionOfIntersection = new HashSet<>();
        Set<String> AB = new HashSet<>(A);
        AB.retainAll(B);

        Set<String> AC = new HashSet<>(A);
        AC.retainAll(C);

        Set<String> BC = new HashSet<>(B);
        BC.retainAll(C);

        unionOfIntersection.addAll(AB);
        unionOfIntersection.addAll(AC);
        unionOfIntersection.addAll(BC);

        return unionOfIntersection;
    }
    
    public static void main(String[] args) {
        //check the length of the arguments
        if(args.length != 1) {
            System.out.println("Usage: SetOperations <csv_file_path>");
            return;
        }

        //create sets
        Set<String> A = new HashSet<>();
        Set<String> B = new HashSet<>();
        Set<String> C = new HashSet<>();

        //read csv file and store the data in the sets
        String csvFile = args[0];
        try(BufferedReader br = new BufferedReader(new FileReader(csvFile));) {
            String line = br.readLine();
            while(line != null) {
                String[] data = line.split(",");
                A.add(data[0]);
                B.add(data[1]);
                C.add(data[2]);

                line = br.readLine();
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        //creating a Set Operations Object
        SetOperations setOperations = new SetOperations();

        System.out.println("A: \n");
        System.out.println(A);
        System.out.println("-------------------------------------------------------");

        System.out.println("B: \n");
        System.out.println(B);
        System.out.println("-------------------------------------------------------");

        System.out.println("C: \n");
        System.out.println(C);
        System.out.println("-------------------------------------------------------");

        //perform union and prints
        Set<String> union = setOperations.union(A, B, C);
        System.out.println("Union: \n");
        System.out.println(union);
        System.out.println("-------------------------------------------------------");

        //perform intersection and prints
        Set<String> intersection = setOperations.intersection(A, B, C);
        System.out.println("Intersection: \n");
        System.out.println(intersection);
        System.out.println("-------------------------------------------------------");

        //perform union and prints
        Set<String> unionOfIntersection = setOperations.unionOfIntersection(A, B, C);
        System.out.println("UnionOfIntersection: \n");
        System.out.println(unionOfIntersection);
        System.out.println("-------------------------------------------------------");
    }
}