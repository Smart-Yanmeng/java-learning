public class Main {
    public static void main(String[] args) {
        Director director = new Director();
        CarBuilder carbuilder = new CarBuilder();
        CarManualBuilder manualBuilder = new CarManualBuilder();

        director.constructSUV(carbuilder);
        director.constructSUV(manualBuilder);

        Car car = carbuilder.getResult();
        Manual manual = manualBuilder.getResult();

        System.out.println("211308121蒋天宇");
        System.out.println(car.test());
        System.out.println(manual.print());
    }
}
