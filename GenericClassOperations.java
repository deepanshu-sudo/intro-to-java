public class GenericClassOperations<T extends Number,U extends Number,V extends Number> {
    //fields to store generic data types
    private T a;
    private U b;
    private V c;
    
    //constructor to initialize field with provided value
    GenericClassOperations(T a, U b, V c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    //calculates sum of three values
    //uses double since it can also handle int and float values
    public Number sum() {
        return (a.doubleValue() + b.doubleValue() + c.doubleValue());
    }

    //calculates product of three values
    //uses double since it can also handle int and float values
    public Number product() {
        return (a.doubleValue() * b.doubleValue() * c.doubleValue());
    }

    //driver code
    public static void main(String[] args) {
        //create instance of float object
        GenericClassOperations<Float,Float,Float> floatObj = new GenericClassOperations<Float,Float,Float>(0.7f,0.2f,0.5f);

        //create instance of integer object
        GenericClassOperations<Integer,Integer,Integer> intObj = new GenericClassOperations<Integer,Integer,Integer>(7, 2, 5);

        //create instance of double object
        GenericClassOperations<Double,Double,Double> doubleObj = new GenericClassOperations<Double,Double,Double>(6.0, 6.0, 6.0);

        //print float object sum and product
        System.out.println("Datatype 1 Float Sum: "+floatObj.sum());
        System.out.println("Datatype 1 Float Product: "+floatObj.product());

        //print integer object sum and product
        System.out.println("Datatype 2 Integer Sum: "+intObj.sum());
        System.out.println("Datatype 2 Integer Product: "+intObj.product());

        //print double object sum and product
        System.out.println("Datatype 3 Double Sum: "+doubleObj.sum());
        System.out.println("Datatype 3 Double Product: "+doubleObj.product());
    }
}
