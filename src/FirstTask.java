public class FirstTask {
    //ფუნქცია რომელიც პარამეტრად იღებს მასივს მთელი რიცხვებისას
    static double averageBelow150(int[] numbers) {
        //ჯამი და რიცხვების რაოდენობა რათა დავიანგარიშოთ საშუალო
        int sum = 0;
        int count = 0;

        //ფორ ციკლი გავატაროთ რიცხვების მასივში და შევამოწმოთ თუ
        //ეს რიცხვი ნაკლებია 150 ზე გავზარდოთ ქაუნთი 1 ით და
        //ეს რიცხვი დავუმატოთ ზევით აღწერილ ჯამს
        for (int num : numbers) {
            if (num < 150) {
                sum += num;
                count++;
            }
        }

        // თუ მასივში არ მოიძებნა ისეთი რიცხვი რომელიც ნაკლებიუა 150-ზე
        // დავაბრუნოთ 0
        if (count == 0) {
            System.out.println("150 ზე ნაკლები რიცხვი არ მოიძებნა მასივში");
            return 0.0;
        }

        // დავაბრუნოთ საშუალო არითმეტიკული როგორც double
        return (double) sum / count;
    }

    //ფუნქცია რომელიც პარამეტრად იღებს მთელი რიცხვების მასივს
    static double calculateGeometricAverage(int [] numbers){
        double mult = 1;
        int count = 0;

        for (int num: numbers){
            if(num % 2 != 0){
                mult*= num;
                count++;
            }
        }

        //გეომეტრიული საშუალო ითვლება რიცხვების ნამრავლიდან ამოვიღოთ n ხარისხის ფესვი
        return Math.pow(mult, 1.0 / count);

    }

    public static void main(String[] args) {
        // აღვწეროთ მასივი და მივანიჭოთ ელემენტები
        int[] array1 = {140, 130, 140, 180, 160};
        int[] array2 = {4, 5, 3, 12, 7};

        //გამოვიძახოთ ჩვენი ფუნქცია და არგუმენტად მივცეთ ჩვენი მასივი
        double average = averageBelow150(array1);
        double geoAverage = calculateGeometricAverage(array2);

        //დავბეჭდოთ შედეგი
        System.out.println("საშუალო არითმეტიკული: " + average);
        System.out.println("გეომეტრიული საშუალო: " + geoAverage);
    }
}
