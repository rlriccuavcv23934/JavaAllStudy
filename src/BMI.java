public class BMI {
    public static void bmiCalculator(double weight, double height) {
        double bmi = weight / Math.pow(height, 2);
        if (bmi < 18.5) {
            System.out.println("您的BMI指数为" + bmi + "，属于偏瘦。");
        } else if (bmi >= 18.5 && bmi < 25) {
            System.out.println("您的BMI指数为" + bmi + "，属于正常范围。");
        } else if (bmi >= 25 && bmi < 28) {
            System.out.println("您的BMI指数为" + bmi + "，属于过重。");
        } else if (bmi >= 28 && bmi < 32) {
            System.out.println("您的BMI指数为" + bmi + "，属于肥胖。");
        } else {
            System.out.println("您的BMI指数为" + bmi + "，属于重度肥胖。");
        }
    }
}
