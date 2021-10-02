public class MAIN_threeinone {
    public static void main(String[] args) {
        ThreeInOne th=new ThreeInOne(3);
        //array size will be 3*3=9
//        System.out.println(th.isFull(2));
//        System.out.println(th.isEmpty(2));
        th.push(0, 1);
        th.push(0, 2);
        th.push(1, 4);
        th.push(1, 5);
        th.push(2, 8);
        System.out.println(th.pop(2));





    }
}
