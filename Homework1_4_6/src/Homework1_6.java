public class Homework1_6 {
    /*课本P61作业1第4章第6题：水仙花数是指其个位、
    十位和百位三个数字的立方和等于这个三位数本身，
    求出所有的水仙花数*/
    public static void main(String args[]){
        for ( int i=100 ; i<1000 ; i++ ){
            int g=i%10 , s=(i/10)%10 , b=i/100;
            if ( (g*g*g+s*s*s+b*b*b)==i ){
                System.out.println(i);
            }
        }
    }
}