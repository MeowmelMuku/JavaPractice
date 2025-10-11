package test.tj;

//一个字符串s（1≤|s|≤10^5）仅由26种大写字母组成。
//你需要对其中字符A和Z进行翻转操作。具体的：
//将所有的字符A和Z字符按原有的先后顺序存到数组a中，字符串s变为字符“_”。
//翻转数组a，即长度为m的数组a[1:n]中，a[i]变为a[n-i+1]
//将a中每一个字符按顺序替代回s的“_”字符。
//例如，对ABAAZCA操作时，首先将A和Z提取出来，原数组变为_B___C_，a=AAAZA，然后反转a，变为AZAAA，填回s变为ABZAACA。
//
//输入格式：
//每个测试点包含多组测试数据。
//第一行，一个整数T(1≤T≤10^5），表示测试组数。
//接下来T行，每行一个字符串s（1≤|s|≤10^5），表示需要被转换的数。
//保证∑|s|≤10^5。
//
//输出格式：
//对于每个测试数据，输出一行一个字符串表示答案。
//
//输入样例：
//4
//A
//DZ
//AZ
//ABAAZCA
//输出样例：
//A
//DZ
//ZA
//ABZAACA

public class test2 {
    public static void main(String[] args) {
        dealWithNum("ABAAZCA");
    }
    public static void dealWithNum(String s){
        System.out.println("输入" + s);
        StringBuilder sb = new StringBuilder(s);
        StringBuilder deal = new StringBuilder(s);
        int point=s.length()-1;
        for (int i=0;i<s.length();i++){
            if(deal.charAt(i)=='A'||deal.charAt(i)=='Z'){
                //从队尾找到sb第一个为A或者Z的元素
                while (point >= 0 && sb.charAt(point) != 'A' && sb.charAt(point) != 'Z') {
                    point--;
                }
                if (point >= 0) {
                    deal.setCharAt(i, sb.charAt(point));
                    point--;
                }
            }
        }
        System.out.println("输出" +deal);
    }
}
